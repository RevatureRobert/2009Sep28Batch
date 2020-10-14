package com.cars.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cars.model.Car;
import com.cars.model.Offer;
import com.cars.service.CarService;
import com.cars.service.OfferService;
import com.cars.service.PaymentService;

public class OfferController {

	//Just something to note.
	//CarController has public List<String> carOfferViewing(Integer i)
	//The only thing it does is select a list of offers, and it is specifically for a car
	//This controller is specifically for manipulating the offers table
	//Adding, accepting, and rejecting offers will be done here.
	
	private OfferService os = new OfferService();
	private CarService cs = new CarService();
	private PaymentService ps = new PaymentService();
	
	public String addNewOffer(int amount, int id, String user) {
		
		user = user.substring(21);
		boolean b = os.addOfferService(amount, id, user);
		if(b) {
			return "Offer was successfully added.";
		} else {
			return "Something went wrong. The offer was not successfully added.";
		}

	}
	
	public String acceptOfferController(int amount, int id, int user) {
		
		String retString = "";
		
		//first, we ensure that the offer got approved
		boolean b = os.acceptOfferService(amount, id, user);
		if(b) {
			retString = "Offer was successfully approved.";
		} else {
			return "Something went wrong. The offer was not successfully approved.";
		}
		
		//next, we automatically reject any other offers on the car
		boolean b2 = os.autoRejectService(id);
		if(b2) {
			retString += "\nOther offers on this car have been automatically rejected.";
		} else {
			return "The offer was approved. However, other updates have failed.";
		}
		
		//now, we update the corresponding car to have a userid
		Car c = cs.findCarService(id);
		c.setUserId(user);
		boolean b3 = cs.editCarService(c);
		if(b3) {
			retString += "\nThis car is now associated with the ID number of the offeree.";
		} else {
			return "The offer was approved, and other offers on this car have been rejected. However, other updates have failed.";
		}
		
		//finally, we need to create a payment object
		boolean b4 = ps.createPaymentService(amount, id, user);
		if(b4) {
			retString += "\nA payment has now been associated with this car and offeree.";
		} else {
			return "The offer was approved, other offers were rejected, and this car has been associated with the offeree. However, a payment plan has not been created.";
		}
		
		return retString;
	}
	
	public String rejectOfferController(int amount, int id, int userid) {
		
		boolean b = os.rejectOfferService(amount, id, userid);
		if(b) {
			return "Offer was successfully rejected.";
		} else {
			return "Something went wrong. The offer was not successfully rejected.";
		}
		

	}
	
	public List<String> getAllOffersController(){
		List<Offer> offers = os.getAllOffersService();
		List<String> strings = new ArrayList<>();
		
		try {
			boolean b = offers.equals(null);
			for(Offer o : offers) {
				String line1 = "User with ID: "+o.getUserId()+" made an offer of $"+o.getAmount()+" for car with ID: "+o.getCarId()+" on "+o.getAddDate()+". ";
				String line2 = "";
				if(o.getStatus() == "submitted") {
					line2 = "The offer has not yet been accepted or rejected.";
				} else {
					line2 = "The offer was "+o.getStatus()+" on "+o.getAppOrRejDate()+".";
				}
				String line3 = line1 + line2;
				strings.add(line3);
			}
			return strings;
		} catch (NullPointerException e) {
			return Arrays.asList("No offers found");
		}
	}
	
}
