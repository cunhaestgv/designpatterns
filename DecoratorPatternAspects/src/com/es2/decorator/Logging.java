package com.es2.decorator;

import java.io.IOException;

/**
 * 
 * Logs the activity in the console. The format is (timestamp),auth().
 *
 */
public class Logging extends Decorator {
	public Logging(AuthInterface auth){
		super(auth);
	}
	
	@Override
	public void auth(String username, String password) throws AuthException, IOException {
		System.out.println(System.currentTimeMillis() + ",auth()");
		super.auth(username, password);
	}
}
