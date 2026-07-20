package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasicCommitDemo {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {
		String sqlQuery = "insert into employee values(?,?,?,?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
			con.setAutoCommit(false);
			System.out.println("transaction started");
			try (PreparedStatement ps = con.prepareStatement(sqlQuery)) {
				ps.setInt(1, 103);
				ps.setString(2, "swathi");
				ps.setDouble(3, 56000);
				ps.setString(4, "delhi");
				int r1 = ps.executeUpdate();
				System.out.println("frist record inserted" + r1);
				ps.setInt(1, 104);
				ps.setString(2, "prasana");
				ps.setDouble(3, 86000);
				ps.setString(4, "bihar");
				int r2 = ps.executeUpdate();
				System.out.println("second record inserted" + r2);

				
			}
			con.commit();
			System.out.println("Transaction commited successfully");

		} catch (SQLException e) {
			try{if(con != null) {
				con.rollback();
				System.out.println("transaction rolled back");
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("Error "+e.getMessage());
	}
	finally {
		try {
			if(con != null) {
				con.close();
				System.out.println("connection closed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		}
	}

}
