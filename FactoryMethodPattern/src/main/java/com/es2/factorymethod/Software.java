package com.es2.factorymethod;

public class Software implements Product {
	private String brand;

	protected Software() {}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
