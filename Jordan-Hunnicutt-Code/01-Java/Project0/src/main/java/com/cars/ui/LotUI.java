package com.cars.ui;

import java.util.List;
import java.util.Scanner;

import com.cars.controller.CarController;
import com.cars.controller.OfferController;
import com.cars.controller.UserController;

public class LotUI {

	private static LotUI instance;
	
	private CarController cc = new CarController();
	private UserController uc = UserController.getInstance();
	private OfferController oc = new OfferController();
	
	private LotUI() {
		
	}

	public static LotUI getInstance() { //ensures there is only one lot instance
		if(instance == null) {
			instance = new LotUI();
		}
		return instance;
	}
	
	public void lotMenu(Scanner scanner, int i) { //initial lot menu, shows all the cars available for sale on the lot
		System.out.println(TextEffects.ANSI_BLUE+"These are the cars available on the lot:");
		List<String> results = cc.lotController(i); //start the chain to pull cars from the repo
		i = Integer.parseInt(results.get(3)); //here we get the page we're on of cars.
		
		System.out.println("---------Page  "+((i/7)+1)+"---------");		
		
		System.out.println(results.get(0));
		System.out.println(results.get(1));
		System.out.println(results.get(2));
		System.out.println("-----------------------");
		
		System.out.println("Type a number to select an option");
		System.out.println("1) View car offers");
		System.out.println("2) Go to the next page");
		System.out.println("3) Go to the previous page");
		System.out.println("4) Return to the previous menu");
		System.out.println("5) Employee Options"+TextEffects.ANSI_GREEN);		
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		
		switch(selection) { 
			case 1:	//view car offers
				String u = uc.getCurrentUsername();
				if(u == "") {
					System.out.println(TextEffects.ANSI_RED+"You must be logged in to view offers.");
					lotMenu(scanner, i);
					break;
				} else {
					carOffersMenu(scanner, i);
					break;
				}
			case 2: //go to the next page
				i = (i / 7) + 1;
				lotMenu(scanner, i);
				break;
			case 3: //go to the previous page
				i = (i / 7) - 1;
				lotMenu(scanner, i);
				break;
			case 4: //return to the previous menu
				//mainMenu(scanner);
				break;
			case 5: //employee options
				boolean b = uc.checkEmp();
				if(b) {
					employeeLotMenu(scanner);
				}else {
					System.out.println(TextEffects.ANSI_RED+"Only employees have access to this menu.");
					lotMenu(scanner, i);
				}				
				break;
			default: //if any other integer is input
				System.out.println(TextEffects.ANSI_RED+"Please type in a valid input.");
				lotMenu(scanner, i);
				break;
		}
	}
		
