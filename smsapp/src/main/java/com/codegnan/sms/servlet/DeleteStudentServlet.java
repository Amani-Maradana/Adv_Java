package com.codegnan.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.service.StudentService;
import com.codegnan.sms.service.StudentServiceImpl;
import com.codegnan.sms.util.HtmlPage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Handles submission of delete-student.html */
@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ctx = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        String idParam = request.getParameter("id");

        try (PrintWriter out = response.getWriter()) {
            HtmlPage.writeHeader(out, ctx, "Delete Student");
            out.println("<h1>Delete Student</h1>");
            try {
                int id = Integer.parseInt(idParam);
                studentService.deleteStudent(id);
                HtmlPage.writeSuccess(out, "Student ID " + id + " deleted successfully.", ctx);
            } catch (NumberFormatException e) {
                HtmlPage.writeError(out, "Student ID must be a valid whole number.", ctx);
            } catch (IllegalArgumentException e) {
                HtmlPage.writeError(out, "Invalid input: " + e.getMessage(), ctx);
            } catch (StudentNotFoundException e) {
                HtmlPage.writeError(out, e.getMessage(), ctx);
            } catch (SQLException e) {
                HtmlPage.writeError(out, "Database error: " + e.getMessage(), ctx);
            }
            HtmlPage.writeFooter(out);
        }
    }
}
