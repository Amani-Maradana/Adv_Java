package com.codegnan.web;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
/**
* FirstServlet demonstrates the use of: - ServletConfig (for local servlet
* parameters) - ServletContext (for global context parameters)
*
* Annotation @WebServlet replaces <servlet> and <servlet-mapping> from web.xml.
*/
@WebServlet(name = "FirstServlet", urlPatterns = { "/first" }, initParams = { @WebInitParam(name = "c", value = "CCC"),
		@WebInitParam(name = "d", value = "DDD") })
public class FirstServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// getServletConfig() gives access to servlet-specific parameters
		ServletConfig config = getServletConfig();
		// getServletContext() gives access to application-wide parameters
		ServletContext context = getServletContext();
		out.println("<html><body><h1>");
		out.println("a ----> " + context.getInitParameter("a") + "<br>");
		out.println("b ----> " + context.getInitParameter("b") + "<br>");
		out.println("c ----> " + config.getInitParameter("c") + "<br>");
		out.println("d ----> " + config.getInitParameter("d") + "<br>");
		out.println("e ----> " + config.getInitParameter("e") + "<br>");
		out.println("f ----> " + config.getInitParameter("f") + "<br>");
		out.println("</h1></body></html>");
	}
}


