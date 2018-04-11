package com.es2.causeeffect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public aspect CauseEffectDiagramAspect{
	String[] methodsAndParameters = {
			"Missing test pos 0",
			"Missing test pos > 0",
			"Missing test pos < 0",
			"Missing test pos == size()+1",
			"Missing null object test"
	};

	@Before("execution(* GenericList.insert(..))")
	public void call1(JoinPoint jp){
		int pos = (int) jp.getArgs()[0];
		int internalListSize = ((GenericList) jp.getTarget()).size();
		Object obj = jp.getArgs()[1];
		
		if(pos == 0) methodsAndParameters[0] = null;
		if(internalListSize > 0) methodsAndParameters[1] = null;
		if(pos == -1) methodsAndParameters[2] = null;
		if(pos == internalListSize+1) methodsAndParameters[3] = null;
		if(obj == null) methodsAndParameters[4] = null;
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
