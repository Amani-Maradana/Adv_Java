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
* SecondServlet has its own servlet-level parameters. It demonstrates that: -
* ServletConfig is unique to each servlet - ServletContext values are shared
* across all servlets
*/
@WebServlet(name = "SecondServlet", urlPatterns = { "/second" }, initParams = {
		@WebInitParam(name = "e", value = "EEE"), @WebInitParam(name = "f", value = "FFF") })
public class SecondServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Local (per-servlet) configuration
		ServletConfig config = getServletConfig();
		// Shared (application-wide) configuration
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

