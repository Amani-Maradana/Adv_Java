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

/** Handles submission of update-marks.html */
@WebServlet("/update")
public class UpdateMarksServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ctx = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        String idParam = request.getParameter("id");
        String marksParam = request.getParameter("marks");

        try (PrintWriter out = response.getWriter()) {
            HtmlPage.writeHeader(out, ctx, "Update Student Marks");
            out.println("<h1>Update Student Marks</h1>");
            try {
                int id = Integer.parseInt(idParam);
                double marks = Double.parseDouble(marksParam);
                studentService.updateStudentMarks(id, marks);
                HtmlPage.writeSuccess(out, "Marks for student ID " + id + " updated to " + marks, ctx);
            } catch (NumberFormatException e) {
                HtmlPage.writeError(out, "Student ID and Marks must be valid numbers.", ctx);
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
