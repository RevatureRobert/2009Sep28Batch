package com.cars.ui;

import java.util.List;
import java.util.Scanner;

import com.cars.controller.OfferController;
import com.cars.controller.UserController;

public class ManagerUI {

	private static ManagerUI instance;
	private static OfferController oc = new OfferController();
	private static UserController uc = UserController.getInstance();
	
	private ManagerUI() {
		
	}

	public static ManagerUI getInstance() { //ensures there is only one manager menu instance
		if(instance == null) {
			instance = new ManagerUI();
		}
		return instance;
	}
	
	public static void managerMenu(Scanner scanner) { //allows the managers to add and remove employees, and to view offer transactions
		System.out.println(TextEffects.ANSI_BLUE+"Manager Options");
		System.out.println("1) Add employee");
		System.out.println("2) Remove employee");
		System.out.println("3) View all offer transactions");
		System.out.println("4) Return to main menu"+TextEffects.ANSI_GREEN);
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int selection = scanner.nextInt();
		
		switch(selection) {
			case 1:
				//add an employee
				System.out.println(TextEffects.ANSI_BLUE+"Please input the employee's username:"+TextEffects.ANSI_GREEN);
				String uName = scanner.next();
				System.out.println(TextEffects.ANSI_BLUE+"Please input the employee's password:"+TextEffects.ANSI_GREEN);
				String pass = scanner.next();
				
				System.out.print("\033[H\033[2J");
				System.out.flush(); //clears sensitive password information
				
				//check to make sure it is validated
				String ret = uc.registerControl(uName, pass, 2);
				System.out.println(TextEffects.ANSI_RED+ret);
				System.out.println("Returning to Manager Options");
				managerMenu(scanner);
				break;
			case 2:
				//remove an employee
				System.out.println(TextEffects.ANSI_BLUE+"Please input the employee's username:"+TextEffects.ANSI_GREEN);
				String empName = scanner.next();
				boolean isEmp = uc.checkEmpAsManager(empName);
				String ret2 = "";
				if(isEmp) {
					ret2 = uc.removeUserController(empName);
				} else {
					System.out.println(TextEffects.ANSI_RED+"The username provided does not match an employee account.");
				}
				System.out.println(TextEffects.ANSI_RED+ret2);
				System.out.println("Returning to Manager Options");
				managerMenu(scanner);
				break;
			case 3: //view all offer transactions
				System.out.println(TextEffects.ANSI_RED+"Here are all of the offers"+TextEffects.ANSI_BLUE);
				System.out.println("----------Offers----------");
				//returns all offers
				List<String> offers = oc.getAllOffersController();
				for(String s : offers) {
					System.out.println(s);
				}
				System.out.println("--------------------------");
				System.out.println(TextEffects.ANSI_RED+"Press enter to return to Manager Options"+TextEffects.ANSI_GREEN);
				
				scanner.nextLine();
				scanner.nextLine();
				
				managerMenu(scanner);
				break;
			case 4:
				//returns to main menu
				break;
			default: //any other integer input
				System.out.println(TextEffects.ANSI_RED+"Please input a valid option");
				managerMenu(scanner);
				break;
		}
	}
	
}
