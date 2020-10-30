package com.reimbursement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbursement.controller.ControllerSelector;

/**
 * Servlet meant to deliver Web pages to the front end.
 * 
 * Servlet implementation class WebpageServlet
 * 
 */
@WebServlet(name="webpages", urlPatterns= {"*.page"})
public class WebpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String targetPage = "frontend/html/index.html";
		targetPage = new ControllerSelector().toString();
		
		request.getRequestDispatcher(targetPage).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
