package com.es2.stubs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;

public aspect StubsTopDownIntegration{
	String[] methodsAndParameters = {
			"Missing Test Constructor()",
			"Missing Correct setBookService()",
			"Missing Correct setBookValidatorService()",
			"Missing Correct getTotalBooks()"
	};
	
	@Before("execution(AuthorServiceImpl.new(..))")
	public  void call1() {		
		this.methodsAndParameters[0]=null;
	}
	
	@Before("execution(* *.setBookService(..))")
	public  void call2(JoinPoint jp) {
		if(jp.getArgs()[0] instanceof MockBookServiceImpl)
			this.methodsAndParameters[1]=null;
	}
	
	@Before("execution(* *.setBookValidatorService(..))")
	public  void call3(JoinPoint jp) {
		if(jp.getArgs()[0] instanceof FakeBookValidatorService)
			this.methodsAndParameters[2]=null;
	}
	@AfterReturning(pointcut="execution(* AuthorServiceImpl.getTotalBooks(..))", returning = "returnValue")
	public  void call4(int returnValue) {
		if(returnValue == 3) this.methodsAndParameters[3]=null;;
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
