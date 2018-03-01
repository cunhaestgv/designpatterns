package com.es2.composite;

public class Link extends Menu {
	protected String URL;
	
	public Link(){
	}
	
	public String getURL() {
		return URL;
	}
	
	public void setURL(String URL) {
		this.URL = URL;
	}
	
	public void showOptions() {
		System.out.println(this.label);
		System.out.println(this.URL);
	}
}
