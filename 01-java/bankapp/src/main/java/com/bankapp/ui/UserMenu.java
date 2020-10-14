package com.bankapp.ui;

import java.util.Scanner;

import com.bankapp.controller.UsersController;
import com.bankapp.model.Users;

public class UserMenu {
	private static UserMenu um = new UserMenu();
	private static EmployeeMenu em = new EmployeeMenu();
	private static CustomerMenu cm = new CustomerMenu();
	private UsersController uc;

	public UserMenu() {
		this(new UsersController());
	}

	public UserMenu(UsersController uc) {
		super();
		this.uc = uc;
	}
	public String Login(Scanner scanner) {
		System.out.println("Username:");
		String username = scanner.next();
		System.out.println("Password:");
		String password = scanner.next();
		//check to see if the username matches the password
		//pull user from database and show appropriate menu
		return UserMenu(scanner);
//		UserAssign(scanner);
	}
	public String NewAccount(Scanner scanner){		//new account email, username, and password are stored into the database 
		System.out.println("Email:");
		String email = scanner.next();
		System.out.println("Username:");
		String username = scanner.next();
		System.out.println("Passowrd:");
		String password = scanner.next();
		return uc.insert(new Users(username, email, password, false, false, false, false, 0, false, 0));
		}
//	static String Username(Scanner scanner){
//		System.out.println("Username:");
//		String username = scanner.next();
//		return username;
//	}
	
//	static String Password(Scanner scanner){		//scanner to assign the password to the account
//		System.out.println("Passowrd:");
//		String password = scanner.next();
//		System.out.println("Confirm Password:");
//		String confirmPassword = scanner.next();
//		if(password.equals(confirmPassword)) {
//			
//			UserAssign(scanner);
//		}else if(password == null || confirmPassword == null) {
//			System.out.println("You must enter a valid password");
//			Password(scanner);
//		}
//		else{
//			System.out.println("Passwords are not the same");
//			Password(scanner);
//		}
//		return password;
//	}
	
	
	
	static void UserAssign(Scanner scanner) {
		System.out.println("Are you a: \n1. user\n2. employee\n3. customer");
		int role = scanner.nextInt();
		if(role == 1) {
			System.out.println("Role set to User");
			um.UserMenu(scanner);
			UserAssign(scanner);
			}
		if (role == 2) {
			System.out.println("Role set to Employee");
			em.EmployeeMenu(scanner);
			UserAssign(scanner);
		}
		if (role == 3) {
			System.out.println("Role set to Customer");
			cm.CustomerMenu(scanner);
			UserAssign(scanner);
		}
	}
	public String UserMenu(Scanner scanner) {
		
		
	System.out.println("Would you like to create a customer account?\n1. yes\n2. no");
	int accountType = scanner.nextInt();
	if(accountType == 1) {
		//assign account to type customer
		System.out.println("Congratulations, you have created a customer account!");
//		cm.CustomerMenu(scanner);
	}
	if(accountType == 2) {
		System.out.println("Would you like to create an employee account?\n1. yes\n2. no");
		int empAcc = scanner.nextInt();
		if(empAcc == 1) {
			//assign account to type employee
			System.out.println("Congratulations, you have created an employee account!");
//			em.EmployeeMenu(scanner);					
		}
		else if(empAcc == 2){
			System.out.println("Exiting to User Menu");
//			UserMenu(scanner);
			
		}
	}
	else {
		System.out.println("Please make a valid selection");
		UserMenu(scanner);
	}
	return "troubleshooting";
	}
}
