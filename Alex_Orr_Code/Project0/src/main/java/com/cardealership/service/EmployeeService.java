package com.cardealership.service;

import java.util.List;

import com.cardealership.model.Customer;
import com.cardealership.model.Employee;
import com.cardealership.repo.EmployeeDao;

public class EmployeeService {
	
	private EmployeeDao ed;
	
	public EmployeeService() {
		super();
		this.ed = new EmployeeDao();
	}
	public List<Employee> listEmployees() {
		return ed.findAll();
	}
	public Employee create(Customer t, int dealershipId) {
		return ed.create(t, dealershipId);
	}
	public boolean delete(int userId) {
		if(ed.delete(userId) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
