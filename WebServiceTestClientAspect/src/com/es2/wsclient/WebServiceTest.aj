package com.es2.wsclient;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import java.net.URL;
import java.net.HttpURLConnection;

public aspect WebServiceTest {
	String[] methodsAndParameters = {
			"Test Normal Values",
			"Test Validation of Header Fields",
			"Test Incorrect Token",
			"Test Valid Response Code",
			"Test Invalid Response Code 1",
			"Test Invalid Response Code 2"
			
	};
	
	@Before("call(URL.new(..))")
	public  void call1(JoinPoint jp) {
		if(jp.getArgs()[0].toString().contains("8080/client/2"))
			this.methodsAndParameters[0]=null;
			
	}
	
	@Before("call(* HttpURLConnection.getHeaderField(..))")
	public  void call2(JoinPoint jp) {
		if(jp.getArgs()[0].toString().equals("Content-type"))
			this.methodsAndParameters[1]=null;
	}
	
	@Before("call(* HttpURLConnection.setRequestProperty(..))")
	public  void call3(JoinPoint jp) {
		if(! jp.getArgs()[1].toString().equals("Bearer 123456789"))
			this.methodsAndParameters[2]=null;
	}
	
	@AfterReturning(pointcut="call(* HttpURLConnection.getResponseCode(..))", returning = "returnValue")
	public  void call4(int returnValue) {
		if(returnValue == 200)
			this.methodsAndParameters[3]=null;
		if(returnValue == 404)
			this.methodsAndParameters[4]=null;
		if(returnValue == 401)
			this.methodsAndParameters[5]=null;
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
