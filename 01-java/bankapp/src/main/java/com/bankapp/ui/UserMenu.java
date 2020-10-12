package com.bankapp.ui;

import java.util.Scanner;

public class UserMenu {
	public void UserMenu(Scanner scanner) {
		
	System.out.println("Would you like to create a customer account?\n1. yes\n2. no");
	int accountType = scanner.nextInt();
	if(accountType == 1) {
		//assign account to type customer
		System.out.println("Congratulations, you have created a customer account!");
		CustomerMenu(scanner);
	}
	if(accountType == 2) {
		System.out.println("Would you like to create an employee account?\n1. yes\n2. no");
		int empAcc = scanner.nextInt();
		if(empAcc == 1) {
			//assign account to type employee
			System.out.println("Congratulations, you have created an employee account!");
			EmployeeMenu(scanner);					
		}
		else if(empAcc == 2){
			System.out.println("Exiting to Customer Menu");
			UserMenu(scanner);
			
		}
	}
	else {
		System.out.println("Please make a valid selection");
		UserMenu(scanner);
	}
	}
}
