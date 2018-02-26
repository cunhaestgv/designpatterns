package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ReusablePool {
	private static ReusablePool object = null;
	private ArrayList<HttpURLConnection> connectionsfree = new ArrayList<HttpURLConnection>();
	private ArrayList<HttpURLConnection> connectionsused = new ArrayList<HttpURLConnection>();
	private int maxSize=10;
	
	private ReusablePool(){}
	
	
	public static ReusablePool getInstance(){
		if(object == null) object = new ReusablePool();
				
		return object;
	}
	
	public synchronized HttpURLConnection acquire() throws IOException, PoolExhaustedException{
		HttpURLConnection con= null;
		if(this.connectionsfree.isEmpty())
			if(this.connectionsused.size() < this.maxSize) {
				URL url = new URL("http://www.ipv.pt");
				con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				this.connectionsused.add(con);
			}else throw new PoolExhaustedException();		
		else {
			this.connectionsused.add(this.connectionsfree.get(0));
			this.connectionsfree.remove(0);	
		} 
		return con;
	}
	
	public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException{
		int i = this.connectionsused.indexOf(conn);
		if(i != -1) {
			this.connectionsfree.add(this.connectionsused.get(i));
			this.connectionsused.remove(i);
		}else throw new ObjectNotFoundException();
	}
	
	public synchronized void resetPool() {
		object = null;
	}
	
	public void setMaxPoolSize(int size) {
		this.maxSize = size;
	} 
	
	
}
