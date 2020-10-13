package com.project0.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.project0.controller.BidController;
import com.project0.controller.CarController;
import com.project0.controller.EmployeeController;
import com.project0.model.Bid;
import com.project0.model.Car;
import com.project0.model.Employee;

public class EmployeeMenu {

	static Logger log = Logger.getLogger(EmployeeMenu.class);

	private EmployeeController ec;
	private CarController cc;
	private BidController bc;

	public EmployeeMenu() {
		this(new EmployeeController(), new CarController(), new BidController());
	}

	public EmployeeMenu(EmployeeController ec, CarController cc, BidController bc) {
		super();
		this.ec = ec;
		this.cc = cc;
		this.bc = bc;
	}

	MainMenu mm = new MainMenu();

	public String employeeMenu(Scanner scan, Employee employee) {
		System.out.println(employee.getName() + " ...GET BACK TO WORK!");
		System.out.println("1. Add cars to DB");
		System.out.println("2. Remove cars from DB");
		System.out.println("3. View/Approve bids");
		System.out.println("4. View Payments");
		System.out.println("9. Main Menu");
		int result = scan.nextInt();
		switch (result) {
		case 1:
			createCarMenu(scan);
			return employeeMenu(scan, employee);

		case 2:
			deleteCarMenu(scan);
			return employeeMenu(scan, employee);
		case 3:
			acceptBid(showBidsAndChoose(scan, employee));
			return employeeMenu(scan, employee);
		case 4:
			viewPayments();
			return employeeMenu(scan, employee);
		case 9:
			mm.mainMenu(scan);
			return null;
		default:
			System.out.println("please choose a valid option");
			return employeeMenu(scan, employee);
		}

	}

	public String createCarMenu(Scanner scan) {
		log.info("Creating a new car..");
		System.out.println("Creating new car..");
		System.out.println("Enter make...");
		String make = scan.next();
		System.out.println("Enter model...");
		String model = scan.next();
		System.out.println("Enter year...");
		int year = 0;

		try {
			year = scan.nextInt();

		} catch (Exception e) {
			log.error("Failed car created @ year: " + e.getMessage());

			System.out.println("Please enter a year. Restarting...");
			scan.nextLine();
			createCarMenu(scan);

		}
		System.out.println("Enter price...");
		int price = 0;

		try {
			price = scan.nextInt();
//			The same price twice because the price is also the balance
			return cc.insert(new Car(make, model, year, price, price));

		} catch (Exception e) {
			log.error("Failed car creation @ insert : " + e.getMessage());

			System.out.println("Could not create car");
			scan.nextLine();
			createCarMenu(scan);

		}
		return null;

	}

	public int deleteCarMenu(Scanner scan) {
		System.out.println("Which car do you want to delete?");
		Set<Integer> ids = new HashSet<>();

		for (Car c : cc.findAll()) {
			ids.add(c.getId());

			System.out.println(c.getId() + ":" + " " + c.toString());
		}
		int deleteId = -1;

		try {
			deleteId = scan.nextInt();

		} catch (Exception e) {
			log.error("Failed deletion : " + e.getMessage());

			System.out.println("invalid selection");
			scan.next();
			deleteCarMenu(scan);
		}

		if (!ids.contains(deleteId)) {
			System.out.println("Please only select an id from the cars you want to delete.");
			deleteCarMenu(scan);
		}
		System.out.println("Car deleted!");
		return cc.delete(deleteId);
	}

	public Bid showBidsAndChoose(Scanner scan, Employee employee) {
		List<Bid> bidList = bc.findAll();
		if (bidList.size() != 0) {

			System.out.println("Which bid would you like to accept?:");

			System.out.println("bidId" + "  " + "carid" + "  " + "bid amount" + "  " + "customerId");

			for (Bid b : bidList) {
				System.out.println(b.getId() + ":     " + b.getCarId() + "        " + b.getAmount() + "            "
						+ b.getCustomerId());
			}
			int bidChoice = scan.nextInt();

			return bc.findById(bidChoice);

		} else {
			System.out.println("There are no active bids.");
			employeeMenu(scan, employee);
		}
		return null;

	}

	public int acceptBid(Bid b) {
		bc.deleteAllForCar(b.getCarId());
		cc.addCusToCar(b.getCustomerId(), b.getCarId());
		System.out.println("Bid accepted! Rejecting all other bids for this car.");
		return 1;
	}

	public int viewPayments() {
		System.out.println("Current payments: ");
		System.out.println("carId: " + "amount owed     " + "monthly payment" + "    payments left");

		for (Car c : cc.findAllCarsWithBalance()) {
			System.out.println(c.getId() + ":         " + c.getBalance() + "             " + c.getMonthlyPayment()
					+ "               " + (c.getBalance() / c.getMonthlyPayment()));
		}
		return 1;
	}

}
