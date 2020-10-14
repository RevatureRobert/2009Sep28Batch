package com.car_dealership_cli.user_interface;

import java.util.Scanner;


import com.car_dealership_cli.user_interface.interfaces.Menu;

public class CustomerMenu implements Menu {
	private Scanner input;
	private boolean cont = false;
	
	@Override
	public void open(Scanner a) {
		this.input = a;
		
		do {
			display();
			select(input.next());
		}while(!cont);
		

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\nPlease Select a Number");
		System.out.println("1: View Cars on the Lot");
		System.out.println("2: View Cars that I own");
		System.out.println("3: Exit");

	}

	@Override
	public boolean select(String in) {
		switch(in) {
		case "1":
			Menu om = new OfferMenu();
			om.open(input);
			break;
		case "2":
			Menu oc = new OwnedCars();
			oc.open(input);
			break;
		case "3":
			cont = true;
			break;
		default:
		return false;
		}
		return true;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}


}
