package com.cardealership.ui;

import java.util.List;
import java.util.Scanner;

import com.cardealership.model.Admin;
import com.cardealership.model.Customer;
import com.cardealership.model.Employee;
import com.cardealership.model.Offers;
import com.cardealership.service.AdminService;
import com.cardealership.service.CustomerService;
import com.cardealership.service.DealershipService;
import com.cardealership.service.EmployeeService;

public class AdminMenu {
	
	DealershipService ds;
	AdminService as;
	EmployeeService es;
	CustomerService cs;
	
	public AdminMenu() {
		super();
		this.ds = new DealershipService();
		this.as = new AdminService();
		this.es = new EmployeeService();
		this.cs = new CustomerService();
	}
	
	public void AdminMenu(Scanner scan, Admin t) {
		System.out.println("Welcome to the Admin menu!");
		System.out.println("Please select one of the following options:");
		System.out.println("1: View Cars");
		System.out.println("2: Add Car");
		System.out.println("3: Remove Car");
		System.out.println("4: Edit Existing Car");
		System.out.println("5: View Employees");
		System.out.println("6: Hire Employee");
		System.out.println("7: Fire Employee");
		System.out.println("8: View offers on a car");
		System.out.println("9: Accept offer on a car");
		System.out.println("10: Reject off on a car");
		System.out.println("11: View all payments made");
		System.out.println("12: Logout");
		
		int input = scan.nextInt();
		switch(input) {
			case 1:
				ds.viewCars(t);
				System.out.println("\nPlease enter 0 to go back to the previous menu.");
				int back = scan.nextInt();
				if(back != -404) {
					AdminMenu(scan, t);
				}
			case 2:
				System.out.println("Enter the name of the car:");
				String carName = scan.nextLine();
				carName += scan.nextLine();
				System.out.println("Enter the asking price of the car:");
				int askingPrice = scan.nextInt();
				
				if(ds.addCar(t.getDealershipId(), carName, askingPrice)) {
					System.out.println("Car successfully added!");
					AdminMenu(scan, t);
				}
				else {
					System.out.println("Car could not be added successfully :(");
					AdminMenu(scan, t);
				}
			case 3:
				System.out.println("Please enter the car id or -1 to return to the previous menu:");
				int carIdDelete = scan.nextInt();
				if(carIdDelete==-1) {
					AdminMenu(scan, t);
				}
				else {
					if(ds.removeCar(carIdDelete)) {
						System.out.println("Car successfully removed.");
						AdminMenu(scan, t);
					}
					else {
						System.out.println("Car was not removed. Please make sure you have the correct car id.");
						AdminMenu(scan, t);
					}
				}
			case 4:
				System.out.println("Please enter the car id or -1 to return to the previous menu:");
				int carIdUpdate = scan.nextInt();
				System.out.println("Please enter the cars updated name:");
				String caeNameUpdate = scan.nextLine();
				caeNameUpdate += scan.nextLine();
				System.out.println("Enter the asking price of the car:");
				int askingPriceUpdate = scan.nextInt();
				if(carIdUpdate==-1) {
					AdminMenu(scan, t);
				}
				else {
					if(ds.updateCar(carIdUpdate, caeNameUpdate, askingPriceUpdate)) {
						System.out.println("Car successfully updated");
						AdminMenu(scan, t);
					}
					else {
						System.out.println("Car was not removed. Please make sure you have the correct car id.");
						AdminMenu(scan, t);
					}
				}
			case 5:
				List<Employee> employees = es.listEmployees();
				for(int i = 0; i < employees.size(); i++) {
					System.out.println(employees.get(i).toString());
				}
				System.out.println("\nPlease enter 0 to go back to the previous menu.");
				back = scan.nextInt();
				if(back != -404) {
					AdminMenu(scan, t);
				}

			case 6:
				System.out.println("Enter the Customer ID of the customer you would like to hire(all new employees must first have a customer account before getting hired):");
				int newEmployeeId = scan.nextInt();
				System.out.println("Enter the dealership Id where the new employee will work:");
				int newEmployeeDealershipId = scan.nextInt();
				Customer newEmployee = cs.findById(newEmployeeId);
				if(es.create(newEmployee,newEmployeeDealershipId) != null) {
					System.out.println("Employee Hired!");
					AdminMenu(scan, t);
				}
				else {
					System.out.println("Oh no, something went wrong. Please double check your inputs");
					AdminMenu(scan, t);

				}
			case 7:
				System.out.println("Please enter the UserId of the employee being terminated:");
				int termEmployeeid = scan.nextInt();
				if(es.delete(termEmployeeid)) {
					System.out.println("Employee successfully terminated.\n");
					AdminMenu(scan, t);
				}
				else {
					System.out.println("Oh no, something went wrong. Please double check your inputs\n");
					AdminMenu(scan, t);
				}
			case 8:
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
				AdminMenu(scan,t);
			case 9:
				System.out.println("Enter the carId:");
				int acceptOfferCarId = scan.nextInt();
				System.out.println("Enter the userId of the offer you would like to accept:");
				int acceptOfferUserId = scan.nextInt();
				
				System.out.println("\nPlease enter 0 to go back to the previous menu.");
				scan.next();
				AdminMenu(scan,t);
			case 10:
				System.out.println("Enter the carId:");
				int rejectOfferCarId = scan.nextInt();
				System.out.println("Enter the userId");
				int rejectOfferUserId = scan.nextInt();
				
				if(ds.rejectOffer(rejectOfferCarId, rejectOfferUserId)) {
					System.out.println("Car delete successfully");
				}
				else
					System.out.println("Car was not successfully deleted. Please double check your inputs.");
				System.out.println("\nPlease enter 0 to go back to the previous menu.");
				scan.next();
				AdminMenu(scan,t);
				
			case 11:
			case 12:
				System.out.println("Thanks for stopping by!");
				System.exit(1);
		}		
	}
}
