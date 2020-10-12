package com.dealership.repo;

import java.util.List;

import com.dealership.model.Employee;
import com.dealership.model.Manager;
import com.dealership.model.Offer;

public interface ManagerDao {

	/**
	 * Login to manager's account
	 * @param username
	 * @param password
	 * @return manager
	 */
	public Manager login(String username, String password);

	/**
	 * Create an employee account
	 * @param username
	 * @param password
	 * @return number of rows updated
	 */
	public int createEmployeeAccount(String username, String password);
	
	/**
	 * Get all employees
	 * @return list of employees
	 */
	public List<Employee> viewEmployees();
	
	/**
	 * Fire an employee
	 * @param employeeId
	 * @return number of rows updated
	 */
	public int fireEmployee(int employeeId);
	
	/**
	 * View sales history
	 * @return list of offers
	 */
	public List<Offer> viewSalesHistory();
	
}
