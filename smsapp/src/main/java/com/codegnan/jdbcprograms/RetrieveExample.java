package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveExample {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jfs2vsp";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        String sqlQuery = "SELECT * FROM employee";

        // Place Connection, Statement, and ResultSet in the try-with-resources block
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {

            System.out.println("eno\tename\tesal\teaddr");
            System.out.println("------------------------------------");
            
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + 
                                   rs.getString(2) + "\t" + 
                                   rs.getDouble(3) + "\t" + 
                                   rs.getString(4));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
