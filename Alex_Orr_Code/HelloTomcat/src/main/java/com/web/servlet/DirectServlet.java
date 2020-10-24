package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet lifecycle
 * 
 * 		init		called once
 * 		service		called everytime a request is processed
 * 		destroy 	called once
 * 
 * 
 * REST
 * 	REpresentational State Transfer
 * 
 * six rest constraint
 * 		1. Stateless
 * 			It does not keep track of the client and does not care
 * 				if it is the same or different client during
 * 				subsquent reuqests.
 * 		2. Client-server Separation
 * 			The client and the server are kept separate and the
 * 				updating of one does not mean the other has to.
 * 		3. Layered System
 * 			The client is unaware of the different layers of the 
 * 				restful application.
 * 		4. Code on demand(optional)
 * 			When making a quest, we can get any type of format back
 * 				in the response. RESTful applications can send back
 * 				any format including html, xml, javascript, java, css, etc...
 * 		5. Cacheable
 * 			The information coming back from the restful application
 * 				should be cacheable.
 * 		6. Uniform interface
 * 			We use the same endpoint with different http verbs to interact
 * 				with the same objects. This provides a uniform interface
 * 				to work with our api's.
 * */

/*load on startup will determine how the servlet is initialized. >=0 eager, 0 is lazy*/
@WebServlet(name = "direct", urlPatterns = {"/direct"}, loadOnStartup = 0)
public class DirectServlet extends HttpServlet {
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1>this is a direct response</h1>");
		}
	
	@Override
	public void init() throws ServletException {
		System.out.println("it is being initialized");
		super.init();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("it is in service");
		super.service(req, resp);
	}
	@Override
	public void destroy() {
		System.out.println("it is being destroyed");
		super.destroy();
	}
}
