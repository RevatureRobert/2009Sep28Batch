package com.web.servlet;

import javax.servlet.http.HttpServletRequest;

import com.web.controller.MonsterController;

public class RequestForwarder {
	
	
	public String routes(HttpServletRequest req) {
		String s = req.getRequestURI(); // portion of the url that says HallowsMonsters/
		
		switch (s) {
		case "/HallowsMonsters/login.page":
			return new MonsterController().login(req); // typically don't want to do this
		default:
				return "html/landing.html";
		}
	}
}
