package com.es2.multipleconditions;

public class Marks {
	private int writtenTest;
	private float attendance;
	private int work;
	
	public Marks(int writtenTest, float attendance, int work) {
		this.writtenTest = writtenTest;
		this.attendance = attendance;
		this.work = work;
	}

	public int getWrittenTest() {
		return writtenTest;
	}

	public float getAttendance() {
		return attendance;
	}

	public int getWork() {
		return work;
	}
	
	
}
