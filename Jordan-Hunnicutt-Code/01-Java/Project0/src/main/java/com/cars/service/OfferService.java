package com.cars.service;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.cars.model.Offer;
import com.cars.model.User;
import com.cars.repository.OfferDAO;
import com.cars.repository.UserDAO;

public class OfferService {

	private UserDAO ud = new UserDAO();
	private OfferDAO od = new OfferDAO();
	
	public boolean addOfferService(int amount, int id, String user) {
		
		User userMakingOffer = ud.findById(user);
		Offer offerObject = new Offer(amount, id, userMakingOffer.getUserId(), "submitted", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
		Offer returnedOffer = od.create(offerObject);
		
		try {
			boolean b = returnedOffer.equals(null);
			return true; //the offer is not null
		} catch (NullPointerException e) {
			return false; //the offer is null
		}
		

	}
	
	public boolean acceptOfferService(int amount, int id, int user) {
		
		Offer offerObject = new Offer(amount, id, user, "approved", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
		Offer returnedOffer = od.update(offerObject);
		
		try {
			boolean b = returnedOffer.equals(null);
			return true; //the offer is not null
		} catch (NullPointerException e) {
			return false; //the offer is null
		}
		
	}
	
	public boolean autoRejectService(int id) {
		
		boolean b = od.autoUpdate(id);
		
		return b;
	}
	
	public boolean rejectOfferService(int amount, int id, int user) {
		
		Offer offerObject = new Offer(amount, id, user, "rejected", Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
		Offer returnedOffer = od.update(offerObject);
		
		try {
			boolean b = returnedOffer.equals(null);
			return true; //the offer is not null
		} catch (NullPointerException e) {
			return false; //the offer is null
		}
	}
	
	public List<Offer> getAllOffersService(){
		List<Offer> offers = od.findAll();
		
		try {
			boolean b = offers.isEmpty();
			return offers;
		} catch (NullPointerException e) {
			return null;
		}
		
	}
	
}
