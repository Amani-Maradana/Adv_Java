package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {
	private static final String driver_name = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	private static final String userName = "root";
	private static final String password = "root";
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
				
		try {
			Class.forName(driver_name);
			
			con = DriverManager.getConnection(JDBC_URL,userName,password);
			st = con.createStatement();
			String sqlQuery = "create table if not exists employee("+"eno int auto_increment primary key,"+"ename varchar(100),"
			                        +"esal decimal(10,2),"+"eaddr varchar(30)"+")";
			st.execute(sqlQuery);
			System.out.println("table created");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
