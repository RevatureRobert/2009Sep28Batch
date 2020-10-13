package com.project0.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.project0.controller.BidController;
import com.project0.controller.CarController;
import com.project0.controller.CustomerController;
import com.project0.model.Bid;
import com.project0.model.Car;
import com.project0.model.Customer;

public class CustomerMenu {

	static Logger log = Logger.getLogger(EmployeeMenu.class);

	private CustomerController cusC;
	private CarController carC;
	private BidController bidC;

	public CustomerMenu() {
		this(new CustomerController(), new CarController(), new BidController());
	}

	public CustomerMenu(CustomerController cusC, CarController carC, BidController bidC) {
		super();
		this.cusC = cusC;
		this.carC = carC;
		this.bidC = bidC;
	}

	MainMenu mm = new MainMenu();

//	return string???
	public void customerMenu(Scanner scan, Customer customer) {
		System.out.println("Welcome " + customer.getName());
		System.out.println("1. View your cars");
		System.out.println("2. View unsold cars");
		System.out.println("3. Make a bid on a car");
		System.out.println("4. Make a payment");
		System.out.println("9. Main Menu");

		int result = scan.nextInt();
		switch (result) {
		case 1:
			showCars(carC.findCarsByOwnerId(customer.getId()));
			customerMenu(scan, customer);
			break;
		case 2:
			showCars(carC.findAvailableCars());
			customerMenu(scan, customer);
			break;
		case 3:
			try {
				makeBid(scan, customer);
			} catch (Exception e) {
				System.out.println("Didn't work");
				e.printStackTrace();
			}
			customerMenu(scan, customer);
			break;
		case 4:
			try {
				lowerPrice(scan, makePayment(scan, customer));
				customerMenu(scan, customer);
			} catch (Exception e) {
				System.out.println("Didn't work");
				e.printStackTrace();
			}
			customerMenu(scan, customer);
			break;
		case 9:
			mm.mainMenu(scan);
			break;
		default:
			System.out.println("please choose a valid option");
			customerMenu(scan, customer);
		}

	}

	public void showCars(List<Car> cars) {
		if (cars.size() == 0) {
			System.out.println("You don't have any cars. Please make a bid first.");
		} else {
			System.out.println("ID   year make      model     blue book value");
			for (Car c : cars) {
				System.out.println(c.getId() + ": " + c.toString());
			}
		}

	}

	public String makeBid(Scanner scan, Customer customer) {
		int carChoice = -1;
		System.out.println("Choose a car to bid on..");
		showCars(carC.findAvailableCars());
		try {
			carChoice = scan.nextInt();
		} catch (Exception e) {
			log.error("Failed bid: " + e.getMessage());

			System.out.println("Please only enter the Id from the car you'd like to bid on.");
			scan.next();
			makeBid(scan, customer);

		}

		Car car = carC.findById(carChoice);
		if (car == null) {
			System.out.println("Car not found. Please try again.");
			makeBid(scan, customer);
		}

		System.out.println("what amount would you like to bid? (1-" + car.getPrice() + ")");

		int amount = scan.nextInt();
		if (amount > car.getPrice() || amount < 1) {
			System.out.println("Please choose an amount between 1 and " + car.getPrice() + ".");
			customerMenu(scan, customer);
		}

		return bidC.insert(new Bid(carChoice, customer.getId(), amount));

	}

	public int makePayment(Scanner scan, Customer customer) {

		List<Car> cusUnpaidCars = carC.findAllCarsWithBalance(customer.getId());

		if (cusUnpaidCars.size() == 0) {
			System.out.println("You don't have any outstanding debts");
			customerMenu(scan, customer);

		}
		System.out.println("Which car do you want to make a payment?");
		System.out.println("  " + "Car" + "            " + "        amount owed     monthly payment");

		Set<Integer> ids = new HashSet<>();

		for (Car c : cusUnpaidCars) {
			ids.add(c.getId());
			System.out.println(c.getId() + ": " + c.getMake() + c.getModel() + "    " + c.getBalance() + "         "
					+ c.getMonthlyPayment());

		}
		int paymentChoice = -1;

		try {
			paymentChoice = scan.nextInt();

		} catch (Exception e) {
			System.out.println("invalid selection");
			scan.next();
			makePayment(scan, customer);
		}

		if (ids.contains(paymentChoice)) {
			return paymentChoice;
		} else {
			System.out.println("Please only select an id from the cars you owe money for.");
			customerMenu(scan, customer);
		}
		return -1;

	}

	public String lowerPrice(Scanner scan, int carId) {
		Car car = carC.findById(carId);
		System.out.println("How much do you want to pay?");
		int paymentAmount = scan.nextInt();
		carC.makePayment(carId, paymentAmount);
		System.out.println("Thank you for the payment.");

		return null;

	}

}
