package com.es2.causeeffect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public aspect CauseEffectDiagramAspect{
	String[] methodsAndParameters = {
			"Missing test pos 0",
			"Missing test pos > 0",
			"Missing test pos < 0",
			"Missing test pos == size()+1",
			"Missing null object test",
			"Missing Boyer Text Comb 1",
			"Missing Boyer Pattern Comb 1",
			"Missing Boyer Pattern Comb 2",
			"Missing Boyer Pattern Comb 3",
			"Missing Boyer Min Chars Comb 1",
			"Missing Boyer Min Chars Comb 2",
			"Missing Boyer Min Chars Comb 3",
			"Missing Boyer Min Chars Comb 4",
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
	
	@Before("execution(* BoyerMoore.search(..))")
	public void call2(JoinPoint jp){
		String pattern = ((BoyerMoore) jp.getTarget()).pattern;
		String text = (jp.getArgs()[0]==null)?null:jp.getArgs()[0].toString();
		int minChars = Integer.parseInt(jp.getArgs()[1].toString());
		
		if(text== null)  methodsAndParameters[5]=null;
		else {  
			if(! text.contains(pattern))  methodsAndParameters[7]=null;
			if(pattern.length()>text.length()) methodsAndParameters[8]=null;
			if(minChars> pattern.length()) methodsAndParameters[9]=null;
			if(minChars < 0) methodsAndParameters[10]=null;
			if(minChars == 0 && text.contains(pattern)) methodsAndParameters[11]=null;
			if(minChars > 0 && text.contains(pattern)) methodsAndParameters[12]=null;
		}		
		
		
	}
	
	@Before("execution(BoyerMoore.new(..))")
	public void call3(JoinPoint jp){
		String pattern = (jp.getArgs()[0]==null)?null:jp.getArgs()[0].toString();
		
		if(pattern== null)  methodsAndParameters[6]=null;

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
