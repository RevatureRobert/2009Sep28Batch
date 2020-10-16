package com.friday.scanner;

import java.util.Scanner;

/*
 * Scanner is meant to gather input from the console and from files.
 * 		^ important function is console inputting
 * 
 * 
 * Layers of project 0
 * 
 * 	Data Flow
 * 		UI
 * 			Gather input from the user
 * 			Display information to the user
 * 			Get actions from the user
 * 		Controller
 * 			Gather information from the UI
 * 			Use the data to communicate with the service layer
 * 			Send info back to the UI
 * 			Send info to the Service Layer
 * 		Service
 * 			Gather info from Repository
 * 			Use the data to perform logic with the controller
 * 			Send info to controller
 * 			Send info to repository layer
 * 		Repository
 * 			Gather info from the service layer
 * 			Communicate with the DB
 * 			Send & gather info to/from the DB
 * 			Store user information
 * 	Data
 * 		Model
 * 			Provide classes meant to represent real-world objects
 * 			POJOs
 * 
 * (not MVC / model-view-controller design pattern)
 */

public class ScannerExample {

	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//getInformation(scanner);
//		System.out.println("The name you entered is: " + name);
		//scanner.close();
		
		// Scanners cannot be reopened once closed inside the same program
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("get information");
		scanner2.next();
	}
	
	static void getInformation(Scanner scanner) {
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		System.out.println("What is your preferred email address?");
		String email = scanner.nextLine();
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		
		shareInformation(name, email, age);
	}
	
	// Imagine a controller class in another package below ...
	
	static void shareInformation(String name, String email, int age) {
		System.out.println("Your user has been created:");
		
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("email: " + email);
	}
}
