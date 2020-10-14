package com.project.ui;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.controller.CarController;
import com.project.controller.MoneyController;
import com.project.model.Car;
import com.project.model.Offer;

public class CarLotMenu extends currentUser {
	
	private CarController cc;
	private MoneyController mc;
	private static MoneyMenu mm = new MoneyMenu();
	final static Logger logger = Logger.getLogger(CarLotMenu.class);
	
	public CarLotMenu() {
		this(new CarController(), new MoneyController());
	}

	public CarLotMenu(CarController cc, MoneyController mc) {
		this.cc = cc;
		this.mc = mc;
	}
	
	// ----------------------------------------------- Simple menu -----------------------------------------------
	
	public String carSimpleMenu(Scanner A) {
		logger.info("Entering the car lot, not logged in");
		
		Printers.blankPrinter();
		System.out.println("---------------------------- Carlo's Current Car Collection ----------------------------");
		List<Car> tempList = cc.findAll();
		if(tempList.size()==0) { System.out.println("There are currently no cars on the lot.\n"); }
		for(Car s : tempList)
			System.out.println(s);
		System.out.println("\nPlease login to view additional options!");
		System.out.println("Type \"exit\" to return to main menu.\n");
		
		// Gather user input
		System.out.print("Input: ");
		String selection = A.next();
		if(selection.toUpperCase().equals("EXIT")) {
			logger.info("Guest exitted the lot");
			return "";
		}
		else {			// If fell user through, bad input and retry
			logger.info("Invalid input at car lot");
			Printers.invalid("input");
			return carSimpleMenu(A);
		}

	}
	
	// ----------------------------------------------- Customer menu -----------------------------------------------
	
	public String carCustomerMenu(Scanner A) {
		logger.info("Entering the car lot as a customer");
		
		Printers.blankPrinter();
		System.out.println("---------------------------- Carlo's Current Car Collection ----------------------------");
		List<Car> tempList = cc.findAll();
		if(tempList.size()==0) { System.out.println("There are currently no cars on the lot.\n"); }
		for(Car s : tempList)
			System.out.println(s);
		System.out.println("\n1) Make offer");
		System.out.println("2) View my cars");
		System.out.println("Type \"exit\" to return to main menu.\n");
		
		// Gather user input
		System.out.print("Input: ");
		String selection = A.next();
		switch (selection.toUpperCase()) {
		case "1":
			mm.makeOfferMenu(A, tempList);
			return carCustomerMenu(A);
		case "2":
			viewOwnedCars(A);
			return carCustomerMenu(A);
		case "EXIT":
			logger.info("Customer left car lot");
			return "";
		default:		// If fell user through, bad input and retry
			logger.info("Invalid input at car lot");
			Printers.invalid("input");
			return carCustomerMenu(A);
		}
			
	}
	
	// ----------------------------------------------- Employee menu -----------------------------------------------
	
	public String carEmployeeMenu(Scanner A) {
		logger.info("Entered the car lot as an employee");
		
		Printers.blankPrinter();
		System.out.println("---------------------------- Carlo's Current Car Collection ----------------------------");
		List<Car> tempList = cc.findAll();
		if(tempList.size()==0) { System.out.println("There are currently no cars on the lot.\n"); }
		for(Car s : tempList)
			System.out.println(s);
		System.out.println("\n1) Add Car");
		System.out.println("2) Remove Car");
		System.out.println("3) Update Car");
		System.out.println("4) View, accept, and reject offers");
		System.out.println("5) View payments");
		System.out.println("Type \"exit\" to return to main menu.\n");
		
		// Gather user input
		System.out.print("Input: ");
		String selection = A.next();
		switch (selection.toUpperCase()) {
		case "1":	// Add car
			createCar(A);
			return carEmployeeMenu(A);
		case "2":	// Remove car
			deleteCar(A);
			return carEmployeeMenu(A);
		case "3":	// Update car
			updateCar(A, tempList);
			return carEmployeeMenu(A);
		case "4":	// View offers, submenus for approving/rejecting an offer
			mm.viewOfferMenu(A);
			return carEmployeeMenu(A);
		case "5":	// View payments
			viewAllPayments(A);
			return carEmployeeMenu(A);
		case "EXIT":
			logger.info("Employee left car lot");
			return "";
		default:		// If fell user through, bad input and retry
			logger.info("Invalid input at car lot");
			Printers.invalid("input");
			return carEmployeeMenu(A);
		}

	}
	
	// ----------------------------------------------------- Create new car -----------------------------------------------------

