package com.carsales.menu;

import java.util.Scanner;

import com.carsales.controller.UserController;
import com.carsales.model.User;

public class LoginMenu {
	
	private UserController us;
	
	public LoginMenu() {
		this(new UserController());
	}
	
	
	public LoginMenu(UserController userController) {
		super();
		this.us = userController;
	}
	
	public void SignUpMenuPrint(Scanner scan)
	{
		System.out.println("Enter Your Username:");
		String usern = scan.nextLine();
		System.out.println("Enter Your Password:");
		String pass = scan.nextLine();
		User newuse = new User(usern, pass, "customer");
		int addint = us.addUser(newuse);
		if(addint == 1)
			System.out.println("User Added Successfully\n");
		else
			System.out.println("Sign Up Failed Please Try Again:\n");
	}
	
	public User LoginMenuPrint(Scanner scan)
	{
		User use = null;
		System.out.println("Enter Your Username:");
		String usern = scan.nextLine();
		System.out.println("Enter Your Password:");
		String pass = scan.nextLine();
		use = new User(usern, pass);
		use = us.checkUser(use);
		if(use != null)
		{
			System.out.println("Login Success! Welcome, " + usern + "\n");
		}
		else
		{
			System.out.println("Login Failed Please Try Again:\n");
		}
			
		return use;
	}
	

}
