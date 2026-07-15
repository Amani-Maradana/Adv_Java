package com.codegnan.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static {
		try {
			Class.forName(DbConfig.DRIVER);
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Mysql JDBC driver does not found on classpath :"+DbConfig.DRIVER,e);
		}
	}
	private DbConnection() {
		
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DbConfig.JDBC_URL ,DbConfig.userName,DbConfig.password);
	}

}
