package com.cars.ui;

import java.util.Scanner;

import com.cars.controller.Controller;
import com.cars.model.Car;



/*
 * 		layers of project 0
 * 			UI
 * 				Gather input from the user
 * 				Display information to the user
 * 				Get actions from the user (I want to put an offer on a car)
 * 			Controller
 * 				Gather information from the UI
 * 				Use the data to communicate with service layer
 * 				Send information back to the UI
 * 				Send information to the Service layer
 * 			Service
 * 				Gather information from the Repository
 * 				Use the data to perform logic with the controller
 * 				Send information to the controller
 * 				Send information to the repository layer
 * 			Repository
 * 				Gather information from the service layer
 * 				Communicate with the database
 * 				send and gather information to/from the db
 * 
 * 			Model (accessible throughout) (what does the data look like? the other layers are about dataflow, this is about the actual data)
 * 				Provide classes meant to represent real world objects
 */
public class UI {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		mainMenu(scanner);
	}
	
	static void mainMenu(Scanner scanner) {
		System.out.println(TextEffects.ANSI_RED+"Welcome to the dealership!");
		System.out.println(TextEffects.ANSI_BLUE+"Type a number to select an option:");
		System.out.println("1) View cars on the lot");
		System.out.println("2) View cars I own");
		System.out.println("3) Register for an account");
		System.out.println("4) Login to an account");
		System.out.println("5) Logout"+TextEffects.ANSI_GREEN);
		
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1:
				lotMenu(scanner, 0);
				break;
			case 2:
				ownedCarsMenu(scanner);
				break;
			case 3:
				registerMenu(scanner);
				break;
			case 4:
				loginMenu(scanner);
				break;
			case 5:
				System.out.println("You have been successfully logged out.");
				mainMenu(scanner);
				break;
			default:
				System.out.println("Please type in a valid input.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mainMenu(scanner);
				break;
		}
		
	}
	
	static void lotMenu(Scanner scanner, int i) {
		System.out.println(TextEffects.ANSI_BLUE+"These are the cars available on the lot:");
		System.out.println("---------Page1---------");
		
		//Controller.lotController(); //start the chain to pull cars from the repo
		System.out.println("Gold 2005 Buick Terazza");
		System.out.println("Listing Price: $2400");
		System.out.println("Offers: 1");
		System.out.println("Monthly Payments: $200 for 12 months");
		System.out.println("Yearly Payments: $0 for 0 years");
		System.out.println("-----------------------");
		
		System.out.println("Type a number to select an option");
		System.out.println("1) View car offers");
		System.out.println("2) Go to the next page");
		System.out.println("3) Go to the previous page");
		System.out.println("4) Return to the previous menu"+TextEffects.ANSI_GREEN);
		
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1:
//				System.out.println("Please type in the id of the car you would like to view:");
//				int selTwo = scanner.nextInt();
//				//code testing if selTwo matches a car id
//				//if so, go to carOffers menu
//				//if not, go back to lot menu
//				if(selTwo == 1) {
//					carOffersMenu(scanner, new Car());
//				} else {
//					lotMenu(scanner, i);
//				}
				carOffersMenu(scanner, new Car());
				break;
			case 2:
				i++;
				lotMenu(scanner, i);
				break;
			case 3:
				i--;
				lotMenu(scanner, i);
				break;
			case 4:
				mainMenu(scanner);
				break;
			default:
				System.out.println("Please type in a valid input.");
				lotMenu(scanner, i);
				break;
		}
		
		
	}
	
	static void ownedCarsMenu(Scanner scanner) {
		System.out.println("These are the cars you own:");
		System.out.println("Type a number to select an option:");
		System.out.println("1) View payments");
		System.out.println("2) Return to main menu");
		
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1:
				carPaymentsMenu(scanner, new Car());
				break;
			case 2:
				mainMenu(scanner);
				break;
			default:
				System.out.println("Please type in a valid input.");
				ownedCarsMenu(scanner);
				break;
		}
		
		mainMenu(scanner);
	}
	
	static void registerMenu(Scanner scanner) {
		System.out.println("Please input your new username:");
		String uName = scanner.next();
		System.out.println("Please input your new password:");
		String pass = scanner.next();
		System.out.println("Are you a customer or an employee?");
		System.out.println("Type 1 for customer, 2 for employee:");
		int uType = scanner.nextInt();
		
		switch(uType) {
			case 1:
				Controller.registerControl(uName, pass, "Customer");
				break;
			case 2:
				System.out.println("A current employee will need to confirm this new employee acount.");
				System.out.println("Current employee, please input your username:");
				String eName = scanner.next();
				System.out.println("Current employee, please input your password:");
				String ePass = scanner.next();
				
				if(Controller.checkEmp(eName, ePass, "Employee")) {
					
				} else {
					System.out.println("No matching record was found. Returning to main menu...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					mainMenu(scanner);
				}
				
				Controller.registerControl(uName, pass, "Employee");
				break;
			default:
				System.out.println("Improper input for customer/employee selection.");
				System.out.println("No account was created.  Returning to main menu...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mainMenu(scanner);
				break;
		}
		
		//code that has current employee confirm new employee account before allowing
		System.out.println("Thank you for registering! Now returning you to the main menu");
		mainMenu(scanner);
	}
	
	static void loginMenu(Scanner scanner) {
		System.out.println("Please enter your username:");
		String uName = scanner.next();
		//calls controller function which progogates up to repo, checks if username exists. if so, continue
		System.out.println("Please enter your password:");
		String pass = scanner.next();
		//calls controller function which propagates up to repo, checks is pass matches username.  if so, continue
		System.out.println("Thank you for logging in! Now returning you to the main menu");
		mainMenu(scanner);
	}
	
	static void carOffersMenu(Scanner scanner, Car car) {
		System.out.println(TextEffects.ANSI_BLUE+"Here are the car details, and offers: ");
		
		//get info from table
		System.out.println("--------Details--------");
		System.out.println("Gold 2005 Buick Terazza");
		System.out.println("Listing Price: $2400");
		System.out.println("Offers: 1");
		System.out.println("Monthly Payments: $200 for 12 months");
		System.out.println("Yearly Payments: $0 for 0 years");
		System.out.println("--------Offers---------");
		System.out.println("$2200");
		
		System.out.println("Type a number to select an option:");
		System.out.println("1) Make offer");
		System.out.println("2) Employee options");
		System.out.println("3) Return to lot");
		System.out.println("4) Return to main menu"+TextEffects.ANSI_GREEN);
		
		int selection = scanner.nextInt();
		switch(selection) {
			case 1:
				System.out.println(TextEffects.ANSI_BLUE+"What is your offer?"+TextEffects.ANSI_GREEN);
				scanner.nextInt();
				//send offer to table
				System.out.println(TextEffects.ANSI_RED+"Thank you for your offer.  Returning you to the car you were viewing...");
				carOffersMenu(scanner, new Car());
				break;
			case 2:
				//get type of user, has to be employee.
				//if true,
				
		}
		
		
		mainMenu(scanner);
	}
	
	static void carPaymentsMenu(Scanner scanner, Car car) {
		System.out.println("Here are the car details, and remaining payments: ");
		System.out.println("Type a number to select an option:");
		System.out.println("1) Return to owned cars menu");
		System.out.println("2) Return to main menu");
		
		int selection = scanner.nextInt();
		
		mainMenu(scanner);
	}
	
}
