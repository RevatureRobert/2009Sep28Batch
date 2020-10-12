package com.bankapp.ui;

import java.util.Scanner;

public class EmployeeMenu{
	public String EmployeeMenu(Scanner scanner) {
		
	System.out.println("What would you like to do?\n1. Check account requests\n2. View customer accounts\n3. View transaction logs");
	int action = scanner.nextInt();
	if(action == 1) {
		System.out.println("Here are the new account requests:");
		//account requests inserted here
		System.out.println("Which account request do you want to view?");
		// choose account request to view
		System.out.println("Are you approving or denying this account?\n1. Approve\n2. Deny");
		int action1 = scanner.nextInt();
		if (action1 == 1) {
			System.out.println("Account Approved");
			//add account to account database
		} else if(action1 == 2) {
			System.out.println("Account Denied");
			//remove account from requests
		}
		System.out.println("Enter 0 to exit");
		int exit = scanner.nextInt();
		if(exit == 0) {
			EmployeeMenu(scanner);
		}
	}
		
	}
	return 
}
