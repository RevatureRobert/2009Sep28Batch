package com.dealership.service;

import java.util.List;

import com.dealership.model.Employee;
import com.dealership.model.Manager;
import com.dealership.model.Offer;
import com.dealership.repo.ManagerDaoImpl;

public class ManagerService {

	private ManagerDaoImpl mDAO;

	public ManagerService() {
		this(new ManagerDaoImpl());
	}

	public ManagerService(ManagerDaoImpl mDAO) {
		this.mDAO = mDAO;
	}
	
	public Manager login(String username, String password) {
		return mDAO.login(username, password);
	}
	
	public int createEmployeeAccount(String username, String password) {
		return mDAO.createEmployeeAccount(username, password);
	}
	
	public List<Employee> viewEmployees() {
		return mDAO.viewEmployees();
	}
	
	public int fireEmployee(int employeeId) {
		return mDAO.fireEmployee(employeeId);
	}
	
	public List<Offer> viewSalesHistory() {
		return mDAO.viewSalesHistory();
	}
	
}
