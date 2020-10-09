package com.friday.scanner;

import java.util.Scanner;

public class ScannerExample {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		GetInformation(scanner);
		scanner.close();
//		Scanner scanner2 = new Scanner(System.in);
//		scanner2.next();
		
	}
	
	static void GetInformation(Scanner scanner) {
		
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		System.out.println("What is you preferred email address?");
		String email = scanner.nextLine();
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		ShareInformation(name, email, age);
	}
	
	// Imagine a controller class in another package below
	
	static void ShareInformation(String name, String email, int age) {
			System.out.print("Your user has been created: ");
			System.out.println("name: "+name);
			System.out.println("Email: "+email);
			System.out.println("Age: "+age);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
