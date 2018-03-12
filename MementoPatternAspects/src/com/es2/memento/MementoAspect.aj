package com.es2.memento;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public aspect MementoAspect {
	String[] methodsAndParameters = {"No tests to validate added students",
				"No tests to validate list of students retrieved",
				"No tests to validate ExistingStudentException Thrown",
				"No tests to validate creation of snapshot",
				"No tests to validate Server return to a previous snapshot",
				"No tests to validate Server NotExistingSnapshotException is thrown"};
	
	@Before("execution(* Server.addStudent(..))")
	public void call1(){this.methodsAndParameters[0] = null;}
	
	@Before("execution(* Server.getStudentNames())")
	public void call2(){ this.methodsAndParameters[1] = null; }
	
	@AfterThrowing(value = "(execution(* Server.addStudent(..)))", throwing = "e")
	public void call3(ExistingStudentException e){ this.methodsAndParameters[2] = null; }
	
	@Before("execution(* BackupService.takeSnapshot())")
	public void call4(){ this.methodsAndParameters[3] = null; }
	
	@Before("execution(* BackupService.restoreSnapshot(..))")
	public void call5(){ this.methodsAndParameters[4] = null; }
	
	@AfterThrowing(value = "(execution(* BackupService.restoreSnapshot(..)))", throwing = "e")
	public void call6(NotExistingSnapshotException e){ this.methodsAndParameters[5] = null; }

	
	@Before("execution(* tearDown(..))")
	  public void calln() {
		String errors = "";
		
		for(String s:methodsAndParameters)
			if(s!=null) errors+= s + "\n";
		
	    if(errors != "") 
	    		throw new RuntimeException(errors);
	  }
}
