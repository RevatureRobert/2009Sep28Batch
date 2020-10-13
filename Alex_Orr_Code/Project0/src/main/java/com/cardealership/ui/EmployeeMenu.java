package com.cardealership.ui;

import java.util.Scanner;

import com.cardealership.model.Employee;
import com.cardealership.service.DealershipService;

public class EmployeeMenu {

	DealershipService ds;

	public EmployeeMenu() {
		super();
		ds = new DealershipService();
	}

	public void EmployeeMenu(Scanner scan, Employee t) {
		System.out.println("Welcome to the Employee menu!");
		System.out.println("Please select one of the following options:");
		System.out.println("1: View Cars");
		System.out.println("2: Add Car");
		System.out.println("3: Remove Car");
		System.out.println("4: Edit Existing Car");
		System.out.println("5: View offers on a car");
		System.out.println("6: Accept offer on a car");
		System.out.println("7: Reject off on a car");
		System.out.println("8: View all payments made");
		System.out.println("9: Logout");

		int input = scan.nextInt();
		switch(input) {
		case 1:
			ds.viewCars(t);
			System.out.println("\nPlease enter 0 to go back to the previous menu.");
			int back = scan.nextInt();
			if(back != -404) {
				EmployeeMenu(scan, t);
			}
		case 2:
			System.out.println("Enter the name of the car:");
			String carName = scan.nextLine();
			carName += scan.nextLine();
			System.out.println("Enter the asking price of the car:");
			int askingPrice = scan.nextInt();

			if(ds.addCar(t.getDealershipId(), carName, askingPrice)) {
				System.out.println("Car successfully added!");
				EmployeeMenu(scan, t);
			}
			else {
				System.out.println("Car could not be added successfully :(");
				EmployeeMenu(scan, t);
			}
		case 3:
			System.out.println("Please enter the car id or -1 to return to the previous menu:");
			int carIdDelete = scan.nextInt();
			if(carIdDelete==-1) {
				EmployeeMenu(scan, t);
			}
			else {
				if(ds.removeCar(carIdDelete)) {
					System.out.println("Car successfully removed.");
					EmployeeMenu(scan, t);
				}
				else {
					System.out.println("Car was not removed. Please make sure you have the correct car id.");
					EmployeeMenu(scan, t);
				}
			}
		case 4:
			System.out.println("Please enter the car id or -1 to return to the previous menu:");
			int carIdUpdate = scan.nextInt();
			if(carIdUpdate==-1) {
				EmployeeMenu(scan, t);
			}
			System.out.println("Please enter the cars updated name:");
			String caeNameUpdate = scan.nextLine();
			caeNameUpdate += scan.nextLine();
			System.out.println("Enter the asking price of the car:");
			int askingPriceUpdate = scan.nextInt();
			if(ds.updateCar(carIdUpdate, caeNameUpdate, askingPriceUpdate)) {
				System.out.println("Car successfully updated");
				EmployeeMenu(scan, t);
			}
			else {
				System.out.println("Car was not removed. Please make sure you have the correct car id.");
				EmployeeMenu(scan, t);
			}
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.println("Thanks for stopping by!");
			System.exit(1);
		}
	}
}