	public String createCar(Scanner A) {
		logger.info("Employee is creating a car...");
		
		System.out.println("Please input car details, type \"exit\" to leave at any time.");
		System.out.print("Enter the make of the car: ");
		String tempMake = A.next();
		if(tempMake.toUpperCase().equals("EXIT")) {
			logger.info("Employee exitted at car make input.");
			return "";
			}
		System.out.print("Enter the model of the car: ");
		String tempModel = A.next();
		if(tempModel.toUpperCase().equals("EXIT")) {
			logger.info("Employee exitted at car model input.");
			return "";
			}
		System.out.print("Enter the year of the car: ");
		int tempYear = 0;
		try { tempYear = Integer.parseInt(A.next());}
		catch(NumberFormatException e) {
			logger.error("Employee entered a string in a number field");
			Printers.invalid("number");
			return "";
			}
		System.out.print("Enter the color of the car: ");
		String tempColor = A.next();
		if(tempColor.toUpperCase().equals("EXIT")) {
			logger.info("Employee exitted at car color input.");
			return "";
			}
		System.out.print("Enter the condition of the car: ");
		String tempSize = A.next();
		if(tempSize.toUpperCase().equals("EXIT")) {
			logger.info("Employee exitted at car condition input.");
			return "";
			}
		
		Printers.validInput();
		return cc.insert(new Car(tempMake, tempModel, tempYear, tempColor, tempSize));
	}
	
	// ----------------------------------------------------- Update a car -----------------------------------------------------

	public String updateCar(Scanner A, List<Car> L) {
		logger.info("Employee is updating a car...");
		
		System.out.println("Please select the car you wish to update, or type \"exit\" to cancel.");
		System.out.print("Car #");
		String tempID = A.next();
		if(tempID.toUpperCase().equals("EXIT")) {
			logger.info("Employee exitted at car ID selection.");
			return "";
			}
		int tempIDInteger = 0;
		try { tempIDInteger = Integer.parseInt(tempID);}
		catch(NumberFormatException e) {
			logger.error("Employee entered a string in a number field");
			Printers.invalid("number");
			return "";
			}
		
		Car tempCar = new Car();
		
		Printers.loading("search");
		
		// Check to see if ID exists
		for(int i = 0; i < L.size(); i++) {
			if(tempIDInteger==L.get(i).getID()) {	// ID Found
				tempCar = L.get(i);
				break;
			}
		}
		
		if(tempCar.getID()==-1) {		// Car not found
			logger.info("Car not found.");
			Printers.invalid("record");
			return "";
		} else {				// Car found, continue
			logger.info("Car was found.");
			Printers.validInput();
		}

		// Enter actual update menu
		carUpdater(A, tempCar);
		
		return "";
		
	}
		
	// ----------------------------------------------------- Actual update screen -----------------------------------------------------
		
	public String carUpdater(Scanner A, Car c) {
		logger.info("Employee is updating a car...");
	
		Printers.blankPrinter();
		System.out.println("Car info: "+c);
		System.out.println("\nWhat would you like to change? (Type \"exit\" to cancel changes)");
		System.out.println("1) Make");
		System.out.println("2) Model");
		System.out.println("3) Year");
		System.out.println("4) Color");
		System.out.println("5) Condition");
		System.out.println("6) Submit update\n");
		
		// Gather user input
		System.out.print("Input: ");
		String selection = A.next();
		switch (selection.toUpperCase()) {
		case "1":
			System.out.print("Enter the make of the car: ");
			String tempMake = A.next();
			if(tempMake.toUpperCase().equals("EXIT")) {
				logger.info("Employee exitted at car make input.");
				return "";
				}
			c.setMake(tempMake);
			logger.info("Employee altered the car's make.");
			break;
		case "2":
			System.out.print("Enter the model of the car: ");
			String tempModel = A.next();
			if(tempModel.toUpperCase().equals("EXIT")) {
				logger.info("Employee exitted at car model input.");
				return "";
				}
			c.setModel(tempModel);
			logger.info("Employee altered the car's model.");
			break;
		case "3":
			System.out.print("Enter the year of the car: ");
			int tempYear = 0;
			try { tempYear = Integer.parseInt(A.next());}
			catch(NumberFormatException e) {
				logger.error("Employee entered a string in a number field");
				Printers.invalid("number");
				return carUpdater(A, c);
				}
			c.setYear(tempYear);
			logger.info("Employee altered the car's year.");
			break;
		case "4":
			System.out.print("Enter the color of the car: ");
			String tempColor = A.next();
			if(tempColor.toUpperCase().equals("EXIT")) {
				logger.info("Employee exitted at car color input.");
				return "";
				}
			c.setColor(tempColor);
			logger.info("Employee altered the car's color.");
			break;
		case "5":
			System.out.print("Enter the condition of the car: ");
			String tempSize = A.next();
			if(tempSize.toUpperCase().equals("EXIT")) {
				logger.info("Employee exitted at car condition input.");
				return "";
				}
			c.setSize(tempSize);
			logger.info("Employee altered the car's condition.");
			break;
		case "6":
			int updated = cc.update(c);
			Printers.loading("update");
			if(updated>=1) {
				logger.info("Employee committed changes on car #"+c.getID());
				Printers.validInput();
			} else {
				logger.info("Car update somehow failed.");
				Printers.invalid("input");
			}
			return "";
		case "EXIT":
			logger.info("Employee left while editing car. Changes not saved.");
			return "";
		default:		// If fell user through, bad input and retry
			logger.info("Invalid input, returning to beginning of updater.");
			Printers.invalid("input");
			return carUpdater(A, c);
		}
		
		return carUpdater(A, c);
		
	}
	
	// ----------------------------------------------------- Delete car -----------------------------------------------------
	
