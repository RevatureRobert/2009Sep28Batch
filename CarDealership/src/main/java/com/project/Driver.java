package com.project;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.ui.CarLotMenu;
import com.project.ui.Printers;
import com.project.ui.TextColors;
import com.project.ui.UserMenu;
import com.project.ui.currentUser;

public class Driver extends currentUser {
	
	// Initialize menu objects
	private static UserMenu um = new UserMenu();
	private static CarLotMenu cm = new CarLotMenu();
	final static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		
		logger.info("Application initialized. oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		Scanner mainScanner = new Scanner(System.in);

		mainMenu(mainScanner);
	}
	
	public static void mainMenu(Scanner A) {
		if(currentUser==null) {
			logger.info("Guest entered main menu");
		} else if (currentUser.getType()==1) {
			logger.info("Customer entered main menu");
		} else if (currentUser.getType()==2) {
			logger.info("Employee entered main menu");
		} else if (currentUser.getType()==3) {
			logger.info("Manager entered main menu");
		}
			
		String input;
		// Menu text
		Printers.mainMenuNonsense();
		if(currentUser!=null) {System.out.println(TextColors.GREEN_BOLD+"Current user: "+currentUser.getUsername()+TextColors.RESET);}
		System.out.println("\nPlease select an option by typing its number:");
		System.out.println("1) Login");
		System.out.println("2) View Lot");
		System.out.println("3) Register");
		try {
			if(currentUser.getType()==3)
				System.out.println("4) Manage employees");
		} catch (NullPointerException e) {
			// Do nothing
		}
		System.out.println("Type \"exit\" to leave.\n");
		
		// Gather user input
		System.out.print("Input: ");
		input = A.next();
		
		// Read input from menu, do something based on input
		switch(input.toUpperCase()) {
		case "1":
			um.LoginMenu(A);
			mainMenu(A);
			break;
		case "2":
			if(currentUser==null) {
				cm.carSimpleMenu(A);		// If not logged in
			} else if (currentUser.getType()==1) {
				cm.carCustomerMenu(A);		// If a customer
			} else if (currentUser.getType()>=2) {
				cm.carEmployeeMenu(A);		// If a employee or manager
			}
			mainMenu(A);					// Regardless, return to main menu afterwards
			break;
		case "3":
			um.RegistrationMenu(A);
			mainMenu(A);
			break;
		case "4":
			if(currentUser==null) {
				Printers.invalid("permission");
				logger.info("Guest tried to access employee records.");
			} else if(currentUser.getType()==3) {
				um.managerMenu(A);		// If manager
			} else {
				Printers.invalid("permission");
				logger.info("User #"+currentUser.getID()+" ("+currentUser.getUsername()+") tried to access employee records.");
			}
			mainMenu(A);					// Regardless, return to main menu afterwards
			break;
		case "EXIT":	// Exit message, close resources
			Printers.exitText();
			A.close();
			logger.info("User closed application. xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.exit(0);
		default:
			logger.info("Invalid input in main menu.");
			Printers.invalid("input");	// If input fell through the switch statement, input was incorrect.
			mainMenu(A);
			break;
		}
	}
	
}
