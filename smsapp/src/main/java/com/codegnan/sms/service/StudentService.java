package com.codegnan.sms.service;

import java.sql.SQLException;
import java.util.List;

import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.model.Student;

public interface StudentService {
	int addStudent(Student student) throws SQLException;
	List<Student> getAllStudents() throws SQLException;
	Student getStudentById(int id) throws SQLException,StudentNotFoundException;
	List<Student> getStudentByCourse(String course) throws SQLException;
	int updateStudentMarks(int studentId,double newMarks) throws SQLException,StudentNotFoundException;
	int deleteStudent (int studentId) throws SQLException,StudentNotFoundException;
	Student getStudentById() throws SQLException, StudentNotFoundException;
	
	

}
