package com.cardealership.ui;

import java.util.List;
import java.util.Scanner;

import com.cardealership.model.Employee;
import com.cardealership.model.Offers;
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
		System.out.println("8: Logout");

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
			System.out.println("Enter the carId:");
			int viewOffersCarId = scan.nextInt();
			List<Offers> carOffers = ds.getOffers(viewOffersCarId);
			System.out.println();
			if(carOffers.size() == 0) {
				System.out.println("No offers on this car!");
			}
			else
				for(int i = 0; i<carOffers.size();i++) 
					System.out.println(carOffers.get(i).toString());

			System.out.println();
			System.out.println("\nPlease enter 0 to go back to the previous menu.");
			scan.next();
			EmployeeMenu(scan,t);		
		case 6:
			System.out.println("Enter the carId:");
			int acceptOfferCarId = scan.nextInt();
			System.out.println("Enter the userId of the offer you would like to accept:");
			int acceptOfferUserId = scan.nextInt();

			if(ds.acceptOffer(acceptOfferCarId, acceptOfferUserId)) {
				System.out.println("Offer Accepeted!");
			}
			else {
				System.out.println("Offer not accepted.");
			}
			System.out.println("\nPlease enter 0 to go back to the previous menu.");
			scan.next();
			EmployeeMenu(scan,t);
		case 7:
			System.out.println("Enter the carId:");
			int rejectOfferCarId = scan.nextInt();
			System.out.println("Enter the userId");
			int rejectOfferUserId = scan.nextInt();

			if(ds.rejectOffer(rejectOfferCarId, rejectOfferUserId)) {
				System.out.println("Offer deleted successfully");
			}
			else
				System.out.println("Car was not successfully deleted. Please double check your inputs.");
			System.out.println("\nPlease enter 0 to go back to the previous menu.");
			scan.next();
			EmployeeMenu(scan,t);
		case 9:
			System.out.println("Thanks for stopping by!");
			System.exit(1);
		}
	}
}
