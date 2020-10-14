package com.project.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project.controller.CarController;
import com.project.controller.MoneyController;
import com.project.model.Car;
import com.project.model.Offer;

public class MoneyMenu extends currentUser {
	
	final static Logger logger = Logger.getLogger(MoneyMenu.class);
	private MoneyController mc;
	private CarController cc;
	
	public MoneyMenu() {
		this(new MoneyController(), new CarController());
	}

	public MoneyMenu(MoneyController mc, CarController cc) {
		this.mc = mc;
		this.cc = cc;
	}
	
	// ----------------------------------------------- Make offer (customer) -----------------------------------------------
	
	public String makeOfferMenu(Scanner A, List<Car> L) {
		logger.info("Customer is making an offer...");
		
		System.out.println("Enter the number of the car you wish to make an offer on, type \"exit\" to cancel.");
		System.out.print("Car number: ");
		String tempCarId = A.next();
		if(tempCarId.toUpperCase().equals("EXIT")) {
			logger.info("Customer exitted at ID entry");
			return "";
			}
		System.out.print("Enter the offer amount: $");
		String tempOffer = A.next();
		if(tempOffer.toUpperCase().equals("EXIT")) {
			logger.info("Customer exitted at offer entry");
			return "";
			}
		
		// Convert both to integers, cancel if invalid
		int intCarId=0, intOffer=0;
		try {
			intCarId = Integer.parseInt(tempCarId);
			intOffer = Integer.parseInt(tempOffer);
			} catch(NumberFormatException e) {
				logger.error("Customer entered a string in a number field");
				Printers.invalid("number");
				return "";
			}
		
		Car tempCar = new Car();
		
		Printers.loading("offer");
		
		// Check to see if ID exists
		for(int i = 0; i < L.size(); i++) {
			if(intCarId==L.get(i).getID()) {	// ID Found
				tempCar = L.get(i);
				break;
			}
		}
		
		if(tempCar.getID()==-1) {		// Car not found
			logger.info("Car not found.");
			Printers.invalid("record");
			return "";
		} else {				// Car found, continue
			logger.info("Car was found.");
		}
		
		logger.info("Offer submitted by customer #"+currentUser.getID());
		Printers.validInput();
		return mc.insert(new Offer(currentUser.getID(), intCarId, intOffer));
	}
	
	// ----------------------------------------------- Make payments (customer) -----------------------------------------------
	
	public String makePaymentMenu(Scanner A, List<Offer> L) {
		logger.info("Customer is making a payment...");
		
		// Displays all payments owed, and will calculate how much customer needs to pay over 72 months
		// customer can also make a payment
		
//		 * (you owe xxx dollars on your car_name, which will cost you $xxx/month to pay off in 6 year with our 0% apr financing)
//		 * For now, I could use a function/procedure that just subtracts from the payment total. No idea where to store it for now
		
		System.out.println("Please enter the number associated with car you own. Type \"exit\" to cancel.");
		System.out.print("Car #");
		String tempID = A.next();
		if(tempID.toUpperCase().equals("EXIT")) {
			logger.info("Customer stopped making a payment.");
			return "";
			}	// Abandon changes if employee wants to exit
		int tempIDInteger;
		try { tempIDInteger = Integer.parseInt(tempID);}		// Otherwise turn into number and delete if actually a number
		catch(NumberFormatException e) {
			logger.error("Customer entered a string in a number field");
			Printers.invalid("number");
			return "";
			}
		
		System.out.println("\nEnter how much you would like to pay. Type \"exit\" to cancel.");
		System.out.print("I am paying $");
		String tempPayment = A.next();
		if(tempPayment.toUpperCase().equals("EXIT")) {
			logger.info("Customer stopped making a payment.");
			return "";
			}	// Abandon changes if employee wants to exit
		int tempPaymentInteger;
		try { tempPaymentInteger = Integer.parseInt(tempPayment);}		// Otherwise turn into number and delete if actually a number
		catch(NumberFormatException e) {
			logger.error("Customer entered a string in a number field");
			Printers.invalid("number");
			return "";
			}
		
		Offer tempOffer = new Offer();
		// Get associated offer
		for(Offer o : L) {
			if(o.getOfferId()==tempIDInteger) {
				logger.info("Offer found");
				tempOffer=o;
			}
		}
		
		// Check if offer was found
		if(tempOffer.getOfferId()==-1) {
			logger.info("Offer not found");
			return "";
		}
		
		// Check if payment is legal
		if(tempOffer.getOfferAmount()<tempPaymentInteger || tempPaymentInteger<1) {
			logger.info("Customer entered invalid payment.");
			Printers.invalid("payment");
			return "";
		}
		
		mc.makePayment(tempPaymentInteger,tempOffer.getOfferId());		// Finally, make payment. Should have no problems here
		logger.info("Payment successfully sent to DB.");
		Printers.loading("payment");
		Printers.validInput();
		return "";

	}
	