	private String deleteCar(Scanner A) {
		logger.info("Employee is deleting a car...");
		
		System.out.println("Please enter the number of the car that you wish to delete. Type \"exit\" to cancel.");
		System.out.print("Car number: ");
		String tempID = A.next();
		if(tempID.toUpperCase().equals("EXIT")) {return "";}	// Abandon changes if employee wants to exit
		int tempIDInteger;
		try { tempIDInteger = Integer.parseInt(tempID);}		// Otherwise turn into number and delete if actually a number
		catch(NumberFormatException e) {
			logger.error("Employee entered a string in a number field");
			Printers.invalid("number");
			Printers.blankPrinter();
			return deleteCar(A);
			}
		
		// Remove associated offers
		try {
			mc.callClearOffers(tempIDInteger); // This will certainly need to be fixed, but should work for the time being
		} catch (Exception e) {
			logger.error("An unforseen error occured, aborting");
			System.out.println("This shouldn't happen.");
			System.exit(0);
		}
		
		int check = cc.remove(tempIDInteger);		// Finally, try to remove the car
		if(check>=1) {	// Something was deleted
			logger.info("Employee deleted car with ID #"+tempID);
			Printers.loading("delete");
			Printers.validInput();
		} else {
			logger.info("Employee tried to delete a car that does not exist!");
			Printers.loading("search");
			Printers.invalid("record");
		}
		return "";

	}
	
	// ----------------------------------------------------- View owned cars -----------------------------------------------------
	
	private String viewOwnedCars(Scanner A) {
		logger.info("Customer is viewing their cars...");
		
		Printers.blankPrinter();
		System.out.println("------------------------------- Your cars -------------------------------");
		List<Car> tempListCar = cc.ownedCars(currentUser.getID());
		List<Offer> tempListOffer = mc.amountOwed(currentUser.getID());
		List<Offer> moneyMatcher = new ArrayList<Offer>();;
		for(int i = 0; i < tempListCar.size(); i++) {
			for(int j = 0; j < tempListCar.size();j++) {
				if(tempListCar.get(i).getID()==tempListOffer.get(j).getCarId()) {
					moneyMatcher.add(tempListOffer.get(j));
				}
			}
		}
		if(tempListCar.size()==0) { System.out.println("You currently don't own any cars! Go buy some!\n"); }
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.UP);
		
		for(int i = 0; i < tempListCar.size(); i++) {
			double d = ((1.23671*tempListOffer.get(i).getOfferAmount())/72);
			d = Double.parseDouble(df.format(d));
			if(tempListOffer.get(i).getOfferAmount()==0) {
				System.out.println("#"+moneyMatcher.get(i).getOfferId()+") A "+tempListCar.get(i).condensedDescription()+", which you've fully paid off!");
			} else {
				System.out.println("#"+moneyMatcher.get(i).getOfferId()+") A "+tempListCar.get(i).condensedDescription()+", in which you owe"+TextColors.RED_BOLD_BRIGHT+" $"+moneyMatcher.get(i).getOfferAmount()+TextColors.RESET+". This amount equates to "+TextColors.RED_BOLD_BRIGHT+"$"+d+TextColors.RESET+"/month*.");
			}
		}
		if(tempListCar.size()>0) { System.out.println("\n*Based on our standard 6 year 10% APR loan agreement.\n"); }
		System.out.println("\n1) Make a payment");
		System.out.println("Type \"exit\" to return to the lot.");	// The above loop might not be correct for cars/owed amounts
		
		// Gather user input
		System.out.print("Input: ");
		String input = A.next();
		if(input.toUpperCase().equals("EXIT")) {
			logger.info("Customer left their owned car menu.");
			return "";
			} else if (input.equals("1")) {
				mm.makePaymentMenu(A, tempListOffer);
				return viewOwnedCars(A);
			}
		
		logger.info("Invalid input.");
		Printers.invalid("input");
		return viewOwnedCars(A);
		
	}
	
	// ----------------------------------------------------- View all owed payments -----------------------------------------------------
	
	public String viewAllPayments(Scanner A) {
		logger.info("Employee is viewing all payments...");
		
		Printers.blankPrinter();
		System.out.println("------------------------- All payments owed -------------------------");
		List<Car> tempListCar = cc.findAllOwned();
		List<Offer> tempListOffer = mc.findAllOwed();
		if(tempListOffer.size()==0) { System.out.println("Everyone is all payed up!\n"); }
		for(int i = 0; i < tempListCar.size(); i++)
			System.out.println("Customer #"+tempListOffer.get(i).getCustomerId()+" owes $"+tempListOffer.get(i).getOfferAmount()+" on their "+tempListCar.get(i).condensedDescription()+".");
		System.out.println("\nType \"exit\" to return to the lot.");	// The above loop might not be correct for cars/owed amounts
		
		// Gather user input
		System.out.print("Input: ");
		String input = A.next();
		if(input.toUpperCase().equals("EXIT")) {
			logger.info("Employee left payment menu.");
			return "";
			}
		
		logger.info("Invalid input.");
		Printers.invalid("input");
		return viewAllPayments(A);
		
	}

}
