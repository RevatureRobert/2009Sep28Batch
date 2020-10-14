package com.car_dealership_cli;


import java.util.Scanner;
import com.car_dealership_cli.user_interface.MainMenu;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		MainMenu mM = new MainMenu();
		mM.open(input);
		input.close();
		System.out.println("Closing Program.");
		
		
	}

}
