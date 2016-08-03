/**
 * 
 */
package com.tikal.codenote.services.security.impl;

import java.util.Base64;

import org.springframework.stereotype.Service;

import com.tikal.codenote.services.security.Security;

/**
 * @author Zeev Ben Sender
 *
 */
@Service
public class SecurityImpl implements Security {

	@Override
	public String encrypt(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	@Override
	public String decrypt(String encrypted) {
		return new String(Base64.getDecoder().decode(encrypted));
	}
}
