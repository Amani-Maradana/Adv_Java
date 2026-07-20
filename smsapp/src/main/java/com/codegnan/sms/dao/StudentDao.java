package com.codegnan.sms.dao;

import java.sql.SQLException;
import java.util.List;

import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.model.Student;

public interface StudentDao {
	int save(Student student) throws SQLException;
	List<Student> findAll()throws SQLException;
	Student findbyId(int studentId) throws SQLException,StudentNotFoundException;
	List<Student> findStudentByCourse(String course)throws SQLException;
	int updateStudentMarks (int studentId, double newMarks) throws  SQLException,StudentNotFoundException;
	public int deleteById (int studentId) throws SQLException,StudentNotFoundException;
	

}
