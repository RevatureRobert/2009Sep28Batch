package com.project0;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project0.ui.CustomerMenu;
import com.project0.ui.EmployeeMenu;
import com.project0.ui.UserMenu;

public class dealershipDriver {
	private static Scanner in = new Scanner(System.in);
	private static UserMenu um = new UserMenu(in);
	private static CustomerMenu cm;
	private static EmployeeMenu em;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		mainMenu(in);
	}
	
	private static void mainMenu(Scanner in) {
		int choice = 0;
		boolean chosen = false;
		//loops until either 1 or 2 is input. 
		loop1: do {
			try {
				
				System.out.println("What can we help you with today?");
				System.out.println("1. Login");
				System.out.println("2. Register as a customer");
				System.out.println(("3. Quit"));
				choice = in.nextInt();
				switch(choice) {
				case 1:
					//login function
					//chosen = true;
					System.out.println("Taking you to login...");
					in.nextLine(); //clears the console
					String[] arr = um.enterLogin();
					switch(arr[0]) {
					case "c":
						//customer menu
						cm = new CustomerMenu(in,arr[1]);
						cm.start();
						break;
					case "e":
						//employee menu
						em = new EmployeeMenu(in,arr[1]);
						em.start();
						break;
					default:
						//default means its null, so the user wanted to come back
					}
					break;
				case 2:
					// register customer function
					// chosen = true;
					System.out.println("Taking you to register as a customer...");
					in.nextLine(); //clears the console
					um.register();
					break;
				case 3:
					//this will break out of the do while, and the program will go back 
					//to the display, where it will finish
					System.out.println("Goodbye!");
					break loop1;
				default:
					throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid input. Please choose either 1,2, or 3");
				in.nextLine(); //clears choice
			}
		} while(!chosen);
			
	}
	
	

}

//GRPNQZ5F4N
