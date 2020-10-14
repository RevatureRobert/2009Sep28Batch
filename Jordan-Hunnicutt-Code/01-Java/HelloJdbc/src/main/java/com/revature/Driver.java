package com.revature;

import java.util.Scanner;

import com.revature.ui.BearMenu;
import com.revature.ui.CircusMenu;

public class Driver {

	private static BearMenu bm = new BearMenu();
	private static CircusMenu cm = new CircusMenu();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		mainMenu(scanner);
	}
	
	private static void mainMenu(Scanner scan) {
		System.out.println("Welcome to the circus");
		System.out.println("What would you like information about?");
		System.out.println("1) Bears");
		System.out.println("2) Circus");
		System.out.println("0) Exit");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println(bm.BearMenu(scan));
			mainMenu(scan);
			break;
		case 0:
			System.exit(0);
		case 2:
			System.out.println(cm.circusMenu(scan));
			mainMenu(scan);
			break;
		default:
			System.out.println("Please input a valid option");
			mainMenu(scan);
			break;
		}
	}
	
}
