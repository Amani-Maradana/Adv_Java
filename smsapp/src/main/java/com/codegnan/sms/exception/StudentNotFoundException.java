package com.codegnan.sms.exception;

public class StudentNotFoundException extends Exception{
	private final int studentId;
	public StudentNotFoundException(String msg) {
		super(msg);
		this.studentId=-1;
	}
	public StudentNotFoundException(int studentId) {
		super("Student Not Found with Id "+studentId);
		this.studentId = studentId;
	} 
	public int getStudentId() {
		return studentId;
	}

}
