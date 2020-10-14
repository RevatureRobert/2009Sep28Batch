package com.project0.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project0.models.Car;
import com.project0.models.Offer;
import com.project0.models.Payment;
import com.project0.service.CustomerService;

/*
 * a customer can:
 * 1. View cars you own
 * 		a. make a payment on a car
 * 2. View cars on the lot
 * 		a. make an offer
 * 3. View Remaining Payments
 * 4. Logout
 */

public class CustomerMenu {
	private static Scanner in;
	private static CustomerService serve;
	private static int id;
	private static String username;
	final static Logger log = Logger.getLogger("CustomerMenu.class");
	
	
	public CustomerMenu(Scanner in, String username) {
		serve = new CustomerService();
		CustomerMenu.in = in;
		CustomerMenu.username = username;
		CustomerMenu.id = serve.findId(username); 
	}
	
	public void start() {
		boolean one = false;
		do {
			try {
				System.out.println("Hello "+ username + ", welcome to the Customer Portal!");
				System.out.println("1. View my cars");
				System.out.println("2. View cars on the lot");
				System.out.println("3. View my remaining payments");
				System.out.println("4. Logout");
				int choice = in.nextInt();
				switch(choice) {
				case 1:
					//go to cars method
					System.out.println("Retrieving all your cars...");
					log.info("Getting user cars");
					myCars();
					break;
				case 2:
					//go to cars on lot method
					System.out.println("Retrieving the cars on the lot...");
					log.info("Getting cars on the lot");
					carLot();
					break;
				case 3:
					//go to payments method
					System.out.println("Retrieving your remaining payments...");
					log.info("Getting payments");
					myPayments();
					break;
				case 4:
					one = true;
					in.nextLine();
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				log.error("The input wasn't what was expected" +e);
				in.nextLine();
				System.out.println("Please enter either 1,2,3,or 4");	
			}
		} while(!one);
	}//end of start method
	
	
	//method to get this customer's cars
	public static void myCars() {
		List<Car> mine = serve.findMyCars(id);
		System.out.println("You have " + mine.size()+ " car(s):");
		for(Car x:mine) {
			System.out.println("CarId: " + x.getCarID() + "|| " + x.toString());
		}
		System.out.println("1. Go back to the Customer Portal");
 		boolean one = false;
		do {
			try {
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
				case 1:
					one = true;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				log.error("The input wasn't what was expected" +e);
				System.out.println("Invalid input, press 1 to back to the Customer Portal");
			}
		} while(!one);
	}//end of mycars method
	
	
	//method to get cars on the lot
	public static void carLot() {
		List<Car> lot = serve.getCarLot();
		ArrayList<Offer> offers = (ArrayList<Offer>) serve.getOffers();
		ArrayList<String> printableCarLot = printCarLot(lot,offers);
		boolean refresh = false;
 		boolean one = false;
		do {
			try {
				if(refresh) {
					lot = serve.getCarLot();
					offers = (ArrayList<Offer>) serve.getOffers();
					printableCarLot = printCarLot(lot,offers);
					refresh= false;
				}
				for(String str:printableCarLot) {
					System.out.println(str);
				}
				System.out.println("1. Make an offer on a car");
				System.out.println("2. Go back to the Customer Portal");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
				case 1:
					log.info("Went to make an offer");
					refresh = makeOffer(printableCarLot);
					break;
				case 2:
					one = true;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				log.error("The input wasn't what was expected" +e);
				System.out.println("Invalid input, choose from the following options:");
			}
		} while(!one);
	}//end of carlot method
	
	//making an offer an a car
	public static boolean makeOffer(ArrayList<String> toPrint) {
		HashMap<Integer, Offer> myOffers = serve.getMyOffers(id);
		ArrayList<Integer> carIds = serve.getCarLotIDs();
		boolean changed = false;
		boolean one = false;
		do {
			try {
				//reprint the carlot
				for(String x: toPrint) {
					System.out.println(x);
				}
				System.out.println("Enter the CarID of the car you'd like to make an offer on.");
				int theId = in.nextInt();
				in.nextLine();
				if(carIds.contains(theId)) {
					boolean two = false;
					while(!two) {
						try {
							System.out.println("How much would you like to offer on CarID: " + theId+ "?");
							double amount = in.nextDouble();
							in.nextLine();
							//if customer doesn't have an offer for this car
							if(myOffers.get(theId) == null) {
								log.info("User made a completely new offer");
								Offer newO = new Offer(0,id,theId,amount);
								serve.makeNewOffer(newO);
							} else {
								log.info("User updated their offer");
								serve.updateOffer(myOffers.get(theId));
							}
							one =true;
							two = true;
							changed = true;
							System.out.println("You made an offer!");
							System.out.println("Taking you back to the car lot...");
						}catch(InputMismatchException e) {
							log.error("The input wasn't what was expected" +e);
							System.out.println("That's an invalid amount.");
						}
					}//end of while(entered)
					
				}else { // the carId is invalid
					boolean two = false;
					while(!two) {
						System.out.println("You can't make an offer on that CarID");
						try {
							System.out.println("1. Choose a different car");
							System.out.println("2. Go back to the welcome portal");
							int choice = in.nextInt();
							in.nextLine();
							switch(choice) {
							case 1:
								two = true;
								break;
							case 2:
								two = true;
								one = true;
								break;
							default:
								throw new InputMismatchException();	
							}
							
						} catch (InputMismatchException e) {
							log.error("The input wasn't what was expected" +e);
							System.out.println("Didn't recognize that input, please pick from the following options");
							
						}
					}
				}
				
			} catch (InputMismatchException e) {
				System.out.println("That CarID doesn't exist, please choose an existing CarID");
			}
		}while(!one);
		return changed;
	}// end of makeOffer method
	
	
	//method to see remaining payments
	
	public static void myPayments() {
		HashMap<Integer,Payment> payments = serve.findMyPayments(id);
		List<Car> cars = serve.findMyCars(id);
		ArrayList<String> toPrint = printablePayments(payments,cars);
		//this will print out your cars
		boolean refresh = false;
 		boolean one = false;
		do {
			try {
				if(refresh) {
					payments = serve.findMyPayments(id);
					cars = serve.findMyCars(id);
					toPrint = printablePayments(payments,cars);
					refresh = false;
				}
				for(String x:toPrint) {
					System.out.println(x);
				}
				System.out.println("1. Make a payment on a car");
				System.out.println("2. Go back to the Customer Portal");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
				case 1:
					one = true;
					//make a payment method
					log.info("Went to make a payment");
					refresh = makePayment(toPrint,payments);
					break;
				case 2:
					one = true;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				log.error("The input wasn't what was expected" +e);
				System.out.println("Invalid input, please choose from the following options:");
			}
		} while(!one);
	}//end of mypayments method
	
	//method to make a payment
	public static boolean makePayment(ArrayList<String> toPrint,HashMap<Integer,Payment> mine) {
		boolean changed = false;
		boolean one = false;
		do {
			try {
				//this prints out your cars again
				for(String x:toPrint) {
					System.out.println(x);
				}
				System.out.println("Enter the CarID of the loan you'd like to make a payment on.");
				int theId = in.nextInt();
				in.nextLine();
				if(mine.containsKey(theId)) {
					boolean two = false;
					while(!two) {
						try {
							System.out.println("How many months of payment would you like to make?");
							int months = in.nextInt();
							in.nextLine();
							Payment abc = mine.get(theId);
							log.info("Tried to make a payment on " + abc.getCarId());
							abc = serve.makePayment(abc,months);
							//serve.makePayment prints a statement about the payment
							System.out.println("Taking you back to your payments...");
							two =true;
							one = true;
							changed = true;
						} catch(InputMismatchException e) {
							log.error("The input wasn't what was expected" +e);
							System.out.println("Please enter a number for the number of months.");
						}
					}//end of while(two) 
					
				} else {
					boolean two = false;
					while(!two) {
						System.out.println("You can't make a payment on that car");
						try {
							System.out.println("1. Choose a different car");
							System.out.println("2. Go back to the welcome portal");
							int choice = in.nextInt();
							in.nextLine();
							switch(choice) {
							case 1:
								two = true;
								break;
							case 2:
								two = true;
								one = true;
								break;
							default:
								throw new InputMismatchException();	
							}
							
						} catch (InputMismatchException e) {
							log.error("The input wasn't what was expected" +e);
							System.out.println("Didn't recognize that input, please pick from the following options");
							
						}
					}
				}
				
			} catch (InputMismatchException e) {
				log.error("The input wasn't what was expected" +e);
				System.out.println("Didn't recognize that input, please enter a valid CarId");
			}
		}while(!one);
		return changed;
	}//end of makepayment method
	
	private static ArrayList<String> printCarLot(List<Car> lot, ArrayList<Offer> offers) {
		//this holds the println statements to repeat if the customer wants to go make an offer
		ArrayList<String> toPrint = new ArrayList<String>();
		toPrint.add("");
		toPrint.add("There are " + lot.size()+ " car(s) on the lot.");
		//for each car, print the car, the highest offer, and your offer
		for(Car x:lot) {
			toPrint.add("CarId: " + x.getCarID() + "|| " + x.toString() + " for " + NumberFormat.getCurrencyInstance().format(x.getPrice()));
			//get all offers for car x into specific
			ArrayList<Offer> specific = new ArrayList<Offer>();
			for(Offer y:offers) {
				if(y.getCarID() == x.getCarID()) {
					specific.add(y);
				}
			}
			
			//checks if there are offers
			if(specific.isEmpty()) {
				toPrint.add("       - There are no offers for this car yet.");
			} else {
				//finding the highest offer and the index of the highest offer and your offer
				Offer high = specific.get(0);
				Offer yours = null;
				//for loop starts at 1 so checking if 0 is your offer.
				if(specific.get(0).getPersonID() == id) {
					yours = specific.get(0);
				}
				for(int i = 1; i <specific.size();i++) {
					if(specific.get(i).getAmount() > high.getAmount()) {
						high = specific.get(i);
					}
					if(specific.get(i).getPersonID() == id) {
						yours = specific.get(i);
					}
				}
				toPrint.add("     - The highest offer is OfferID " + high.getOfferID() + "| " + NumberFormat.getCurrencyInstance().format(high.getAmount()));
				
				if(yours != null) {
					toPrint.add("     - Your offer is OfferID " + yours.getOfferID() + "| " + NumberFormat.getCurrencyInstance().format(yours.getAmount()));
				} else {
					toPrint.add("     - You have no offer on this car");
				}
			}//end of if else specific
		}
		toPrint.add("");
		return toPrint;
	}//end of printCarLot method
	
	private static ArrayList<String> printablePayments(HashMap<Integer,Payment> payments, List<Car> cars) {
		// TODO Auto-generated method stub
		//this will hold the print statements for your cars
		ArrayList<String> toPrint = new ArrayList<String>();
		toPrint.add("");
		toPrint.add("You have " + cars.size() + " payment(s):");
		for(Payment x:payments.values()) {
			for(Car y: cars) {
				if(x.getCarId() == y.getCarID()) {
					
					toPrint.add("CarID: " + y.getCarID() + "| "+y.toString() +". "+ x.toString());
					break;
				}
			}
		}
		toPrint.add("");
		return toPrint;
	}
	
}//end of class