	// ----------------------------------------------- View offers (employee) -----------------------------------------------
	
	public String viewOfferMenu(Scanner A) {
		logger.info("Employee is viewing all offers...");
		
		Printers.blankPrinter();
		System.out.println("---------------------------- Customer offers ----------------------------");
		List<Offer> tempList = mc.findAll();
		if(tempList.size()==0) { System.out.println("There are currently no offers.\n"); }
		for(int i = 0; i < tempList.size(); i++)
			System.out.println(tempList.get(i));
		System.out.println("\n1) Approve an offer");
		System.out.println("2) Reject an offer");
		System.out.println("Type \"exit\" to cancel.\n");
		
		// Gather user input
		System.out.print("Input: ");
		String selection = A.next();
		switch (selection.toUpperCase()) {
		case "1":	// Approve offer
			acceptOffer(A, tempList);
			return viewOfferMenu(A);
		case "2":	// Reject offer
			rejectOffer(A);
			return viewOfferMenu(A);
		case "EXIT":
			logger.info("Employee left offer menu");
			return "";
		default:		// If fell user through, bad input and retry
			logger.info("Bad input");
			Printers.invalid("input");
			return viewOfferMenu(A);
		}
		
	}
	
	// ----------------------------------------------- Accept offers (employee) -----------------------------------------------
	
	public String acceptOffer(Scanner A, List<Offer> L) {
		logger.info("Employee plans on accepting offers...");
		
		System.out.println("Enter the number of the offer you wish to accept, type \"exit\" to cancel.");
		System.out.print("Enter number: ");
		String offer = A.next();
		if(offer.toUpperCase().equals("EXIT")) {
			logger.info("Employee exitted offer acceptance menu");
			return "";
			}		// Abandon changes if employee wants to exit
		int offerNum;
		try { offerNum = Integer.parseInt(offer);}
		catch(NumberFormatException e) {
			logger.error("Employee entered a string in a number field");
			Printers.invalid("number");
			return "";
			}
		
		// Check that the offer exists, otherwise the following commands would likely break down completely
		Offer chosenOffer = mc.findById(offerNum);
		if(chosenOffer==null) {
			logger.info("Employee searched for a record that does not exist");
			Printers.invalid("record");
			return "";
		}
		
		// Now that we know the record exists, we are safe to begin with the normal flow of commands,
		// since none of them should break now. We begin by assigning the user the car. The car
		// and user is stored in the offer already, so we take in the current list of offers as a param.
		// This change is reflected in the cust_id column in car in the database
		Car carWithOwner = new Car(chosenOffer.getCarId(),chosenOffer.getCustomerId());		// Needs the ID of the car and customer ID id from correct offer object
		if(cc.updateOwner(carWithOwner)==null) {
			logger.error("An unforseen error occured, aborting");
			System.out.println("You should absolutely never, ever have this fail.");
			System.exit(0);
		}
		
		// In the offer table, there's a column that identifies when an offer has been finalized. Once the offer
		// is accepted it is marked as "owed" so that a customer can see it and start paying it off.
		if(mc.offerBecomesOwed(chosenOffer)==null) {
			logger.error("An unforseen error occured, aborting");
			System.out.println("Again, this message should never show up.");
			System.exit(0);
		}
		
		// Now, delete every other offer on that car_id since the car is no longer available. Use the stored procedure! 
		try {
			mc.callClearOffers(chosenOffer.getCarId());
		} catch (Exception e) {
			logger.error("An unforseen error occured, aborting");
			System.out.println("This shouldn't happen.");
			System.exit(0);
		}
		
		logger.info("Employee accepted an offer");
		Printers.loading("offerAccept");
		Printers.validInput();	// It worked!
		return "";
		
	}
	
	// ----------------------------------------------- Reject offer (employee) -----------------------------------------------
	
	public String rejectOffer(Scanner A) {
		logger.info("Employee is rejecting an offer...");
		
		System.out.println("Please enter the number of the offer that you wish to reject. Type \"exit\" to cancel.");
		System.out.print("Offer number: ");
		String tempID = A.next();
		if(tempID.toUpperCase().equals("EXIT")) {
			logger.info("Employee left offer rejection menu");
			return "";
			}	// Abandon changes if employee wants to exit
		int tempIDInteger;
		try { tempIDInteger = Integer.parseInt(tempID);}		// Otherwise turn into number and delete if actually a number
		catch(NumberFormatException e) {
			logger.error("Employee entered a string in a number field");
			Printers.invalid("number");
			return viewOfferMenu(A);
			}
		
		mc.remove(tempIDInteger);		// Finally, try to remove the offer
		logger.info("Statement successfully passed to DB, no guarentee offer existed.");
		Printers.validInput();
		return "";

	}

}