	public void carOffersMenu(Scanner scanner, int i) { //shows the offer details for a particular car
		System.out.println(TextEffects.ANSI_BLUE+"Here are the car details, and offers: ");
		List<String> result = cc.carOfferViewing(i); //gets all the offers for one car
			
		//get info from table
		System.out.println("--------Details--------");
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		System.out.println(result.get(2));
		System.out.println("--------Offers---------");
		System.out.println(result.get(3));
			
		System.out.println("Type a number to select an option:");
		System.out.println("1) Make offer");
		System.out.println("2) Employee options");
		System.out.println("3) Return to lot");
		System.out.println("4) Return to main menu"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		switch(selection) {
			case 1: //make offer
				String user = uc.getCurrentUsername();
				if(user == "") {
					System.out.println(TextEffects.ANSI_RED+"You must be logged into an account to make an offer.");
					carOffersMenu(scanner, i);
					break;
				}
				
				System.out.println(TextEffects.ANSI_BLUE+"What is your offer?"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int amount = scanner.nextInt();
				//send offer to table
				int id = Integer.parseInt(result.get(1).substring(4));
				String ret = oc.addNewOffer(amount, id, user);
				System.out.println(TextEffects.ANSI_RED+ret);
				System.out.println("Returning you to the car you were viewing...");
				carOffersMenu(scanner, i);
				break;
			case 2: //employee options
				boolean b = uc.checkEmp();
				if(b) {
					employeeOfferMenu(scanner, i);
				}else {
					System.out.println(TextEffects.ANSI_RED+"Only employees have access to this menu.");
					carOffersMenu(scanner, i);
				}	
				break;
			case 3: //return to lot
				lotMenu(scanner, i);
				break;
			case 4:
				//returns to main menu
				break;
			default: //when any other integer is input
				System.out.println("Please input a valid option");
				carOffersMenu(scanner, i);
				break;
		}
		}

	public void employeeOfferMenu(Scanner scanner, int i) { //shows the offers for a particular car to an employee

		System.out.println(TextEffects.ANSI_BLUE+"Welcome employee.");
		System.out.println("Here are the car details, and offers:");
		
		List<String> result = cc.carOfferEmpViewing(i);
		
		//get info from table
		System.out.println("--------Details--------");
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		System.out.println(result.get(2));
		System.out.println("--------Offers---------");
		System.out.println(result.get(3));
			
		System.out.println("Please select an option:");
		System.out.println("1) Accept offer");
		System.out.println("2) Reject Offer");
		System.out.println("3) Back to Lot");
		System.out.println("4) Back to Main Menu"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		switch(selection) {
			case 1: //accept offer
				//accept offer
				System.out.println(TextEffects.ANSI_BLUE+"Please type in the offer amount you want to accept."+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int amount = scanner.nextInt();
				System.out.println(TextEffects.ANSI_BLUE+"Please type in the ID number of the offeree"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int user = scanner.nextInt();
				//check matches
				//if true
				int id = Integer.parseInt(result.get(1).substring(4));
				String ret = oc.acceptOfferController(amount, id, user);
				System.out.println(TextEffects.ANSI_RED+ret);
				
				System.out.println("Returning to main menu.");
				break;
			case 2:
				//reject offer
				System.out.println(TextEffects.ANSI_BLUE+"Please type in the offer amount you want to reject."+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int rjamount = scanner.nextInt();
				System.out.println(TextEffects.ANSI_BLUE+"Please type in the ID number of the offeree"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int rjUser = scanner.nextInt();
				//check matches
				//if true
				int rjId = Integer.parseInt(result.get(1).substring(4));
				String rjRet = oc.rejectOfferController(rjamount, rjId, rjUser);
				System.out.println(TextEffects.ANSI_RED+rjRet);
				System.out.println("Returning to main menu");
				break;
			case 3: //back to lot
				lotMenu(scanner, i);
				break;
			case 4:
				//return to main menu
				break;
			default: //any other integer input
				System.out.println(TextEffects.ANSI_RED+"Please input a valid option");
				employeeOfferMenu(scanner, i);
				break;
		}
	}
	
	public void employeeLotMenu(Scanner scanner) { //allows employees to add, remove, or edit cars on the lot
		System.out.println(TextEffects.ANSI_BLUE+"Employee Lot Options");
		System.out.println("1) Add car");
		System.out.println("2) Remove car");
		System.out.println("3) Edit car");
		System.out.println("4) Back to lot");
		System.out.println("5) Back to main menu"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1: //add car
				System.out.println(TextEffects.ANSI_BLUE+"Please input car details.");
				System.out.println("What is the car's make? (Buick, Chevrolet, Ford, etc.)"+TextEffects.ANSI_GREEN);
				String make = scanner.next();
				System.out.println(TextEffects.ANSI_BLUE+"What is the car's model?"+TextEffects.ANSI_GREEN);
				String model = scanner.next();
				System.out.println(TextEffects.ANSI_BLUE+"What color is the car?"+TextEffects.ANSI_GREEN);
				String color = scanner.next();
				System.out.println(TextEffects.ANSI_BLUE+"What model year is the car?"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int year = scanner.nextInt();
				System.out.println(TextEffects.ANSI_BLUE+"What is the listing price of the car?"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int price = scanner.nextInt();
				String ret = cc.addCarController(make, model, color, year, price);
				System.out.println(TextEffects.ANSI_RED+ret);
				System.out.println("Returning to Employee Lot Options");
				employeeLotMenu(scanner);
				break;
			case 2: //remove car
				System.out.println(TextEffects.ANSI_BLUE+"Please input the ID of the car to remove"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int id = scanner.nextInt();
				String ret2 = cc.removeCarController(id);
				System.out.println(TextEffects.ANSI_RED+ret2);
				System.out.println("Returning to Employee Lot Options");
				employeeLotMenu(scanner);
				break;
			case 3: //edit car
				System.out.println(TextEffects.ANSI_BLUE+"Please input the ID of the car to edit"+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int id2 = scanner.nextInt();
				boolean ret3 = cc.editCarCheckController(id2);
				if(ret3) {
					employeeEditMenu(scanner, id2);
				} else {
					System.out.println(TextEffects.ANSI_RED+"Car is already owned, and cannot be edited.");
				}
				System.out.println("Returning to Employee Lot Options");
				employeeLotMenu(scanner);
				break;
			case 4: //back to lot
				lotMenu(scanner, 0);
				break;
			case 5:
				//go to main menu
				break;
			default: //any other integer input
				System.out.println(TextEffects.ANSI_RED+"Please input a valid option");
				employeeLotMenu(scanner);
				break;
		}
	}
	
	public void employeeEditMenu(Scanner scanner, int id) { //allows an employee to edit a car already on the lot
		System.out.println(TextEffects.ANSI_BLUE+"Please input car details.");
		System.out.println("What is the car's make? (Buick, Chevrolet, Ford, etc.)"+TextEffects.ANSI_GREEN);
		String make = scanner.next();
		System.out.println(TextEffects.ANSI_BLUE+"What is the car's model?"+TextEffects.ANSI_GREEN);
		String model = scanner.next();
		System.out.println(TextEffects.ANSI_BLUE+"What color is the car?"+TextEffects.ANSI_GREEN);
		String color = scanner.next();
		System.out.println(TextEffects.ANSI_BLUE+"What model year is the car?"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int year = scanner.nextInt();
		System.out.println(TextEffects.ANSI_BLUE+"What is the listing price of the car?"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int price = scanner.nextInt();
		String s = cc.editCarController(id, make, model, color, year, price);
		System.out.println(TextEffects.ANSI_RED+s);
	}
	
}	