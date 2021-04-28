package com.es2.blackboxpartitioning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import java.io.ByteArrayOutputStream;

public aspect TestBlackBoxPartitioningAspect{
	String[] methodsAndParameters = {
			"Missing test for constructor of Die",
			"Missing test for constructor of Die",
			"Missing test for constructor of Die",
			"Missing test for Die.getNumSides()",
			"Missing test for Die.getResult()",
			"Missing test for Die.getNumSides()",
			"Missing test for Die.getNumSides()",
			"Missing test for roll()",
			"Missing test for toString()",
			"Missing test for findMin()",
			"Missing test for findMin()",
			"Missing test for goodResize()",
			"Missing test for goodResize()",
			"Missing test for goodResize()",
			"Missing test for findAndPrintPairs(..)",
			"Missing test for findAndPrintPairs(..)",
			"Missing test for findAndPrintPairs(..)",
			"Missing test for findAndPrintPairs(..)",
			null,
			"Missing test for showList(..)",
			"Missing test for showList(..)",
			"Missing test for isAscending(..)",
			"Missing test for isAscending(..)",
			"Missing test for isAscending(..)",
			"Missing test for isAscending(..)",
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
	
	@Before("execution(* findAndPrintPairs(..))")
	public void call7(JoinPoint jp){
		int[] vec = (int[]) jp.getArgs()[0];
		int target = (int) jp.getArgs()[1];
		
		if(target == 0)
			methodsAndParameters[14] = null;
		if(target == 1)
			methodsAndParameters[15] = null;
		if(vec.length == 0)
			methodsAndParameters[16] = null;
		if(vec.length > 0)
			methodsAndParameters[17] = null;
		
	}
	
	@Before("call(* ByteArrayOutputStream.toString(..))")
	public void call8(){
		if(methodsAndParameters[18] != null && methodsAndParameters[18].endsWith("|||"))	
			methodsAndParameters[18] = null;
		else methodsAndParameters[18] += "|";
		
	}	
	
	@Before("execution(* showList(..))")
	public void call9(JoinPoint jp){
		int[] vec = (int[]) jp.getArgs()[0];
		
		if(vec.length == 0)
			methodsAndParameters[19] = null;
		if(vec.length >= 1)
			methodsAndParameters[20] = null;
	}
	
	@Before("execution(* isAscending(..))")
	public void call10(JoinPoint jp){
		int[] vec = (int[]) jp.getArgs()[0];
		
		if(vec.length == 0)
			methodsAndParameters[21] = null;
		if(vec.length >= 1)
			methodsAndParameters[22] = null;
	}
	
	@AfterReturning(pointcut="execution(* isAscending(..))", returning = "returnValue")
	public void call11(boolean returnValue){
		
		if(returnValue)
			methodsAndParameters[23] = null;
		else
			methodsAndParameters[24] = null;
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
