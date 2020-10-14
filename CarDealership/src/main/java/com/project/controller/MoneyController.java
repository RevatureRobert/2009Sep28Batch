package com.project.controller;

import java.util.List;

import com.project.model.Offer;
import com.project.service.MoneyService;

public class MoneyController {

	private MoneyService ms;
	
	public MoneyController() {
		this(new MoneyService());
	}
	
	public MoneyController(MoneyService ms) {
		this.ms = ms;
	}
	
	public List<Offer> findAll() {
		return ms.findAll();
	}
	
	public List<Offer> findAllOwed() {
		return ms.findAllOwed();
	}
	
	public Offer findById(Integer i) {
		return ms.findById(i);
	}
	
	public String insert(Offer o) {
		try {
			Offer result = ms.create(o);
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public Offer offerBecomesOwed(Offer o) {
		return ms.offerBecomesOwed(o);
	}
	
	public List<Offer> amountOwed(Integer i) {
		return ms.amountOwed(i);
	}
	
	public int remove(Integer i) {
		return ms.delete(i);
	}
	
	// Stored procedure
	public void callClearOffers(int x) {
		ms.callClearOffers(x);
	}

	public int makePayment(Integer x, Integer y) {
		return ms.makePayment(x,y);
	}
	
}
