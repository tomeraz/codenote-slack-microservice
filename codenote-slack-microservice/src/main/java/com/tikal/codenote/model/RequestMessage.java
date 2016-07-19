/**
 * 
 */
package com.tikal.codenote.model;

import java.io.Serializable;

/**
 * @author Pniel
 *
 */
public class RequestMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3678543257429536892L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
