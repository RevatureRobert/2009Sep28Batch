package com.reimbursement.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbursement.controller.InboundDataController;
import com.reimbursement.controller.OutboundDataController;
import com.reimbursement.controller.ViewController;

public class ReturnDataSelector {
	
	public void getJsonData(HttpServletRequest req, HttpServletResponse res) {
		String jsonPath = req.getRequestURI();
		jsonPath = jsonPath.substring(jsonPath.lastIndexOf('/'));
		
//		System.out.println(jsonPath);
		
//		System.out.println(req.getSession().getAttribute("warning-message"));
		
		switch(jsonPath) {
		case "/warn.json":
			new OutboundDataController().loginWarningStatus(req, res);
			break;
		case "/user.json":
			new OutboundDataController().currentUser(req, res);
			break;
		case "/records.json":
			new OutboundDataController().records(req, res);
			break;
		case "/record.json":
			new InboundDataController().newRecord(req, res);
			break;
		case "/approve.json":
			new InboundDataController().approveRecord(req, res);
			break;
		case "/deny.json":
			new InboundDataController().denyRecord(req, res);
			break;
		}
	}
	
	public String getPageData(HttpServletRequest req) {
		String s = req.getRequestURI();
		s = s.substring(s.lastIndexOf('/'));
		
//		System.out.println(s);
		
		if(s == null)
			return "frontend/html/index.html";
		
		switch (s) {
		case "/login.page":
			return new ViewController().attemptLogin(req);
		case "/reimbursements.page":
			if(req.getSession().getAttribute("user") != null) {
				return "frontend/html/viewer.html";
			}
		default:
			return "frontend/html/index.html";
		}
	}
}
