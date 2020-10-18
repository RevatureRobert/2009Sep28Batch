package com.photoshop.controller;

import javax.servlet.http.HttpServletRequest;

import com.photoshop.model.User;
import com.photoshop.service.UserService;

public class UserController {

	private UserService us;
	
	public UserController() {
		this(new UserService());
	}
	
	public UserController(UserService us) {
		this.us = us;
	}
	
	public String verifyUser(HttpServletRequest req) {
		String email = (String) req.getAttribute("inputEmail");
		String password = (String) req.getAttribute("inputPassword");
		
		if ( us.verifyUser(email, password) ) {
			User user = us.findByEmail(email);
			
			if (user.getUserRole().getRole().equals("Employee")) {
				return "html/employee.html";
			} 
			else {
				return "html/finance manager.html";
			}
		}
		
		return "html/login.html";
	}
}
