package com.friday.scanner;

import java.util.Scanner;

/*
 * Scanner
 * 
 * 		Scanner is meant to gather input from the console and files.
 * 
 * 
 * 		layers of project 0
 * 
 * 			UI
 * 				Gather input from the user
 * 				Display information to the user
 * 				Get actions from the user
 * 			Controller
 * 				Gather information from the UI
 * 				Use the data to communicate with the service layer
 * 				Send information back to the UI
 * 				Send information to the Service layer
 * 			Service
 * 				Gather information from the Repository
 * 				Use the data to perform logic with the controller
 * 				Send information to the controller
 * 				Send information to the repository layer
 * 			Repository
 * 				Gather information from the service layer
 * 				Communicate with the DB
 * 				send and gather information to/from the db
 * 
 * 			Model
 * 				Provide classes meant to represent real world objects
 * 
 */
public class ScannerExample {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("the name you entered is: "+name);
		GetInformation(scanner);
		scanner.close();
		
		// scanners cannot be opened once closed. no matter the circumstance inside the same program.
//		scanner = new Scanner(System.in);
//		scanner.next();
//		Scanner scanner2 = new Scanner(System.in);
//		System.out.println("get information");
//		scanner2.next();
	}
	
	static void GetInformation(Scanner scanner) {
		
		System.out.println("what is your name?");
		String name = scanner.nextLine();
		System.out.println("what is you preferred email address?");
		String email = scanner.nextLine();
		System.out.println("how old are you?");
		int age = scanner.nextInt();
		ShareInformation(name, email, age);
	}
	
	//imagine a controller class in another package below
	
	
	static void ShareInformation(String name, String email, int age) {
		System.out.print("Your user has been created: ");
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		System.out.println("email: "+email);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
