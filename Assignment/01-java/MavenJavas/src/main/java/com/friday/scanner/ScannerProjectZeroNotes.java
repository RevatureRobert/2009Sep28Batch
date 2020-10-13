package com.friday.scanner;

import java.util.Scanner;

/*
 * Scanner
 * 
 * 
 * 		Scanner is meant to gather input from the console and files.
 * 
 * ***Once you close a scanner you can't use it again. 
 * 
 *  
 *  	Layers of project 0 
 *  	
 *  		UI
 *  			Gather input from the user
 *  			Display information to the user
 *  			Get actions from the user (like making an offer)
 *  			scanner goes here. 
 *  		Controller
 *  			Gather information from the UI
 *  			Use the data to communicate with service layer. (ie logging in, get user and pass from ui, and controller will call method from service)
 *  			sends information back to UI
 *  			Send information to the service layer
 *  		Service
 *  			Gather information from the repository
 *  			Use data to perform logic with the controller
 *  			Send information to the controller and to the repository layer
 *  		Repository
 * 				Gather information from service layer
 * 				Communicate with the database
 * 				send and gather information to/from the database
 * 
 * 					** everything above this is the data flow. passes data.
 * 						Model provides what the data looks like. 
 * 
 * 			Model
 * 				Provide classes meant to represent real world objects(cars, user)
 * 				determines the type of data passes around. 
 * 
 * register
 * take in from console to ui, send to controller, controller will create user model, to service layer. The service layer will provide whatever
 * logic needed, and then send to repository. Then the repository will send to database. this might go all the way back to provide confirmation 
 * to the user. 
 * 
 * 
 * solid design principles
 * 		Singular responsibility per layer
 * 		O
 * 		L
 * 		I
 * 		D
 * 
 * 
 * this lets you have a code separation, where if something goes wrong, you know where to look. 
 * 
 * 
 * 
 * 
 * 
 */

public class ScannerProjectZeroNotes {
	
	
	public static void main(String[] args) {
		//***Once you close a scanner you can't use it again. 
		Scanner scanner = new Scanner(System.in);
		getInformation(scanner);
		scanner.close();
		//System.out.println("The name you entered is: " + name);
		scanner.nextLine();
	} //end of main method
	
	static void getInformation(Scanner scanner) {
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		System.out.println("What is your preferred email address?");
		String email = scanner.nextLine();
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		ShareInformation(name, email,age);		
		
	}
	
	//imagine a controller class in another package
	
	static void ShareInformation(String name, String email, int age) {
		System.out.print("Your user has been created: ");
		System.out.println("Name: " + name + " Age: " + age + " Email: " + email);
	}
	
	
	
}// end of Scanner Example class
