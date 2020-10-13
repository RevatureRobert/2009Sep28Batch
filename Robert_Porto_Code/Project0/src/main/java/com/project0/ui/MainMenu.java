package com.project0.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.main.Driver;
import com.project0.model.Customer;
import com.project0.model.Employee;

public class MainMenu {
	static Logger log = Logger.getLogger(Driver.class);

	private static CustomerMenu cm = new CustomerMenu();
	private static CustomerLoginMenu clm = new CustomerLoginMenu();
	private static EmployeeMenu em = new EmployeeMenu();
	private static EmployeeLoginMenu elm = new EmployeeLoginMenu();

	private static NewCustomerMenu ncm = new NewCustomerMenu();

	public void mainMenu(Scanner scan) {
		System.out.println("Welcome to the car dealership. Please choose your option below...");
		System.out.println("1. Customer");
		System.out.println("2. Employee");
		System.out.println("3. New Customer Account");
		System.out.println("0. Exit");

		int selection = scan.nextInt();

		switch (selection) {
		case 1:
			Customer customer = clm.CustomerLogin(scan);
			try {
				cm.customerMenu(scan, customer);
			} catch (NullPointerException e) {
				System.out.println("Customer not Found. Please Try again...");
				log.error("Failed customer login attempt: " + e.getMessage());
				mainMenu(scan);
				break;
			}
			break;
		case 2:
			Employee employee = elm.EmployeeLogin(scan);
			try {
				em.employeeMenu(scan, employee);
			} catch (NullPointerException e) {
				System.out.println("Employee not Found. You were probably fired.");
				log.error("Failed employee login attempt: " + e.getMessage());
				mainMenu(scan);
				break;
			}
			mainMenu(scan);
			break;
		case 3:
			try {
				ncm.display(scan);
			} catch (Exception e) {
				System.out.println("That didn't work. Please try again.");
				log.error("Failed new customer: " + e.getMessage());
				mainMenu(scan);
				break;

			}
			System.out.println("Customer account created!");
			mainMenu(scan);
			break;
		case 0:
			System.out.println("Goodbye");
			System.exit(0);
		default:
			System.out.println("please choose a valid option");
			mainMenu(scan);
			break;
		}

	}

}
