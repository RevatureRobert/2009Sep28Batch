package com.servlet;

import javax.servlet.http.HttpServletRequest;

import com.controller.FinanceManagerController;

public class RequestForwarder 
{
	public String routes(HttpServletRequest req)
	{
		switch(req.getRequestURI())
		{
		case "/ExpenseReimbursementApplication/farty.page":
			return new FinanceManagerController().login(req);
		default:
			return "html/landing.html";
		}
	}
}
