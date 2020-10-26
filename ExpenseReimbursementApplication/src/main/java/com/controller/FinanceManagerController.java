package com.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.model.FinanceManager;
import com.service.FinanceManagerService;

public class FinanceManagerController 
{
	private FinanceManagerService fms;

	public FinanceManagerController(FinanceManagerService fms) {
		super();
		this.fms = fms;
	}

	public FinanceManagerController() 
	{
		this(new FinanceManagerService());
	}
	
	public String login(HttpServletRequest req)
	{
		String user_id = req.getParameter("users_id");
		System.out.println(user_id);
		
		if(user_id.equals(null))
		{
			user_id = "2";
		}
		
		int id = Integer.parseInt(user_id);
		
		FinanceManager fm = fms.findById(id);
		
		if(fm != null)
		{
			return "html/financemanager.html";
		}
		else
		{
			return "html/landing.html";
		}
	}
}
