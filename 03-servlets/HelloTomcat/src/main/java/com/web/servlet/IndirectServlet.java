package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 * 	A java class to extend the capabilities of a server
 * 
 * 	To create a servlet,
 * 		1. extend the HttpServlet abstract class
 * 		2. register it with tomcat
 * 			a. web.xml
 * 			b. annotations
 * 
 * HIERARCHY OF A SERLVET
 * 
 * 		Servlet (interface)
 * 			GenericServlet (abstract class)
 * 				HTTPServlet (abstract class)
 * 					CustomServlet (our class)
 * 
 * 	Status codes
 * 		100 = informational
 * 		200 = successful / ok
 * 		300 = redirect
 * 		400 = client errors
 * 		500 = server errors
 * 
 * 	Redirect
 * 		2 requests 2 responses
 * 	Forward
 * 		1 request, 1 response
 * 	Direct
 * 		1 request, 1 response
 * 
 * 	http methods
 * 		get, post, put, delete, patch, head, options, etc.
 * 
 * 	CRUD operations:
 * 		get = read
 * 		post = create
 * 		put = update
 * 		delete = delete
 * 		patch = update
 * 	
 * 	head = getting headers
 * 	options = when working with cores, send an options request to make sure
 * 		the receiver can receive what you want to send
 */

public class IndirectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getServletConfig().getInitParameter("servlet"));
		System.out.println(this.getServletName());
		System.out.println(this.getServletContext().getInitParameter("application"));
		
		// redirect will change the url and send the user somewhere else
//		resp.sendRedirect("03-Front End/html/intro.html");
		
		
		
		// url stays the same, server handles all the information gathering;
		//		gives the browser data to handle instead of telling it where to go
		req.getRequestDispatcher("03-Front End/html/login.html").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// The input string is the "name" attribute of the html form,
		//		the output is the value put in by the user of the html form.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username.contentEquals("john") && password.equals("pass"))
			req.getRequestDispatcher("03-Front End/html/success.html").forward(req,  resp);
		else
			req.getRequestDispatcher("03-Front End/html/intro.html").forward(req,  resp);
	}
}
