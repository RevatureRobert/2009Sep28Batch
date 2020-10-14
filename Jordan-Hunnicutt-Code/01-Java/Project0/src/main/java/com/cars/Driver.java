package com.cars;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cars.controller.UserController;
import com.cars.ui.LotUI;
import com.cars.ui.ManagerUI;
import com.cars.ui.OwnedCarsUI;
import com.cars.ui.RegisterAndLoginUI;
import com.cars.ui.TextEffects;

public class Driver {

	static LotUI lu = LotUI.getInstance();
	static OwnedCarsUI ocu = OwnedCarsUI.getInstance();
	static RegisterAndLoginUI ralu = RegisterAndLoginUI.getInstance();
	static ManagerUI mu = ManagerUI.getInstance();
	static UserController ctrl = UserController.getInstance();
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		logger.debug("App started"); //note, you have to use System.exit in order for the log file to update
		
		mainMenu(scanner);
	}
	
	public static void mainMenu(Scanner scanner) { //prints out the main menu
		System.out.println(TextEffects.ANSI_RED+"Welcome to the dealership!");
		System.out.println(ctrl.getCurrentUsername()); //if there is a user logged in, print their name here
		System.out.println(TextEffects.ANSI_BLUE+"Type a number to select an option:");
		
		System.out.println("1) View cars on the lot");
		System.out.println("2) View cars I own");
		System.out.println("3) Register for an account");
		System.out.println("4) Login to an account");
		System.out.println("5) Logout");
		System.out.println("6) Manager Options");
		System.out.println("7) Exit the application"+TextEffects.ANSI_GREEN);
		
		while(!scanner.hasNextInt()) { //prevents improper input
			System.out.println(TextEffects.ANSI_RED+"Please input an integer."+TextEffects.ANSI_GREEN);
			scanner.next();
		}
		int	selection = scanner.nextInt();

		
		
		switch(selection) {
			case 1: //view cars on the lot
				lu.lotMenu(scanner, 0);
				mainMenu(scanner);
				break;
			case 2:	//view cars I own
				String user = ctrl.getCurrentUsername(); //you have to be logged into an account to view cars
				if(user == "") {
					System.out.println(TextEffects.ANSI_RED+"You must be logged in to view this menu.");
				} else {
					ocu.ownedCarsMenu(scanner);
				}				
				mainMenu(scanner);
				break;
			case 3: //register for an account
				ralu.registerMenu(scanner);
				mainMenu(scanner);
				break;
			case 4: //login to an account
				ralu.loginMenu(scanner);
				mainMenu(scanner);
				break;
			case 5: //logout
				ctrl.logOut();
				System.out.println(TextEffects.ANSI_RED+"You have been successfully logged out.");
				mainMenu(scanner);
				break;
			case 6: //manager options
				boolean isManager = ctrl.checkManagerNoPassController();
				if(isManager) {
					mu.managerMenu(scanner);
				} else {
					System.out.println(TextEffects.ANSI_RED+"You must be a manager to access this menu.");
				}
				
				mainMenu(scanner);
				break;
			case 7: //exit the application
				System.exit(0);
				break;
			default: //any other integer
				System.out.println(TextEffects.ANSI_RED+"Please type in a valid input.");
				mainMenu(scanner);
				break;
		}
		
	}
	
}
