package com.car_dealership_cli.user_interface;

import java.util.Scanner;

import com.car_dealership_cli.user_interface.interfaces.Menu;


public class MainMenu implements Menu {

	Scanner input;

	boolean cont = false;
	@Override
	public void open(Scanner a) {
		// TODO Auto-generated method stub]
		this.input = a;
		do {
			
			display();
			select(input.next());
		}while (!cont);
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\nPlease Select a Number");
		System.out.println("\n1: User Login");
		System.out.println("2: Register for a New Account");
		System.out.println("3: View Current Inventory");
		System.out.println("4: Exit");
	}

	@Override
	public boolean select(String in) {
		switch(in) {
		case "1": 
			Menu userLogin = new UserLogin();
			userLogin.open(input);
			break;
		case "2":
			Menu newAccout = new NewAccout();
			newAccout.open(input);
			break;
		case"3":
			Menu viewInventory = new ViewInventory();
			viewInventory.open(input);
			break;
		case"4":
			exit();
			break;
		default:
			System.out.println("\nPlease enter a Valid numerical number. I.e. '1'");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\n\n\n\n\n\n\n\n");
			break;
		}
		return false;
	}

	@Override
	public void exit() {
		cont = true;

	}

}
