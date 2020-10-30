package com.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.reimbursement.service.UserService;

public class ViewController {
	private UserService usersvc;
	
	public ViewController(UserService usersvc) {
		super();
		this.usersvc = usersvc;
	}
	public ViewController() {
		this(new UserService());
	}



	public String attemptLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		
		if(session.getAttribute("warning-message") == null) {
//			System.out.println("It's null!");
			session.setAttribute("warning-message", "");
			return "frontend/html/index.html";
		}
		
		String username = req.getParameter("input-username");
		String password = req.getParameter("input-password");
		
		if(username == null) {
//			System.out.println("Username's null!");
			session.setAttribute("warning-message", "Username not entered!");
			return "frontend/html/index.html";
		} else if(password == null) {
//			System.out.println("Password's null!");
			session.setAttribute("warning-message", "Password not entered!");
			return "frontend/html/index.html";
		}
		
		
		String validationCode = usersvc.verifyLoginCredentials(username.toLowerCase(), password);
//		System.out.println(validationCode);
		
		if(validationCode.equalsIgnoreCase("invalid username")) {
//			System.out.println(validationCode);
			session.setAttribute("warning-message", "Username doesn't exist!");
			return "frontend/html/index.html";
		}else if(validationCode.equalsIgnoreCase("invalid password")) {
//			System.out.println(validationCode);
			session.setAttribute("warning-message", "Password is wrong!");
			return "frontend/html/index.html";
		}else if(validationCode.equalsIgnoreCase("valid")) {
//			System.out.println(validationCode);
			session.setAttribute("warning-message", "");
			session.setAttribute("user", usersvc.login(username));
			return "LOGIN";
		}
		
		return "frontend/html/index.html";
	}
	
}
