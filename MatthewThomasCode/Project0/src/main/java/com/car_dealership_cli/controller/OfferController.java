package com.car_dealership_cli.controller;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.car_dealership_cli.dao.CarDAO;
import com.car_dealership_cli.dao.OfferDAO;
import com.car_dealership_cli.model.Car;
import com.car_dealership_cli.model.Offer;

public class OfferController {
	private static final Logger log = Logger.getLogger(OfferController.class);
	public static void view(Scanner input) {
		OfferDAO od = new OfferDAO();
		CarDAO cd = new CarDAO();
	
		//System.out.println("Select Car id to see outstanding offers or enter any other key.");
		//Collection<Car> c = cd.findMapDebtors().values();
		//Object[] c2 = c.toArray();
		//for (int i=0;i<c2.length;i++) {
	//		System.out.println(((Car)c2[i]).getCarId() +": " + c2[i].toString());
		//}
		//String in = input.next();
		//Pattern p = Pattern.compile("[^0-9]");
		//Matcher m = p.matcher(in);
		//if(!m.find()) { 
		
		
		
			//System.out.println(od.findAll());
			System.out.println("\n\n\n   Current offers:");
			Collection<Offer> c = od.findAll();
			Object[] c2 =  c.toArray();
			for (int i=0;i<c2.length;i++) {
				System.out.println(((Offer)(c2[i])).getOrderId() +": " + c2[i].toString());
			}
			
			System.out.println("Please select a Offer ID to accept, or enter any other key.");
			String in = input.next();
			Pattern p = Pattern.compile("[^0-9]"); 
			Matcher m = p.matcher(in);
			if (!m.find()) {
				System.out.println("Are you sure you wish to accept this order? (y,n)");
				String in2 = input.next();
				Pattern t = Pattern.compile("[yY]");
				Matcher y = t.matcher(in2);
				if (y.find()) {
					//change car to be owned by Order's customer //May cause null pointer exception]
					//System.out.println(od.findById(Integer.parseInt(in)).getCar());
					//System.out.println(od.findById(Integer.parseInt(in)).getUser().getUserId());
					Car c1 = od.findById(Integer.parseInt(in)).getCar();
					c1.setDebt(od.findById(Integer.parseInt(in)).getOffer());
					c1.setPayment(c1.getDebt()/24);
					
					cd.update(c1,od.findById(Integer.parseInt(in)).getUser().getUserId());
					log.info("Sale Made, $"+od.findById(Integer.parseInt(in)).getOffer()+", "+ c1.getCarId()+ ": "+ c1.getMake()+" "+c1.getModel()+" "+c1.getYear());
					//delete all offers with that Car's ID
					od.delete(od.findById(Integer.parseInt(in)).getCar().getCarId());
					
					System.out.println("Offer Accepted. All other offers are rejected. Ownership transfered.");
				}else {
					System.out.println("Canceled.");
				}
			
			}
		
		
	}
		
		
	
}
