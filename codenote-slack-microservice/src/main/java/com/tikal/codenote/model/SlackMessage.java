/**
 * 
 */
package com.tikal.codenote.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Pniel
 *
 */
@Component
@Scope("prototype")
public class SlackMessage implements Serializable {

	private String token;
	private String channel;
	private String text;
	private String username;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAsParam() {
		return "?token=" + token + "&text=" + text + "&channel=" + channel;
	}

}
