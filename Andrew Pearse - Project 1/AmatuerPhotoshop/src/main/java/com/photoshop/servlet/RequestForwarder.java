package com.photoshop.servlet;

import javax.servlet.http.HttpServletRequest;

import com.photoshop.controller.UserController;

public class RequestForwarder {

	UserController uc;
	
	public RequestForwarder() {
		this(new UserController());
	}
	
	public RequestForwarder(UserController uc) {
		this.uc = uc;
	}
	
	public String routes(HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case "/AmatuerPhotoshop/login.html":
			return uc.verifyUser(req);
		case "/AmateurPhotoshop/employee.page":
		case "/AmateurPhotoshop/finance.page":
		default:
			return "html/login.html";
		}
	}
}
