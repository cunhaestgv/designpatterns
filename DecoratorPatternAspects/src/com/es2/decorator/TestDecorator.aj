package com.es2.decorator;
import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TestDecorator {
	String[] methodsAndParameters = {
			"Missing test that validates condition of Auth.auth() for true",
			"Missing test that validates condition of Auth.auth() for false",
			"Missing test that validates condition of CommonWordsValidator.auth() for exception 1",
			"Missing test that validates condition of CommonWordsValidator.auth() for exception 2"
	};

	@Before("execution(* Auth.auth(..))")
	public void call1(JoinPoint jp){
		String p1 = (String) jp.getArgs()[0];
		String p2 = (String) jp.getArgs()[1];
		if(p1.equals("admin") && p2.equals("admin"))
			methodsAndParameters[0] = null;
		else
			methodsAndParameters[1] = null;
	}
	
	@AfterReturning(pointcut= "execution(* CommonWordsValidator.getHTTPRequest(..))",returning="ret")
	public void call2(String ret){
			methodsAndParameters[3] = null;
	}
	
	@AfterThrowing(pointcut = "execution(* CommonWordsValidator.getHTTPRequest(..))", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, IOException e) {    
		methodsAndParameters[2] = null;
    }
	
	@Before("execution(End.new(..))")
	public  void calln() {
		String errors = "";

		for(String s:methodsAndParameters)
			if(s!=null) errors+= s + "\n";

		if(errors != "") 
			throw new RuntimeException(errors);
		
	}
}
