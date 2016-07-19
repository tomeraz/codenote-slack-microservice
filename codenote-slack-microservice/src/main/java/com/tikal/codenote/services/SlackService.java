/**
 * 
 */
package com.tikal.codenote.services;

import java.util.List;

/**
 * @author Pniel
 */
public interface SlackService {

	String addNewSlackMessage(String message);

	/**
	 * @return
	 */
	List<String> getMessages();

}
