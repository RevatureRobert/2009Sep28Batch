package com.dealership;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dealership.model.Customer;
import com.dealership.ui.CustomerMenu;
import com.dealership.ui.EmployeeMenu;
import com.dealership.ui.ManagerMenu;

public class Driver {
	
	private static final Logger logger = LogManager.getLogger(Driver.class.getName());
	
	private static ManagerMenu mm = new ManagerMenu();
	private static EmployeeMenu em = new EmployeeMenu();
	private static CustomerMenu cm = new CustomerMenu();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		displayMainMenu(scanner);
	}
	
	public static void displayMainMenu (Scanner scan) {
		logger.info("Entering dealership");
		System.out.println("\nWelcome to Matthew's Dealership!");

		while (true) {
			displayTitle("Main Menu");

			System.out.println("1. Manager Login");
			System.out.println("2. Employee Login");
			System.out.println("3. Customer Login");
			System.out.println("4. Register Customer Account");
			System.out.println("5. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				if (mm.login(scan) == null) {
					logger.info("Invalid username and/or password");
					System.out.println("\n\nInvalid username and/or password!");
				} else {
					mm.displayManagerMenu(scan);
					displayExit();
					logger.info("Logging out\n");
					return;
				}
				break;			
			case "2":
				if (em.login(scan) == null) {
					logger.info("Invalid username and/or password");
					System.out.println("\n\nInvalid username and/or password!");
				} else {
					em.displayEmployeeMenu(scan);
					displayExit();
					logger.info("Logging out\n");
					return;
				}
				break;
			case "3":
				Customer customer = cm.login(scan);
				if (customer == null) {
					logger.info("Invalid username and/or password");
					System.out.println("\n\nInvalid username and/or password!");
				} else {
					cm.displayCustomerMenu(scan, customer.getId());
					displayExit();
					logger.info("Logging out\n");
					return;
				}
				break;
			case "4":
				if (cm.register(scan) == 0) {
					System.out.println("\n\n** Username is already taken! **");
				} else {
					System.out.println("\n\n*** Successfully registered! ***");
				}
				break;
			case "5":
				displayExit();
				logger.info("Exiting dealership\n");
				return;
			default:
				System.out.println("\n\n******** Invalid input! ********");
			}
		}
	}
	
	private static void displayExit() {
		System.out.println("\n\n--------------------------------");
		System.out.print("Thank you for visiting! Goodbye!");
	}
	
	private static void displayTitle(String title) {
		int padding = ((32 - title.length()) / 2) + title.length();

		System.out.println("\n--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");
	}
	
}
