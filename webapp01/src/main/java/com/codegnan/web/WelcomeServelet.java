package com.codegnan.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/welcome")

public class WelcomeServelet implements Servlet{
	
	public void init(ServletConfig arg0) throws ServletException {
		
	}
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style = 'color:red' align = 'center'>");
		out.println("welcome to amani's first project");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}


	
	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	
	public void destroy() {
		
	}


}

