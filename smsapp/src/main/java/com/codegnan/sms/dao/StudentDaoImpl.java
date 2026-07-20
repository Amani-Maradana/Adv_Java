package com.codegnan.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.model.Student;
import com.codegnan.sms.util.DbConnection;

public class StudentDaoImpl implements StudentDao {
	private static final String INSERT_SQL = "insert into students(name, course, marks, email) values(?,?,?,?)";
	private static final String SELECT_ALL_SQL = "select student_id, name, course, marks, email from students order by student_id";
	private static final String SELECT_BY_ID = "select student_id, name, course, marks, email from students where student_id = ?";
	private static final String SELECT_BY_COURSE = "select student_id, name, course, marks, email from students where course = ?";
	private static final String UPDATE_SQL = "update students set marks = ? where student_id = ?";
	// FIX 1: Corrected SQL syntax for delete command
	private static final String DELETE_SQL = "delete from students where student_id = ?";
	
	private Student mapRow(ResultSet rs) throws SQLException {
		return new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
	}

	@Override
	public int save(Student student) throws SQLException {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, student.getName());
			ps.setString(2, student.getCourse());
			ps.setDouble(3, student.getMarks());
			ps.setString(4, student.getEmail());
			
			int rows = ps.executeUpdate();
			try(ResultSet keys = ps.getGeneratedKeys()) {
				if(keys.next()) {
					student.setStudentID(keys.getInt(1)); // Ensure setStudentID matches your Model class method exact name
				}
			}
			return rows;
		}
	}

	@Override
	public List<Student> findAll() throws SQLException {
		List<Student> list = new ArrayList<>();
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_SQL);
				ResultSet rs = ps.executeQuery()) {
			while(rs.next()) {
				list.add(mapRow(rs));
			}
		}
		return list;
	}

	@Override
	public Student findbyId(int studentId) throws SQLException, StudentNotFoundException {
		// FIX 2: Corrected method syntax, parameter mapping, and return statement
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {
			ps.setInt(1, studentId);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					return mapRow(rs);
				} else {
					throw new StudentNotFoundException(studentId);
				}
			}
		}
	}

	@Override
	public List<Student> findStudentByCourse(String course) throws SQLException {
		List<Student> list = new ArrayList<>();
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_BY_COURSE)) {
			// FIX 3: Bind the course parameter to the '?' placeholder
			ps.setString(1, course);
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					list.add(mapRow(rs));
				}
			}			
		}
		return list;
	}

	@Override
	public int updateStudentMarks(int studentId, double newMarks) throws SQLException, StudentNotFoundException {
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {
			ps.setDouble(1, newMarks);
			ps.setInt(2, studentId);
			int rows = ps.executeUpdate();
			if(rows == 0) {
				throw new StudentNotFoundException(studentId);
			}
			return rows;
		}
	}

	@Override
	public int deleteById(int studentId) throws SQLException, StudentNotFoundException {
		// FIX 4: Changed reference to the corrected DELETE_SQL string
		try(Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQL)) {
			ps.setInt(1, studentId);
			int rows = ps.executeUpdate();
			if(rows == 0) {
				throw new StudentNotFoundException(studentId);
			}
			return rows;
		}
	}
}
