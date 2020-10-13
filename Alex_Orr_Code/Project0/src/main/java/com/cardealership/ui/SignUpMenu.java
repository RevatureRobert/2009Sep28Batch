package com.cardealership.ui;

import java.util.Scanner;

import com.cardealership.Driver;
import com.cardealership.service.CustomerService;

public class SignUpMenu {
	
	private CustomerService cs;
	
	public SignUpMenu() {
		this(new CustomerService());		
	}
	public SignUpMenu(CustomerService cs) {
		super();
		this.cs = cs;
	}
	
	public void SignUpMenu(Scanner scan) {
		System.out.println("Please enter your first name:");
		String firstName = scan.next();
		System.out.println("Please enter your last name:");
		String lastName = scan.next();
		System.out.println("Please enter your desired username:");
		String userName = scan.next();
		System.out.println("Please enter your password: ");
		String password = scan.next();
		System.out.println("Please enter your email address: ");
		String email = scan.next();
		if(cs.create(userName, password, firstName, lastName, email) != null) {
			System.out.println("Account successfully created!");
			Driver.mainMenu(scan);
		}
		else {
			System.out.println("Oh no, something went wrong. Most likely your username or email is already taken. Please try again!");
			SignUpMenu(scan);
		}
		
	}

}
