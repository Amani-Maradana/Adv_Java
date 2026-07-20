package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class ResultsetMetaDataExample {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery("select * from employee limit 0")){
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for(int i = 1;i <= columnCount;i++) {
				System.out.println("column name : "+metaData.getColumnName(i));
				System.out.println("Data type : "+metaData.getColumnTypeName(i));
				System.out.println("is nullable : "+(metaData.isNullable(i)== ResultSetMetaData.columnNullable?"yes":"no"));
				System.out.println("is autoincrement : "+metaData.isAutoIncrement(i));
				System.out.println();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
