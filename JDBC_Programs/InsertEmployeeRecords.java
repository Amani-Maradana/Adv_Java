package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertEmployeeRecords {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	private static final String userName = "root";
	private static final String password = "root";

	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection(JDBC_URL, userName, password)){
			Statement statement = connection.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter number of records you want to enter : ");
			int num = sc.nextInt();
			for(int i =1;i<=num;i++) {
				 System.out.print("Enter employee id: ");
	                int id = sc.nextInt();
	                
	                sc.nextLine(); 
	                
	                System.out.print("Enter employee name: ");
	                String name = sc.nextLine();
	                
	                System.out.print("Enter employee salary: ");
	                double salary = sc.nextDouble();
	                
	                System.out.print("Enter employee address: ");
	                String address = sc.next();
	                
	                String sql = "INSERT INTO employee VALUES (" + id + ", '" + name + "', " + salary + ", '" + address + "')";
	                
            int rowsAffected = statement.executeUpdate(sql);
            if(rowsAffected == 1) {
            	System.out.println("records inserted successfully");
            }
            else {
            	System.out.println("record insertion failure");
            }
			System.out.println("drop table excuted");
			}
		sc.close();
		}catch(

	SQLException e)
	{
		e.printStackTrace();
	}

}


}
