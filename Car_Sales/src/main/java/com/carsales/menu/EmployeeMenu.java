package com.carsales.menu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.carsales.controller.AutoController;
import com.carsales.controller.OfferController;
import com.carsales.controller.PaymentController;
import com.carsales.model.Auto;
import com.carsales.model.Offer;
import com.carsales.model.Payment;

public class EmployeeMenu {
	
public AutoController as;
public OfferController of;
public PaymentController pa;
	
	public EmployeeMenu() {
		this(new AutoController());
	}
	
	
	public EmployeeMenu(AutoController aito) {
		super();
		this.as = aito;
	}
	
	public void EmpMenuPrint(Scanner scan)
	{
		int inp = 0;
		while(inp != 6)
		{
			System.out.println("Please Make a Selection:");
			System.out.println("1) Add a Car to Inventory");
			System.out.println("2) Remove a Car from Inventory");
			System.out.println("3) Manage Pending Offers");
			System.out.println("4) View Inventory");
			System.out.println("5) View All Payments");
			System.out.println("6) Logout\n");
			inp = scan.nextInt();
			switch(inp)
				{
				case 1:
					AddCarMenu(scan);
					break;
				case 2:
					RemoveCarsMenu(scan);
					break;
				case 3:
					OffersMenu(scan);
					break;
				case 4:
					PrintCars();
					break;
				case 5:
					PrintPayments();
					break;
				}
			
			
		}
	}
	
	
	public int AddCarMenu(Scanner scan) {
		
		int ret;
		int year;
		String make;
		String model;
		int milage;
		int price;
		System.out.println("Enter Year");
		year = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Make");
		make = scan.nextLine();
		System.out.println("Enter Model");
		model = scan.nextLine();
		System.out.println("Enter Mileage");
		milage = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter Full Price");
		price = scan.nextInt();
		Auto auto = new Auto(year, make, model, milage, price);
		ret = as.addAuto(auto);
		if(ret == 1)
			System.out.println("Car Added Successfully\n");
		else
			System.out.println("Car Add Failed Please Try Again:\n");
		return ret;
		
	}
	
	public void PrintCars()
	{
		List<Auto> autos = new LinkedList<Auto>();
		autos = as.getAutobyOwner("admin");
		System.out.println();
		System.out.println("Lot Inventory:");
		System.out.println("==============");
		for(int i = 0; i < autos.size(); i++)
		{
			if(autos.get(i).getOwner().equals("admin"))
			{
			System.out.println((i + 1) + ") " + autos.get(i).getYear() + " " + autos.get(i).getMake() + " "
					+ autos.get(i).getModel() + " " + (autos.get(i).getMileage()/1000) + "k " + '$' + autos.get(i).getPrice());
			}
		}
		System.out.println();
	}
	
	public void RemoveCarsMenu(Scanner scan)
	{
		int select;
		List<Auto> autos = new LinkedList<Auto>();
		autos = as.getAutobyOwner("admin");
		System.out.println();
		System.out.println("Lot Inventory:");
		System.out.println("==============");
		for(int i = 0; i < autos.size(); i++)
		{
			System.out.println((i + 1) + ") " + autos.get(i).getYear() + " " + autos.get(i).getMake() + " "
					+ autos.get(i).getModel() + " " + (autos.get(i).getMileage()/1000) + "k " + '$' + autos.get(i).getPrice());
			
		}
		System.out.println();
		System.out.println("Which Car Would You Like to Remove?");
		System.out.println("0) To Cancel\n");
		select = scan.nextInt();
		scan.nextLine();
		if(select > autos.size())
		{
			System.out.println("Car Does Not Exist. Try Again.\n");
			return;
		}
		else if(select < 1)
			return;
		else
		{
			int remo = as.removeAuto(autos.get(select -1).getCar_id());
			if(remo == 1)
				System.out.println("Car Removed Successfully!\n");
		}
	}
	
	public void OffersMenu(Scanner scan)
	{
		int select;
		List<Offer> offers = new LinkedList<Offer>();
		Auto newaut = new Auto();
		of = new OfferController();
		as = new AutoController();
		pa = new PaymentController();
		offers = of.GetallOffer();
		System.out.println();
		System.out.println("Pending Offers:");
		System.out.println("===============");
		for(int i = 0; i < offers.size(); i++)
		{
			newaut = as.getAutobyId(offers.get(i).getCar_id());
			System.out.println((i + 1) + ") " + offers.get(i).getUsername() + " Offered $" + offers.get(i).getAmount() + " for the " + newaut.getYear() + " " + newaut.getModel() + ". Car# " + newaut.getCar_id());
		}
		System.out.println();
		System.out.println("1) Accept an Offer");
		System.out.println("2) Decline an Offer");
		System.out.println("3) Cancel");
		System.out.println();
		select = scan.nextInt();
		scan.nextLine();
		if(select == 1)
		{
			int select2;
			System.out.println("Which offer Would you Like to Accept?");
			select2 = scan.nextInt();
			scan.nextLine();
			pa.PopulatePayments(offers.get(select2 - 1));
			System.out.println("Offer Accepted!\n");
		}
		else if(select == 2)
		{
			int select2;
			System.out.println("Which offer Would you Like to Decline?");
			select2 = scan.nextInt();
			scan.nextLine();
			of.removeOffer(offers.get(select2 - 1).getOffer_id());
			System.out.println("Offer Declined!\n");
		}
		else
		{
			return;
		}
		
	}
	
	public void PrintPayments()
	{
		pa = new PaymentController();
		List<Payment> payments = new LinkedList<Payment>();
		payments = pa.getallpayment();
		for(int i = 0; i < payments.size(); i++)
		{
			System.out.println("Payment #:" + (i +1) + " Due From " + payments.get(i).getUsername() + " $" + payments.get(i).getAmount());
		}
		System.out.println();
	}
	
	

}
