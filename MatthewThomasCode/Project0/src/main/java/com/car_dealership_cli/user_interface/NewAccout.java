package com.car_dealership_cli.user_interface;

import java.util.Scanner;

import com.car_dealership_cli.dao.UserDAO;
import com.car_dealership_cli.model.Customer;
import com.car_dealership_cli.model.User;
import com.car_dealership_cli.user_interface.interfaces.Menu;

public class NewAccout implements Menu {
	Scanner input;
	boolean cont = false;
	Customer newCust = new Customer();
	User newUser = new User();
	UserDAO uD = new UserDAO();
	@Override
	public void open(Scanner a) {
		input = a;
		int i = 0;
		do{
			display(i);
			i++;
		}while(!cont);
		

	}

	@Override
	public void display() {
		System.out.println("Please pass in a parameter");

	}
	public void display(int a) {
		switch(a) {
		case 0:
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			break;
		case 1:
			System.out.println("Welcome to user creation.");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("Please enter your first name: ");
			newCust.setFirstName(input.next());
			System.out.print("\nPlease enter your last name: ");
			newCust.setLastName(input.next());
			break;
		case 2:
			System.out.print("\nPlease enter your email: ");
			newUser.setEmail(input.next());
			if (uD.findByEmail(newUser.getEmail()).getEmail() !=  null) {
				System.out.println("Email already in use. Please enter a different email or ask a SysAdmin for help.");
				display(2);
			}
			break;
		case 3:
			System.out.print("\nPlease enter your username: ");
			newUser.setUserName(input.next());
			if (uD.findByUsername(newUser.getUserName()).getUserName() != null){
				System.out.println(uD.findByUsername(newUser.getUserName()).getUserName());
				System.out.println("Username already in use. Please enter a different email or ask a SysAdmin for help.");
				display(3);
			}
			break;
		case 4:
			String inOne = "Password";
			String inTwo = "password";
			boolean error = false;
			do {
				if(error) {
					System.out.println("Please enter the same passowrd Twice.");
				}
				System.out.print("Please enter your password: ");
				inOne = input.next();
				System.out.print("Please enter your password again:");
				inTwo = input.next();
				if(!inOne.equals(inTwo)) {
					error = true;
				}
			}while(!inOne.equals(inTwo));
			newUser.setPassword(inOne);
			UserDAO ud = new UserDAO();
			ud.create(newUser);
			break;
		case 5:
			System.out.print("You're all done! Redirecting you to the main menu.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.print(".");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.print(".");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			break;	
		default:
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			cont = true;
		}
	}

	@Override
	public boolean select(String in) {
		
		return false;
	}

	@Override
	public void exit() {
		

	}

}
