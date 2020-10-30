package com.reimbursement.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbursement.controller.InboundDataController;
import com.reimbursement.controller.OutboundDataController;
import com.reimbursement.controller.ViewController;

public class ReturnDataSelector {
	
	public void getJsonData(HttpServletRequest req, HttpServletResponse res) {
		String jsonURI = req.getRequestURI();
		
//		System.out.println(jsonURI);
		
//		System.out.println(req.getSession().getAttribute("warning-message"));
		
		switch(jsonURI) {
		case "/WeHuntMonsters/warn.json":
			new OutboundDataController().loginWarningStatus(req, res);
			break;
		case "/WeHuntMonsters/user.json":
			new OutboundDataController().currentUser(req, res);
			break;
		case "/WeHuntMonsters/records.json":
			new OutboundDataController().records(req, res);
			break;
		case "/WeHuntMonsters/record.json":
			new InboundDataController().newRecord(req, res);
			break;
		case "/WeHuntMonsters/approve.json":
			new InboundDataController().approveRecord(req, res);
			break;
		case "/WeHuntMonsters/deny.json":
			new InboundDataController().denyRecord(req, res);
			break;
		}
	}
	
	public String getPageData(HttpServletRequest req) {
		String s = req.getRequestURI();
		
		switch (s) {
		case "/WeHuntMonsters/login.page":
			return new ViewController().attemptLogin(req);
		case "/WeHuntMonsters/reimbursements.page":
			if(req.getSession().getAttribute("user") != null) {
				return "frontend/html/viewer.html";
			}
		default:
			return "frontend/html/index.html";
		}
	}
}
