package com.driver;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.EmployeeDao;
import com.model.Customer;
import com.model.Employee;
import com.ui.CustomerLoginMenu;
import com.ui.CustomerMenu;
import com.ui.EmployeeLoginMenu;
import com.ui.EmployeeMenu;


public class Driver 
{

	private static EmployeeLoginMenu elm = new EmployeeLoginMenu();
	private static EmployeeMenu em = new EmployeeMenu();
	private static CustomerMenu cmd = new CustomerMenu();
	private static CustomerLoginMenu clm = new CustomerLoginMenu();
	private static EmployeeDao ed = new EmployeeDao();
	static Employee t = new Employee();
	private static CustomerDao cd = new CustomerDao();
	static Customer c = new Customer();
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		welcomeMenu(scan);
	}	
	
	
	
// Welcome page to the application.	
	public static void welcomeMenu(Scanner scan)
	{
		boolean successful = false;
		int selection = 0;
		while(successful == false)
		{
			System.out.println("Welcome to Dawit's Car Dealership Web Application!");
			System.out.println("Please select an option: ");
			System.out.println("1. Employee Register");
			System.out.println("2. Employee Login");
			System.out.println("3. Customer Login");
			System.out.println("4. Customer Register");
			System.out.println("5. Close the Application");
			System.out.print(": ");
			selection = scan.nextInt();
			
			switch(selection)
			{
			case 1: 
				ed.create(t);
				successful = true;
				break;
			case 2:
				System.out.println(elm.EmployeeLoginMenu(scan));		
				successful = true;
				break;
			case 3:
				System.out.println(clm.CustomerLoginMenu(scan));
				successful = true;
				break;
			case 4:
				cd.create(c);
				successful = true;
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("\nPLEASE CHOOSE A VALID OPTION.\n");		
			}
		}
		
		switch(selection)
		{
		case 1:
			welcomeMenu(scan);
			break;
		case 2:
			System.out.println(em.EmployeeMenu(scan));
			break;
		case 3:
			System.out.println(cmd.CustomerMenu(scan));
			break;
		case 4:
			welcomeMenu(scan);
			break;
		}
		
		
		
	}
		
}	
			
			
		
				
			
					
				
				
				
				
	
						
						

		

			
			
			
			
			
		
		
	

