package com.cardealership.service;

import java.util.Scanner;

import com.cardealership.model.Admin;
import com.cardealership.model.Customer;
import com.cardealership.model.Employee;
import com.cardealership.model.User;
import com.cardealership.model.UserType;
import com.cardealership.repo.AdminDao;
import com.cardealership.repo.CustomerDao;
import com.cardealership.repo.EmployeeDao;
import com.cardealership.repo.UserDao;
import com.cardealership.ui.AdminMenu;
import com.cardealership.ui.CustomerMenu;
import com.cardealership.ui.EmployeeMenu;
import com.cardealership.ui.SignInMenu;

public class SignInService {
	private UserDao ud;
	
	private AdminMenu am = new AdminMenu();
	private AdminDao ad = new AdminDao();

	private EmployeeMenu em = new EmployeeMenu();
	private EmployeeDao ed = new EmployeeDao();
	
	private CustomerMenu cm = new CustomerMenu();
	private CustomerDao cd = new CustomerDao();

	public SignInService() {
		this.ud = new UserDao();
	}
	public SignInService(UserDao ud, SignInMenu sim) {
		this.ud = ud;
	}
	public boolean login(String username, String password, Scanner scan) {
		User user = ud.login(username, password);
		if(user == null) {
			System.out.println("Invalid username or password. Please try again!");
			return false;
		}
		UserType type = user.getUserType();
		switch(type) {
		case admin:
			System.out.println("logged in as admin");
			Admin admin = ad.getAdmin(username);
			am.AdminMenu(scan, admin);
			break;
		case employee:
			System.out.println("logged in as employee");
			Employee employee = ed.getEmployee(username);
			em.EmployeeMenu(scan, employee);
			break;
		case customer:
			System.out.println("logged in as customer");
			Customer customer = cd.getCustomer(username);
			cm.CustomerMenu(scan, customer);
			
			break;
		}
		return true;
		
	}
}
