package com.es2.factorymethod;

public class Computer implements Product {
	private String brand;
	
	protected Computer() {}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


}
