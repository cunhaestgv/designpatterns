package com.es2.decorator;

import java.io.IOException;

/**
 * Defines the common interface implemented by the Auth classes and all decorators classes
 *
 */
public interface AuthInterface {
	/**
	 * Performs authentication. By default the username/password is admin/admin.
	 * @param username the username
	 * @param password the password
	 * @throws AuthException thrown when authentication fails
	 * @throws IOException thrown when some I/O error occurs
	 */
	public void auth(String username, String password) throws AuthException, IOException;
}
