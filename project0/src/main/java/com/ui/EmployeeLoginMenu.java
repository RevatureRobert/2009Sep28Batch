package com.ui;

import java.util.Scanner;

import com.dao.CarDao;
import com.dao.EmployeeDao;
import com.driver.Driver;
import com.model.Car;

public class EmployeeLoginMenu 
{
	
	public String EmployeeLoginMenu(Scanner scan)
	{
	
		Driver d = new Driver();
		EmployeeDao ed = new EmployeeDao();
		
		int userIDInput = 1;
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
			
			System.out.println(ed.validateLogin(userIDInput, userPassword));
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
