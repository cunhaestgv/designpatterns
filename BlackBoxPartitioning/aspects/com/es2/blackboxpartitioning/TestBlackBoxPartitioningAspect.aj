package com.es2.blackboxpartitioning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;

public aspect TestBlackBoxPartitioningAspect{
	String[] methodsAndParameters = {
			"Missing Die()",
			"Missing Die(int)",
			"Missing Die(int, int)",
			"Missing key value when return Die.getNumSides()",
			"Missing key value when return Die.getResult()",
			"Missing incorrect value when return Die.getNumSides()",
			"Missing incorrect value when return Die.getNumSides()",
			"Missing roll()",
			"Missing toString()",
			"Missing size=0 findMin()",
			"Missing size>0 findMin()",
			"Missing negative size goodResize()",
			"Missing vec.length < newSize goodResize()",
			"Missing vec.length >= newSize goodResize()",
	};

	@Before("execution(Die.new(..))")
	public void call1(JoinPoint jp){
		int nParams = jp.getArgs().length;
		
		methodsAndParameters[nParams] = null;
		
		if(nParams >0) {
			int nSides = (int) jp.getArgs()[0];
			if(nSides <=1) methodsAndParameters[5] = null;
			if(nSides >6) methodsAndParameters[6] = null;
		}
	}
	
	@Before("execution(* roll())")
	public void call3(JoinPoint jp){
		methodsAndParameters[7] = null;
	}
	
	@Before("execution(* toString())")
	public void call4(JoinPoint jp){
		methodsAndParameters[8] = null;
	}
	
	@AfterReturning(pointcut= "execution(* Die.getNumSides(..))",returning="returnValue")
	public void call2(int returnValue){
		
		if(returnValue==6)
			methodsAndParameters[3] = null;
	}
	
	@AfterReturning(pointcut="execution(* Die.getResult(..))", returning = "returnValue")
	public void call3(int returnValue){
		
		if(returnValue==1)
			methodsAndParameters[4] = null;
	}
	
	@Before("execution(* findMin(..))")
	public void call5(JoinPoint jp){
		int[] vec = (int[]) jp.getArgs()[0];
		
		if(vec.length ==0)
			methodsAndParameters[9] = null;
		if(vec.length >0)
			methodsAndParameters[10] = null;
		
	}
	
	@Before("execution(* goodResize(..))")
	public void call6(JoinPoint jp){
		int[] vec = (int[]) jp.getArgs()[0];
		int newSize = (int) jp.getArgs()[1];
		
		if(newSize < 0)
			methodsAndParameters[11] = null;
		if(vec.length < newSize)
			methodsAndParameters[12] = null;
		if(vec.length >= newSize)
			methodsAndParameters[13] = null;
		
	}
	

	@Before("execution(* tearDownAfterClass(..))")
	public  void calln() {
		String errors = "";

		for(String s:methodsAndParameters)
			if(s!=null) errors+= s + "\n";

		if(errors != "") 
			throw new RuntimeException(errors);
	}

}
