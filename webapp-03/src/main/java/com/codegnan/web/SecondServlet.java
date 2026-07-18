package com.codegnan.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double salary = Double.parseDouble(request.getParameter("esal"));
		String address = request.getParameter("eaddr");
		HttpSession hs = request.getSession();
		hs.setAttribute("salary",salary);
		hs.setAttribute("address", address);

		RequestDispatcher rd = request.getRequestDispatcher("display.html");
		rd.forward(request, response);
		
		
	}

}
