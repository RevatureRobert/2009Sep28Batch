package com.reimbursement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//		Cookie[] cookies = request.getCookies();
		
//		for (Cookie cookie : cookies)
//			System.out.println(cookie.getValue());
		
		String targetPage = new ReturnDataSelector().getPageData(request);
		
//		System.out.println(request.getSession().getAttribute("warning-message"));
		
		if(targetPage.equals("LOGIN")) {
//			System.out.println("Logged in!");
			String url = request.getRequestURL().toString();
			response.sendRedirect(url.substring( 0, url.lastIndexOf('/')) + "/reimbursements.page");
		} else {
			request.getRequestDispatcher(targetPage).forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
