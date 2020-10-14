package com.project.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.controller.IsValid;
import com.project.controller.UserController;
import com.project.model.User;

public class UserMenu extends currentUser {
	
	private UserController uc;
	final static Logger logger = Logger.getLogger(UserMenu.class);
	
	public UserMenu() {
		this(new UserController());
	}

	public UserMenu(UserController cc) {
		this.uc = cc;
	}
	
	/* -------------------------------------------- Register menu -------------------------------------------- */
	
	public String RegistrationMenu(Scanner A) {
		logger.info("Entering the user registration menu");
	
		Printers.blankPrinter();
		System.out.println("********************************************");
		System.out.println("REGISTRATION (Type \"exit\" to return to menu)");
		System.out.println("********************************************\n");
	
		System.out.print("Enter your email: ");
		String tempEmail = A.next();
		if(tempEmail.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User exitted registration during email input.");
			return "";				
		}
		if(!IsValid.email(tempEmail)) {
			logger.info("User failed the simple email check.");
			Printers.invalid("input");
			return RegistrationMenu(A);					// If statement wasn't met, input must be bad, reset.
		}
		
		System.out.print("Enter a username: ");
		String tempUsername = A.next();
		if(tempUsername.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User exitted registration during username input.");
			return "";
		}
		
		System.out.print("Enter a password: ");
		String tempPassword = A.next();
		if(tempPassword.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User exitted registration during password input.");
			return "";
		}
		
		User testUser = uc.insert(new User(tempEmail, tempUsername, tempPassword));
		
		if(testUser==null) {
			logger.info("Customer was not created.");
			return RegistrationMenu(A);
		} else {	// Appropriate data has been given, create the customer and add to DB
			logger.info("Customer was successfully created.");
			return "";
		}
		
	}
	
	/* -------------------------------------------- Login menu -------------------------------------------- */
	
	public String LoginMenu(Scanner A) {
		logger.info("Entering the login menu");
		
		Printers.blankPrinter();
		System.out.println("*************************************");
		System.out.println("LOGIN (Type \"exit\" to return to menu)");
		System.out.println("*************************************\n");
		
		System.out.print("Enter your username: ");	// Gather username
		String tempUsername = A.next();
		if(tempUsername.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User exitted at username entry");
			return "";				
		}
		
		System.out.print("Enter your password: ");	// Gather password
		String tempPassword = A.next();
		if(tempPassword.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User exitted at password entry");
			return "";
		}
		
		User man = new User();
		logger.info("Attempting to log in...");
		man = uc.findByNamePass(tempUsername, tempPassword);
		currentUser = man;
		if(currentUser!=null) {
			logger.info("User successfully logged in");
			Printers.validInput();
			return "";
		}
		
		// If user still here, failed to login and reset menu
		logger.info("Login failed.");
		Printers.invalid("record");
		return LoginMenu(A);
			
	}
	
	/* -------------------------------------------- Manager tools -------------------------------------------- */
	
	public String managerMenu(Scanner A) {
		logger.info("User entered the manager menu.");
		
		Printers.blankPrinter();
		System.out.println("--------------------- Current employees ---------------------");
		List<User> tempList = uc.findAll();
		if(tempList.size()==0) { System.out.println("You currently don't have any employees! Better hire some.\n"); }
		for(User u : tempList)
			System.out.println(u.userInfo());
		System.out.println("\n1) Make employee account");
		System.out.println("2) Fire employee");
		System.out.println("Type \"exit\" to return to main menu.\n");
		
		// Gather user input
		System.out.print("Input: ");
		String selection = A.next();
		switch (selection.toUpperCase()) {
		case "1":
			makeEmployeeAccount(A);
			return managerMenu(A);
		case "2":
			deleteUser(A);
			return managerMenu(A);
		case "EXIT":
			return "";
		default:		// If fell user through, bad input and retry
			logger.info("User entered invalid input and reset the manager menu.");
			Printers.invalid("input");
			return managerMenu(A);
		}
			
	}

	/* -------------------------------------------- Make an employee account -------------------------------------------- */
	
	private String makeEmployeeAccount(Scanner A) {
		logger.info("Manager is making an employee account...");
		
		Printers.blankPrinter();
		System.out.println("********************************************");
		System.out.println("EMPLOYEE CREATION (Type \"exit\" to cancel)");
		System.out.println("********************************************\n");
	
		System.out.print("Enter the employee's email: ");
		String tempEmail = A.next();
		if(tempEmail.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User left at email entry.");
			return "";				
		}
		if(!IsValid.email(tempEmail)) {
			logger.info("User failed the simple email check.");
			Printers.invalid("input");
			return RegistrationMenu(A);					// If statement wasn't met, input must be bad, reset.
		}
		
		System.out.print("Enter the employee's username: ");
		String tempUsername = A.next();
		if(tempUsername.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User left at username entry.");
			return "";
		}
		
		System.out.print("Enter the employee's password: ");
		String tempPassword = A.next();
		if(tempPassword.toUpperCase().equals("EXIT")) {	// If user wants to exit
			logger.info("User left at password entry.");
			return "";
		}
		
		User testUser = uc.insertEmployee(new User(tempEmail, tempUsername, tempPassword));
		
		if(testUser==null) {
			logger.info("Employee was not created.");
		} else {	// Appropriate data has been given, create the customer and add to DB
			logger.info("Employee was successfully created.");
		}
		
		return "";
	}
	
	/* -------------------------------------------- Delete a user -------------------------------------------- */

	private String deleteUser(Scanner A) {
		logger.info("User entered employee deletion menu.");
		
		System.out.println("Please enter the ID of the user that you wish to delete. Type \"exit\" to cancel.");
		System.out.print("User ID: ");
		String tempID = A.next();
		if(tempID.toUpperCase().equals("EXIT")) {		// Abandon changes if employee wants to exit
			logger.info("User left at employee ID entry.");
			return "";
			}	
		int tempIDInteger;
		try { tempIDInteger = Integer.parseInt(tempID);}		// Otherwise turn into number and delete if actually a number
		catch(NumberFormatException e) {
			logger.error("User entered a string in a field requesting numbers.");
			Printers.invalid("number");
			Printers.blankPrinter();
			return "";
			}
		
		int check = uc.remove(tempIDInteger);		// Finally, try to remove the employee
		if(check>=1) {	// Something was deleted
			logger.info("Employee deleted car with ID #"+tempID);
			Printers.loading("delete");
			Printers.validInput();
		} else {
			logger.info("Manager tried to delete an employee that does not exist!");
			Printers.loading("search");
			Printers.invalid("record");
		}
		return "";

	}
	
}
