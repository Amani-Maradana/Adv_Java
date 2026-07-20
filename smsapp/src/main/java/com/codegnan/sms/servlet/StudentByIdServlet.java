package com.codegnan.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.codegnan.sms.exception.StudentNotFoundException;
import com.codegnan.sms.model.Student;
import com.codegnan.sms.service.StudentService;
import com.codegnan.sms.service.StudentServiceImpl;
import com.codegnan.sms.util.HtmlPage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Handles search-by-id.html (GET ?id=..) */
@WebServlet("/view")
public class StudentByIdServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ctx = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        String idParam = request.getParameter("id");

        try (PrintWriter out = response.getWriter()) {
            HtmlPage.writeHeader(out, ctx, "Search Student by ID");
            out.println("<h1>Search Student by ID</h1>");
            try {
                int id = Integer.parseInt(idParam);
                Student s = studentService.getStudentById(id);

                out.println("<table class=\"data-table\">");
                out.println("<thead><tr><th>ID</th><th>Name</th><th>Course</th><th>Marks</th><th>Email</th></tr></thead>");
                out.println("<tbody><tr>");
                out.println("<td>" + s.getStudentID() + "</td>");
                out.println("<td>" + HtmlPage.escape(s.getName()) + "</td>");
                out.println("<td>" + HtmlPage.escape(s.getCourse()) + "</td>");
                out.println("<td>" + s.getMarks() + "</td>");
                out.println("<td>" + HtmlPage.escape(s.getEmail()) + "</td>");
                out.println("</tr></tbody></table>");

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
