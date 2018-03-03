package com.es2.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * The client interacts with this class to access to service implementations
 *
 */
public class APIRequest{
	protected HashMap<String,APIServiceInterface> services = new HashMap<String,APIServiceInterface>();
	
	public APIRequest() {}	
	
	/**
	 * Adds a new service
	 * @param service represents the service to be added
	 * @return returns the ID of the service added
	 */
	public String addService(APIServiceInterface service) {
		String id= UUID.randomUUID().toString();
		this.services.put(id, service);
		
		return id;
	}
	
	
	/**
	 * Returns the API content
	 * @param serviceId represents the ID of the service
	 * @param contentId represents the ID of the content to be returned
	 * @return returns stored content or null in case it doesn't exist
	 */
	public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
		if(this.services.containsKey(serviceId)) {
			return this.services.get(serviceId).getContent(contentId);
		}else throw new ServiceNotFoundException();
	}
	
	/**
	 * Store new content in the API
	 * @param serviceId represents the ID of the service
	 * @param content represents the content to be stored
	 * @return contentId returns the ID of the content stored
	 */
	public String setContent(String serviceId, String content) throws ServiceNotFoundException {
		if(this.services.containsKey(serviceId)) {
			return this.services.get(serviceId).setContent(content);
		}else throw new ServiceNotFoundException();
	}

}
