package com.project0.ui;

import java.util.Scanner;

import com.project0.controller.EmployeeController;
import com.project0.model.Employee;

public class EmployeeLoginMenu {
	private EmployeeController ec;

	public EmployeeLoginMenu() {
		this(new EmployeeController());
	}

	public EmployeeLoginMenu(EmployeeController ec) {
		super();
		this.ec = ec;
	}

	public Employee EmployeeLogin(Scanner scan) {
		System.out.println("Please login...");
		System.out.println("Please enter your employee name");
		String name = scan.next();
		System.out.println("Please enter your password");
		String password = scan.next();
		return ec.findByLogin(name, password);

	}
}
