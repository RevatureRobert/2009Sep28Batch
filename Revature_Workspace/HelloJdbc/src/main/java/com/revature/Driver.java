package com.revature;

import java.util.Scanner;

import com.revature.ui.BearMenu;

public class Driver {
	private static BearMenu bm = new BearMenu();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		mainMenu(scan);
	}
	private static void mainMenu(Scanner scan) {
		System.out.println("welcome to the circus");
		System.out.println("what would you like information about?");
		System.out.println("1. Bears");
		System.out.println("0. Exit");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println(bm.BearMenu(scan));
			mainMenu(scan);
		case 0: 
			System.exit(0);
		default:
			System.out.println("Please select a valid option");
			mainMenu(scan);
			break;
		}
	}
}
