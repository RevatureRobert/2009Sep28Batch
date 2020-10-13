package com.project0.controller;

import java.util.List;

import com.project0.model.Employee;
import com.project0.service.EmployeeService;

public class EmployeeController {
	private EmployeeService es;

	public EmployeeController() {
		this(new EmployeeService());
	}

	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}

	public List<Employee> findAll() {
		return es.findAll();
	}

	public Employee findByLogin(String name, String password) {
		return es.findByLogin(name, password);

	}
}
