package com.cardealer.service;

import java.util.Scanner;

public class UtilityFunctions {
	public static int confirmINT(Scanner sc) {
		while(!sc.hasNextInt()) { //prevents improper input
			System.out.println("Please input an integer.");
			sc.next();
		}
		return sc.nextInt();
	}
}
