package com.project0.ui;

import java.util.Scanner;

import com.project0.controller.CustomerController;
import com.project0.model.Customer;

public class CustomerLoginMenu {
	private CustomerController cc;

	public CustomerLoginMenu() {
		this(new CustomerController());
	}

	public CustomerLoginMenu(CustomerController cc) {
		super();
		this.cc = cc;
	}

	public Customer CustomerLogin(Scanner scan) {
		System.out.println("Please login...");
		System.out.println("Please enter your customer name");
		String name = scan.next();
		System.out.println("Please enter your password");
		String password = scan.next();
		return cc.findByLogin(name, password);

	}

}
