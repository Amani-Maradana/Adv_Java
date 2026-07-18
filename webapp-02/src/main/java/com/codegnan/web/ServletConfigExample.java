package com.codegnan.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet_01", urlPatterns = {"/config"}, initParams = {
		@WebInitParam(name="driver", value="com.mysql.cj.jdbc.Driver"),
		@WebInitParam(name="driver", value="jdbc:mysql://localhost:3306/adjava"),
		@WebInitParam(name="username", value="root"),
		@WebInitParam(name="password", value="root")
})
public class ServletConfigExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String logicalName = config.getServletName();
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("username");
		String pwd = config.getInitParameter("password");
		out.println("<html><body><h1>");
		out.println("Logical Name : " + logicalName + "<br><br>");
		out.println("Driver : " + driver + "<br><br>");
		out.println("Url Name : " + url + "<br><br>");
		out.println("User Name : " + user + "<br><br>");
		out.println("Password : " + pwd + "<br><br>");
		out.println("</html></body></h1>");
	}

}