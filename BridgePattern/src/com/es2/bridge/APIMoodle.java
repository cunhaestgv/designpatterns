package com.es2.bridge;

import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * Moodle's service implementation
 * 
 */
public class APIMoodle implements APIServiceInterface {
	protected LinkedHashMap<String,String> content = new LinkedHashMap<String,String>();

	public APIMoodle() {
	}

	@Override
	public String getContent(String contentId) {
		if(contentId.equals("0")) {
			String agg="";
			for (String key : content.keySet()) agg += content.get(key);
			return agg;
		
		}else return this.content.get(contentId);
	}

	@Override
	public String setContent(String content) {
		String id= UUID.randomUUID().toString();
		this.content.put(id, content);
		return id;
	}
}
