package com.es2.multipleconditions;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

public aspect TestWhiteBoxCondition {
	String[] methodsAndParameters = {
			"Missing Null condition of assertConditionsToDrive()",
			"Missing age>=18 condition of assertConditionsToDrive()",
			"Missing age<18 condition of assertConditionsToDrive()",
			"Missing condition 1 of findName()",
			"Missing condition 2 of findName()",
			"Missing comb1 of approved()",
			"Missing comb2 of approved()",
			"Missing comb3 of approved()",
			"Missing comb4 of approved()",
			"Missing comb5 of approved()",
			"Missing comb6 of approved()",
			"Missing comb7 of approved()",
			"Missing comb8 of approved()"
	};

	@Before("execution(* DriveUtils.assertConditionsToDrive(..))")
	public void call1(JoinPoint jp){
		Person p = (Person) jp.getArgs()[0];
		int age = 0;
		if(p!=null) age = p.getAge();
		
		if(p==null)
			methodsAndParameters[0] = null;
		if(p!=null && p.getAge()>=18)
			methodsAndParameters[1] = null;
		if(p!=null && p.getAge()<18)
			methodsAndParameters[2] = null;
	}
	
	@Before("execution(* ListUtils.findName(..))")
	public void call2(JoinPoint jp){
		ArrayList<String> a = (ArrayList<String>) jp.getArgs()[0];
		String name = (String) jp.getArgs()[1];
		
		if(a.contains(name))
			methodsAndParameters[3] = null;
		if(!a.contains(name))
			methodsAndParameters[4] = null;
	}
	
	@Before("execution(* CourseUtils.approved(..))")
	public void call3(JoinPoint jp){
		Marks record = (Marks) jp.getArgs()[0];		
		
		if(record.getAttendance() > 0.66 && record.getWork() >= 10 && record.getWrittenTest()>=9.5)
			methodsAndParameters[5] = null;
		if(record.getAttendance() > 0.66 && record.getWork() < 10 && record.getWrittenTest()>=9.5)
			methodsAndParameters[6] = null;
		if(record.getAttendance() > 0.66 && record.getWork() >= 10 && record.getWrittenTest()<9.5)
			methodsAndParameters[7] = null;
		if(record.getAttendance() > 0.66 && record.getWork() < 10 && record.getWrittenTest()<9.5)
			methodsAndParameters[8] = null;
		
		if(record.getAttendance() <= 0.66 && record.getWork() >= 10 && record.getWrittenTest()>=9.5)
			methodsAndParameters[9] = null;		
		if(record.getAttendance() <= 0.66 && record.getWork() < 10 && record.getWrittenTest()>=9.5)
			methodsAndParameters[10] = null;
		if(record.getAttendance() <= 0.66 && record.getWork() >= 10 && record.getWrittenTest()<9.5)
			methodsAndParameters[11] = null;
		if(record.getAttendance() <= 0.66 && record.getWork() < 10 && record.getWrittenTest()<9.5)
			methodsAndParameters[12] = null;
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
