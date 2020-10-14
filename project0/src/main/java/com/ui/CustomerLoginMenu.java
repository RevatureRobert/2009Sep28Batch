package com.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.dao.CustomerDao;
import com.dao.PaymentDao;
import com.driver.Driver;

public class CustomerLoginMenu 
{
	final static Logger logger = Logger.getLogger(CustomerLoginMenu.class);

	public static int userIDInput = 0;

	public String CustomerLoginMenu(Scanner scan)
	{
	logger.info("Entering the customer login menu method.");
	Driver d = new Driver();
	CustomerDao cd = new CustomerDao();
	
	// final int userIDInput = 1;
	String userPassword = "";
	String returnValue = "";
	int i = 0;
	int hit = 0;
	{	
	while(i < 1)
	{
		
		if(hit > 0)
		{
			scan.nextLine();
			System.out.println("\nPlease have no letters in userID and no spaces in userID or password.\n");
		}
		try 
		{
		System.out.print("Enter userID: ");
		userIDInput = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter password: ");
		userPassword = scan.nextLine();
		i = 2;
		break;
		}
		catch(Exception e)
		{
			hit++;
			continue;
		}
		
		
	}
	
	while(i < 4)
	{
		if(i == 3)
		{
			d.welcomeMenu(scan);
		}
					
		try
		{
		
		System.out.println(cd.validateLogin(userIDInput, userPassword));
		System.out.println("\nYou have successfully logged onto your Online Account!\n");
		 i = 4;
		}
		catch(Exception e)
		{
			returnValue = "Failure";
			i = 3;
			System.out.println("\nWe are sorry. We don't recognize those credentials. Please try again or quit.\n");
		}
		
}
}
	return "";
	}
}

