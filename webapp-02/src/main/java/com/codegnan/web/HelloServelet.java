package com.codegnan.web;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServelet
 */
@WebServlet("/HelloServelet")
public class HelloServelet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style = 'color:red' align = 'center'>");
		out.println("welcome to generic Servelet");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
