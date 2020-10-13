package com.cardealership.ui;

import java.util.List;
import java.util.Scanner;

import com.cardealership.model.Customer;
import com.cardealership.model.Offers;
import com.cardealership.model.Sold_Car;
import com.cardealership.service.CustomerService;
import com.cardealership.service.DealershipService;

public class CustomerMenu {

	DealershipService ds = new DealershipService();
	CustomerService cs = new CustomerService();

	public CustomerMenu() {
		super();
	}
	public void CustomerMenu(Scanner scan, Customer t) {
		System.out.println("\nWelcome to the Customer menu!");
		System.out.println("Please select one of the following options:");
		System.out.println("1:  View Cars");
		System.out.println("2:  View amount owed");
		System.out.println("3:  View monthly payment");
		System.out.println("4:  Make a payment");
		System.out.println("5:  View my cars");
		System.out.println("6:  Make an offer on a car");
		System.out.println("7:  Remove an offer on a car");
		System.out.println("8:  View pending offers");
		System.out.println("9:  Calculate total monthly payments remaining");
		System.out.println("10: Log out");

		int input = scan.nextInt();
		switch(input) {
		case 1:
			System.out.println("Please select your dealership:");
			System.out.println("1: WeSellRealVirtualCars");
			int dealershipChoice = scan.nextInt();
			ds.viewCars(dealershipChoice);
			System.out.println("\nPlease enter 0 to go back to the previous menu.");
			int back = scan.nextInt();
			CustomerMenu(scan, t);
		case 2:
			System.out.println("You owe: $" + t.getBalance());
			CustomerMenu(scan,t);
		case 3:
			System.out.println("Your monthly payment is: $" + t.getMonthlyPayment());
			CustomerMenu(scan,t);
		case 4:

		case 5:
			List<Sold_Car> cars = cs.myCars(t.getUserId());
			if(cars!=null) {
				for(int i = 0; i<cars.size();i++) {
					System.out.println(cars.get(i).toString());
				}
			}
			else {
				System.out.println("Seems you don't have any cars. You should conisder making an offer!");
			}
			CustomerMenu(scan,t);
		case 6:
			System.out.println("Enter the id of the car you would like to make an offer on (-1 to go back):");
			int carId = scan.nextInt();
			System.out.println("Enter the amount you'd like to offer");
			int offerAmount = scan.nextInt();
			if(offerAmount == -1 || carId == -1 ) {
				System.out.println("No offer made");
				System.out.println("\nPlease enter 0 to go back to the customer menu:");
				scan.nextInt();
				CustomerMenu(scan, t);
			}
			else {
				System.out.println("Offer successfully placed!");
				System.out.println("\nPlease enter 0 to go back to the customer menu:");
				scan.nextInt();
				cs.makeOffer(carId, offerAmount, t);
				CustomerMenu(scan,t);
			}
		case 7:
			System.out.println("Enter the carId of the offer you would like to remove:");
			int removeOfferCarId = scan.nextInt();
			if(cs.removeOffer(removeOfferCarId, t)) {
				System.out.println("\nOffer removed successfully");
				System.out.println("\nPlease enter 0 to go back to the customer menu:");
				scan.nextInt();
				CustomerMenu(scan, t);
			}
			else {
				System.out.println("\nOffer was not successfully removed");
				System.out.println("\nPlease enter 0 to go back to the customer menu:");
				scan.nextInt();
				CustomerMenu(scan, t);
			}
			
		case 8:
			List<Offers> offers = cs.getOffers(t);
			if(offers.size()==0)
				System.out.println("You have no offers!");
			else
				for(int i = 0; i<offers.size();i++) 
					System.out.println(offers.get(i).toString());

			System.out.println("\nPlease enter 0 to go back to the customer menu:");
			scan.nextInt();
			CustomerMenu(scan, t);		
		case 9:	
			if(t.getMonthlyPayment() == 0) {
				System.out.println("\nYou don't have a monthly payment!\n");
				CustomerMenu(scan,t);
			}
			else {
				System.out.println("You have " + (t.getBalance()/t.getMonthlyPayment()) + " payments remaining.");
			}
		case 10:
			System.out.println("Thanks for stopping by!");
			System.exit(1);
		}
	}
}
