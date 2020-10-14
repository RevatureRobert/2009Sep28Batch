package com.ui;

import java.util.Scanner;

import com.controller.EmployeeController;
import com.dao.CarDao;
import com.dao.EmployeeDao;
import com.dao.PaymentDao;
import com.driver.Driver;
import com.model.Car;
import com.model.Offer;

public class EmployeeMenu 
{
	private EmployeeController ec;
	
	public EmployeeMenu()
	{
		this(new EmployeeController());
	}

	public EmployeeMenu(EmployeeController ec) 
	{
		super();
		this.ec = ec;
	}
	
	public String EmployeeMenu(Scanner scan)
	{
		Driver d = new Driver();
		EmployeeDao edd = new EmployeeDao();
		CarDao cd = new CarDao();
		PaymentDao pd = new PaymentDao();
		Car t = new Car();
		Offer o = new Offer();
		
		int selection;
		
		System.out.println("Please select an option: \n");
		System.out.println("1: View Cars On the Lot");
		System.out.println("2. Add a Car to the Lot");
		System.out.println("3. Remove a Car from the Lot");
		System.out.println("4. View Payments");
		System.out.println("5. View Offers on Cars");
		System.out.println("6. Approve an offer for a car");
		System.out.println("7. Reject an offer for a car");
		System.out.println("8. Go Back to Welcome Page");
		System.out.println("9. Close the App.");
		System.out.print(": ");
		
		selection = scan.nextInt();
		scan.nextLine();
			
				switch(selection)
				{
				case 1:
					edd.viewCarsByEmployee();				
					break;
				case 2:
					cd.create(t);
					EmployeeMenu(scan);
					break;
				case 3:
					cd.delete(t);
					EmployeeMenu(scan);
					break;
				case 4:
					edd.viewPayments();
					break;
				case 5:
					edd.viewOffersFromCustomers();
					break;
				case 6:
					edd.acceptOfferForCar(o);
					EmployeeMenu(scan);
					break;
				case 7:
					edd.rejectOfferForCar(o);
					EmployeeMenu(scan);
					break;
				case 8:
					d.welcomeMenu(scan);
					break;
				case 9:
					System.exit(0);
				}
				return "";
	}
}
