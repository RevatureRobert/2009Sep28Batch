package com.carsales;

import java.util.Scanner;

import com.carsales.controller.UserController;
import com.carsales.menu.AdminMenu;
import com.carsales.menu.CustomerMenu;
import com.carsales.menu.EmployeeMenu;
import com.carsales.menu.LoginMenu;
import com.carsales.menu.MenuPrint;
import com.carsales.model.User;

public class Driver {
	public static void main(String...strings)
	{
		UserController usrCo = new UserController();
		LoginMenu lmen = new LoginMenu();
		int input;
		Scanner scan = new Scanner(System.in);
		MenuPrint.MainMenu();
		input = scan.nextInt();
		
		while(input != 3)
		{
			scan.nextLine();
			switch(input)
			{
			case 1:
				User loggedin = lmen.LoginMenuPrint(scan);
				if(!(loggedin == null))
				LoggedinMenu(scan, loggedin);
				break;
			case 2:
				lmen.SignUpMenuPrint(scan);
				break;
			}
			MenuPrint.MainMenu();
			input = scan.nextInt();
		}
	}
	
	
	public static void LoggedinMenu(Scanner scan, User user) {
		EmployeeMenu e = new EmployeeMenu();
		CustomerMenu c = new CustomerMenu();
		AdminMenu o = new AdminMenu();
		if(user.getRole().equals("employee"))
		{
			e.EmpMenuPrint(scan);
		}
		else if(user.getRole().equals("customer"))
		{
			c.CustMenuPrint(scan, user);
		}
		else if(user.getRole().equals("system"))
		{
			o.AdminMenuPrint(scan, user);
		}
		
	}

}
