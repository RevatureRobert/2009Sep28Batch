package com.revature.ui;

import java.util.Scanner;

import com.revature.controller.MiscController;
import com.revature.model.Customer;
import com.revature.model.Employee;

public class LoginMenu {
	private MiscController mc = new MiscController();
	
	public LoginMenu() {
		super();
	}
	
	public LoginMenu(MiscController mc) {
		this.mc = mc;
	}
	
	
	public Customer signUp(Scanner scan) {
		System.out.println("Please enter your firstname: ");
		scan.nextLine(); //keep from skipping next scan.nextLine
		String firstname = scan.nextLine();
		System.out.println("Please enter your lastname:");
		String lastname = scan.nextLine();
		System.out.println(("Please enter your email: "));
		String email = scan.nextLine();
		System.out.println("Please enter your password");
		String password = scan.nextLine();
		return mc.signUp(firstname, lastname, email, password);
	}
	
	public Customer customerLogin(Scanner scan) {
		System.out.println("Please enter your email: ");
		scan.nextLine(); //keep from skipping next scan.nextLine
		String email = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		return mc.customerLogin(email, password);
	}
	
	public Employee employeeLogin(Scanner scan) {
		System.out.println("Please enter your email: ");
		scan.nextLine(); //keep from skipping next scan.nextLine
		String email = scan.nextLine();
		System.out.println("Please enter your password: ");
		String password = scan.nextLine();
		return mc.employeeLogin(email, password);
	}

}
