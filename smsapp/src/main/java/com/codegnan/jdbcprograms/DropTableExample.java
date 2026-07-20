package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableExample {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	private static final String userName = "root";
	private static final String password = "root";

	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection(JDBC_URL, userName, password)){
			Statement statement = connection.createStatement();
            String sql = "DROP TABLE IF EXISTS employee";
			statement.executeUpdate(sql);
			System.out.println("drop table excuted");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
