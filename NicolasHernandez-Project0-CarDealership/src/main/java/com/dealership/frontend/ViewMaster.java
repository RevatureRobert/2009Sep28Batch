package com.dealership.frontend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dealership.dao.DealershipDAO;
import com.dealership.dao.DealershipMasterDAO;
import com.dealership.pojos.Customer;
import com.dealership.pojos.Employee;
import com.dealership.pojos.Offer;
import com.dealership.pojos.Payment;
import com.dealership.pojos.SoldCar;
import com.dealership.pojos.UnsoldCar;
import com.dealership.pojos.User;
import com.dealership.util.DatabaseConnector;

/**
 * The ViewMaster singleton class houses the main loop of the program. Acts as the
 * controller layer for the views contained.
 * 
 * This object requires a Scanner for user input and a DealershipDAO for data access
 * and validation.
 * 
 * To run, simply call the static initialize() method, then call runViewSelector()
 * on the ViewMaster object that's returned.
 * 
 * If the garbage collector cleans this object, the Scanner and DAO objects will be
 * closed.
 * 
 * @author Nicolas Hernandez
 *
 */
public class ViewMaster {
	/**
	 * The ViewMaster singleton instance.
	 */
	private /*volatile*/ static ViewMaster viewManagerInstance;
	
	
	
	
	/**
	 * Log4j logger. Logs new sales.
	 */
	final static Logger logger = Logger.getLogger(DealershipMasterDAO.class);
	
	/**
	 * The Scanner for user input.
	 */
	private Scanner s;
	
	/**
	 * The DealershipDAO for accessing and posting backend data.
	 */
	private DealershipDAO dao;
	
	/**
	 * The User object, used to inform control flow after logging in.
	 */
	private User user;
	
	/**
	 * Control variable allowing Employee users to perform Customer actions.
	 */
	private boolean viewAsCustomer;
	
