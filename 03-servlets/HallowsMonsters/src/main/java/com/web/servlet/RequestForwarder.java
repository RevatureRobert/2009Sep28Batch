package com.web.servlet;

import javax.servlet.http.HttpServletRequest;

import com.web.controller.MonsterController;

public class RequestForwarder {

	
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/HallowsMonsters/login.page":
			return new MonsterController().login(req);
		default: 
			return "html/landing.html";
		}
	}
}
