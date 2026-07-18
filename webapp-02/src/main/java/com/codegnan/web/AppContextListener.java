package com.codegnan.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
public void contextInitialized(ServletContextEvent sce) {
	ServletContext context = sce.getServletContext();
	context.setInitParameter("a","aaa");
	context.setInitParameter("b","bbb");
	
}
public void contextDestroyed(ServletContextEvent sce) {
	
}
}
