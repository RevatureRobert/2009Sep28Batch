package com.friday.scanner;

import java.util.Scanner;

/*
 * Scanner
 * 
 * 		Scanner is meant to gather input from the console and files.
 *
 * 		layers of project 0
 * 			UI
 * 				Gather input from the user
 * 				Display information to the user
 * 				Get actions from the user (I want to put an offer on a car)
 * 			Controller
 * 				Gather information from the UI
 * 				Use the data to communicate with service layer
 * 				Send information back to the UI
 * 				Send information to the Service layer
 * 			Service
 * 				Gather information from the Repository
 * 				Use the data to perform logic with the controller
 * 				Send information to the controller
 * 				Send information to the repository layer
 * 			Repository
 * 				Gather information from the service layer
 * 				Communicate with the database
 * 				send and gather information to/from the db
 * 
 * 			Model (accessible throughout) (what does the data look like? the other layers are about dataflow, this is about the actual data)
 * 				Provide classes meant to represent real world objects
 * 
 * Solid design principles:
 * 		these layers provide single responsibilities for each layer, no conflicts.
 * 		Each layer only communicates one layer deep.
 * 		Creates a code separation where it is much easier to debug
 * 
 * 
 */
public class ScannerExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		//you should either pass in a scanner, make it static, or whatever other way works
														//Scanner should remain in the UI layer.  The UI is the only thing using the scanner
		
		GetInformation(scanner);
		scanner.close(); //IF YOU CLOSE A SCANNER, YOU WILL NOT BE ABLE TO OPEN IT BACK UP, EVEN WITH A NEW INSTANCE. THIS EXTENDS PROGRAM WIDE
//		Scanner scanner2 = new Scanner(System.in);
//		System.out.println("get info");
//		scanner2.next();					//this will throw an exception
	}
	
	//This method is important for Project 0 as an example
	static void GetInformation(Scanner scanner) {
		
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		System.out.println("What is your preferred email address?");
		String email = scanner.nextLine();
		System.out.println("How old are you?");
		int age = scanner.nextInt(); //diferent scanner method
		ShareInformation(name, email, age);
		
	}
	
	//imagine a controller class in another package below
	
	static void ShareInformation(String name, String email, int age) {
		
		System.out.println("Your user has been created: ");
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("Age: "+age);
		
	}
	
	
}
