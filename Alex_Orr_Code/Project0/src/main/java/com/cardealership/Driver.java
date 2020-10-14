package com.cardealership;
import java.util.Scanner;
import com.cardealership.ui.*;

public class Driver {
	
	private static SignInMenu sim = new SignInMenu();
	private static SignUpMenu sum = new SignUpMenu();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		mainMenu(scan);
	}
	public static void mainMenu(Scanner scan) {
		System.out.println("Welcome to We Sell Real Virtual Cars!");
		System.out.println("Please select one of the following options:");
		System.out.println("1: Sign In");
		System.out.println("2: Sign Up");
		int selection = scan.nextInt();
		switch(selection){
		case 1:
			sim.SignInMenu(scan);
			break;
		case 2:
			sum.SignUpMenu(scan);
			break;
		}		
	}
}
