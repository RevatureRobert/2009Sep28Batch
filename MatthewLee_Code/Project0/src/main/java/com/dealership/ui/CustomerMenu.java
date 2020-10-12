package com.dealership.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dealership.controller.CustomerController;
import com.dealership.model.Car;
import com.dealership.model.Customer;
import com.dealership.model.Offer;
import com.dealership.model.Payment;

public class CustomerMenu {

	private CustomerController cControl;

	public CustomerMenu() {
		this(new CustomerController());
	}

	public CustomerMenu(CustomerController cControl) {
		this.cControl = cControl;
	}
	
	public int register(Scanner scan) {
		String title = "Register Customer Account";
		int padding = ((32 - title.length()) / 2) + title.length();

		System.out.println("\n\n--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		System.out.print("Enter username: ");
		String username = scan.next();
		System.out.print("Enter password: ");
		String password = scan.next();
		
		return cControl.register(username, password);
	}
	
	public Customer login(Scanner scan) {
		String title = "Customer Login";
		int padding = ((32 - title.length()) / 2) + title.length();

		System.out.println("\n\n--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		System.out.print("Enter username: ");
		String username = scan.next();
		System.out.print("Enter password: ");
		String password = scan.next();		
		
		return cControl.login(username, password);
	}
	
	public void displayCustomerMenu(Scanner scan, int customerId) {
		String title = "Customer Menu";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			System.out.println("1. View car lot");
			System.out.println("2. View your cars");
			System.out.println("3. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				viewCarLot(scan, customerId);
				break;
			case "2":
				viewCustomerCarsandPayments(scan, customerId);
				break;
			case "3":
				return;
			default:
				displayInvalidInput();
			}
		}
	}
	
	private void viewCarLot(Scanner scan, int customerId) {
		List<Car> cars = cControl.viewCarLot();
		if (cars.size() == 0) {
			System.out.println("\n\n* We are currently out of cars! *");
			return;
		}
		
		List<Integer> carIds = new ArrayList<>();
		
		String title = "Car Lot";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Car c : cars) {
				System.out.println(c);
				carIds.add(c.getId());
			}

			System.out.println("\n1. Make offer");
			System.out.println("2. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				int result = makeOffer(scan, cars, carIds, customerId);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Offer was not made.*");
				} else if (result == 1) {
					System.out.println("\n\n* Offer was successfully made. *");
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
	
	private int makeOffer(Scanner scan, List<Car> cars, List<Integer> carIds, int customerId) {
		int carId = 0;
		Offer offer = null;
		
		String title = "Make Offer";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Car c : cars) {
				System.out.println(c);
			}

			System.out.println("\nE. Exit");
			System.out.print("Select a car to make an offer on: ");

			String input = scan.next();
			if (input.equals("E") || input.equals("e")) {
				System.out.println("\n");
				return -1;
			}
			
			try {
				carId = Integer.parseInt(input);				
			} catch (NumberFormatException e) {
				displayInvalidInput();
				continue;
			}
			
			if (!carIds.contains(carId)) {
				displayInvalidInput();
				continue;
			} else {
				break;
			}
		}
		
		while (true) {
			try {
				System.out.print("Enter offer amount: ");
				int amount = Integer.parseInt(scan.next());
				
				System.out.print("Enter number of monthly payments: ");
				int months = Integer.parseInt(scan.next());
				
				System.out.println(String.format("\nIf offer is accepted, you will pay "
						+ "%d monthly payments of $%.2f.", months, (amount/ (double) months)));
			
				System.out.print("Enter any key to continue: ");
				scan.next();
				
				offer = new Offer(amount, months, customerId, carId);
				break;
				
			} catch (NumberFormatException e) {
				displayInvalidInput();
				continue;
			}
		}
		
		return cControl.makeOffer(offer);
	}
	
	private void viewCustomerCarsandPayments(Scanner scan, int customerId) {
		List<Car> cars = cControl.viewCustomerCars(customerId);
		if (cars.size() == 0) {
			System.out.println("\n\n*** You do not own any cars! ***");
			return;
		}
		
		List<Payment> payments = cControl.viewPayments(customerId);
		List<Integer> carIds = new ArrayList<>();
		
		String title = "Customer's Cars";
		int padding = ((32 - title.length()) / 2) + title.length();

		while (true) {
			System.out.println("\n\n--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Car c : cars) {
				carIds.add(c.getId());
				System.out.println(c);
				for (Payment p : payments) {
					if (p.getCarId() == c.getId()) {
						System.out.println(p.displayPaidBalance() + "\n");
					}
				}
			}

			System.out.println("1. Make payment");
			System.out.println("2. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				int result = makePayment(scan, cars, carIds, payments, customerId);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Payment was not made.*");
				} else if (result == 1) {
					System.out.println("\n\n* Payment was successfully made. *");
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
	
	private int makePayment(Scanner scan, List<Car> cars, List<Integer> carIds, List<Payment> payments, int customerId) {
		int carId = 0;
		double monthlyPayment = 0;
		
		String title = "Make Payment";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Car c : cars) {
				System.out.println(c);
				for (Payment p : payments) {
					if (p.getCarId() == c.getId()) {
						System.out.println(p.displayPaidBalance() + "\n");
					}
				}
			}

			System.out.println("\nE. Exit");
			System.out.print("Select a car to make an payment on: ");

			String input = scan.next();
			if (input.equals("E") || input.equals("e")) {
				System.out.println("\n");
				return -1;
			}
			
			try {
				carId = Integer.parseInt(input);				
			} catch (NumberFormatException e) {
				displayInvalidInput();
				continue;
			}
			
			if (!carIds.contains(carId)) {
				displayInvalidInput();
				continue;
			} else {
				boolean paid = false;
				for (Payment p : payments) {
					if (p.getCarId() == carId) {
						monthlyPayment = p.getMonthlyPayment();
						
						if (p.getBalance() == 0) {
							System.out.println("\n\nThe car is already paid in full.");
							paid = true;
							break;
						}
					}
				}
				
				if (paid) {
					continue;
				}
				
				break;
			}
		}
				
		return cControl.makePayment(new Payment(customerId, carId, monthlyPayment));
	}
	
	private void displayInvalidInput() {
		System.out.println("\n\n******** Invalid input! ********");
	}
}
