package com.codegnan.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.codegnan.sms.model.Student;
import com.codegnan.sms.service.StudentService;
import com.codegnan.sms.service.StudentServiceImpl;
import com.codegnan.sms.util.HtmlPage;

/**
 * Handles submission of the "Add Student" HTML form (add-student.html).
 * No JSP is used - the response HTML is written directly.
 */
@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ctx = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String marksParam = request.getParameter("marks");
        String email = request.getParameter("email");

        try (PrintWriter out = response.getWriter()) {
            HtmlPage.writeHeader(out, ctx, "Add Student");
            try {
                double marks = Double.parseDouble(marksParam);
                Student student = new Student(name, course, marks, email);
                studentService.addStudent(student);

                out.println("<h1>Add Student</h1>");
                HtmlPage.writeSuccess(out,
                        "Student '" + student.getName() + "' added successfully with ID " + student.getStudentID(),
                        ctx);

            } catch (NumberFormatException e) {
                out.println("<h1>Add Student</h1>");
                HtmlPage.writeError(out, "Marks must be a valid number.", ctx);
            } catch (IllegalArgumentException e) {
                out.println("<h1>Add Student</h1>");
                HtmlPage.writeError(out, "Invalid input: " + e.getMessage(), ctx);
            } catch (SQLException e) {
                out.println("<h1>Add Student</h1>");
                HtmlPage.writeError(out, "Database error: " + e.getMessage(), ctx);
            }
            HtmlPage.writeFooter(out);
        }
    }
}

