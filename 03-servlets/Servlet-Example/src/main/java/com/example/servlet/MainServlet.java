package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	
	/**
	 * this method will only be called once. it is meant to initialize
	 * the servlet and its properties with whatever values may be configurable
	 * such as inside the web.xml.
	 */
	@Override
	public void init() throws ServletException {
		message = this.getInitParameter("message");
		System.out.println(this.getServletContext().getInitParameter("something"));
		super.init();
	}
	
	
	/**
	 * this method will be called when the servlet container gets a http request
	 * for the endpoint specified for this servlet. this method will determine which
	 * do... method to call and will run it.
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}
	
	/**
	 * this is our cleanup method. you can think of it as a pre-finalize method.
	 * this will be used to cleanup any resources the servlet may be using such
	 * as http conections, file io, etc. this object will become eligible for 
	 * garbage collection after this method is called.
	 */
	@Override
	public void destroy() {
		super.destroy();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(208);
		resp.getWriter().println(message);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		message = req.getParameter("message");
	}
}
