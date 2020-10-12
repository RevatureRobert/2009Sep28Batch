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
		System.out.println("welcome to the circus");
		System.out.println("what would you like information about?");
		System.out.println("1. bears");
		System.out.println("2. circus");
		System.out.println("0. exit");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println(bm.BearMenu(scan));
			mainMenu(scan);
			break;
		case 0:
			System.exit(0);
		case 2:
			cm.circusMenu(scan);
			mainMenu(scan);
			break;
		default:
			System.out.println("please choose a valid option");
			mainMenu(scan);
			break;
		}
	}
}
