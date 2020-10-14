package com.cars.ui;

import java.util.Scanner;

import com.cars.controller.UserController;

public class RegisterAndLoginUI {
	
	private static RegisterAndLoginUI instance;
	
	private RegisterAndLoginUI() {
		
	}

	public static RegisterAndLoginUI getInstance() { //ensures there is only one registerandloginui instance
		if(instance == null) {
			instance = new RegisterAndLoginUI();
		}
		return instance;
	}
	
	static UserController ctr = UserController.getInstance();
	
	public void registerMenu(Scanner scanner) { //allows the user to create a new account
		System.out.println(TextEffects.ANSI_BLUE+"Please input your new username:"+TextEffects.ANSI_GREEN);
		String uName = scanner.next();
		System.out.println(TextEffects.ANSI_BLUE+"Please input your new password:"+TextEffects.ANSI_GREEN);
		String pass = scanner.next();
		System.out.println(TextEffects.ANSI_BLUE+"Are you a customer or an employee?");
		System.out.println("Type 1 for customer, 2 for employee:"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int uType = scanner.nextInt();
		
		switch(uType) {
			case 1: //new account is for a customer
				//check that user doesn't already exist and that pass is not null
				String s = ctr.registerControl(uName, pass, 1);
				
				System.out.print("\033[H\033[2J");
				System.out.flush(); //clears sensitive password information
				
				System.out.println(TextEffects.ANSI_RED+s+"\nNow returning you to the main menu");
				break;
			case 2: //new account is for an employee
				System.out.println(TextEffects.ANSI_BLUE+"The manager will need to confirm this new employee acount.");
				System.out.println("Manager, please input your username:"+TextEffects.ANSI_GREEN);
				String eName = scanner.next();
				System.out.println(TextEffects.ANSI_BLUE+"Manager, please input your password:"+TextEffects.ANSI_GREEN);
				String ePass = scanner.next();
				
				System.out.print("\033[H\033[2J");
				System.out.flush(); //clears sensitive password information
				
				if(ctr.checkMngr(eName, ePass, 3)) {
					//if the manager entered credentials correctly
					String s2 = ctr.registerControl(uName, pass, 2);
					System.out.println(TextEffects.ANSI_RED+s2);
				} else {
					System.out.println(TextEffects.ANSI_RED+"Manager credentials incorrect.");
					//mainMenu(scanner);
				}
				
				
				//after everything
				System.out.println(TextEffects.ANSI_RED+"Now returning you to the main menu");
				break;
			default: //user does not select customer or employee integer
				System.out.print("\033[H\033[2J");
				System.out.flush(); //clears sensitive password information
				System.out.println(TextEffects.ANSI_RED+"Improper input for customer/employee selection.");
				System.out.println("No account was created.  Returning to main menu...");
				//goes to main menu
				break;
		}
		
	}
	
	public static void loginMenu(Scanner scanner) { //logs into an account
		System.out.println(TextEffects.ANSI_BLUE+"Please enter your username:"+TextEffects.ANSI_GREEN);
		String uName = scanner.next();
		System.out.println(TextEffects.ANSI_BLUE+"Please enter your password:"+TextEffects.ANSI_GREEN);
		String pass = scanner.next();
		
		System.out.print("\033[H\033[2J");
		System.out.flush(); //clears sensitive password information
		
		String s = ctr.loginControl(uName.trim(), pass.trim());
		System.out.println(TextEffects.ANSI_RED+s);
		System.out.println("Now returning you to the main menu");
		//mainMenu(scanner);
	}
}
