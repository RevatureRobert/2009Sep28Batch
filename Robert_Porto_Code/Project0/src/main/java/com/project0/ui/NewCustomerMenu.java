package com.project0.ui;

import java.util.Scanner;

import com.project0.controller.CustomerController;
import com.project0.model.Customer;

public class NewCustomerMenu {
	private CustomerController cc;

	public NewCustomerMenu() {
		this(new CustomerController());
	}

	public NewCustomerMenu(CustomerController cc) {
		super();
		this.cc = cc;
	}

	public Customer display(Scanner scan) {
		System.out.println("Please enter your name");
		String name = scan.next();
		System.out.println("Please enter a password");
		String password = scan.next();
		return cc.newCustomer(new Customer(name, password));

	}
}
