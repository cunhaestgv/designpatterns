package com.es2.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 
 * Validates if the password exists in a database of english words, to avoid the use of common words. 
 *
 */
public class CommonWordsValidator extends Decorator {

	public CommonWordsValidator(AuthInterface auth){
		super(auth);
	}
	
	@Override
	public void auth(String username, String password) throws AuthException, IOException {
		try {
			getHTTPRequest(password);				
		}catch(IOException e) {
			throw new AuthException();
		}
		
		super.auth(username, password);
	}
	
	/**
	 * Establishes a HTTP Request with the server
	 * <pre>{@code    StringBuilder result = new StringBuilder();
	 *    URL url = new URL("https://owlbot.info/api/v2/dictionary/" + word + "?format=json");
	 *    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	 *    conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
	 *    conn.setRequestMethod("GET");
	 *    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	 *    String line;
	 *    while ((line = rd.readLine()) != null) {
	 *       result.append(line);
	 *    }
	 *    rd.close();
	 *    return result.toString();
	 * }</pre>
	 * @param word represents the word to be searched
	 * @return result in format JSON
	 * @throws IOException thrown when the connection cannot be done successfully
	 */
	public String getHTTPRequest(String word) throws IOException {
		 StringBuilder result = new StringBuilder();
	     URL url = new URL("https://owlbot.info/api/v2/dictionary/" + word + "?format=json");
	     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	     conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
	     conn.setRequestMethod("GET");
	     BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	     String line;
	     while ((line = rd.readLine()) != null) {
	        result.append(line);
	     }
	     rd.close();
	     
	     return result.toString();
	}

}
