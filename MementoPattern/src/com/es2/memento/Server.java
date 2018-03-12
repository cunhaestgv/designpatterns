package com.es2.memento;

import java.util.ArrayList;

/**
 * 
 * Stores student names.
 *
 */
public class Server {
	private ArrayList<String> studentNames = new ArrayList<String>();
	
	public Server(){}
	
	/**
	 * Adds a new student name
	 * @param studentName the student name to be added
	 * @throws ExistingStudentException thrown when the student name already exists
	 */
	public void addStudent(String studentName) throws ExistingStudentException {
		if(this.studentNames.contains(studentName))
			throw new ExistingStudentException();
		this.studentNames.add(studentName);
	}
	
	/**
	 * Backups the server state to a Memento object
	 * @return the Memento object with the backup
	 */
	public Memento backup() {
        return new Memento(studentNames);
    }
	
	/**
	 * Restores a previous server state
	 * @param state the state to be restored
	 */
    public void restore(Memento state) {
    		this.studentNames = state.getState();
    }
    
    /**
     * Return the student names
     * @return list of student names
     */
    public ArrayList<String> getStudentNames(){
    		return this.studentNames;
    }
	
}
