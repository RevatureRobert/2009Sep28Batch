package com.bankapp.controller;

import java.util.List;

import com.bankapp.model.Users;
import com.bankapp.service.EmployeeService;

public class EmployeeController {
	private EmployeeService es;

	public EmployeeController() {
		this(new EmployeeService());
	}

	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}

	public List<Users> findAll() {
		return es.findAll();
	}
	public String insert(Users c) {
		try {
			Users result = es.update(c);
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
