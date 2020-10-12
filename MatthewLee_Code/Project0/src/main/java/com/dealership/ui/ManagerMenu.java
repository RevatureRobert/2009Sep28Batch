package com.dealership.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealership.controller.ManagerController;
import com.dealership.model.Employee;
import com.dealership.model.Manager;
import com.dealership.model.Offer;

public class ManagerMenu {

	private ManagerController mControl;
	
	public ManagerMenu() {
		this(new ManagerController());
	}

	public ManagerMenu(ManagerController mControl) {
		this.mControl = mControl;
	}

	public Manager login(Scanner scan) {
		String title = "Manager Login";
		int padding = ((32 - title.length()) / 2) + title.length();

		System.out.println("\n\n--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		System.out.print("Enter username: ");
		String username = scan.next();
		System.out.print("Enter password: ");
		String password = scan.next();

		return mControl.login(username, password);
	}
	
	public void displayManagerMenu(Scanner scan) {
		String title = "Manager Menu";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			System.out.println("1. Create employee account");
			System.out.println("2. View employees");
			System.out.println("3. View sales history");
			System.out.println("4. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":				
				if (createEmployeeAccount(scan) == 0) {
					System.out.println("\n\n** Username is already taken! **");
				} else {
					System.out.println("\n\n* Account successfully created! *");
				}
				break;
			case "2":
				viewEmployees(scan);
				break;
			case "3":
				viewSalesHistory(scan);
				break;
			case "4":
				return;
			default:
				displayInvalidInput();
			}
		}
	}
	
	private int createEmployeeAccount(Scanner scan) {
		String title = "Make Employee Account";
		int padding = ((32 - title.length()) / 2) + title.length();

		System.out.println("\n\n--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		System.out.print("Enter username: ");
		String username = scan.next();
		System.out.print("Enter password: ");
		String password = scan.next();
		
		return mControl.createEmployeeAccount(username, password);
	}
	
	private void viewEmployees(Scanner scan) {
		List<Employee> employees = mControl.viewEmployees();

		String title = "Employees";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			if (employees.size() == 0) {
				System.out.println("\n\n*** There are no employees! ***");
				return;
			}

			for (Employee e : employees) {
				System.out.println(e);
			}

			System.out.println("\n1. Fire employee");
			System.out.println("2. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				int result = fireEmployee(scan, employees);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Employee was not fired.*");
				} else if (result == 1) {
					System.out.println("\n\n* Employee succesfully fired. *");
				}
				return;
			case "2":
				System.out.println("\n");
				return;
			default:
				displayInvalidInput();
			}
		}
	}
	
	private int fireEmployee(Scanner scan, List<Employee> employees) {
		List<Integer> employeeIds = new ArrayList<>();
		int employeeId = 0;

		String title = "Fire Employee";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Employee e : employees) {
				System.out.println(e);
				employeeIds.add(e.getId());
			}

			System.out.println("\nE. Exit");
			System.out.print("Select employee to fire: ");

			String input = scan.next();
			if (input.equals("E") || input.equals("e")) {
				System.out.println("\n");
				return -1;
			}

			try {
				employeeId = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				displayInvalidInput();
				continue;
			}

			if (!employeeIds.contains(employeeId)) {
				displayInvalidInput();
				continue;
			} else {
				break;
			}
		}

		return mControl.fireEmployee(employeeId);	
	}
	
	private void viewSalesHistory(Scanner scan) {
		List<Offer> offers = mControl.viewSalesHistory();
		
		String title = "Sales History";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		System.out.println("--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		if (offers.size() == 0) {
			System.out.println("\n\n** There is no sale history! **");
			return;
		}
		
		for (Offer o : offers) {
			System.out.println(o.printOfferStatus());
		}

		System.out.print("\nEnter any key to exit: ");
		scan.next();
		System.out.println("\n");
	}

	private void displayInvalidInput() {
		System.out.println("\n\n******** Invalid input! ********");
	}
	
}
