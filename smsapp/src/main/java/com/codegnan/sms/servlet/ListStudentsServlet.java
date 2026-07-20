package com.codegnan.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.codegnan.sms.model.Student;
import com.codegnan.sms.service.StudentService;
import com.codegnan.sms.service.StudentServiceImpl;
import com.codegnan.sms.util.HtmlPage;

/** Shows every student in a table. Linked from the nav bar as "View All". */
@WebServlet("/list")
public class ListStudentsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ctx = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HtmlPage.writeHeader(out, ctx, "All Students");
            out.println("<h1>All Students</h1>");
            try {
                List<Student> students = studentService.getAllStudents();
                if (students.isEmpty()) {
                    out.println("<p class=\"empty-msg\">No students found.</p>");
                } else {
                    out.println("<table class=\"data-table\">");
                    out.println("<thead><tr><th>ID</th><th>Name</th><th>Course</th><th>Marks</th><th>Email</th></tr></thead>");
                    out.println("<tbody>");
                    for (Student s : students) {
                        out.println("<tr>");
                        out.println("<td>" + s.getStudentID() + "</td>");
                        out.println("<td>" + HtmlPage.escape(s.getName()) + "</td>");
                        out.println("<td>" + HtmlPage.escape(s.getCourse()) + "</td>");
                        out.println("<td>" + s.getMarks() + "</td>");
                        out.println("<td>" + HtmlPage.escape(s.getEmail()) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody></table>");
                }
            } catch (SQLException e) {
                HtmlPage.writeError(out, "Database error: " + e.getMessage(), ctx);
            }
            HtmlPage.writeFooter(out);
        }
    }
}
