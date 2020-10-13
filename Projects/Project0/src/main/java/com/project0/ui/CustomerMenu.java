package com.project0.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
	
	
	public CustomerMenu(Scanner in, String username) {
		serve = new CustomerService();
		CustomerMenu.in = in;
		CustomerMenu.id = serve.findId(username); 
	}
	
	public void start() {
		boolean one = false;
		do {
			try {
				System.out.println("Welcome to the Customer Portal");
				System.out.println("1. View My Cars");
				System.out.println("2. View cars on the lot");
				System.out.println("3. View my remaining payments");
				System.out.println("4. Logout");
				int choice = in.nextInt();
				switch(choice) {
				case 1:
					//go to cars method
					System.out.println("Retrieving all your cars...");
					myCars();
					break;
				case 2:
					//go to cars on lot method
					System.out.println("Retrieving the cars on the lot...");
					carLot();
					break;
				case 3:
					//go to payments method
					System.out.println("Retrieving your remaining payments...");
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
				in.nextLine();
				System.out.println("Please enter either 1,2,3,or 4");	
			}
		} while(!one);
	}//end of start method
	
	
	//method to get this customer's cars
	public static void myCars() {
		List<Car> mine = serve.findMyCars(id);
		System.out.println("You have " + mine.size()+ " cars:");
		for(Car x:mine) {
			System.out.println("CarId: " + x.getCarID() + "|| " + x.toString());
		}
		System.out.println("Press 1 to go back to the Customer Portal");
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
				System.out.println("Invalid input, press 1 to back to the Customer Portal");
			}
		} while(!one);
	}//end of mycars method
	
	
	//method to get cars on the lot
	public static void carLot() {
		List<Car> lot = serve.getCarLot();
		ArrayList<Offer> offers = (ArrayList<Offer>) serve.getOffers();
		
		//this holds the println statements to repeat if the customer wants to go make an offer
		ArrayList<String> toPrint = new ArrayList<String>();
		toPrint.add("There are " + lot.size()+ " cars on the lot.");
		
		//this hashmap will hold my offers for each carid
		HashMap<Integer,Offer> myOffers = new HashMap<Integer,Offer>();
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
			toPrint.add("     - The highest offer is OfferID " + high.getOfferID() + ": " + NumberFormat.getCurrencyInstance().format(high.getAmount()));
			
			myOffers.put(x.getCarID(),yours);
			if(yours != null) {
				toPrint.add("     - Your offer is OfferID" + yours.getOfferID() + ": " + NumberFormat.getCurrencyInstance().format(yours.getAmount()));
			} else {
				toPrint.add("     - You have no offer on this car");
			}
		}
		for(String str:toPrint) {
			System.out.println(str);
		}
 		boolean one = false;
		do {
			try {
				System.out.println("Press 1 to make an offer on a car");
				System.out.println("Press 2 to go back to the Customer Portal");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
				case 1:
					//make offer method**********************************
					//System.out.println("making an offer");
					makeOffer(toPrint,myOffers);
				case 2:
					one = true;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid input, choose from the following options:");
			}
		} while(!one);
	}//end of carlot method
	
	//making an offer an a car
	public static void makeOffer(ArrayList<String> toPrint, HashMap<Integer, Offer> myOffers) {
		
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
				if(myOffers.containsKey(theId)) {
					boolean two = false;
					while(!two) {
						try {
							System.out.println("How much would you like to offer on CarID:" + theId);
							double amount = in.nextDouble();
							in.nextLine();
							//if customer doesn't have an offer for this car
							if(myOffers.get(theId) == null) {
								Offer newO = new Offer(0,id,theId,amount);
								serve.makeNewOffer(newO);
								two = true;
							} else {
								serve.updateOffer(myOffers.get(theId));
								two = true;
							}
						}catch(InputMismatchException e) {
							System.out.println("That's an invalid amount.");
						}
					}//end of while(entered)
					two = false;
					System.out.println("What would you like to do next?");
					while(!two) {
						try {
							System.out.println("1. Make another offer");
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
							System.out.println("Didn't recognize that input, please pick from the following options:");
						}
					}//end of while(chose)
					
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
							System.out.println("Didn't recognize that input, please pick from the following options");
							
						}
					}
				}
				
			} catch (InputMismatchException e) {
				System.out.println("That CarID doesn't exist, please choose an existing CarID");
			}
		}while(!one);
		
	}// end of makeOffer method
	
	
	//method to see remaining payments
	
	public static void myPayments() {
		List<Payment> payments = serve.findMyPayments(id);
		List<Car> cars = serve.findMyCars(id);
		HashMap<Integer,Payment> mine = new HashMap<Integer,Payment>();
		//this will hold the print statements for your cars
		ArrayList<String> toPrint = new ArrayList<String>();
		for(Payment x:payments) {
			for(Car y: cars) {
				if(x.getCarId() == y.getCarID()) {
					mine.put(y.getCarID(),x);
					toPrint.add("For your " + y.toString() + " with CarID: " + y.getCarID() + ", " + x.toString());
					break;
				}
			}
		}//end of foreach loop on 253
		//this will print out your cars
		for(String x:toPrint) {
			System.out.println(x);
		}
 		boolean one = false;
		do {
			try {
				System.out.println("Press 1 to make a payment on a car");
				System.out.println("Press 2 to go back to the Customer Portal");
				int a = in.nextInt();
				in.nextLine();
				switch(a) {
				case 1:
					one = true;
					//make a payment method
					makePayment(mine,toPrint);
					break;
				case 2:
					one = true;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch(InputMismatchException e) {
				System.out.println("Invalid input, please choose from the following options:");
			}
		} while(!one);
	}//end of mypayments method
	
	
	//method to make a payment
	public static void makePayment(HashMap<Integer,Payment> mine, ArrayList<String> toPrint) {
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
							abc = serve.makePayment(abc,months);
							two =true;
						} catch(InputMismatchException e) {
							System.out.println("Please enter a number for the number of months.");
						}
					}//end of while(entered) 
					two = false;
					System.out.println("What would you like to do next?");
					while(!two) {
						try {
							System.out.println("1. Make another payment");
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
							System.out.println("Didn't recognize that input, please pick from the following options:");
						}
					}//end of while(chose)
					
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
							System.out.println("Didn't recognize that input, please pick from the following options");
							
						}
					}
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Didn't recognize that input, please enter a valid CarId");
			}
		}while(!one);
	}//end of makepayment method
	
}//end of class
