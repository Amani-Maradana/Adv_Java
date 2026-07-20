package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRecordPS {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	private static final String userName = "root";
	private static final String password = "root";

	public static void main(String[] args) {
		String sql = "delete from employee where eno = ?";
		try(Scanner sc = new Scanner(System.in);
				Connection con = DriverManager.getConnection(JDBC_URL, userName, password);
				PreparedStatement ps = con.prepareStatement(sql)){
			
			System.out.println("enter the employee id :");
			int id = sc.nextInt();
			
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected ==1) {
				System.out.println("deleted");
			}
			else {
				System.out.println("not deleted");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
