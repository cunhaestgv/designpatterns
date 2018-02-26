package com.es.composite;

public abstract class Menu {
	protected String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public abstract void showOptions();
}
