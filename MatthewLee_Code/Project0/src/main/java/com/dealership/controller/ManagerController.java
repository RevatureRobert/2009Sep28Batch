package com.dealership.controller;

import java.util.List;

import com.dealership.model.Employee;
import com.dealership.model.Manager;
import com.dealership.model.Offer;
import com.dealership.service.ManagerService;

public class ManagerController {

	private ManagerService mService;

	public ManagerController() {
		this(new ManagerService());
	}

	public ManagerController(ManagerService mService) {
		this.mService = mService;
	}
	
	public Manager login(String username, String password) {
		return mService.login(username, password);
	}
	
	public int createEmployeeAccount(String username, String password) {
		return mService.createEmployeeAccount(username, password);
	}
	
	public List<Employee> viewEmployees() {
		return mService.viewEmployees();
	}
	
	public int fireEmployee(int employeeId) {
		return mService.fireEmployee(employeeId);
	}
	
	public List<Offer> viewSalesHistory() {
		return mService.viewSalesHistory();
	}
	
}
