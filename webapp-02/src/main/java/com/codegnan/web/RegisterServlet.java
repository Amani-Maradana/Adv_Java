package com.codegnan.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String email = request.getParameter("uemail");
		String phone = request.getParameter("umobile");
		String address = request.getParameter("uaddr");
		out.println("<html><body>");
		out.println("<h2 style = 'color:red'> User Registration details</h2>");
		out.println("<p><b>User name :</b>"+name+"</p>");
		out.println("<p><b>User password :</b>"+password+"</p>");
		out.println("<p><b>User email :</b>"+email+"</p>");
		out.println("<p><b>User phone :</b>"+phone+"</p>");
		out.println("<p><b>User address :</b>"+address+"</p>");
		out.println("</body></html>");
		out.close();

	}

}
