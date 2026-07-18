package com.codegnan.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = Integer.parseInt(request.getParameter("eno"));
		String name = request.getParameter("ename");
		HttpSession hs = request.getSession();
		hs.setAttribute("number",number);
		hs.setAttribute("name",name);
		RequestDispatcher rd = request.getRequestDispatcher("form2.html");
		rd.forward(request, response);

	}

}
