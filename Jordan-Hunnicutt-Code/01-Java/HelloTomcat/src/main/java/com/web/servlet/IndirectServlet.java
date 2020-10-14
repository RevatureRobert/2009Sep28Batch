package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * servlets
 * 		what is it?
 * 			A servlet is a java class to extend the capabilities of a server
 * 		to create a servlet
 * 			1. extend the httpservlet (ac)
 * 			2. register it with tomcat
 * 				a. through web.xml
 * 				b. through annotations
 * 
 * hierarchy of a servlet
 * 
 * 		Servlet (interface)
 * 			GenericServlet (Abstract Class)
 * 				HttpServlet (AC)
 * 					CustomServlet (our class)
 * 
 * 		status codes
 * 			100 = informational (direct response)
 * 			200 = successful (ok)
 * 			300 = redirect
 * 			400 = client side errors
 * 			500 = server side errors
 * 
 *		Redirect
 *			2 requests, 2 responses
 *
 *		Forward
 *			1 request, 1 response
 *
 *		Direct
 *			1 request, 1 reponse
 *
 *		http methods
 *			get, post, put, delete, patch, head, options, etc...
 *
 *		these methods are associated with crud methods
 *			get = read
 *			post = create
 *			put = update
 *			delete = delete (wow)
 *			patch = update
 *			head = gets all headers
 *			options (coors?) makes sure you are allowed to access things
 *
 */
public class IndirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);  //YOU DO NOT WANT TO CALL SUPER .DOGET, ERROR
		
		//there are three types of responses we can make with a servlet
		//		forward (I can handle whatever I need to do for this request) (url will not change)
		//		redirect (sends to a completely different location)  		  (url will change)
		
		//redirect will change the url and send the user somewhere else
//		resp.sendRedirect("03-FrontEnd/html/intro.html");
		
		//forward will not change the url, the server handles all the information gathering
		req.getRequestDispatcher("03-FrontEnd/html/login.html").forward(req,  resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username"); //this is how we get the values out of the login.html form
		String password = req.getParameter("password");
		if(username.equals("bill")) {
			if(password.equals("pass")) {
				req.getRequestDispatcher("03-FrontEnd/html/success.html").forward(req, resp);
			} else {
				req.getRequestDispatcher("03-FrontEnd/html/intro.html").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("03-FrontEnd/html/intro.html").forward(req, resp);
		}
		
	}
	
}
