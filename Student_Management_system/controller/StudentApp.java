package com.codegnan.sms.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.model.Student;
import com.codegnan.sms.service.StudentService;
import com.codegnan.sms.service.StudentServiceImpl;

public class StudentApp {
	private static final Scanner sc = new Scanner(System.in);
	private static final StudentService service = new StudentServiceImpl();

	public static void main(String[] args) {
		boolean running = true;
		while (running) {
			printMenu();
			int choice = readInt("Enter your choice");
			switch (choice) {
			case 1:
				insertStudent();
				break;
			case 2:
				viewAllStudents();
				break;
			case 3:
				viewStudentById();
				break;
			case 4:
				viewStudentByCourse();
				break;
			case 5:
				updateStudentMarks();
				break;
			case 6:
				deleteStudent();
				break;
			case 7:
				running = false;
				System.out.println("Thank you for using Student Management System");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 to 7");
			}
		}
		sc.close();
	}

	public static int readInt(String prompt) {
		System.out.println(prompt);
		while (!sc.hasNextInt()) {
			System.out.println("Please enter a valid whole number");
			sc.next();
		}
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}

	public static double readDouble(String prompt) {
		System.out.println(prompt);
		while (!sc.hasNextDouble()) {
			System.out.println("Please enter a valid whole number");
			sc.next();
		}
		double value = sc.nextDouble();
		sc.nextLine();
		return value;
	}

	private static void printMenu() {
		System.out.println("||=====================================================================||");
		System.out.println("||======================Student Management System======================||");
		System.out.println("||======================1. Add Student=================================||");
		System.out.println("||======================2. View All Students===========================||");
		System.out.println("||======================3. View Student by ID==========================||");
		System.out.println("||======================4. View Students by Course=====================||");
		System.out.println("||======================5. Update Student Marks========================||");
		System.out.println("||======================6. Delete Student==============================||");
		System.out.println("||======================7. Exit========================================||");
		System.out.println("||=====================================================================||");
	}

	private static void insertStudent() {
		try {
			System.out.print("Enter Name : ");
			String name = sc.nextLine();
			System.out.print("Enter Course : ");
			String course = sc.nextLine();
			double marks = readDouble("Enter Marks");
			System.out.print("Enter Email : ");
			String email = sc.nextLine();

			// If your constructor requires 5 parameters, use: new Student(0, name, course,
			// marks, email);
			Student student = new Student(name, course, marks, email);
			service.addStudent(student);
			System.out.println("Student Added Successfully! ID is generated automatically.");
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid input: " + e.getMessage());
		}
	}

	private static void viewAllStudents() {
		try {
			List<Student> students = service.getAllStudents();
			if (students.isEmpty()) {
				System.out.println("No student found");
			} else {
				students.forEach(System.out::println);
			}
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		}
	}

	// FIX: Completed method implementation
	private static void viewStudentById() {
		int id = readInt("Enter Student ID to view: ");
		try {
			Student student = service.getStudentById();
			System.out.println("Student Details: " + student);
		} catch (StudentNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		}
	}

	// FIX: Added missing method
	private static void viewStudentByCourse() {
		System.out.print("Enter Course Name: ");
		String course = sc.nextLine();
		try {
			List<Student> students = service.getStudentByCourse(course);
			if (students.isEmpty()) {
				System.out.println("No students found enrolled in course: " + course);
			} else {
				students.forEach(System.out::println);
			}
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		}
	}

	// FIX: Added missing method
	private static void updateStudentMarks() {
		int id = readInt("Enter Student ID to update marks: ");
		double newMarks = readDouble("Enter New Marks: ");
		try {
			service.updateStudentMarks(id, newMarks);
			System.out.println("Student marks updated successfully!");
		} catch (StudentNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid input: " + e.getMessage());
		}
	}

	// FIX: Added missing method
	private static void deleteStudent() {
		int id = readInt("Enter Student ID to delete: ");
		try {
			service.deleteStudent(id);
			System.out.println("Student record deleted successfully!");
		} catch (StudentNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println("Database error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("Invalid input: " + e.getMessage());
		}
	}
}
