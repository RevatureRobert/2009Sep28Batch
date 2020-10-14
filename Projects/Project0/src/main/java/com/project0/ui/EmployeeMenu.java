package com.project0.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.project0.enums.CarName;
import com.project0.models.Car;
import com.project0.models.Offer;
import com.project0.models.Payment;
import com.project0.service.EmployeeService;

/*
 * An employee can:
 * 1. add cars to the lot
 * 2. approve or reject an offer on a car
 * 3. remove a car from the lot
 * 4. view all payments
 */

public class EmployeeMenu {
	private static Scanner in;
	private static EmployeeService serve;
	private static String username;
	
	final static Logger log = Logger.getLogger("EmployeeMenu.class");
	public EmployeeMenu(Scanner in, String username) {
		serve = new EmployeeService();
		EmployeeMenu.in = in;
		EmployeeMenu.username = username;
	}
	
	public void start() {
		boolean chosen = false;
		do {
			try {
				System.out.println("Hello "+ username + ", welcome to the Employee Portal!");
				System.out.println("1. View cars on the lot");
				System.out.println("2. View all remaining payments");
				System.out.println("3. Logout");
				int choice = in.nextInt();
				switch(choice) {
				case 1:
					log.info("Going to retrieve cars on the lot");
					System.out.println("Retrieving all the cars on the lot...");
					carLot();
					break;
				case 2:
					log.info("Getting payments");
					System.out.println("Retrieving all payments...");
					//getpayment method****
					getPayments();
					break;
				case 3:
					chosen = true;
					in.nextLine();
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				log.error("The input wasn't what was expected" +e);
				in.nextLine();
				System.out.println("Please enter either 1,2 or 3.");	
			}
		} while(!chosen);
	}
	
	private void getPayments() {
		ArrayList<String> toPrint = printPayments();
		for(String x:toPrint) {
			System.out.println(x);
		}
		System.out.println("1. Go back to the Employee Portal");
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
				System.out.println("Invalid input, press 1 to back to the Employee Portal");
			}
		} while(!one);
	}//end of getPayments method
	
	//method to get cars on the lot
		public static void carLot() {
			List<Car> lot = serve.getCarLot();
			log.info("Got the cars on the lot");
			ArrayList<Offer> offers = (ArrayList<Offer>) serve.getOffers();
			log.info("Got the active offers");
			ArrayList<String> printableCarLot = printCarLot(lot,offers);
			boolean refresh = false;
	 		boolean chosen = false;
			do {
				try {
					//this checks if data has been updated
					if(refresh) {
						lot = serve.getCarLot();
						offers = (ArrayList<Offer>) serve.getOffers();
						printableCarLot = printCarLot(lot,offers);
						refresh = false;
					}
					for(String str:printableCarLot) {
						System.out.println(str);
					}
					System.out.println("1. Manage an offer");
					System.out.println("2. Manage the car lot");
					System.out.println("3. Go back to the Employee Portal");
					int a = in.nextInt();
					in.nextLine();
					switch(a) {
					case 1:
						//manage the offers
						refresh = manageOffers(offers);
						break;
					case 2:
						//manage the car lot
						refresh = manageCarLot(lot);
						break;
					case 3:
						chosen = true;
						break;
					default:
						throw new InputMismatchException();
					}
				} catch(InputMismatchException e) {
					log.error("The input wasn't what was expected" +e);
					System.out.println("Invalid input, choose from the following options:");
				}
			} while(!chosen);
		}//end of carlot method
		
		

		private static boolean manageCarLot(List<Car> lot) {
			HashMap<Integer,Car> carLot = new HashMap<Integer,Car>();
			for(Car x:lot) {
				carLot.put(x.getCarID(),x);
			}
//			ArrayList<String> toPrint = printCars(carLot);
//			for(String x: toPrint) {
//				System.out.println(x);
//			}
			boolean changed = false;
			boolean one = false;
			System.out.println("What changes would you like to make to the car lot?");
			do {
				try {
					System.out.println("1. Add a car");
					System.out.println("2. Remove a car");
					System.out.println("3. Cancel");
					int choice = in.nextInt();
					in.nextLine();
					switch(choice) {
					case 1:
						//method to add a car
						changed = addCar();
						one = true;
						break;
					case 2:
						//method to remove a car
						changed = removeCar(carLot);
						one = true;
						break;
					case 3:
						one = true;
						break;
					default:
						throw new InputMismatchException();
					}
					
				}catch(InputMismatchException e) {
					log.error("The input wasn't what was expected" +e);
					System.out.println("Invalid input, choose from the following options to change the car lot:");
				}
				
			}while(!one);
			
			return changed;
		}//end of manageCarLot method

		private static boolean removeCar(HashMap<Integer, Car> carLot) {
			boolean changed = false;
			boolean one = false;
			do {
				try {
					System.out.println("Enter the CarID of the car you'd like to remove.");
					ArrayList<String> p = printCars(carLot);
					for(String x:p) {
						System.out.println(x);
					}
					int choice = in.nextInt();
					in.nextLine();
					if(carLot.containsKey(choice)) {//valid input
						Car car = carLot.get(choice);
						System.out.println("Deleting the " + car.toString()+"...");
						serve.deleteCar(choice);
						System.out.println("You removed a " + car.toString() + " with CarID: "+choice+"!");
						changed = true;
						one = true;
					} else if(choice == 0) {
						one = true;
					} else {
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e) {
					log.error("The input wasn't what was expected" +e);
					System.out.println("That's not a valid car, choose from the following options:");
				}
			} while(!one);
			return changed;
		}//end of removeCar

		private static boolean addCar() {
			boolean changed = false;
			boolean one = false;
			do {
				try {
					System.out.println("Which car would you like to add?");
					System.out.println(CarName.printNames());
					System.out.println("Please enter the number of the car, or enter 0 to cancel");
					HashMap<Integer,CarName> names = CarName.map();
					int choice = in.nextInt();
					in.nextLine();
					if(names.containsKey(choice)) {//valid input
						CarName carname = names.get(choice);
						System.out.println("Adding the " + carname.readable() + "...");
						int abc = serve.addCar(carname);
						System.out.println("You added a " + carname.readable() + " with CarID: "+abc+"!");
						changed = true;
						one = true;
					} else if(choice == 0) {
						one = true;
					} else {
						throw new InputMismatchException();
					}
				}catch(InputMismatchException e) {
					log.error("The input wasn't what was expected" +e);
					System.out.println("That's not a valid car, choose from the following options:");
				}
			} while(!one);
			
			return changed;
		}//end of addCar method

		public static boolean manageOffers(ArrayList<Offer> offers) {
			boolean changed = false;
			//mapping the offerids and offers for easier access
			HashMap<Integer,Offer> offerMap = new HashMap<Integer,Offer>();
			for(Offer x: offers) {
				offerMap.put(x.getOfferID(), x);
			}
			boolean one = false;
			do {
				try {
					int oID = 0;
					System.out.println("Enter the Offer ID of the offer you'd like to manage.");
					oID = in.nextInt();
					in.nextLine();
					
					if(offerMap.containsKey(oID)) {//valid offerID
						boolean two = false;
						do {
							try {
								System.out.println("What would you like do to with Offer ID: " + oID );
								System.out.println("1. Approve the offer");
								System.out.println("2. Reject the offer");
								System.out.println("3. Cancel and go back to the car lot");
								int choice = in.nextInt();
								in.nextLine();
								switch(choice) {
								case 1:
									//method to approve offer
									System.out.println("Approving the offer...");
									serve.approveOffer(offerMap.get(oID));
									System.out.println("You approved the offer!");
									System.out.println("Taking you back to the car lot...");
									two = true;
									one = true;
									changed = true;
									break;
								case 2:
									//method to reject the offer
									System.out.println("Rejecting the offer...");
									serve.rejectOffer(offerMap.get(oID));
									System.out.println("You rejected the offer!");
									System.out.println("Taking you back to the car lot...");
									one = true;
									two = true;
									changed = true;
									break;
								case 3:
									//go back to car lot
									one = true;
									two = true;
									break;
								}
							}catch (InputMismatchException e) {
								log.error("The input wasn't what was expected" +e);
								System.out.println("Invalid input. Please pick from one of the following choices:");
							}
						}while(!two);
					} else {//invalid offerID
						//method for managing offers
						System.out.println("That OfferID is invalid.");
						boolean two = false;
						while(!two) {
							try{
								System.out.println("1. Try again");
								System.out.println("2. Go back to the car lot");
								switch(in.nextInt()) {
								case 1:
									two = true;
									break;
								case 2:
									one = true;
									two = true;
									break;
								default:
									throw new InputMismatchException();
								}
							} catch(InputMismatchException e) {
								log.error("The input wasn't what was expected" +e);
								System.out.println("Invalid input, pick from the following options:");
							}
							
						}//end of while(two)
					}//end of ifelse for offerID validation
					
					
				} catch(InputMismatchException e) {
					log.error("The input wasn't what was expected" +e);
					System.out.println("Invalid input, please input an integer;");
				}
			}while(!one);
			return changed;
		}//end of manageoffers method

		private static ArrayList<String> printCarLot(List<Car> lot, ArrayList<Offer> offers) {
			//this holds the println statements to repeat if the employee wants to manage the offers
			ArrayList<String> toPrint = new ArrayList<String>();
			toPrint.add("");
			toPrint.add("There are " + lot.size()+ " car(s) on the lot.");
			
			//this hashmap will hold all the offers for each carid
			HashMap<Integer,ArrayList<Offer>> myOffers = new HashMap<Integer,ArrayList<Offer>>();
			
			//for each car, print the car and each of the offers
			for(Car x:lot) {
				toPrint.add("CarId: " + x.getCarID() + "|| " + x.toString() + " for " + NumberFormat.getCurrencyInstance().format(x.getPrice()));
				
				//gathers all offers for car x
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
					//Ordering the offers
					ArrayList<Offer> ordered = new ArrayList<Offer>();
					while(specific.size() != 0) {
						int highIndex = 0;
						for(int i = 1;i<specific.size();i++) {
							if(specific.get(i).getAmount() > specific.get(i-1).getAmount()) {
								highIndex = i;
							}
						}
						ordered.add(specific.remove(highIndex));
					}
					
					for(Offer o:ordered) {
						toPrint.add("       - Offer ID " + o.getOfferID() + ": " +NumberFormat.getCurrencyInstance().format(o.getAmount()));
					}
				}
			}
			toPrint.add("");
			return toPrint;
		}//end of printableCarLot method
		
		private static ArrayList<String> printCars(HashMap<Integer, Car> carLot) {
			ArrayList<String> toPrint = new ArrayList<String>();
			toPrint.add("");
			for(Car x:carLot.values()) {
				toPrint.add("CarId: " + x.getCarID() + "|| " + x.toString() + " for " + NumberFormat.getCurrencyInstance().format(x.getPrice()));
			}
			toPrint.add("");
			return toPrint;
		}//end of printCars
		
		private static ArrayList<String> printPayments(){
			//Integer is userid for both here
			HashMap<Integer,ArrayList<Payment>> payments = serve.getPaymentMap();
			HashMap<Integer,ArrayList<Car>> cars = serve.getCarMap();
			ArrayList<String> toPrint = new ArrayList<String>();
			toPrint.add("");
			for(Integer x:payments.keySet()) {
				ArrayList<Payment> p = payments.get(x);
				toPrint.add("UserId " + x + " has " + p.size()+ " payment(s).");
				ArrayList<Car> a = cars.get(x);
				for(Payment y:payments.get(x)) {
					Car cc = null;
					for(Car c:a) {
						if(y.getCarId() == c.getCarID()) {
							cc = c;
							break;
						}
					}
					toPrint.add("   -CarID: " + cc.getCarID() + "| " + cc.toString()+ ". " + y.forEmployee());
				}
			}
			return toPrint;
			
		}//end of printPayments method
		
}//end of employeemenu class
