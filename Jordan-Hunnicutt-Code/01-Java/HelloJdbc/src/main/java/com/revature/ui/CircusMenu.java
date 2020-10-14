package com.revature.ui;

import java.util.Scanner;

import com.revature.controller.CircusController;
import com.revature.model.Circus;

public class CircusMenu {

	private CircusController cc;
	
	public CircusMenu() {
		this(new CircusController());
	}
	
	public CircusMenu(CircusController cc) {
		super();
		this.cc = cc;
	}
	
	public String circusMenu(Scanner scan) {
		System.out.println("What would you like to do?");
		System.out.println("2) Create a circus");
		System.out.println("0) Go back");
		int result = scan.nextInt();
		switch(result) {
			case 2:
				return createCircus(scan);
			case 0:
				return null;
			default:
				System.out.println("Please choose a valid option");
				return circusMenu(scan);
		}
	}
	
	public String createCircus(Scanner scan) {
		System.out.println("What is the name of the circus?");
		String name = scan.next();
		System.out.println("Who is the ringleader?");
		String leader = scan.next();
		System.out.println("Is it entertaining? true or false");
		boolean entertaining = scan.nextBoolean();
		return cc.insert(new Circus(name, leader, entertaining, null));
	}
	
}
