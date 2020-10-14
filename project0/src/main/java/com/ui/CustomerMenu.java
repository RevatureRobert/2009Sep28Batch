package com.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.controller.CustomerController;
import com.dao.CarDao;
import com.dao.CustomerDao;
import com.dao.EmployeeDao;
import com.dao.OfferDao;
import com.dao.PaymentDao;
import com.driver.Driver;
import com.model.Car;
import com.model.Offer;
import com.model.Payment;

public class CustomerMenu 
{
	final static Logger logger = Logger.getLogger(CustomerMenu.class);
	
	private CustomerController cc;
	
	
	Scanner scan = new Scanner(System.in);
	
		
	/*
	public CustomerMenu()
	{
		this(new CustomerController());
	}
	*/
	
	
	public CustomerMenu(CustomerController cc)
	{
		super();
		this.cc = cc;
	}
	
	public CustomerMenu()
	{
		
	}
	
	public String CustomerMenu(Scanner scan)
	{
		logger.info("Entering the customer menu.");
		
		Driver d = new Driver();
		CustomerDao cd = new CustomerDao();
		OfferDao od = new OfferDao();
		Offer t = new Offer();
		CarDao mycars = new CarDao();
		PaymentDao pd = new PaymentDao();
		Payment p = new Payment();
		int selection = 0;
			
		System.out.println("Please select an option: \n");
		System.out.println("1. View available cars on the lot.");
		System.out.println("2. View your debt balance.");
		System.out.println("3. View cars that you own.");
		System.out.println("4. Make an offer on a car.");
		System.out.println("5. Make a payment.");
		System.out.println("6. Go Back to Welcome Page");
		System.out.println("7. Close the Application");
		System.out.print(": ");
		
		selection = scan.nextInt();
		scan.nextLine();
		
		
		switch(selection)
		{
		case 1:
			cd.viewCarsByCustomer();
			break;
		case 2:
			System.out.println(cd.viewDebtBalance(CustomerLoginMenu.userIDInput));
			break;
		case 3:
			System.out.println(mycars.viewCarsOwned(String.valueOf(CustomerLoginMenu.userIDInput)));
			break;
		case 4:
			od.create(t);
			CustomerMenu(scan);
			break;
		case 5:
			pd.create(p);
			CustomerMenu(scan);
			break;
		case 6:
			d.welcomeMenu(scan);
			break;
		case 7:
			System.exit(0);
		}
		
		return "";
	}
}
