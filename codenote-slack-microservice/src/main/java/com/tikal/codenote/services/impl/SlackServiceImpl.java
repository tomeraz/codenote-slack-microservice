/**
 * 
 */
package com.tikal.codenote.services.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.tikal.codenote.model.SlackMessage;
import com.tikal.codenote.services.SlackService;
import com.tikal.codenote.services.security.Security;

/**
 * @author Pniel
 *
 */
@Service
@EnableConfigurationProperties
public class SlackServiceImpl implements SlackService {

	private static final Logger logger = LoggerFactory.getLogger(SlackServiceImpl.class);

	@Autowired
	private Security Service;

	@Value("${slackServiceImpl.address}")
	private String address;
	@Value("${slackServiceImpl.team}")
	private String team;
	@Value("${slackServiceImpl.username}")
	private String username;
	@Value("${slackServiceImpl.token}")
	private String token;
	@Value("${slackServiceImpl.channel}")
	private String channel;

	@PostConstruct
	public void init() {
		token = Service.decrypt(token);
	}

	@Autowired
	private Gson gson;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ApplicationContext context;

	@Override
	public String addNewSlackMessage(String message) {
		try {
			SlackMessage slackMessage = context.getBean(SlackMessage.class);
			slackMessage.setChannel(channel);
			slackMessage.setToken(token);
			slackMessage.setUsername(username);
			slackMessage.setText(message);
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.TEXT_PLAIN);
			// String msg = gson.toJson(slackMessage);
			String params = slackMessage.getAsParam();
			// HttpEntity<String> entity = new HttpEntity<String>(msg, headers);
			ResponseEntity<String> result = restTemplate.exchange(address + params, HttpMethod.POST, null, String.class);
			return result.getBody();
		}
		catch (Exception e) {
			logger.error("unable to add new slack message for the given address: {}, message: {}", address, message, e);
		}
		return null;
	}

	@Override
	public List<String> getMessages() {
		try {
			ResponseEntity<String> result = restTemplate.exchange(address, HttpMethod.GET, null, String.class);
			return null;
		}
		catch (Exception e) {
			logger.error("unable to get slack messages for the given address: {}", address, e);
		}
		return null;
	}
}
