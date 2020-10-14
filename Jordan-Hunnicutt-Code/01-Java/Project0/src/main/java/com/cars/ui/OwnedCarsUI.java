package com.cars.ui;

import java.util.List;
import java.util.Scanner;

import com.cars.controller.CarController;
import com.cars.controller.PaymentController;
import com.cars.controller.UserController;
import com.cars.model.Car;

public class OwnedCarsUI {
	
	private static OwnedCarsUI instance;
	private static UserController uc = UserController.getInstance();
	private static CarController cc = new CarController();
	private static PaymentController pc = new PaymentController();
	
	private OwnedCarsUI() {
		
	}

	public static OwnedCarsUI getInstance() { //ensures there is only one ownedcarsui instance
		if(instance == null) {
			instance = new OwnedCarsUI();
		}
		return instance;
	}
	
	
	public static void ownedCarsMenu(Scanner scanner) { //displays all the cars owned by the current user
		System.out.println(TextEffects.ANSI_BLUE+"These are the cars you own:");
		System.out.println("----------Cars----------");
		int user = uc.getUserIdController(uc.getCurrentUsername().substring(21));
		List<String> myCars = cc.ownedController(user);
		//list all the owned cars
		for(String s : myCars) {
			System.out.println(s);
		}		
		System.out.println("------------------------");
		System.out.println("Type a number to select an option:");
		System.out.println("1) View payments");
		System.out.println("2) Return to main menu");
		System.out.println("3) Employee Options"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1: //view payments
				carPaymentsMenu(scanner);
				break;
			case 2:
				//mainMenu(scanner);
				break;
			case 3: //employee options
				boolean isEmp = uc.checkEmp();
				if(isEmp) {
					employeePaymentMenu(scanner); //only allowed in if user is an employee or manager
				} else {
					System.out.println(TextEffects.ANSI_RED+"You must be an employee to access this menu.");
					ownedCarsMenu(scanner);
				}
				break;
			default: //any other integer input
				System.out.println(TextEffects.ANSI_RED+"Please type in a valid input.");
				ownedCarsMenu(scanner);
				break;
		}
		

	}
	
	public static void carPaymentsMenu(Scanner scanner) { //shows all of the payments for a user
		System.out.println(TextEffects.ANSI_BLUE+"Here are your payments: ");
		System.out.println("----------Payments----------");
		int userId = uc.getUserIdController(uc.getCurrentUsername().substring(21));
		List<String> payStrings = pc.getMyPaymentsController(userId);
		for(String s : payStrings) {
			System.out.println(TextEffects.ANSI_BLUE+s);
		}
		System.out.println("----------------------------");
		System.out.println("Type a number to select an option:");
		System.out.println("1) Make a payment");
		System.out.println("2) Return to owned cars menu");
		System.out.println("3) Return to main menu"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1: //make a payment
				//update table, subtract 1 from num_of in payments
				System.out.println(TextEffects.ANSI_BLUE+"Which car would you like to make a payment for? Type in the ID: "+TextEffects.ANSI_GREEN);
				while(!scanner.hasNextInt()) { //prevents improper input
					System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
					scanner.next();
				}
				int carId = scanner.nextInt();
				String ret = pc.makePaymentController(carId, userId);			
				System.out.println(TextEffects.ANSI_YELLOW+"\ud83d\udcc1"+TextEffects.ANSI_BLACK+"...."+TextEffects.ANSI_GREEN+"\u0d9e"+TextEffects.ANSI_BLACK+"...."+TextEffects.ANSI_YELLOW+"\ud83d\udcc1");     //ඞ is \u0d9e, 📁 is \ud83d\udcc1
				System.out.println(TextEffects.ANSI_RED+"Updating payment details...");
				try {
					Thread.sleep(2000);
				} catch(InterruptedException e) {
					//don't print anything
				}
				System.out.println(ret);
				if(ret.equals(TextEffects.ANSI_RED+"You successfully made a payment.")) {
					System.out.println("Task completed!");
					try {
						Thread.sleep(2000);
					} catch(InterruptedException e) {
						//don't print anything
					}
				}				
				System.out.println("Returning to Payment Menu");
				carPaymentsMenu(scanner);
				break;
			case 2: //return to owned cars menu
				ownedCarsMenu(scanner);
				break;
			case 3: //return to main menu
				//mainMenu(scanner);
				break;
			default: //any other integer input
				System.out.println(TextEffects.ANSI_RED+"Please input a valid option");
				carPaymentsMenu(scanner);
				break;
		}
		
	}
	
	public static void employeePaymentMenu(Scanner scanner) { //lets an employee view payments for every car
		System.out.println(TextEffects.ANSI_BLUE+"Employee Payment Options");
		System.out.println("1) View all payments for all cars");
		System.out.println("2) Back to owned cars");
		System.out.println("3) Back to main menu"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1: //view all payments for all cars
				
				System.out.println(TextEffects.ANSI_BLUE+"Here are all of the payments.");
				System.out.println("----------Payments----------");
				List<String> allPayments = pc.getAllPaymentsController();
				for(String s : allPayments) {
					System.out.println(s);
				}
				System.out.println("----------------------------");
				System.out.println("Press enter to go back to options");
				
				scanner.nextLine();
				scanner.nextLine();
				
				//String goBack = scanner.next();
				
				employeePaymentMenu(scanner);
				break;
			case 2: //back to owned cars
				ownedCarsMenu(scanner);
				break;
			case 3: //back to main menu
				//mainMenu(scanner);
				break;
			default: //any other integer input
				System.out.println(TextEffects.ANSI_RED+"Please input a valid option");
				employeePaymentMenu(scanner);
				break;
		}
	}
	
}
