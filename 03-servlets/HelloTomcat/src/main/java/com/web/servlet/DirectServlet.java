package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet life cycle
 * 
 * 		init			called once
 * 							by default does not initialize until it gets a request ("lazy" initialization)
 * 							if loadOnStartup is >= 0, it will be "eagerly loaded" as soon as the server application is loaded
 * 								The one with 0 will be initialized first, then 1, then so on
 * 								is -1 by default
 * 		service			called every time a request is processed
 * 		destroy			called once
 * 
 * REST
 * 		Representational State Transfer
 * 		When we make a request, the server is taking data,
 * 			taking the data's initial state and transferring something that it sends back to the client (?)
 * 		Six rest constraints
 * 			STATELESS
 * 				the server does not keep track of clients
 * 				server doesn't care if the same or a different client makes a request or not
 * 				no session ids
 * 			CLIENT-SERVER SEPARATION
 * 				the client does not depend on the server
 * 				the client and the server are kept separete, and
 * 				updating one does not mean the other has to
 * 			LAYERED SYSTEM
 * 				the server abstracts any internal layers; the cxlient just gets the information it needs
 * 				the client is unaware of different layers of the restful aplication.
 * 			CODE ON DEMAND (optional)
 * 				restful application can send back any type of content (.html, .css, .js, .java, anything)
 * 				when making a request, we can get any type of format back in the response
 * 				RESTful applications can send back any format including html, xml, java, css, etc...
 * 			CACHEABLE
 * 				the information coming back (the http response) from the application should be cacheable
 * 				
 * 			UNIFORM INTERFACE
 * 					++brownie points if used in our projects (like project 1 reimbursement system)
 * 				Send different verbs, interact with the same servlet, to get dynamic reponses
 * 				we use same endpoint (same url) w/ diff http verbs to interact w/ same objects,
 * 					and this provides a unique interface to work with our apis
 * 
 * 
 * 
 * https://image.slidesharecdn.com/restv2-100720064613-phpapp02/95/rest-representational-state-transfer-14-728.jpg?cb=1279681274
 * 
 * GOOD METRIC BY WHICH TO MEASURE ITS CONFORMANCE:
 * https://19yw4b240vb03ws8qm25h366-wpengine.netdna-ssl.com/wp-content/uploads/The-Richardson-Maturity-Model-Nordic-APIs.png
 */

@WebServlet(name = "direct", urlPatterns = {"/direct"}, /*
						*	load on startup will determine servlet
						*	initialization behavior; >=0 eager, <0 lazy
		 				*/ loadOnStartup = 0)
public class DirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("<h1 style = \"color: red\">this is a direct response</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void init() throws ServletException {
		System.out.println("init called!");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service call!");
		super.service(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy call");
		super.destroy();
	}
}
