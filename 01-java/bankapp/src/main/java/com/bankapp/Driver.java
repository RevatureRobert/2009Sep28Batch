package com.bankapp;

import java.util.Scanner;

import com.bankapp.ui.CustomerMenu;
import com.bankapp.ui.EmployeeMenu;
import com.bankapp.ui.UserMenu;

public class Driver {
	private static UserMenu um = new UserMenu();
	private static EmployeeMenu em = new EmployeeMenu();
	private static CustomerMenu cm = new CustomerMenu();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		mainMenu(scanner);
	}
	
	private static void mainMenu(Scanner scanner) {
		System.out.println("Are you logging in or creating a new account? \n1. Login \n2. Create new account");
		int account = scanner.nextInt();
		if (account == 1) {
			Login(scanner);
		}if(account == 2) {
			NewAccount(scanner);
		}
		if(account >=2) {
			System.out.println("please choose a valid option");
			mainMenu(scanner);
		}
	}
	static void Login(Scanner scanner) {
		System.out.println("Username:");
		String username = scanner.next();
		System.out.println("Password:");
		String password = scanner.next();
		//check to see if the username matches the password
		//pull user from database and show appropriate menu
		UserAssign(scanner);
	}
	static String NewAccount(Scanner scanner){		//new account email, username, and password are stored into the database 
		System.out.println("Email:");
		String email = scanner.next();
		Username(scanner);
		Password(scanner);
		//store user in database
		return email;
		}
	static String Username(Scanner scanner){
		System.out.println("Username:");
		String username = scanner.next();
		return username;
	}
	
	static String Password(Scanner scanner){		//scanner to assign the password to the account
		System.out.println("Passowrd:");
		String password = scanner.next();
		System.out.println("Confirm Password:");
		String confirmPassword = scanner.next();
		if(password.equals(confirmPassword)) {
			
			UserAssign(scanner);
		}else if(password == null || confirmPassword == null) {
			System.out.println("You must enter a valid password");
			Password(scanner);
		}
		else{
			System.out.println("Passwords are not the same");
			Password(scanner);
		}
		return password;
	}
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
			System.out.println(em.EmployeeMenu(scanner));
			UserAssign(scanner);
		}
		if (role == 3) {
			System.out.println("Role set to Customer");
			cm.CustomerMenu(scanner);
			UserAssign(scanner);
		}
	}
}
