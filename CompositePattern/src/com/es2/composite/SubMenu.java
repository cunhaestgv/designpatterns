package com.es2.composite;
import java.util.ArrayList;

public class SubMenu extends Menu {
	private ArrayList<Menu> menus;	
	
	public SubMenu(){
		menus = new ArrayList<Menu>();
	}
	
	public void addChild(Menu child){
		this.menus.add(child);
	}
	
	public void removeChild(Menu child){
		this.menus.remove(child);
	}
	
	public void showOptions() {
		System.out.println(this.label);
		for(Menu m: menus)
			m.showOptions();
	}
}
