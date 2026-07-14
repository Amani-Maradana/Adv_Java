package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTable {

	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
	    private static final String USER_NAME = "root";
	    private static final String PASSWORD = "root";

	    public static void main(String[] args) {
	        String sql = "UPDATE employee SET name = ?, salary = ?, address = ? WHERE id = ?";

	        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql);
	             Scanner sc = new Scanner(System.in)) {

	            System.out.print("Enter the Employee ID you want to update: ");
	            int id = sc.nextInt();
	            sc.nextLine(); 

	            System.out.print("Enter new employee name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter new employee salary: ");
	            double salary = sc.nextDouble();
	            sc.nextLine(); 

	            System.out.print("Enter new employee address: ");
	            String address = sc.nextLine();


	            preparedStatement.setString(1, name);
	            preparedStatement.setDouble(2, salary);
	            preparedStatement.setString(3, address);
	            preparedStatement.setInt(4, id);


	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Success: " + rowsAffected + " employee record(s) updated.");
	            } else {
	                System.out.println("Failure: No employee found with ID " + id);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }  

}
