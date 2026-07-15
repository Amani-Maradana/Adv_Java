package com.codegnan.sms.service;

import java.sql.SQLException;
import java.util.List;

import com.codegnan.sms.dao.StudentDao; // Added missing import
import com.codegnan.sms.dao.StudentDaoImpl; // Added missing import
import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.model.Student;

public class StudentServiceImpl implements StudentService {
	// FIX 1: Added both data type AND the field name 'studentDao'
	private final StudentDao studentDao = new StudentDaoImpl();
	
	private void validateStudentId(int studentId) {
		if(studentId < 0) {
			throw new IllegalArgumentException("Student ID must be positive");
		}
	}
	
	// FIX 2: Added the missing validation method to prevent crash
	private void validateStudent(Student student) {
		if (student == null || student.getName() == null || student.getName().trim().isEmpty()) {
			throw new IllegalArgumentException("Student details cannot be empty");
		}
	}

	@Override
	public int addStudent(Student student) throws SQLException {
		validateStudent(student);
		// FIX 3: Call the method on 'studentDao', not 'student'
		return studentDao.save(student);
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		// FIX 4: Corrected spelling from 'studnetDao' to 'studentDao'
		return studentDao.findAll();
	}

	public Student getStudentById(int studentId) throws SQLException, StudentNotFoundException {
		validateStudentId(studentId);
		return studentDao.findbyId(studentId);
	}

	@Override
	public List<Student> getStudentByCourse(String course) throws SQLException {
		if (course == null || course.trim().isEmpty()) {
			throw new IllegalArgumentException("Course name cannot be empty");
		}
		return studentDao.findStudentByCourse(course);
	}

	@Override
	public int updateStudentMarks(int studentId, double newMarks) throws SQLException, StudentNotFoundException {
		validateStudentId(studentId);
		if (newMarks < 0 || newMarks > 100) {
			throw new IllegalArgumentException("Marks must be between 0 and 100");
		}
		return studentDao.updateStudentMarks(studentId, newMarks);
	}

	@Override
	public int deleteStudent(int studentId) throws SQLException, StudentNotFoundException {
		validateStudentId(studentId);
		return studentDao.deleteById(studentId);
	}

	@Override
	public Student getStudentById() throws SQLException, StudentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
