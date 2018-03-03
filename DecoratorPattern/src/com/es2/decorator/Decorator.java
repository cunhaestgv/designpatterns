package com.es2.decorator;

import java.io.IOException;

/**
 * 
 * Represents the base class of all decorators.
 *
 */
public class Decorator implements AuthInterface{
	AuthInterface auth;
	
	public Decorator(AuthInterface auth){
		this.auth = auth;
	}

	@Override
	public void auth(String username, String password) throws AuthException, IOException {
		auth.auth(username, password);
	}
}
