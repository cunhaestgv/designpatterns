package com.es2.memento;

import java.util.ArrayList;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public aspect MementoAspect {
	ArrayList<String> methodsAndParameters = null;
	
	public void init() {
		methodsAndParameters = new ArrayList<String>();
		methodsAndParameters.add("No tests to validate added students");
		methodsAndParameters.add("No tests to validate list of students retrieved");
		methodsAndParameters.add("No tests to validate ExistingStudentException Thrown");
		methodsAndParameters.add("No tests to validate creation of snapshot");
		methodsAndParameters.add("No tests to validate Server return to a previous snapshot");
		methodsAndParameters.add("No tests to validate Server NotExistingSnapshotException is thrown");
	}
	
	@Before("execution(* Server.addStudent(..))")
	public void call1(){
		if(methodsAndParameters == null ) init();
		methodsAndParameters.remove("No tests to validate added students");}
	
	@Before("execution(* Server.getStudentNames())")
	public void call2(){
		if(methodsAndParameters == null ) init();
		methodsAndParameters.remove("No tests to validate list of students retrieved");}
	
	@AfterThrowing(value = "execution(* Server.addStudent(..))", throwing = "e")
	public void call3(ExistingStudentException e){
		if(methodsAndParameters == null ) init();
		methodsAndParameters.remove("No tests to validate ExistingStudentException Thrown");}
	
	@Before("execution(* BackupService.takeSnapshot())")
	public void call4(){
		if(methodsAndParameters == null ) init();
		methodsAndParameters.remove("No tests to validate creation of snapshot");}
	
	@Before("execution(* BackupService.restoreSnapshot(..))")
	public void call5(){
		if(methodsAndParameters == null ) init();
		methodsAndParameters.remove("No tests to validate Server return to a previous snapshot");}
	
	@AfterThrowing(value = "execution(* BackupService.restoreSnapshot(..))", throwing = "e")
	public void call6(NotExistingSnapshotException e){
		if(methodsAndParameters == null ) init();
		methodsAndParameters.remove("No tests to validate Server NotExistingSnapshotException is thrown");}

	
	@Before("execution(* tearDownAfterClass(..))")
	  public void calln() {
		String errors = "";
		
		for(String s:methodsAndParameters)
			errors+= s + "\n";
		
	    if(errors != "") 
	    		throw new RuntimeException(errors);
	  }
}
