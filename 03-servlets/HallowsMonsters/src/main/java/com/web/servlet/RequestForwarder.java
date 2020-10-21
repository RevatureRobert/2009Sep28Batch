package com.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	public void data(HttpServletRequest req, HttpServletResponse res) {
		switch(req.getRequestURI()) {
			
		}
	}
}
