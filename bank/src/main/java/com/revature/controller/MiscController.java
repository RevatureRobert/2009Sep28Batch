package com.revature.controller;

import com.revature.model.Customer;
import com.revature.model.Employee;
import com.revature.service.MiscService;

public class MiscController {
	private MiscService ms = new MiscService();

	public MiscController() {
		super();
	}

	public MiscController(MiscService ms) {
		super();
		this.ms = ms;
	}
	
	public Customer signUp(String firstname, String lastname, String email, String password) {
		return ms.signUp(firstname, lastname, email, password);
	}
	public Customer customerLogin(String email, String password) {
		return ms.customerLogin(email, password);
	}
	
	public Employee employeeLogin(String email, String password) {
		return ms.employeeLogin(email, password);
	}
	
	public Employee isManager(int employee_id) {
		return ms.isManager(employee_id);
	}
	
	public void removePending() {
		ms.removePending();
	}
}

