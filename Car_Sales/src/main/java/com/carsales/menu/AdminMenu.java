package com.carsales.menu;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.carsales.controller.UserController;
import com.carsales.model.User;

public class AdminMenu {
	
	public UserController us;
		
		public AdminMenu() {
			this(new UserController());
		}
		
		
		public AdminMenu(UserController use) {
			super();
			this.us = use;
		}
		
		public void AdminMenuPrint(Scanner scan, User use)
		{
			int inp = 0;
			while(inp != 4)
			{
				System.out.println("Please Make a Selection:");
				System.out.println("1) View Employees:");
				System.out.println("2) Hire Employee:");
				System.out.println("3) Fire Employees");
				System.out.println("4) Logout:\n");
				inp = scan.nextInt();
				scan.nextLine();
				switch(inp)
					{
					case 1:
						ViewEmployees();
						break;
					case 2:
						HireEmployee(scan);
						break;
					case 3:
						FireEmployees(scan);
						break;
					
					}
			}
		}
	
		public void ViewEmployees()
		{
			List<User> users = new LinkedList<User>();
			us = new UserController();
			users = us.getEmployeebyRole("employee");
			for(int i = 0; i < users.size(); i++)
			{
				System.out.println((i+1) + ") " + users.get(i).getUserName() + "- Employee ID#:" + users.get(i).getUserId());
			}
			System.out.println();
		}
		
		
		public void HireEmployee(Scanner scan)
		{
			System.out.println("Enter Employee Name:");
			String name = scan.nextLine();
			System.out.println("Enter Employee Password:");
			String pass = scan.nextLine();
			User newuse = new User(name, pass, "employee");
			int addint = us.addUser(newuse);
			if(addint == 1)
				System.out.println("User Added Successfully\n");
			else
				System.out.println("Sign Up Failed Please Try Again:\n");
		}
		
		public void FireEmployees(Scanner scan)
		{
			int input = 0;
			List<User> users = new LinkedList<User>();
			us = new UserController();
			users = us.getEmployeebyRole("employee");
			for(int i = 0; i < users.size(); i++)
			{
				System.out.println((i+1) + ") " + users.get(i).getUserName() + "- Employee ID#:" + users.get(i).getUserId());
			}
			System.out.println();
			System.out.println("Who Would You Like to Fire?");
			input = scan.nextInt();
			us.removeUser(users.get(input -1).getUserId());
			System.out.println(users.get(input -1).getUserName() +  " Successfully Fired!");
			System.out.println();
		}
		

}
