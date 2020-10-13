package com.carsales.menu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.carsales.controller.AutoController;
import com.carsales.controller.OfferController;
import com.carsales.controller.PaymentController;
import com.carsales.controller.UserController;
import com.carsales.model.Auto;
import com.carsales.model.Offer;
import com.carsales.model.Payment;
import com.carsales.model.User;

public class CustomerMenu {
	
public UserController us;
	
public AutoController as;	
public OfferController of;
public PaymentController pa;
	
	public void CustMenuPrint(Scanner scan, User use)
	{
		int inp = 0;
		while(inp != 5)
		{
			System.out.println("Please Make a Selection:");
			System.out.println("1) View The Cars For Sale");
			System.out.println("2) Make an Offer");
			System.out.println("3) View My Cars");
			System.out.println("4) Manage Payments");
			System.out.println("5) Logout\n");
			inp = scan.nextInt();
			switch(inp)
				{
				case 1:
					PrintCars(use);
					break;
				case 2:
					MakeOffer(scan, use);
					break;
				case 3:
					ViewCarsOwned(use);
					break;
				case 4:
					ManagePaymentsMenu(use, scan);
				}
			
			
		}
	}
	
	public List<Auto> PrintCars(User use)
	{
		as = new AutoController();
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
		return autos;
	}
	
	public int MakeOffer(Scanner scan, User use)
	{
		int oint;
		int amount;
		List<Auto> autos = new LinkedList<Auto>();
		autos = PrintCars(use);
		System.out.println("Which Car Would You Like to Make an Offer on?\n");
		oint = scan.nextInt();
		scan.nextLine();
		System.out.println("How Much is Your Offer?\n");
		amount = scan.nextInt();
		scan.nextLine();
		of = new OfferController();
		int addoff = of.addOffer(new Offer(autos.get(oint -1).getCar_id(), use.getUserId(), use.getUserName(), amount));
		if(addoff == 1)
		{
			System.out.println("Offer Successfully Submitted\n");
		}
		else
		{
			System.out.println("Offer Failed. Try again\n");
		}
		return addoff;
	}
	
	public void ViewCarsOwned(User use)
	{
		as = new AutoController();
		List<Auto> autos = new LinkedList<Auto>();
		autos = as.getAutobyOwner(use.getUserName());
		System.out.println("Your Cars:");
		System.out.println("==========");
		for(int i = 0; i < autos.size(); i++)
		{
			if(autos.get(i).getOwner().equals(use.getUserName()))
			{
			System.out.println((i + 1) + ") " + autos.get(i).getYear() + " " + autos.get(i).getMake() + " "
					+ autos.get(i).getModel() + " " + "Paid: " + autos.get(i).getPrice());
			}
		}
		System.out.println();
	}
	
	public void ManagePaymentsMenu(User use, Scanner scan)
	{
		int input;
		as = new AutoController();
		pa = new PaymentController();
		List<Auto> autos = new LinkedList<Auto>();
		List<Payment> payments = new LinkedList<Payment>();
		autos = as.getAutobyOwner(use.getUserName());
		System.out.println();
		System.out.println("Which Car Payments?:");
		System.out.println("====================");
		for(int i = 0; i < autos.size(); i++)
		{
			if(autos.get(i).getOwner().equals(use.getUserName()))
			{
			System.out.println((i + 1) + ") " + autos.get(i).getYear() + " " + autos.get(i).getMake() + " "
					+ autos.get(i).getModel() + " " + "Paid: " + autos.get(i).getPrice());
			}
		}
		
		System.out.println("0) Back");
		input = scan.nextInt();
		scan.nextLine();
		if(input == 0) return;
		payments = pa.getPaymentbyCar(autos.get(input -1).getCar_id());
		//System.out.println(payments.get(0).getCar_id());
		Auto car1 = autos.get(input -1);
		for(int i = 0; i < payments.size(); i++)
		{
			System.out.println("Payment #:" + (i +1) + " For " + car1.getYear() + " " + car1.getModel() + " $" + payments.get(i).getAmount());
		}
		System.out.println();
		System.out.println("1) Make Payment");
		System.out.println("2) Cancel");
		input= scan.nextInt();
		if(input == 1)
		{
			//System.out.println(payments.get(0).getPaymentid());
			pa.removePayment(payments.get(0).getPaymentid());
			System.out.println();
			System.out.println("Payment Made Successfully \n");
			payments.clear();
		}
		else
		{
			return;
		}
		
	}
	

}
