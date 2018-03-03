package com.es2.bridge;

public interface APIServiceInterface {
	/**
	 * Returns the API content
	 * @param contentId represents the ID of the content to be returned. When this parameter is "0", returns the all contents concatenated
	 * @return returns stored content or null in case it doesn't exist
	 */
	public String getContent(String contentId);
	
	/**
	 * Store new content in the API
	 * @param content represents the content to be stored
	 * @return contentId returns the ID of the content stored
	 */
	public String setContent(String content);
}
