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
	
	public String CircusMenu(Scanner scan) {
		System.out.println("Please make a selection");
		System.out.println("2. create a circus");
		System.out.println("0. go back");
		int result = scan.nextInt();
		switch(result) {
		case 2:
			createCircus(scan);
		case 0:
			return null;
		default:
			System.out.println("please choose a valid option");
			return CircusMenu(scan);
		}
	}
	
	
	public String createCircus(Scanner scan) {
		System.out.println("What is the name of the circus?");
		String name = scan.nextLine();
		System.out.println("Who is the ringleader?");
		String leader = scan.nextLine();
		System.out.println("is it entertaining? true or false");
		boolean entertaining = scan.nextBoolean();
		
		return cc.insert(new Circus(name, leader, entertaining, null));
	}
}
