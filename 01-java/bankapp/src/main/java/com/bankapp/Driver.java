package com.bankapp;

import java.util.Scanner;

import com.bankapp.ui.UserMenu;



public class Driver {
	private static UserMenu um = new UserMenu();
//	private static EmployeeMenu em = new EmployeeMenu();
//	private static CustomerMenu cm = new CustomerMenu();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		mainMenu(scanner);
	}
	
	
	private static void mainMenu(Scanner scanner) {
		System.out.println("Are you logging in or creating a new account? \n1. Login \n2. Create new account");
		int account = scanner.nextInt();
		if (account == 1) {
			um.Login(scanner);
		}if(account == 2) {
			um.NewAccount(scanner);
		}
		if(account >=2) {
			System.out.println("please choose a valid option");
			mainMenu(scanner);
		}
	}
	
}
