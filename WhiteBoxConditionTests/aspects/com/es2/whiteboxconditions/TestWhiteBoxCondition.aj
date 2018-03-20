package com.es2.whiteboxconditions;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;

public aspect TestWhiteBoxCondition {
	String[] methodsAndParameters = {
			"Missing test that validates evaluateScoreTemperature() 1º condition: score true",
			"Missing test that validates evaluateScoreTemperature() 1º condition: score false",
			"Missing test that validates evaluateScoreTemperature() 1º condition: temperature true",
			"Missing test that validates evaluateScoreTemperature() 1º condition: temperature false",
			"Missing test that validates evaluateScoreTemperature() 2º condition: score true",
			"Missing test that validates evaluateScoreTemperature() 2º condition: score false",
			"Missing test that validates evaluateScoreTemperature() 2º condition: temperature true",
			"Missing test that validates evaluateScoreTemperature() 2º condition: temperature false",
			"Missing test that validates evaluateIfCouldBeAcceptedAtDisco() condition: dressStyle true",
			"Missing test that validates evaluateIfCouldBeAcceptedAtDisco() condition: dressStyle false",
			"Missing test that validates evaluateIfCouldBeAcceptedAtDisco() condition: talkSkill true",
			"Missing test that validates evaluateIfCouldBeAcceptedAtDisco() condition: talkSkill false"
	};

	@Before("execution(* Rating.evaluateScoreTemperature(..))")
	public void call1(JoinPoint jp){
		int score = (int) jp.getArgs()[0];
		int temperature = (int) jp.getArgs()[1];
		
		if(score >= 10)
			methodsAndParameters[0] = null;
		if(score < 10)
			methodsAndParameters[1] = null;
		if(temperature >= 35)
			methodsAndParameters[2] = null;
		if(temperature < 35)
			methodsAndParameters[3] = null;
		if(score < 5)
			methodsAndParameters[4] = null;
		if(score >= 5)
			methodsAndParameters[5] = null;	
		if(temperature <= 20)
			methodsAndParameters[6] = null;
		if(temperature > 20)
			methodsAndParameters[7] = null;
	}
	
	@Before("execution(* Rating.evaluateIfCouldBeAcceptedAtDisco(..))")
	public void call2(JoinPoint jp){
		int dressStyle = (int) jp.getArgs()[0];
		int talkSkill = (int) jp.getArgs()[1];
		
		if(dressStyle >= 8)
			methodsAndParameters[8] = null;
		if(dressStyle < 8)
			methodsAndParameters[9] = null;
		if(talkSkill >= 5)
			methodsAndParameters[10] = null;
		if(talkSkill < 5)
			methodsAndParameters[11] = null;
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
