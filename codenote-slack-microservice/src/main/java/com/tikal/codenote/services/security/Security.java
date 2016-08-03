/**
 * 
 */
package com.tikal.codenote.services.security;

/**
 * @author Pniel
 *
 */
public interface Security {

	String encrypt(String password);

	String decrypt(String password);
}
