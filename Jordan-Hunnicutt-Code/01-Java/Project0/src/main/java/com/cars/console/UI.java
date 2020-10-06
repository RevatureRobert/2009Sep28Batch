package com.cars.console;

import java.util.Scanner;

import com.cars.backend.Controller;
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
		System.out.println("Welcome to the dealership!");
		System.out.println("Type a number to select an option:");
		System.out.println("1) View cars on the lot");
		System.out.println("2) View cars I own");
		System.out.println("3) Register for an account");
		System.out.println("4) Login to an account");
		System.out.println("5) Logout");
		
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1:
				lotMenu(scanner);
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
				mainMenu(scanner);
				break;
		}
		
	}
	
	static void lotMenu(Scanner scanner) {
		System.out.println("These are the cars available on the lot:");
		System.out.println("--------Cars----------");
		
		Controller.lotController();
		
		System.out.println("Type a number to select an option");
		System.out.println("1) View car offers");
		System.out.println("2) Return to the previous menu");
		
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1:
				System.out.println("Please type in the id of the car you would like to view:");
				int selTwo = scanner.nextInt();
				//code testing if selTwo matches a car id
				//if so, go to carOffers menu
				//if not, go back to lot menu
				if(selTwo == 1) {
					carOffersMenu(scanner, new Car());
				} else {
					lotMenu(scanner);
				}
				
				break;
			case 2:
				mainMenu(scanner);
				break;
			default:
				System.out.println("Please type in a valid input.");
				lotMenu(scanner);
				break;
		}
		
		
	}
	
	static void ownedCarsMenu(Scanner scanner) {
		System.out.println("These are the cars you own:");
		System.out.println("Type a number to select an option:");
		System.out.println("1) View payments");
		System.out.println("2) Return to main menu");
		
		int selection = scanner.nextInt();
		
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
		System.out.println("Here are the car details, and offers: ");
		System.out.println("Type a number to select an option:");
		System.out.println("1) Make offer");
		System.out.println("2) Employee options");
		System.out.println("3) Return to lot");
		System.out.println("4) Return to main menu");
		
		int selection = scanner.nextInt();
		
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
