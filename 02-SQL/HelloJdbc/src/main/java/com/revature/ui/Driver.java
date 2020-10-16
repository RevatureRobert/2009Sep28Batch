package com.revature.ui;

import java.util.Scanner;

public class Driver {
	private static BearMenu bm = new BearMenu();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		mainMenu(scanner);
	}
	
	private static void mainMenu(Scanner scan) {
		System.out.println("Welcome to the circus");
		System.out.println("What would you like information about?");
		System.out.println("1. bears");
		System.out.println("2. circus");
		System.out.println("0. exit");
		
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println(bm.bearMenu(scan));
			mainMenu(scan);
			break;
		case 0:
			System.exit(0);
		default:
			System.out.println("Please choose a valid option");
			mainMenu(scan);
			break;
		}
	}
}
