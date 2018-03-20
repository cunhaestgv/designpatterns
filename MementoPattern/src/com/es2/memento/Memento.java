package com.es2.memento;

import java.util.ArrayList;

/**
 * 
 * Stores a snapshot of the Server state
 *
 */
public class Memento {
	private ArrayList<String> studentNames = new ArrayList<String>();

	/**
	 * The constructor stores the student names stored by the Server
	 * @param studentNames the ArrayList with the student names 
	 */
	public Memento(ArrayList<String> studentNames) {
		this.studentNames = 	new ArrayList<String>(studentNames);
	}

	/**
	 * Return the Server state stored by the memento
	 * @return the ArrayList of student names
	 */
	public ArrayList<String> getState() {
		return this.studentNames;
	}
}
