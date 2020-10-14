package com.cardealer.console;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cardealer.model.Account;
import com.cardealer.model.Car;
import com.cardealer.model.Offer;
import com.cardealer.model.Owned;
import com.cardealer.repo.CarDao;
import com.cardealer.repo.OfferDao;
import com.cardealer.repo.OwnedDao;
import com.cardealer.service.UtilityFunctions;

public class CustomerMenu {
	Logger logger;
	Scanner sc;
	Account CurrentAccount;
	
	public CustomerMenu(Logger logger, Scanner sc, Account a) {
		this.logger = logger;
		this.sc = sc;
		this.CurrentAccount = a;
	}
	
	private void viewLot() {
		CarDao view = new CarDao(logger);
		List<Car> lot = view.findAll();
		for (Car c : lot) {
			if(!c.isOwned()) {
				System.out.println(c.toString());
			}
		}
		String input = "";
		while (!input.toLowerCase().equals("q")) {
			System.out.print("Enter Car ID to make offers or Q to quit:  ");
			input = sc.nextLine();
			try {
				int carID = Integer.parseInt(input);
				makeOffer(carID);
				
			}catch (Exception e) {
				if(!input.toLowerCase().equals("q")) {
					System.out.println("Invalid input");
				}
			}
			
		}
	}
	
	public void viewOffers() {
		OfferDao view = new OfferDao(logger);
		List<Offer> offers = view.findAll(CurrentAccount.getUserName());
		for(Offer o : offers) {
			System.out.println(o.toString());
		}
		
	}
	public void makeOffer(int carID) {
		OfferDao offer = new OfferDao(logger);
		int total = 0;
		int months = 0;
		System.out.print("Enter the total you want to pay:  ");
		total = UtilityFunctions.confirmINT(sc);
		System.out.print("Enter how many months you want to pay over:  ");
		months = UtilityFunctions.confirmINT(sc);
		System.out.println("You would like to put in an offer for: ");
		System.out.println(new CarDao(logger).findById(carID));
		System.out.print("And would like to pay $" + total + " over " + months + " months. Type YES to confirm or anything else to cancel:  ");
		String confrim = sc.next();
		if(confrim.toLowerCase().equals("yes")) {
			offer.create(new Offer(0, CurrentAccount.getUserName(), carID, total, months));
			
		}
		sc.nextLine();
	
	
	}
	
	public void makePayment(int carID) {
		OwnedDao view = new OwnedDao(logger);
		List<Owned> owned = view.findUserOwned(CurrentAccount.getUserName());
		Owned pay = null;
		for (Owned o : owned) {
			if(o.getCarID() == carID) {
				pay = o;
			}
		}
		if(pay == null) {
			System.out.println("You do not own a car with this ID");
			return;
		}
		else {
			System.out.println("You currently owe: $" + pay.getPaymentLeft());
			System.out.println("You are making a payment of $" + pay.getPaymentMonthly());
			System.out.print("Type c to confrim:  ");
			String input = sc.nextLine();
			if(input.toLowerCase().equals("c")) {
				view.update(pay);
				System.out.println("Payment Made");
			}
			else {
				System.out.println("Canceling");
				return;
			}
		}
		
	}
	public void viewMyCars() {
		OwnedDao view = new OwnedDao(logger);
		List<Owned> owned = view.findUserOwned(CurrentAccount.getUserName());
		for (Owned o : owned) {
			System.out.println(o.toString());
		}
		
		String input = "";
		while (!input.toLowerCase().equals("q")) {
			System.out.print("Type the CarID to view more information about your car, P to make a payment, or Q to quit:  ");
			input = sc.nextLine();
			try {
				int carID = Integer.parseInt(input);
				if(view.exists(carID, CurrentAccount.getUserName())) {
					CarDao carView = new CarDao(logger);
					System.out.println(carView.findById(carID));
				}
				else {
					System.out.println("You do not own a car with this ID");
				}
				
			}catch (Exception e) {
				if(input.toLowerCase().equals("q")) {
					break;
				}else if (input.toLowerCase().equals("p")) {
					System.out.print("Enter Car ID to make payment on:  ");
					int carID = UtilityFunctions.confirmINT(sc);
					sc.nextLine();
					makePayment(carID);
				}
				else {
					System.out.println("Invalid input");
				}
			}
			
		}
		
	}
	public int userMenu() throws IOException, SQLException {
			
			System.out.flush();
			System.out.println("(1) View Lot");
			System.out.println("(2) View My Cars");
			System.out.println("(3) View My Offers");
			System.out.println("(4) Quit");
			
			String input = "0";
			
			while(("1234").contains(input) == false) {
				System.out.print("Choose an option:  ");
				input = sc.nextLine();
			}
			
			
			// View Lot
			if(input.equals("1")) {
				viewLot();
				return userMenu();
			}
			
			//View Owned Cars
			if(input.equals("2")) {
				viewMyCars();
				return userMenu();
			}
			//View Offers
			if(input.equals("3")) {
				viewOffers();
				return userMenu();
			}
			if(input.equals("4")) {
				
				return -1;
			}
			return -1;
		}
}
