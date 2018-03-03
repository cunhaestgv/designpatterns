package com.es2.bridge;

/**
 * Aggregates all contents of a service
 * 
 */
public class APIRequestContentAggregator extends APIRequest{

	public APIRequestContentAggregator() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns the API content aggregated for the service. The content is concatenated before being returned.
	 * @param contentId represents the ID of the content to be returned
	 * @return returns stored content or null in case it doesn't exist
	 */
	@Override
	public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
		if(this.services.containsKey(serviceId)) {
			return this.services.get(serviceId).getContent("0");
		}else throw new ServiceNotFoundException();
	}

}
