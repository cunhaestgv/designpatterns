package com.es2.multipleconditions;

public class DriveUtils {
	public static void assertConditionsToDrive(Person p) throws PersonCannotDriveException{
		if(p.getAge() <18 && p != null){
			throw new PersonCannotDriveException();
		}
	}
}
