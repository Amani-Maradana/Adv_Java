package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTable{
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	private static final String userName = "root";
	private static final String password = "root";
	
	public static void main(String [] args) {
		String sql = "update employee set ename = ?, esal = ?,eaddr = ? where eno = ?";
		try(Scanner sc = new Scanner(System.in);
				Connection con = DriverManager.getConnection(JDBC_URL, userName, password);
				PreparedStatement  ps = con.prepareStatement(sql)){
			
			System.out.println("enter the employee id you want to update : ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.println("enter the name : ");
			String name = sc.nextLine();
			System.out.println();
			System.out.println("enter the employee salary : ");
			double salary = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("enter the address : ");
			String addr = sc.nextLine();
			
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setString(3, addr);
			ps.setInt(4, id);

			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected ==1) {
				System.out.println("updated record");
			}
			else {
				System.out.println("updation failed");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}