package com.project0.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.project0.models.Car;
import com.project0.models.Offer;
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
	private static int id;
	public EmployeeMenu(Scanner in, String username) {
		serve = new EmployeeService();
		EmployeeMenu.in = in;
		EmployeeMenu.id = serve.findId(username);
	}
	
	public void start() {
		boolean chosen = false;
		do {
			try {
				System.out.println("Welcome to the Employee Portal");
				System.out.println("1. View cars on the lot");
				System.out.println("2. View all remaining payments");
				System.out.println("3. Logout");
				int choice = in.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Retrieving all the cars on the lot...");
					carLot();
					break;
				case 2:
					System.out.println("Retrieving all payments");
					//getpayment method****
					break;
				case 3:
					chosen = true;
					in.nextLine();
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				in.nextLine();
				System.out.println("Please enter either 1,2 or 3.");	
			}
		} while(!chosen);
	}
	
	//method to get cars on the lot
		public static void carLot() {
			List<Car> lot = serve.getCarLot();
			ArrayList<Offer> offers = (ArrayList<Offer>) serve.getOffers();
			
			//this holds the println statements to repeat if the employee wants to manage the offers
			ArrayList<String> toPrint = new ArrayList<String>();
			toPrint.add("There are " + lot.size()+ " cars on the lot.");
			
			//this hashmap will hold all the offers for each carid
			HashMap<Integer,ArrayList<Offer>> myOffers = new HashMap<Integer,ArrayList<Offer>>();
			//for each car, print the car and each of the offers
			for(Car x:lot) {
				toPrint.add("CarId: " + x.getCarID() + "|| " + x.toString() + " for " + NumberFormat.getCurrencyInstance().format(x.getPrice()));
				//get all offers for car x into specific
				ArrayList<Offer> specific = new ArrayList<Offer>();
				for(Offer y:offers) {
					if(y.getCarID() == x.getCarID()) {
						specific.add(y);
					}
				}
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
	 		boolean chosen = false;
			do {
				try {
					for(String str:toPrint) {
						System.out.println(str);
					}
					System.out.println("Press 1 to manage an offer");
					System.out.println("Press 2 to manage the car lot");
					System.out.println("Press 3 to go back to the Customer Portal");
					int a = in.nextInt();
					in.nextLine();
					switch(a) {
					case 1:
						//manage the offers
						manageOffers(offers);
						break;
					case 2:
						//manage the car lot
					case 3:
						chosen = true;
						break;
					default:
						throw new InputMismatchException();
					}
				} catch(InputMismatchException e) {
					System.out.println("Invalid input, choose from the following options:");
				}
			} while(!chosen);
		}//end of carlot method
		
		public static void manageOffers(ArrayList<Offer> offers) {
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
									serve.approveOffer(offers.get(oID));
									break;
								case 2:
									//method to reject the offer
									serve.rejectOffer(offers.get(oID));
									break;
								case 3:
									//go back to car lot
									one = true;
									two = true;
									break;
								}
							}catch (InputMismatchException e) {
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
								System.out.println("Invalid input, pick from the following options:");
							}
							
						}//end of while(two)
					}//end of ifelse for offerID validation
					
					
				} catch(InputMismatchException e) {
					System.out.println("Invalid input, please input an integer;");
				}
			}while(!one);
			
		}//end of manageoffers method

}
