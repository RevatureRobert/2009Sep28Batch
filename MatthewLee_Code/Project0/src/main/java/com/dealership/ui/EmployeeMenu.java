package com.dealership.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.dealership.controller.EmployeeController;
import com.dealership.model.Car;
import com.dealership.model.Employee;
import com.dealership.model.Offer;
import com.dealership.model.Payment;

public class EmployeeMenu {

	private EmployeeController empControl;

	public EmployeeMenu() {
		this(new EmployeeController());
	}

	public EmployeeMenu(EmployeeController empControl) {
		this.empControl = empControl;
	}

	public Employee login(Scanner scan) {
		String title = "Employee Login";
		int padding = ((32 - title.length()) / 2) + title.length();

		System.out.println("\n\n--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		System.out.print("Enter username: ");
		String username = scan.next();
		System.out.print("Enter password: ");
		String password = scan.next();

		return empControl.login(username, password);
	}

	public void displayEmployeeMenu(Scanner scan) {
		String title = "Employee Menu";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			System.out.println("1. View cars");
			System.out.println("2. View offers");
			System.out.println("3. View payments");
			System.out.println("4. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				viewCars(scan);
				break;
			case "2":
				viewOffers(scan);
				break;
			case "3":
				viewPayments(scan);
				break;
			case "4":
				return;
			default:
				displayInvalidInput();
			}
		}
	}

	private void viewCars(Scanner scan) {
		List<Car> cars = empControl.viewCars();
		List<Integer> carIds = new ArrayList<>();

		String title = "Car Lot";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			if (cars.size() == 0) {
				System.out.println("\n\n* We are currently out of cars! *");
			}

			for (Car c : cars) {
				System.out.println(c);
				carIds.add(c.getId());
			}

			System.out.println("\n1. Add car");
			System.out.println("2. Edit car");
			System.out.println("3. Remove car");
			System.out.println("4. Exit");
			System.out.print("Enter option number: ");

			int result = 0;
			switch (scan.next()) {
			case "1":
				result = addCar(scan);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Car was not added.*");
				} else {
					System.out.println("\n\n** Car was succesfully added. **");
				}
				return;
			case "2":
				result = editCar(scan, cars, carIds);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Car was not edited.*");
				} else if (result == 1) {
					System.out.println("\n\n* Car was succesfully edited. *");
				}
				return;
			case "3":
				result = removeCar(scan, cars, carIds);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Car was not added.*");
				} else if (result == 1) {
					System.out.println("\n\n* Car was succesfully removed. *");
				}
				return;
			case "4":
				System.out.println("\n");
				return;
			default:
				displayInvalidInput();
			}
		}
	}

	private int addCar(Scanner scan) {
		Car car = null;

		String title = "Add Car";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			System.out.println("Enter car info.");
			System.out.print("Make: ");
			String make = scan.next();
			System.out.print("Model: ");
			String model = scan.next();
			System.out.print("Year: ");

			try {
				int year = scan.nextInt();
				if (Integer.toString(year).length() != 4) {
					displayInvalidInput();
					continue;
				}

				System.out.print("MPG: ");
				int MPG = scan.nextInt();
				System.out.print("Price: ");
				int price = scan.nextInt();

				car = new Car(make, model, year, MPG, price);
				break;

			} catch (InputMismatchException e) {
				displayInvalidInput();
				scan.nextLine();
				continue;
			}
		}

		return empControl.addCar(car);
	}

	private int editCar(Scanner scan, List<Car> cars, List<Integer> carIds) {
		if (cars.size() == 0) {
			System.out.println("\n\n* We are currently out of cars! *");
			return -1;
		}
		
		int carId = 0;
		Car car = null;

		String title = "Edit Car";
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
			System.out.print("Select car to edit: ");

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
			System.out.println("\nEnter edited car info.");
			System.out.print("Make: ");
			String make = scan.next();
			System.out.print("Model: ");
			String model = scan.next();
			System.out.print("Year: ");

			try {
				int year = scan.nextInt();
				if (Integer.toString(year).length() != 4) {
					displayInvalidInput();
					continue;
				}

				System.out.print("MPG: ");
				int MPG = scan.nextInt();
				System.out.print("Price: ");
				int price = scan.nextInt();

				car = new Car(carId, make, model, year, MPG, price);
				break;

			} catch (InputMismatchException e) {
				displayInvalidInput();
				scan.nextLine();
				continue;
			}
		}

		return empControl.editCar(car);
	}

	private int removeCar(Scanner scan, List<Car> cars, List<Integer> carIds) {
		if (cars.size() == 0) {
			System.out.println("\n\n* We are currently out of cars! *");
			return -1;
		}
		
		int carId = 0;

		String title = "Remove Car";
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
			System.out.print("Select car to remove: ");

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

		return empControl.removeCar(carId);
	}

	private void viewOffers(Scanner scan) {
		List<Offer> offers = empControl.viewOffers();
		if (offers.size() == 0) {
			System.out.println("\n\n***** There are no offers. *****");
			return;
		}
		List<Integer> offerIds = new ArrayList<>();

		String title = "Offers";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Offer o : offers) {
				System.out.println(o);
				offerIds.add(o.getOfferId());
			}

			System.out.println("\n1. Accept offer");
			System.out.println("2. Reject offer");
			System.out.println("3. Exit");
			System.out.print("Enter option number: ");

			switch (scan.next()) {
			case "1":
				acceptOrRejectOffer(scan, offers, offerIds, true);
				System.out.println("\n");
				return;
			case "2":
				int result = acceptOrRejectOffer(scan, offers, offerIds, false);
				if (result == 0) {
					System.out.println("\n\n*Something went wrong! Offer was not rejected.*");
				} else if (result == 1) {
					System.out.println("\n\n*Offer was succesfully reject.*");
				}
				return;
			case "3":
				System.out.println("\n");
				return;
			default:
				displayInvalidInput();
			}
		}
	}

	private int acceptOrRejectOffer(Scanner scan, List<Offer> offers, List<Integer> offerIds, boolean accept) {
		int offerId = 0;
		
		String title = "";
		if (accept) {
			title = "Accept Offer";
		} else {
			title = "Reject Offer";
		}
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		while (true) {
			System.out.println("--------------------------------");
			System.out.println(String.format("%" + padding + "s", title));
			System.out.println("--------------------------------");

			for (Offer o : offers) {
				System.out.println(o);
			}

			System.out.println("\nE. Exit");
			System.out.print("Select offer: ");

			String input = scan.next();
			if (input.equals("E") || input.equals("e")) {
				System.out.println("\n");
				return -1;
			}

			try {
				offerId = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				displayInvalidInput();
				continue;
			}

			if (!offerIds.contains(offerId)) {
				displayInvalidInput();
				continue;
			} else {
				break;
			}
		}
		
		if (accept) {
			empControl.acceptOffer(offerId);
			return 1;
		} else {
			return empControl.rejectOffer(offerId);
		}
	}

	private void viewPayments(Scanner scan) {
		List<Payment> payments = empControl.viewPayments();
		if (payments.size() == 0) {
			System.out.println("\n\n**** There are no payments. ****");
			return;
		}

		String title = "Payments";
		int padding = ((32 - title.length()) / 2) + title.length();
		System.out.println("\n");

		System.out.println("--------------------------------");
		System.out.println(String.format("%" + padding + "s", title));
		System.out.println("--------------------------------");

		for (Payment p : payments) {
			System.out.println(p);
		}

		System.out.print("\nEnter any key to exit: ");
		scan.next();
		System.out.println("\n");
	}

	private void displayInvalidInput() {
		System.out.println("\n\n******** Invalid input! ********");
	}

}