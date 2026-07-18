package com.codegnan.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("eemail");
		String mobile = request.getParameter("emobile");
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		int number =(int)hs.getAttribute("number");
		String name = (String)hs.getAttribute("name");
		double salary = (double) hs.getAttribute("salary");
		String address = (String) hs.getAttribute("address");
		PrintWriter out = response.getWriter();
		  out.println("<html>");
	       out.println("<body bgcolor='lightgreen'>");
	       out.println("<center><br><br>");
	       // table with border
	       out.println("<table bgcolor='lightyellow' border='2' cellpadding='8' cellspacing='0'>");
	       out.println("<tr>");
	       out.println("<td colspan='2' align='center'>");
	       out.println("<b><font size='5' color='red'><u>Registration Details</u></font></b>");
	       out.println("</td>");
	       out.println("</tr>");
	       out.println("<tr><td><b>Employee Number</b></td><td>" + number + "</td></tr>");
	       out.println("<tr><td><b>Employee Name</b></td><td>" + name + "</td></tr>");
	       out.println("<tr><td><b>Employee Salary</b></td><td>" + salary + "</td></tr>");
	       out.println("<tr><td><b>Employee Address</b></td><td>" + address + "</td></tr>");
	       out.println("<tr><td><b>Employee Email</b></td><td>" + email + "</td></tr>");
	       out.println("<tr><td><b>Employee Phone</b></td><td>" + mobile + "</td></tr>");
	       out.println("<tr><td><b>Status</b></td><td>Success</td></tr>");
	       out.println("</table>");
	       out.println("</center>");
	       out.println("</body>");
	       out.println("</html>");


	}

}
