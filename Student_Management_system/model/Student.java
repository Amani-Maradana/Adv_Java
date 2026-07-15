package com.codegnan.sms.model;

public class Student {
	private int studentID;
	private String name;
	private String course;
	private double marks;
	private String email;
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return String.format("Student[id=%-3d name=%-20s course=%-15s marks=%.1f email=%s]",studentID,name,course,marks,email);
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(String name, String course, double marks, String email) {
		super();
		this.name = name;
		this.course = course;
		this.marks = marks;
		this.email = email;
	}
	public Student(int studentID, String name, String course, double marks, String email) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.course = course;
		this.marks = marks;
		this.email = email;
	}
	
	

}
