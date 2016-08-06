/**
 * 
 */
package com.tikal.codenote.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tikal.codenote.model.RequestMessage;
import com.tikal.codenote.services.SlackService;

/**
 * @author Pniel
 *
 */
@RestController
@RequestMapping("/codenote")
public class SlackController {

	@Autowired
	private SlackService slackService;

	@RequestMapping(value = "/slack", method = RequestMethod.POST, produces = "application/json")
	public String addNewMessage(@RequestBody RequestMessage request) {
		return slackService.addNewSlackMessage(request.getMessage());
	}

	@RequestMapping(value = "/slack1", method = RequestMethod.GET, produces = "application/json")
	public String addNewMessage1(@RequestParam String message) {
		return slackService.addNewSlackMessage(message);
	}

	@RequestMapping(value = "/slack", method = RequestMethod.GET, produces = "application/json")
	public List<String> getMessages() {
		return slackService.getMessages();
	}

	@RequestMapping(value = "/deploymenyTest", method = RequestMethod.GET, produces = "application/json")
	public String deploymenyTest() {
		return "SUCCESS";
	}

}
