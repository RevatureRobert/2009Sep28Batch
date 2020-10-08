package com.friday.scaner;

import java.util.Scanner;

/*
 * Scanner
 * 		Scanner is meant to gather input from the console and files.
 * 		Once a scanner is closed it cannot be reopened. No matter the circumstance.
 * 
 * 		Layers of project 0
 * 			UI
 * 				Gather input from the user
 * 				displayer information to the user
 * 				Get actions from the user
 * 			Controller
 * 				Gather information from the UI
 * 				Use the data to communicate with the service layer
 * 				Send information back to the UI
 * 				Send information to the Service layer
 *			Service
 *				Gather information from the Repository
 *				Use the data to perform logic with the controller
 *				Send information to the controller
 *				Send information to the Repository layer
 *			Repository
 *				Gather information from the service layer
 *				Communicate with the DB
 *				Send and gather information to/from the DB
 *		
 *			Model 
 *				Provide classes meant to represent real world objects
 *				
 * 
 * 		
 * */
public class ScannerExample {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		getInformation(scan);
		scan.close();
		
	}
	static void getInformation(Scanner scan) {
		System.out.println("what is your name");
		String name = scan.nextLine();
		System.out.println("what is your preferred email");
		String email = scan.nextLine();
		System.out.println("How old are you?");
		int age = scan.nextInt();
		ShaeInformation(name, email, age);
		
	}
	
//	imagine a controller class in another package below
	
	static void ShaeInformation(String name, String email, int age) {
		System.out.print("Your user has been created:");
		System.out.println("Name:" + name);
		System.out.println("Age:" + age);
		System.out.println("email:" + email);
		
	}
}
