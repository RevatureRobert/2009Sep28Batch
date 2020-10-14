package com.project0.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project0.dealershipDriver;
import com.project0.service.UserService;

import jdk.internal.org.jline.utils.Log;

public class UserMenu {
	private Scanner in;
	private UserService serve;
	final static Logger log = Logger.getLogger(dealershipDriver.class);
	
	
	public UserMenu(Scanner in) {
		serve = new UserService();
		this.in = in;
	}
	
	//login method
		public String[] enterLogin() {
			System.out.println("Login Page");
			String[] arr = new String[2];
			boolean loggedIn = false;
			loop1: do {
				System.out.println("Please enter your username: ");
				String user = in.nextLine();
				System.out.println("Please enter your password:");
				String pass = in.nextLine();
				System.out.println("Attempting to log in...");
				log.info("Attempted to log in using user|password : " + user + "|"+pass);
				int code = serve.checkLogin(user, pass);
				switch(code) {
				case 0:
					//0
					log.info("Successfully logged in as customer");
					System.out.println("You've logged in as a customer! Taking you to the Customer Portal...");
					loggedIn = true;
					arr[0] = "c";
					arr[1] = user;
					return arr;
					//0
				case 1:
					//0
					log.info("Successfully logged in as employee");
					System.out.println("You've logged in as an employee! Taking you to the Employee Portal...");
					loggedIn = true;
					arr[0] = "e";
					arr[1] = user;
					return arr;
					//0
				case 2:
					//0
					log.info("Unsuccessful log-in");
					System.out.println("Either your username or password was incorrect. Choose from the following:");
					boolean correct = false;
					do {
						//Give option to try login again or go back to the start
						System.out.println("1. Go back to the Welcome page");
						System.out.println("2. Try again");
						int x = in.nextInt();
						in.nextLine();
						switch(x) {
						case 1:
							System.out.println("\n");
							arr[0] ="back";
							return arr;
						case 2:
							correct = true;
							break;
						default:
							System.out.println("Invalid input. Please enter either 1 or 2.");
						}
					} while(!correct);
					break;
					//0
				default:
					log.error("Attempted to login and got a unpredictable code:" + code);
					System.out.println("Something went wrong");
				}
			} while(!loggedIn);
			return arr;
		}//end of login method
	
	//method to register
	public void register() {
		System.out.println();
		System.out.println("Registration");
		boolean registered = false;
		String username = null;
		do {
			//create a username first
			if(username == null) {
				//Get wanted username
				System.out.println("Please enter a new username:");
				username = in.nextLine();
				//if username isn't valid, start over
				System.out.println("Checking the username...");
				if(!serve.validUsername(username)) {
					System.out.println("That username already exists or you entered a blank line");
					username = null;
					continue;
				} else {
					System.out.println("That username is valid!");
				}
			} else { //create a password
				//get wanted password
				System.out.println("Please enter a new password:");
				String password = in.nextLine();
				//check if password is valid, or start over
				if(!serve.validPassword(password)) {
					System.out.println("The password cannot be blank");
					continue;
				} else {
					//registers the username and creates a user
					int c = serve.register(username, password); //returns number of rows affected
					switch(c) {
					case 0:
						log.error("Something went wrong and the register returned a weird number:" + c);
						break;
					case 1:
						System.out.println("You've registered successfully!");
						//send to main page, to choose to login or register someone else
						//don't need to call start method, automatically goes back to the start method. 
						//Registration is finished here
						registered = true;
						break;
					default: //this case should run if for some reason more than one row was affected
						log.warn("More than one row was affected during registration: " + c);
						System.out.println("more than 1 row was affected during registration");
					}
					
				}
			}
			
		} while (!registered);
	}// end of register method
	
}//end of UserMenu class
