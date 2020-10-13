package com.cardealership.ui;

import java.util.Scanner;

import com.cardealership.service.SignInService;

public class SignInMenu {
	
	SignInService sis;
	
	public SignInMenu() {
		super();
		this.sis = new SignInService();
	}
	public SignInMenu(SignInService sis) {
		super();
		this.sis = sis;
	}
	public void SignInMenu(Scanner scan) {
		System.out.println("Please Enter your user name:");
		String userName = scan.next();
		System.out.println("Please Enter your password:");
		String password = scan.next();
		if(!sis.login(userName, password, scan)) {
			SignInMenu(scan);
		}		
	}
}
