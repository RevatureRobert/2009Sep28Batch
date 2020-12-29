package com.reimbursement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet meant to handle data / JSONs.
 * 
 * Servlet implementation class DataServlet
 */
@WebServlet(name="data", urlPatterns = {"*.json"})
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	new ReturnDataSelector().getJsonData(request, response);
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new ReturnDataSelector().getJsonData(request, response);
	}
}