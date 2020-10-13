package com.project0.service;

import java.util.List;

import com.project0.model.Employee;
import com.project0.repo.EmployeeDao;

public class EmployeeService {
	private EmployeeDao ed;

	public EmployeeService() {
		this(new EmployeeDao());
	}

	public EmployeeService(EmployeeDao ed) {
		super();
		this.ed = ed;

	}

	public List<Employee> findAll() {
		return ed.findAll();
	}

	public Employee findByLogin(String name, String password) {
		return ed.findByLogin(name, password);
	}

}
