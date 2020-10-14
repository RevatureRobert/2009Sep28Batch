package com.cardealer.console;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cardealer.model.Account;
import com.cardealer.repo.AccountDao;

public class MainMenu {
	Logger logger;
	Scanner sc;
	Account CurrentAccount;
	
	public final static String adminPassword = "IamAdmin";
	public final static String managerPassword = "IamManager";
	
	public MainMenu(Logger logger, Scanner sc) {
		this.logger = logger;
		this.sc = sc;
	}
	public Account returnCurrent() {
		return CurrentAccount;
	}
	
	public int logInMenu() throws IOException, SQLException {
			
			System.out.flush();
			System.out.println("(1) Log in");
			System.out.println("(2) Create an account");
			System.out.println("(3) Quit");
			
			String input = "0";
			
			while(("123").contains(input) == false) {
				System.out.print("Choose an option:  ");
				input = sc.nextLine();
			}
			
			
			// log into account
			if(input.equals("1")) {
				CurrentAccount = logIn();
				if(CurrentAccount == (null)) {
					return logInMenu();
				}
				return 1;
			}
			
			//create account
			if(input.equals("2")) {
				addAccount();
				return logInMenu();
			}
			if(input.equals("3")) {
				
				return -1;
			}
			return -1;
		}
		
		public Account logIn() throws SQLException {
			AccountDao pullFromUser = new AccountDao(logger);
			System.out.flush();
			System.out.print("Enter Username:  ");
			String userName = sc.nextLine().toLowerCase();
			Boolean usernameExists = false;
			while(!usernameExists) {
				usernameExists = pullFromUser.exists(userName);
				if(!usernameExists) {
					System.out.print("Username does not exist. Try again? (Yes/No):  ");
					if(!sc.nextLine().toUpperCase().equals("YES")) {
						return null;
					}
					System.out.print("Enter Username:  ");
					userName = sc.nextLine().toLowerCase();
				}
			}
			
	
			
			Account pull = pullFromUser.findById(userName);
			boolean passwordMatch = false;
			String password = "";
			while(!passwordMatch) {
				System.out.print("Enter Password:  ");
				password=sc.nextLine().strip();
				if(password.equals(pull.getPassword())) {
					logger.info("Logged into " + userName);
					return pull;
				}
				System.out.print("Password does not match. Try again? (Yes/No):  ");
				if(!sc.nextLine().toUpperCase().equals("YES")) {
					return null;
				}
				
			}
			
			
			return null;
		}
		
		
		
		public void addAccount() throws IOException, SQLException {
			AccountDao pullDataBase= new AccountDao(logger);
			System.out.flush();
			System.out.println("Creating Account");
			System.out.print("Enter First Name:  ");
			String firstName = sc.nextLine();
			System.out.print("Enter Last Name:  ");
			String lastName = sc.nextLine();
			System.out.print("Enter Username:  ");
			String userName = sc.nextLine().toLowerCase();
			System.out.print("Enter Password:  ");
			String passWord = sc.nextLine();
			System.out.print("Type Yes for admin account:  ");
			String adminCheck = sc.nextLine();
			boolean isAdmin = false;
			boolean isManager = false;
			if(adminCheck.toLowerCase().equals("yes")) {
				System.out.print("Enter Admin Credentials Password:  ");
				if(sc.nextLine().equals(adminPassword)) {
					isAdmin = true;
					System.out.print("Type Yes for Manager account:  ");
					adminCheck = sc.nextLine();
					if(adminCheck.toLowerCase().equals("yes")) {
						System.out.print("Enter Manager Credentials Password:  ");
						if(sc.nextLine().equals(managerPassword)) {
							isManager = true;
						}
					}
				}
			}
			//Checks if username is taken
			Boolean usernameExists = true;
			while(usernameExists) {
				usernameExists = pullDataBase.exists(userName);
				if(usernameExists) {
					System.out.println("Username is taken.");
					System.out.print("Enter Username:  ");
					userName = sc.nextLine().toLowerCase();
				}
			}
			pullDataBase.create(new Account(userName, passWord, firstName, lastName, isAdmin, isManager));
			
	
		}
}
