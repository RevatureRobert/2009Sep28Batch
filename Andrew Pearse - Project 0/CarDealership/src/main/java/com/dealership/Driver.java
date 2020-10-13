package com.dealership;

import java.util.Scanner;

import com.dealership.ui.DealershipUI;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DealershipUI ui = new DealershipUI();
		ui.startUp(scanner);
	}
	
}
