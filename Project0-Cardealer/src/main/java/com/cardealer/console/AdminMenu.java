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
import com.cardealer.repo.AccountDao;
import com.cardealer.repo.CarDao;
import com.cardealer.repo.OfferDao;
import com.cardealer.repo.OwnedDao;
import com.cardealer.service.UtilityFunctions;

public class AdminMenu {
	Logger logger;
	Scanner sc;
	Account CurrentAccount;
	
	public AdminMenu(Logger logger, Scanner sc, Account a) {
		this.logger = logger;
		this.sc = sc;
		this.CurrentAccount = a;
	}
	
	private void addCar() {
		CarDao add = new CarDao(logger);
		
		System.out.print("Enter Car Manufacturer:  ");
		String maker = sc.nextLine();
		System.out.print("Enter Car Model:  ");
		String model = sc.nextLine();
		System.out.print("Enter Car Year:  ");
		String year = sc.nextLine();
		System.out.print("Enter Car Color:  ");
		String color = sc.nextLine();
		boolean mismatch = true;
		int value = 0;
		while(mismatch) {
			try {
				System.out.print("Enter Car Value:  ");
				value = sc.nextInt();
				mismatch = false;
			}catch (Exception e) {
				System.out.println("Not a Valid Integer...");
				sc.nextLine();
			}
		}
		sc.nextLine();
		add.create(new Car(maker, model, year, color, value));
	}
	
	private void editCar() {
		CarDao add = new CarDao(logger);
		System.out.println("Enter Car ID to edit:  ");
		int carID = UtilityFunctions.confirmINT(sc);
		sc.nextLine();
		if(!add.exists(carID)) {
			System.out.println("Car with matching ID not found...");
			return;
		}
		
		System.out.print("Enter Car Manufacturer:  ");
		String maker = sc.nextLine();
		System.out.print("Enter Car Model:  ");
		String model = sc.nextLine();
		System.out.print("Enter Car Year:  ");
		String year = sc.nextLine();
		System.out.print("Enter Car Color:  ");
		String color = sc.nextLine();
		boolean mismatch = true;
		int value = 0;
		while(mismatch) {
			try {
				System.out.print("Enter Car Value:  ");
				value = sc.nextInt();
				mismatch = false;
			}catch (Exception e) {
				System.out.println("Not a Valid Integer...");
				sc.nextLine();
			}
		}
		sc.nextLine();
		add.updateSettings(new Car(carID, maker, model, year, color, value));
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
			System.out.print("Enter Car ID to remove from the Lot or Q to quit:  ");
			input = sc.nextLine();
			try {
				int carID = Integer.parseInt(input);
				view.delete(carID);
			}catch (Exception e) {
				if(!input.toLowerCase().equals("q")) {
					System.out.println("Invalid input");
				}
			}
			
		}
	}
	
	public void acceptReject(int offerID) {
		OfferDao view = new OfferDao(logger);
		CarDao car = new CarDao(logger);
		OwnedDao owner = new OwnedDao(logger);
		String input = "z";
		while(!("ARQ".contains(input.toUpperCase()))) {
			System.out.print("Type A to accept, R to reject, or Q to quit:  ");
			input = sc.nextLine();
			if (input.toUpperCase().equals("A")) {
				Offer accepted = view.findById(offerID);
				//Delete all offers on car
				view.deleteByCarID(accepted.getCarID());
				//Update car on lot to owned
				car.update(accepted.getCarID());
				//Add to owned table
				owner.create(new Owned(accepted.getUserID(), accepted.getCarID(), accepted.getOfferTotal(), accepted.getOfferMonths()));
				System.out.println("Accepted Offer" + accepted.toString());
			}
			else if (input.toUpperCase().equals("R")) {
				view.delete(offerID);
			}
		}
	}
	
	public void viewOffers() {
		OfferDao view = new OfferDao(logger);
		List<Offer> offers = view.findAll();
		for(Offer o : offers) {
			System.out.println(o.toString());
		}
		String input = "";
		while (!input.toLowerCase().equals("q")) {
			System.out.print("Enter Offer ID to accept or reject or Q to quit:  ");
			input = sc.nextLine().strip();
			try {
				int offerID = Integer.parseInt(input);
				acceptReject(offerID);
				input = "q";
				
			}catch (Exception e) {
				if(!input.toLowerCase().equals("q")) {
					System.out.println("Invalid input");
				}
			}
			
		}
		
	}
	
	public void payments() {
		OwnedDao view = new OwnedDao(logger);
		List<Owned> owned = view.findAll();
		for(Owned o : owned) {
			System.out.println(o.toStringUser());
		}
	}
	public void promotedemote() {
		System.out.println("Enter a User ID to promote/demote to/from manager");
		String userGet = sc.nextLine();
		AccountDao view = new AccountDao(logger);
		if(view.exists(userGet)) {
			Account update = view.findById(userGet);
			if(update.isManager()) {
				System.out.println("Cannot demote another manager...");
				return;
			}
			else {
				view.update(update);
				if(update.isAdminPrivilages()) {
					System.out.println("Demoted " + update.getUserName());
				}
				else {
					System.out.println("Promoted " + update.getUserName());
				}
		
			}
		}
		else {
			System.out.println("Account not found...");
		}
	}
	
	public int adminMenu() throws IOException, SQLException {
			
			System.out.println("(1) View Lot");
			System.out.println("(2) Add Car to Lot");
			System.out.println("(3) Edit Car in Lot");
			System.out.println("(4) View Customers with Payment Plans");
			System.out.println("(5) View Offers");
			System.out.println("(6) View as Customer");
			System.out.println("(7) Quit");
			if (CurrentAccount.isManager()){
				System.out.println("(8) Edit Accounts");
			}
			String input = "0";
			while(("12345678").contains(input) == false) {
				System.out.print("Choose an option:  ");
				input = sc.nextLine();
			}


			
			// View Lot to remove
			if(input.equals("1")) {
				viewLot();
				return adminMenu();
			}
			
			//Add Car
			if(input.equals("2")) {
				addCar();
				return adminMenu();
			}
			//Edit car
			if(input.equals("3")) {
				editCar();
				return adminMenu();
			}
			//Customers
			if(input.equals("4")) {
				payments();
				return adminMenu();
			}
			// View Offers
			if(input.equals("5")) {
				viewOffers();
				return adminMenu();
			}
			//User
			if(input.equals("6")) {
				CustomerMenu asUser = new CustomerMenu(logger, sc, CurrentAccount);
				asUser.userMenu();
				return adminMenu();
			}
			if(input.equals("7")) {
				
				return -1;
			}
			if(input.equals("8")) {
				if (CurrentAccount.isManager()){
					promotedemote();
					return adminMenu();
				}
				else {
					return adminMenu();
				}
			}
			return -1;
		}
}
