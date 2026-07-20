package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertRecordByPreparedStatement {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

	public static void main(String[] args) {
		String insertQuery = "insert into employee(eno,ename,esal,eaddr) values(?,?,?,?)";
		try(Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
				PreparedStatement pst = con.prepareStatement(insertQuery)){
			pst.setInt(1, 888);
			pst.setString(2, "janu");
			pst.setInt(3,70000);
			pst.setString(4, "hyd");
			int rowsAffected = pst.executeUpdate();
			if(rowsAffected == 1) {
            	System.out.println("records inserted successfully");
			}
			else {
				System.out.println("recond insertion failed");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
