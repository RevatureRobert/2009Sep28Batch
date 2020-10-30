package com.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;

public class ControllerSelector {
	
	public String pageUrl(HttpServletRequest req) {
		String s = req.getRequestURI();
		
		switch (s) {
		case "":
			return new ViewController().attemptLogin(req);
		}
		
		return s;
	}
}
