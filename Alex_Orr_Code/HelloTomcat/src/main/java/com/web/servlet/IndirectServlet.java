package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getServletConfig().getInitParameter("servlet"));
		System.out.println(this.getServletName());
		System.out.println(this.getServletContext().getInitParameter("application"));
//		resp.sendRedirect("web/html/index.html"); 
		req.getRequestDispatcher("web/html/index.html").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username= req.getParameter("username");
		String password= req.getParameter("password");
		
		
	}
}
