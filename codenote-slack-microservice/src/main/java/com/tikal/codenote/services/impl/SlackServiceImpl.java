/**
 * 
 */
package com.tikal.codenote.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author Pniel
 *
 */
@Service
public class SlackServiceImpl implements SlackService {

	private String address = "https://slack.com/api/chat.postMessage";
	private String team = "codenote";
	private String username = "tomeraz";
	private String token = "xoxp-60495774180-60506110549-61014966583-ab07cb075b";
	private String channel = "test";

	private static final Logger logger = LoggerFactory.getLogger(SlackServiceImpl.class);

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