	/**
	 * The ViewMaster private constructor.
	 * 
	 * @param scanner Scanner object that handles user input. Close after use.
	 * @param dao Data accessor object that handles backend input. Close after use.
	 */
	private ViewMaster(Scanner scanner, DealershipDAO dao) {
		this.s = scanner;
		this.dao = dao;
	}
	
	
	/**
	 * The ViewMaster static initializer method. Allows only a single instance of the ViewMaster
	 * to exist.
	 * 
	 * @param scanner Scanner object that handles user input. Close after use.
	 * @param dao Data accessor object that handles backend input. Close after use.
	 * @return The ViewMaster singleton
	 * @throws SQLException Thrown in case the database connection refuses.
	 */
	public static ViewMaster initialize(Scanner scanner, DealershipDAO dao) throws SQLException {
		if (viewManagerInstance == null) {
			viewManagerInstance = new ViewMaster(scanner, dao);
			
			// OPEN & CLOSE DATABASE CONNECTION TO VERIFY AUTHENTICATION
			Connection conn = DatabaseConnector.getInstance().getConnection();
			conn.close();
		}
		
		return viewManagerInstance;
	}
	
	
	/**
	 * The main loop of the ViewMaster. Ends when the selectView method returns any
	 * view index less than zero.
	 */
	public void runViewSelector() {
		int viewIndex = 0;
		
		do {
			viewIndex = selectView(viewIndex);
			System.out.println();
		} while (viewIndex >= 0);
	}
	
	
	/**
	 * The ViewMaster's view selector. Takes in an integer and uses it to select
	 * which type of view it will run next.
	 * 
	 * @param selection
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	private int selectView(int viewIndex) {
		switch (viewIndex){
			case 0:
				viewIndex = initialView();
				break;
			case 1:
				viewIndex = login();
				break;
			case 2:
				viewIndex = customerRegistration();
				break;
			case 3:
				viewIndex = customerHome();
				break;
			case 4:
				viewIndex = staffHome();
				break;
			case 5:
				viewIndex = carLotView();
				// HAS SUBVIEWS: carSearch, newCarListing, makeOffer, reviewOffers, carEditor
				break;
			case 6:
				viewIndex = carLoansView();
				// HAS SUBVIEW: makePayment
				break;
			case 7:
				viewIndex = employeeManagementView();
				// HAS SUBVIEW: makeEmployee
				break;
			case 8:
				viewIndex = salesHistoryView();
		}
		
		return viewIndex;
	}
	
	
	/**
	 * View ID 0. The first view the user sees when s/he enters the program.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int initialView() {
		int selection = 0;
		boolean isValid = false;
		
		// LOG IN, REGISTER, OR EXIT
		System.out.println("_WELCOME TO THE CAR DEALERSHIP_\n\n"
				+ "Please enter one of the following to proceed:");
		do {
			System.out.println("Press [1] to log in.\n" +
								"Press [2] to register a new customer account.\n" +
								"Press [0] to exit.\n");
			try {
				selection = s.nextInt();
				isValid = (selection == 1 || selection == 2);
			} catch (InputMismatchException e) {
				selection = -1;
				s.next(); // flushes the newline from the scanner
			}
			
			if(selection == 0) // exit selected
				return -1;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			
		}while(!isValid);
		
		
		s.nextLine();
		return selection;
	}
	
	
	/**
	 * View ID 1. The login interface.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int login() {
		String username = "";
		String password;
		boolean isValid = false;
		
		System.out.println("\n_LOGIN_\n");
		
		// USERNAME CHECK
		do {
			System.out.print("Enter your username, or enter [0] to go back > ");
			username = s.nextLine();
			
			if(username.equals("0")) { // brings the user back to the initial page
				System.out.println("\n\n\n");
				return 0;
			}
			
			isValid = dao.doesUsernameExist(username);
			
			if(!isValid)
				System.out.print("\n\n\nThat username does not exist!\n");
			System.out.println();
		}while(!isValid);
		
		
		
		
		// PASSWORD CHECK
		String passwordHash = dao.getPasswordHashForUser(username);
		do {
			System.out.println("USERNAME: " + username);
			System.out.print("Enter your password, or enter [0] to go back > ");
			password = s.nextLine();
			
			if(password.equals("0")) {
				System.out.println("\n");
				return 1;
			}
			
			isValid = passwordHash.equals(Utilities.hashPassword(password));
			
			if(!isValid)
				System.out.println("\n\n\nInvalid password!\n");
		}while(!isValid);
		
		System.out.println("\nLOGIN SUCCESSFUL!\n");
		
		
		
		
		
		// RETRIEVE USER DATA FROM DATABASE, SET this.user TO THE NEW USER
		user = null;
		try {
			user = dao.getUserData(username);
			
			if(user instanceof Employee) {
				viewAsCustomer = false;
				
				return 4;
			}
			else if(user instanceof Customer) {
				viewAsCustomer = true;
				
				return 3;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		// ONLY REACHES THIS STATEMENT IF USER DATA COULD NOT BE RETRIEVED
		System.out.println("\n\nThere was a problem getting user data!\n"
				+ "Press enter to retry login.");
		s.nextLine();
		
		return 1;
	}
	
	
	/**
	 * View ID 2. The new-user registration interface.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int customerRegistration() {
		String username = "";
		String password = "";
		String colloquialName = "";
		boolean isValid = false;
		
		System.out.println("_REGISTER_\n");
		
		
		// 
		System.out.println("Welcome, new customer!\n");
		// Username handler
		do {
			System.out.println("Please create a new username.\n"
					+ "Usernames may only include letters, numbers, "
					+ "and underscores [_].\n");
			System.out.print("Enter a unique username, or enter [0] to go back > ");
			username = s.nextLine().toLowerCase();
			
			if(username.equals("0")) { // brings the user back to the initial page
				System.out.println("\n\n");
				return 0;
			}
			else if(username.length() == 0) {
				System.out.println("You haven't entered a username!");
			}
			else if(dao.doesUsernameExist(username)) {
				System.out.println("\n\n\nUsername already exists!\n");
				continue;
			} else{
				isValid = true;
				
				int len = username.length();
				for(int index = 0; index < len && isValid; index++) {
					char c = username.charAt(index);
					if(!(Character.isLetterOrDigit(c) || c == '_'))
						isValid = false;
				}
			}
			
			if(!isValid)
				System.out.println("\n\n\nThat username is invalid!");
			System.out.println();
		}while(!isValid);
		
		
		
		// Password handling
		do {
			isValid = false;
			passwordHandler:
			do {
				System.out.println("\n\nYOUR NEW USERNAME: " + username);
				System.out.print("Enter your password, or enter [0] to go back > ");
				password = s.nextLine();
				
				if(password.equals("0")) {
					System.out.println("\n");
					return 2;
				}
				else if(password.length() == 0) {
					System.out.println("You've not entered a password!\n");
					continue passwordHandler;
				}
				
				System.out.print("Re-enter your password to confirm, or enter [0] to go back > ");
				String passConfirm = s.nextLine();
				if(passConfirm.equals("0")) {
					System.out.println();
					continue passwordHandler;
				}
				
				isValid = passConfirm.equals(password);
				
				if(!isValid)
					System.out.println("\nThat password didn't match!");
				System.out.println();
			}while(!isValid);
			
			System.out.println("\n\nUsername & password combination accepted!\n");
		
		
		
		
			// User data finalizer & confirmation
			isValid = false;
			confirmation:
			do {
				System.out.println("What would you like to be called?");
				System.out.print("Enter your name, enter nothing to be called by your username, "
						+ "or enter [0] to go back > ");
				colloquialName = s.nextLine();
				
				if(colloquialName.equals("0"))
					break confirmation;
				else if(colloquialName.length() == 0) {
					colloquialName = new String(username);
				}
				
				
				
				
				int selection = -1;
				do {
					System.out.println("\n\n\nYOUR USERNAME IS: " + username);
					System.out.println("YOU WOULD LIKE TO BE CALLED: " + colloquialName);
					
					System.out.println("\nPress [1] to confirm.\n"
							+ "Press [0] to go back.\n");
					
					try {
						selection = s.nextInt();
						s.nextLine();
						
						if(selection == 1)
							isValid = true;
						else if(selection == 0) {
							System.out.println("\n\n");
							break;
						}
					} catch (InputMismatchException e) {
						s.next(); // flushes the newline from the scanner
						continue;
					}
				}while(!isValid);
			}while(!isValid);
		}while(!isValid);
		
		
		
		
		
		System.out.println("\nUser details confirmed! Creating new user account...\n");
		
		user = new Customer(username, Utilities.hashPassword(password), colloquialName);
		dao.createUser(user);
		
		System.out.println("New user created! Press enter to log in!");
		s.nextLine();
		
		viewAsCustomer = true;
		return 3;
	}
	
	/**
	 * View ID 3. The first view a customer sees when s/he successfully logs in.
	 * 
	 * Also viewable by Employees and Managers if they make themselves Customers.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int customerHome() {
		int selection = 0;
		boolean isValid = false;
		boolean isEmployee = user instanceof Employee;
		System.out.println("_CUSTOMER HOME_\nLogged in as: " + user.getUsername() + "\n");
		
		if(!isEmployee)
			System.out.println("Welcome, " + user.getColloquialName() + ".\n");
		
		System.out.println("Here are your options:");
		do {
			System.out.println("Press [1] to view cars on the lot.\n"
					+ "Press [2] to view your cars & payments.");
			if(!isEmployee)
				System.out.println("Press [0] to log out.\n");
			else
				System.out.println("Press [0] to return to staff view.\n");
			
			try {
				selection = s.nextInt();
				isValid = (selection >= 0 && selection <= 2);
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}while(!isValid);
		
		switch(selection) {
		case 0:
			if(!isEmployee)
				selection = 0;
			else {
				selection = 4;
				viewAsCustomer = false;
			}
			break;
		case 1:
		case 2:
			selection += 4;
		}
		
		return selection;
	}
	
	/**
	 * View ID 4. The first view an employee sees when s/he successfully
	 * logs in.
	 * 
	 * Also viewable by Managers.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int staffHome() {
		boolean isManager = ((Employee)user).isManager();
		int selection = 0;
		boolean isValid = false;
		
		String[]options = new String[isManager ? 6 : 4];
		options[0] = "Press [1] to view cars on the lot.";
		options[1] = "Press [2] to view car loans & payments.";
		options[2] = "Press [3] to view as a customer.";
		options[options.length-1] = "Press [0] to log out.";
		if(isManager) {
			options[3] = "Press [4] to view all employees. (MANAGEMENT OPTION)";
			options[4] = "Press [5] to view sales history. (MANAGEMENT OPTION)";
		}
		
		
		
		System.out.println("_STAFF HOME_\nLogged in as: " + user.getUsername() + "\n");
		
		System.out.println("Greetings, " + user.getColloquialName() + ".\n\n"
				+ "Here are your options:");
		
		do {
			for(String s: options)
				System.out.println(s);
			System.out.println();
			
			try {
				selection = s.nextInt();
				isValid = (selection >= 0 && selection <= (isManager ? 5 : 3));
				
				s.nextLine();
			} catch (InputMismatchException e) {
				selection = -1;
				s.next(); // flushes the newline from the scanner
			}
			
			if(selection == 0) // exit selected
				return 0;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}while(!isValid);
		
		
		switch(selection) {
			case 1:
			case 2:
				selection += 4;
				break;
			case 3:
				viewAsCustomer = true;
				break;
			case 4:
			case 5:
				selection += 3;
				break;
			default:
				selection = 4;
		}
		
		return selection;
	}
	
	/**
	 * View ID 5. Displays cars currently on the lot.
	 * 
	 * Customers can make offers on any cars currently listed.
	 * 
	 * Staff can add cars to & remove cars from the lot, they can edit existing
	 * cars, and they can view & accept current offers being made on the cars.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int carLotView() {
		int selection = 0;
		boolean isValid = false;
		ArrayList<UnsoldCar> allCars = dao.getUnsoldCars();
		ArrayList<UnsoldCar> displayCars = allCars;
		
		System.out.println("_CAR LOT_\n");
		
		// Lot viewer handler
		do {
			System.out.println("Select a car to view details & take actions:\n");
			
			for(int index = 0, len = displayCars.size(); index < len; index++) {
				UnsoldCar car = displayCars.get(index);
				
				System.out.println("[" + (index + (viewAsCustomer ? 3 : 4)) + "] "
						+ car.getYear() + " " + car.getMake() + " " + car.getModel()
						+ " (" + car.getColor() + ")\n\tList price: $"
						+ String.format("%.2f", car.getListPrice()));
			}
			
			System.out.print("\n[1] to search - [2] to clear all searches - ");
			
			if(!viewAsCustomer)
				System.out.print("[3] to add a car to the lot - ");
			
			System.out.println("[0] to go back");
			
			try {
				selection = s.nextInt();
				
				isValid = (selection >= 0 && selection <= (displayCars.size() + (viewAsCustomer ? 2 : 3)));
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(selection == 0) {
				System.out.println();
				if(viewAsCustomer)
					return 3;
				else
					return 4;
			} else if (!isValid) {
				System.out.println("\nInvalid input!\n");
			} else switch(selection) {
			case 1:
				displayCars = carSearchSubview(displayCars);
				isValid = false;
				break;
			case 2:
				displayCars = allCars;
				isValid = false;
				break;
			case 3:
				if(!viewAsCustomer) {
					UnsoldCar newCar = newCarListingSubview();
					
					if(newCar == null)
						System.out.println("\nCancelled new car listing!");
					else {
						allCars.add(newCar);
						displayCars = allCars;
					}
						
					isValid = false;
				} else
					isValid = true;
				break;
			default:
				isValid = true;
			}
			System.out.println();
		}while(!isValid);
		
		
		
		
		
		// Car viewer handler
		UnsoldCar car = displayCars.get(selection - (viewAsCustomer ? 3 : 4));
		isValid = false;
		do {
			System.out.println("_CAR FOR SALE_\n\n" + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " ("
					+ car.getColor() + ")\n\tCAR ID: " + car.getCarId()
					+ "\n\tLIST PRICE: $"
					+ String.format("%.2f", car.getListPrice())
				);
			
			if(viewAsCustomer) {
				System.out.println("\nPress [1] to make or redo an offer.");
			} else
				System.out.println("\nPress [1] to view offers.\n"
						+ "Press [2] to edit or unlist this car.");
			
			System.out.println("Press [0] to go back.");
			
			try {
				selection = s.nextInt();
				
				isValid = (selection >= 0 && selection <= (viewAsCustomer ? 1 : 2));
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			
			switch(selection){
			case 0:
				return 5;
			case 1:
				if(viewAsCustomer)
					makeOfferSubview(car);
				else {
					int code;
					for(code = 0; code == 0; code = reviewOffersSubview(car));
					
					if(code == 2) // means the car was unlisted
						return 5;
				}
				break;
			case 2:
				if(carEditorSubview(car))
					return 5;
			}
			
			System.out.println();
			
			isValid = false;
		}while(!isValid);
		
		
		return 5;
	}
	
	/**
	 * Helper method (ID 5.1) for the Car Lot View; implements search functionality by
	 * filtering the ArrayList of cars based on user input.
	 * 
	 * @param cars The list of cars to be filtered by the search.
	 * @return A filtered list of cars.
	 */
	public ArrayList<UnsoldCar> carSearchSubview(ArrayList<UnsoldCar> cars) {
		int selection = 0;
		boolean isValid = false;
		ArrayList<UnsoldCar> filteredList = new ArrayList<>();
		
		do {
			System.out.println("\nENTER:\n"
				+ "[1] to search by year - [2] to search by maker - [3] to search by model\n"
				+ "[4] to search by color - [5] to set a max price - [6] to set a minimum price\n"
				+ "[0] to go back");
			
			try {
				selection = s.nextInt();
				
				isValid = (selection >= 0 && selection <= 6);
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(selection == 0)
				return cars;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}while(!isValid);
		
		isValid = false;
		String input;
		float price = -1;
		switch(selection) {
		case 1:
			do {
				System.out.print("Enter a year, or press [0] to go back > ");
				
				try {
					selection = s.nextInt();
					
					isValid = selection >= 0;
					
					s.nextLine();
				} catch(InputMismatchException e) {
					s.next();
				}
				
				if(selection == 0)
					return cars;
				else if(!isValid)
					System.out.println("\nInvalid input!\n");
				else for(UnsoldCar car: cars) {
					if(car.getYear() == selection)
						filteredList.add(car);
				}
				System.out.println();
			}while(!isValid);
			break;
		case 2:
			System.out.print("Enter a car brand, or press [0] to go back > ");
				
			input = s.nextLine();
				
			if(input.equals("0"))
				return cars;
			else for(UnsoldCar car: cars) {
				if(car.getMake().equals(input))
					filteredList.add(car);
			}
			System.out.println();
			break;
		case 3:
			System.out.print("Enter a car model, or press [0] to go back > ");
			
			input = s.nextLine();
			
			if(input.equals("0"))
				return cars;
			else for(UnsoldCar car: cars) {
				if(car.getModel().equals(input))
					filteredList.add(car);
			}
			System.out.println();
			break;
		case 4:
			System.out.print("Enter a color, or press [0] to go back > ");
			
			input = s.nextLine();
			
			if(input.equals("0"))
				return cars;
			else for(UnsoldCar car: cars) {
				if(car.getColor().equals(input))
					filteredList.add(car);
			}
			System.out.println();
			break;
		case 5:
			do {
				System.out.print("Enter a maximum price, or press [0] to go back > ");
				
				try {
					price = s.nextFloat();
					
					isValid = price >= 0;
					
					s.nextLine();
				} catch(InputMismatchException e) {
					s.next();
				}
				
				if(price == 0)
					return cars;
				else if(!isValid)
					System.out.println("\nInvalid input!\n");
				else for(UnsoldCar car: cars) {
					if(car.getListPrice() <= price)
						filteredList.add(car);
				}
				System.out.println();
			}while(!isValid);
			break;
		case 6:
			do {
				System.out.print("Enter a minimum price, or press [0] to go back > ");
				
				try {
					price = s.nextFloat();
					
					isValid = price >= 0;
					
					s.nextLine();
				} catch(InputMismatchException e) {
					s.next();
				}
				
				if(price == 0)
					return cars;
				else if(!isValid)
					System.out.println("\nInvalid input!\n");
				else for(UnsoldCar car: cars) {
					if(car.getListPrice() >= price)
						filteredList.add(car);
				}
				System.out.println();
			}while(!isValid);
			break;
		}
		
		if(filteredList.size() == 0) {
			System.out.println("There are no cars that match those criteria!\n"
					+ "Press enter to return to the car lot.");
			
			s.nextLine();
			return cars;
		}
		else
			return filteredList;
	}
	
	/**
	 * Helper method (ID 5.2) to create a new car listing.
	 * 
	 * Accessible only to employees.
	 * 
	 * @return The UnsoldCar that's added to the listing, or NULL if the listing is cancelled.
	 */
	public UnsoldCar newCarListingSubview() {
		String color = "";
		int year = -1;
		String make = "";
		String model = "";
		float listPrice = -1;
		
		System.out.println("\nListing a new car!");
		
		// SET THE NEW CAR LISTING'S MAKE
		System.out.print("Enter the car's manufacturer, or press [0] to cancel this listing > ");
		
		make = s.nextLine();
		
		System.out.println();
		
		if(make.equals("0"))
			return null;
		
		
		// SET THE NEW CAR LISTING'S MODEL
		System.out.print("Enter the car's model type, or press [0] to cancel this listing > ");
		
		model = s.nextLine();
		
		System.out.println();
		
		if(model.equals("0"))
			return null;
		
		
		// SET THE NEW CAR LISTING'S MODEL YEAR
		boolean isValid = false;
		do {
			System.out.print("Enter the car's model year, or press [0] to cancel this listing > ");
			
			try {
				year = s.nextInt();
				
				isValid = year >= 0;
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(year == 0)
				return null;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			
			System.out.println();
		}while(!isValid);
		
		
		// SET THE NEW CAR LISTING'S COLOR
		System.out.print("Enter the car's color, or press [0] to cancel this listing > ");
		
		color = s.nextLine();
		
		System.out.println();
		
		if(color.equals("0"))
			return null;
		
		
		// SET THE NEW CAR LISTING'S LIST PRICE
		isValid = false;
		do {
			System.out.print("Enter the car's listing price, or press [0] to cancel this listing > ");
			
			try {
				listPrice = s.nextFloat();
				
				isValid = listPrice >= 0;
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(listPrice == 0)
				return null;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			else
				listPrice = ((float)Math.round(listPrice * 100f))/100f;
			
			System.out.println();
		}while(!isValid);
		
		
		
		// CONFIRM NEW LISTING
		UnsoldCar car = new UnsoldCar(0, color, year, make, model, listPrice);
		int selection = 0;
		do{
			System.out.println("LISTING CONFIRMATION\n\n" + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " ("
					+ car.getColor() + "), Listed at $"
					+ String.format("%.2f", car.getListPrice())
					+ ".\n\nPRESS [1] TO CONFIRM OR [0] TO CANCEL THIS LISTING.");
			
			try {
				selection = s.nextInt();
				s.nextLine();
				
				if(selection == 0)
					return null;
				else
					isValid = selection == 1;
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		} while(!isValid);
		
		
		
		// 
		System.out.println("\nListing details confirmed! Registering your listing...\n");
		
		car.setCarId(dao.listNewCar(car));
		
		System.out.println("New listing created!"
				+ "\nYou can revise or delete this listing at any time by going to the CAR LOT view and selecting this listing."
				+ "\nPress enter to return to the car lot listing.");
		s.nextLine();
		
		return car;
	}
	
	/**
	 * Helper method (ID 5.3) to make offers on an unsold car.
	 * 
	 * The offer is assigned to the current user.
	 * 
	 * @param car
	 * @return A control boolean indicating whether or not the offer was created.
	 */
	public boolean makeOfferSubview(UnsoldCar car) {
		float offerAmount = -1;
		float downPayment = -1;
		int loanTermInMonths = -1;
		float yearlyInterest = -1;
		
		boolean isValid = false;
		boolean isPayingCash = false;
		
		System.out.println("\nMaking an offer!");
		
		// SET OFFER AMOUNT
		do {
			System.out.print("Enter your total payment price before interest, or press [0] to cancel the offer > ");
			
			try {
				offerAmount = s.nextFloat();
				
				isValid = offerAmount >= 0;
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(offerAmount == 0)
				return false;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			else{
				offerAmount = (float)Math.round(offerAmount*100f) / 100f;
			}
			System.out.println();
		}while(!isValid);
		
		
		
		
		// SET DOWN PAYMENT
		isValid = false;
		do {
			System.out.print("Enter your down payment, or press [0] to cancel the offer > ");
			
			try {
				downPayment = s.nextFloat();
				
				isValid = downPayment >= 0;
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(downPayment == 0)
				return false;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			else{
				downPayment = (float)Math.round(downPayment*100f) / 100f;
			}
			System.out.println();
		}while(!isValid);
		
		if(downPayment >= offerAmount) {
			downPayment = offerAmount;
			isPayingCash = true;
			loanTermInMonths = 0;
			yearlyInterest = 0;
		}
		
		
		
		// SET LOAN TERM IN MONTHS
		isValid = isPayingCash;
		while(!isValid){
			System.out.print("Enter how many months your loan will last, or press [0] to go back > ");
			
			try {
				loanTermInMonths = s.nextInt();
				
				isValid = loanTermInMonths >= 0;
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(loanTermInMonths == 0)
				return false;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}
		
		
		
		// SET APR / YEARLY INTEREST RATE
		isValid = isPayingCash;
		while(!isValid) {
			System.out.print("Enter your interest rate percentage, or press [0] to cancel the offer > ");
			
			try {
				yearlyInterest = s.nextFloat();
				s.nextLine();
				
				if(yearlyInterest > 30) {
					System.out.println("\n" + yearlyInterest + "% YEARLY INTEREST. Are you sure?\n"
							+ "Press enter to retry, or enter [1] to confirm.");
					String choice = s.nextLine();
					if(!choice.equals("1")) {
						yearlyInterest = -1;
						continue;
					}
				}
				
				isValid = yearlyInterest >= 0;
				
				
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(yearlyInterest == 0)
				return false;
			else if(!isValid)
				System.out.println("\nInvalid input!\n");
			else{
				yearlyInterest = (float)Math.round(yearlyInterest*100f) / 10000f;
			}
			System.out.println();
		}
		
		
		
		// CONFIRM OR CANCEL OFFER
		int selection = 0;
		do{
			System.out.println("_OFFER CONFIRMATION_\n\n" + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " ("
					+ car.getColor() + "), Listed at $"
					+ String.format("%.2f", car.getListPrice()) + "\n\nYOU ARE OFFERING $"
					+ String.format("%.2f", offerAmount) + " IN TOTAL, WITH A DOWN"
					+ " PAYMENT OF $" + String.format("%.2f", downPayment)
					+ ". YOUR CAR LOAN WILL LAST " + loanTermInMonths + " MONTHS, WITH AN"
					+ " INTEREST RATE OF " + String.format("%.2f", (yearlyInterest * 100f))
					+ "%.\n\nYOUR MONTHLY PAYMENT WILL BE $" + String.format("%.2f",(
							(float)Math.round(100f*Utilities.calculateMonthlyPayment(
							offerAmount, downPayment, loanTermInMonths, yearlyInterest)) / 100f))
					+ ".\nPRESS [1] TO CONFIRM OR [0] TO CANCEL THIS OFFER.");
			
			try {
				selection = s.nextInt();
				s.nextLine();
				
				if(selection == 0)
					return false;
				else
					isValid = selection == 1;
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		} while(!isValid);
		
		
		
		System.out.println("\nOffer details confirmed! Registering your offer...\n");
		
		
		// REGISTER OFFER INTO DATABASE & GIVE AN EMPLOYEE CUSTOMER STATUS
		dao.createOffer(new Offer(
				car.getCarId(), user.getUsername(), offerAmount, downPayment, loanTermInMonths, yearlyInterest));
		if(user instanceof Employee && !((Employee) user).isCustomer()) {
			((Employee)user).setCustomer(true);
			dao.addEmployeeToCustomerBase((Employee)user);
		}
		
		System.out.println("New offer created!"
				+ " You can revise this offer at any time by coming back and creating a new offer for this car."
				+ "\nPress enter to return to the car you were viewing.");
		s.nextLine();
		
		return false;
	}
	
	/**
	 * Helper method (ID 5.4) to review offers on the given car.
	 * 
	 * Only accessible to employees.
	 * 
	 * @param car
	 * @return control int; 0 = repeat this method; 1 = leave editor; 2 = car was unlisted
	 */
	public int reviewOffersSubview(UnsoldCar car) {
		int selection = 0;
		boolean isValid = false;
		ArrayList<Offer> offers = dao.getOffers(car);
		
		System.out.println("\nViewing all offers for " + car.getYear() + " "
				+ car.getMake() + " " + car.getModel() + " ("
				+ car.getColor() + ") (ID : " + car.getCarId() + ")\n");
		
		// Lot viewer handler
		do {
			System.out.println("Select an offer to view details & take actions:\n");
			
			if(offers.size() == 0)
				System.out.println("NO OFFERS TO DISPLAY");
			for(int index = 0, len = offers.size(); index < len; index++) {
				Offer offer = offers.get(index);
				
				System.out.println("[" + (index + 1) + "] $"
					+ offer.getOfferAmount() + " total ($" + offer.getDownPayment()
					+ " upfront), paid over " + offer.getLoanTermInMonths()
					+ " months with "
					+ (Math.round(offer.getYearlyInterest()*10000f)/100f) + "% APR\n"
					+ "\tFrom user: " + offer.getCustomerId());
			}
			
			System.out.print("\nThe list price is $" + car.getListPrice()
				+ ".\nPress [0] to go back.\n");
			
			try {
				selection = s.nextInt();
				
				isValid = (selection >= 0 && selection <= offers.size());
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(selection == 0) {
				System.out.println();
				return 1;
			} else if (!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}while(!isValid);
		
		
		
		
		
		// Offer viewer handler
		Offer offer = offers.get(selection - 1);
		isValid = false;
		do {
			// Displays full details for both the car being listed and the offer being made.
			System.out.println("LISTING:\n" + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " ("
					+ car.getColor() + ")\n\tCar ID: " + car.getCarId()
					+ "\n\tList price: $"
					+ String.format("%.2f", car.getListPrice())
					+ "\n\nOFFER:\n$" + offer.getOfferAmount() + " total ($"
					+ offer.getDownPayment() + " upfront), paid over "
					+ offer.getLoanTermInMonths() + " months with "
					+ (Math.round(offer.getYearlyInterest()*10000f)/100f) + "% APR\n"
					+ "\tFrom user: " + offer.getCustomerId() + ", also known as "
					+ dao.getNameForUser(offer.getCustomerId()) + ".\n\t"
					+ "Their monthly payment: $" + (Math.round(
						Utilities.calculateMonthlyPayment(offer.getOfferAmount() - offer.getDownPayment(),
							offer.getDownPayment(), offer.getLoanTermInMonths(),
							offer.getYearlyInterest())*100f)/100f)
				);
			
			System.out.println("\n[1] ACCEPT OFFER - [2] REJECT OFFER - [0] Go back");
			
			try {
				selection = s.nextInt();
				
				isValid = (selection >= 0 && selection <= 2);
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			
			switch(selection){
			case 0:
				return 0;
			case 1:
			case 2:
				System.out.print((selection == 1 ? "ACCEPT" : "REJECT")
					+ " OFFER. ARE YOU SURE?\nPress [1] to confirm, or enter"
					+ " anything else to go back.\n");
				String choice = s.nextLine();
				if(!choice.equals("1"))
					isValid = false;
			}
			
			System.out.println();
		}while(!isValid);
		
		if(selection == 1) {
			if(dao.acceptOffer(offer)) {
				logger.info("SALE MADE BY " + user.getColloquialName() + ": "
						+ car.getYear() + " " + car.getMake() + " " + car.getModel()
						+ " (" + car.getColor() + ") "
						+ "LISTED AT $" + car.getListPrice() + ", SOLD AT $"
						+ offer.getOfferAmount() + " ($" + offer.getDownPayment()
						+ " down)");
				return 2;
			}
		}
		else
			dao.rejectOffer(offer);
		
		return 0;
	}
	
	/**
	 * Helper method (ID 5.5) to edit the listed cars.
	 * 
	 * Only accessible to employees.
	 * 
	 * @param car
	 * @return a boolean value stating whether or not the listing has been removed
	 */
	public boolean carEditorSubview(UnsoldCar car) {
		boolean isValid = false;
		int selection = -1;
		String choice = "";
		
		do {
			System.out.println("Editing car:\n" + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " ("
					+ car.getColor() + ")\n\tCAR ID: " + car.getCarId()
					+ "\n\tLIST PRICE: $"
					+ String.format("%.2f%n", car.getListPrice())
				);
			
			System.out.println("\n[1] edit year - [2] edit make - [3] edit model"
					+ "\n[4] edit color - [5] edit list price - [6] unlist this car - [0] go back");
			
			try {
				selection = s.nextInt();
				
				isValid = (selection >= 0 && selection <= 6);
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
			
			
			switch(selection){
			case 1:
				do {
					System.out.print("Enter the car's year, or press [0] to go back > ");
					
					try {
						selection = s.nextInt();
						
						isValid = selection >= 0;
						
						s.nextLine();
					} catch(InputMismatchException e) {
						s.next();
					}
					
					if(!isValid)
						System.out.println("\nInvalid input!\n");
					else if(selection != 0)
						car.setYear(selection);
					System.out.println();
				}while(!isValid);
				isValid = false;
				break;
			case 2:
				System.out.print("Enter the car's make, or press [0] to go back > ");
				
				choice = s.nextLine();
				
				if(!choice.equals("0"))
					car.setMake(choice);
				
				System.out.println();
				isValid = false;
				break;
			case 3:
				System.out.print("Enter the car's model, or press [0] to go back > ");
				
				choice = s.nextLine();
				
				if(!choice.equals("0"))
					car.setModel(choice);
				
				System.out.println();
				isValid = false;
				break;
			case 4:
				System.out.print("Enter the car's color, or press [0] to go back > ");
				
				choice = s.nextLine();
				
				if(!choice.equals("0"))
					car.setColor(choice);
				
				System.out.println();
				isValid = false;
				break;
			case 5:
				float newPrice = -1;
				do {
					System.out.print("Enter the car's list price, or press [0] to go back > ");
					
					try {
						newPrice = s.nextFloat();
						
						isValid = newPrice >= 0;
						
						s.nextLine();
					} catch(InputMismatchException e) {
						s.next();
					}
					
					if(!isValid)
						System.out.println("\nInvalid input!\n");
					else if(newPrice != 0)
						car.setListPrice(newPrice);
					System.out.println();
				}while(!isValid);
				isValid = false;
				break;
			case 6:
				System.out.println("UNLIST THIS CAR. Are you sure?\n"
						+ "Press [1] to confirm, or press anything else to go back.");
				
				choice = s.nextLine();
				System.out.println();
				
				if(choice.equals("1"))
					dao.removeCarListing(car);
					return true;
			}
			
			System.out.println();
		}while(!isValid);
		
		dao.commitCarChanges(car);
		
		return false;
	}
	
	/**
	 * View ID 6. Displays loan details on sold cars.
	 * 
	 * Customers can view their owned cars, make payments, and view past payments.
	 * 
	 * Employees can view all sold cars and their payments.
	 * 
	 * @return
	 */
	public int carLoansView() {
		int selection = 0;
		boolean isValid = false;
		ArrayList<SoldCar> cars;
		if(viewAsCustomer)
			cars = dao.getSoldCars(user);
		else
			cars = dao.getSoldCars();
		
		System.out.println("_CAR LOANS & PAYMENTS_\n");
		
		do {
			System.out.println("Select a car to view details " + (viewAsCustomer
					? " & take actions" : "") + ":\n");
			
			for(int index = 0, len = cars.size(); index < len; index++) {
				SoldCar car = cars.get(index);
				
				System.out.println("[" + (index + 1) + "] " + car.getYear() + " "
						+ car.getMake() + " " + car.getModel() + " ("
						+ car.getColor() + ") bought by user " + car.getOwner_id()
						+ "\n\tTotal due: $" + String.format("%.2f",car.getTotalDue())
						+ " (+ " + (car.getYearlyInterestRate() * 100f) + "% APR)"
						+ (car.getRemainingBalance() <= 0.01f ? "\n\tFULLY PAID OFF"
						: "\n\tMonthly payment: $" + String.format("%.2f",
						car.getMonthlyPayment()) + "\n\tRemaining due: $"
						+ String.format("%.2f",car.getRemainingBalance())
						+ "\n\tLoan term: " + car.getLoanStartDate()
						+ " thru " + car.getLoanEndDate() )
					);
			}
			
			System.out.print("\nEnter a car's number to view " + (viewAsCustomer ?
					"& make " : "") + "payments, or press [0] to go back > ");
			
			try {
				selection = s.nextInt();
				
				if(selection == 0)
					return viewAsCustomer ? 3 : 4;
				
				isValid = (selection > 0 && selection <= cars.size());
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if (!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}while(!isValid);
		
		
		
		
		
		// Car viewer handler
		SoldCar car = cars.get(selection - 1);
		boolean isPaid = car.getRemainingBalance() <= 0.01;
		ArrayList<Payment> payments = dao.getPayments(car);
		isValid = false;
		do {
			System.out.println("\nPAYMENTS FOR: " + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " ("
					+ car.getColor() + ")\n"
				);
			
			for(int index = 0, len = payments.size(); index < len; index++) {
				Payment payment = payments.get(index);
				
				System.out.println("[" + payment.getPayDate() + "] $"
						+ payment.getPayAmount() + (payment.isDownPayment() ?
						" DOWN PAYMENT" : "")
					);
			}
			
			if(!isPaid) {
				System.out.println("\nREMAINING: " + ((int)car.getRemainingBalance()
						/ (int)car.getMonthlyPayment()) + " payments of $"
						+ String.format("%.2f", car.getMonthlyPayment()) + " each, plus one payment of $"
						+ String.format("%.2f", (car.getTotalDue() % car.getMonthlyPayment())) + "\n");
			
				if(viewAsCustomer)
					System.out.print("press [1] to make a new payment - ");
			} else
				System.out.println("\nCar fully paid!\n");
			System.out.println("press [0] to go back");
			
			try {
				selection = s.nextInt();
				
				if(selection == 0)
					return 6;
				
				isValid = (viewAsCustomer && !isPaid) ? selection == 1 : false;
				
				s.nextLine();
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(isValid) {
				Payment newPayment = makePaymentSubview(car);
				
				if(newPayment == null)
					System.out.println("\nPayment cancelled!\n");
				else {
					payments.add(newPayment);
					car.setRemainingBalance(car.getRemainingBalance() - newPayment.getPayAmount());
					
					if(car.getRemainingBalance() <= 0.01f)
						isPaid = true;
					payments = dao.getPayments(car);
				}
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
			
			isValid = false;
		}while(!isValid);
		
		
		
		return 6;
	}
	
	/**
	 * Helper method (ID 6.1) for customers to make payments on cars they own.
	 * 
	 * @param car
	 * @return The Payment made. Returns NULL if the payment is cancelled.
	 */
	public Payment makePaymentSubview(SoldCar car) {
		boolean isValid = false;
		float payAmount = -1;
		int selection = -1;
		
		dispensation:
		do {
			// Pay amount input
			do {
				System.out.print("\nNEW PAYMENT FOR: " + car.getYear() + " "
					+ car.getMake() + " " + car.getModel() + " (" + car.getColor()
					+ ")\n\nMonthly payment: $" + car.getMonthlyPayment()
					+ "\nRemaining balance: $" + car.getRemainingBalance() + " ("
					+ ((int)car.getRemainingBalance() / (int)car.getMonthlyPayment())
					+ " monthly payments, plus $" + (car.getTotalDue()
					% car.getMonthlyPayment()) + ")\n\nEnter your payment amount, or"
					+ " press [0] to cancel the payment > ");
				
				try {
					payAmount = s.nextFloat();
					
					if(payAmount == 0)
						return null;
					
					isValid = payAmount > 0;
					
					s.nextLine();
				} catch(InputMismatchException e) {
					s.next();
				}
				
				if(!isValid)
					System.out.println("\nInvalid input!\n");
				else{
					if(payAmount > car.getRemainingBalance())
						payAmount = car.getRemainingBalance();
					
					payAmount = (float)Math.round(payAmount*100f) / 100f;
				}
				System.out.println();
			}while(!isValid);
			
			
			
			
			
			// Order confirmation
			isValid = false;
			do{
				System.out.print("\nPAY AMOUNT: $" + payAmount
					+ "\n\nPress [1] to confirm or [0] to go back > ");
				
				try {
					selection = s.nextInt();
					s.nextLine();
					
					if(selection == 0)
						continue dispensation;
					
					isValid = selection == 1;
				} catch(InputMismatchException e) {
					s.next();
				}
				
				if(!isValid)
					System.out.println("\nInvalid input!\n");
				System.out.println();
			} while(!isValid);
		} while (!isValid);
		
		
		System.out.println("\nPayment details confirmed! Registering your payment...\n");
		Payment payment = new Payment(car.getCarId(), user.getUsername(),
				new Timestamp(System.currentTimeMillis()), payAmount, false);
		
		dao.makePayment(payment);
		if(user instanceof Employee && !((Employee) user).isCustomer()) {
			((Employee)user).setCustomer(true);
			dao.addEmployeeToCustomerBase((Employee)user);
		}
		
		System.out.println("New payment made!"
				+ "\nPress enter to return to your payment history.");
		s.nextLine();
		
		return payment;
	}
	
	/**
	 * View ID 7. Views & manages the employee roster.
	 * 
	 * Only available to management. Allows a manager to create employee accounts
	 * and remove existing ones.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int employeeManagementView() {
		int selection = -1;
		boolean isValid = false;
		ArrayList<Employee> employees = dao.getEmployees();
		
		System.out.println("_EMPLOYEE MANAGEMENT_\n");
		
		// Employee list viewer
		do {
			System.out.println("Select an employee to take actions:\n");
			
			for(int index = 0, len = employees.size(); index < len; index++) {
				Employee empl = employees.get(index);
				
				System.out.println("[" + (index + 2) + "] " + empl.getColloquialName()
					+ " (username: " + empl.getUsername() + ")"
					+ (empl.isManager() ? " MANAGER" : "")
					);
			}
			
			System.out.print("\n[1] to add a new employee - [0] to go back > ");
			
			try {
				selection = s.nextInt();
				s.nextLine();
				
				if(selection == 0)
					return 4;
				else if(selection == 1) {
					makeEmployeeSubview();
					return 7;
				}
				
				isValid = (selection > 0 && selection <= (employees.size() + 1));
				
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if (!isValid)
				System.out.println("\nInvalid input!\n");
			System.out.println();
		}while(!isValid);
		
		
		
		
		
		// single employee viewer
		Employee empl = employees.get(selection - 2);
		isValid = false;
		do {
			System.out.println("\nEMPLOYEE SELECTED:\n\n" + empl.getColloquialName()
					+ " (username " + empl.getUsername() + ")"
					+ (empl.isManager() ? " MANAGER" : "") + "\n"
				);
			
			System.out.println("[1] to remove employee account - [0] to go back");
			
			try {
				selection = s.nextInt();
				s.nextLine();
				
				if(selection == 0)
					return 7;
				
				isValid = selection == 1;
				
			} catch(InputMismatchException e) {
				s.next();
			}
			
			if(!isValid)
				System.out.println("\nInvalid input!\n");
			else if (empl.getUsername().equals(user.getUsername())){
				System.out.println("\nYou can't fire yourself!");
				
				isValid = false;
			} else {
				System.out.println("\nReally remove employee " + empl.getColloquialName()
					+ "?\nPress [1] to confirm or enter to go back.");
				
				if(s.nextLine().equals("1")) {
					dao.removeEmployee(empl);
					
					System.out.println("Employee " + empl.getColloquialName() + " removed."
							+ " Press enter to continue.");
					
					s.nextLine();
					isValid = true;
				}
			}
				
			System.out.println();
		}while(!isValid);
		
		return 7;
	}
	
	
	/**
	 * Helper method (ID 7.1) for managers to create employees.
	 * 
	 * @return The registered Employee
	 */
	public Employee makeEmployeeSubview() {
		String username = "";
		String password = "";
		String colloquialName = "";
		boolean isValid = false;
		
		System.out.println("\n_REGISTER NEW EMPLOYEE_\n");
		// Username handler
		boolean userExists = false;
		do {
			System.out.println("Create the employee's username.\n"
					+ "Usernames may only unclude letters, numbers, "
					+ "and underscores [_].\n");
			System.out.print("Enter a username, or enter [0] to go back > ");
			username = s.nextLine().toLowerCase();
			
			if(username.equals("0")) {
				System.out.println("\n\n");
				return null;
			}
			else if(username.length() == 0) {
				System.out.println("You haven't entered a username!");
			}
			else if(dao.doesUsernameExist(username)) {
				System.out.println("\n\nUsername already exists!\n"
						+ " Press [1] to enter this account as an"
						+ " employee, or press enter to create a new username.");
				
				if(s.nextLine().equals("1")) {
					userExists = true;
					isValid = true;
				}
				else
					continue;
			} else{
				isValid = true;
				
				int len = username.length();
				for(int index = 0; index < len && isValid; index++) {
					char c = username.charAt(index);
					if(!(Character.isLetterOrDigit(c) || c == '_'))
						isValid = false;
				}
			}
			
			if(!isValid)
				System.out.println("\n\n\nThat username is invalid!");
			System.out.println();
		}while(!isValid);
		
		if(userExists) {
			dao.registerUserAsEmployee(username);
			
			Employee empl = (Employee)dao.getUserData(username);
			
			System.out.println("Employee details confirmed!\nUsername: " + username
					+ "\nCommon name: " + empl.getColloquialName() + "\n\nPress"
					+ " enter to continue,"
					+ " or press [1] to make this employee a manager.");
			
			if(s.nextLine().equals("1")) {
				dao.promoteEmployee(empl);
				
				System.out.println("New manager registered! Press enter to continue.");
				
				s.nextLine();
			}
			
			return empl;
		}
		
		
		
		// Password handling
		do {
			isValid = false;
			passwordHandler:
			do {
				System.out.println("\n\nEMPLOYEE USERNAME: " + username);
				System.out.print("Enter the employee's password, or enter [0] to go back > ");
				password = s.nextLine();
				
				if(password.equals("0")) {
					System.out.println("\n");
					return null;
				}
				else if(password.length() == 0) {
					System.out.println("You've not entered a password!\n");
					continue passwordHandler;
				}
				
				System.out.print("Re-enter your password to confirm, or enter [0] to go back > ");
				String passConfirm = s.nextLine();
				if(passConfirm.equals("0")) {
					System.out.println();
					continue passwordHandler;
				}
				
				isValid = passConfirm.equals(password);
				
				if(!isValid)
					System.out.println("\nThat password didn't match!");
				System.out.println();
			}while(!isValid);
			
			System.out.println("\n\nUsername & password combination accepted!\n");
		
		
		
		
			// User data finalizer & confirmation
			isValid = false;
			confirmation:
			do {
				System.out.println("What should the employee be called?");
				System.out.print("Enter their name, enter nothing to call them by their username, "
						+ "or enter [0] to go back > ");
				colloquialName = s.nextLine();
				
				if(colloquialName.equals("0"))
					break confirmation;
				else if(colloquialName.length() == 0) {
					colloquialName = new String(username);
				}
				
				
				
				
				int selection = -1;
				do {
					System.out.println("\n\n\nNEW EMPLOYEE USERNAME: " + username);
					System.out.println("EMPLOYEE WILL BE CALLED: " + colloquialName);
					
					System.out.println("\nPress [1] to confirm.\n"
							+ "Press [0] to go back.\n");
					
					try {
						selection = s.nextInt();
						s.nextLine();
						
						if(selection == 1)
							isValid = true;
						else if(selection == 0) {
							System.out.println("\n\n");
							break;
						}
					} catch (InputMismatchException e) {
						s.next(); // flushes the newline from the scanner
						continue;
					}
				}while(!isValid);
			}while(!isValid);
		}while(!isValid);
		
		
		
		
		
		System.out.println("\nUser details confirmed! Creating new employee account...\n");
		
		Employee empl = new Employee(username, Utilities.hashPassword(password), colloquialName, false, false);
		dao.createUser(empl);
		
		System.out.println("New employee created! Press enter to return to employee"
				+ " management, or press [1] to make this employee a manager.");
		
		if(s.nextLine().equals("1")) {
			dao.promoteEmployee(empl);
			
			System.out.println("New manager registered! Press enter to continue.");
			
			s.nextLine();
		}
		
		return empl;
	}
	
	
	
	/**
	 * View ID 8. Shows the sales history of all offers.
	 * 
	 * Only available to management.
	 * 
	 * @return the view index; an int value that the ViewMaster uses to select the
	 * 			next view.
	 */
	public int salesHistoryView() {
		System.out.println("_SALES LOG_\n");
		
		try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\sales.log"))){
			String line = "";
			while((line = br.readLine()) != null)
				System.out.println(line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\nPress enter to return to the staff home.\n");
		s.nextLine();
		
		return 4;
	}
	
	
	/**
	 * Closes all input streams upon calling.
	 */
	@Override
	protected void finalize() throws Throwable {
		s.close();
		dao.closeAllConnections();
	}
}
