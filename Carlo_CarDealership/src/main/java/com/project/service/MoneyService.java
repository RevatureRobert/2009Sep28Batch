package com.project.service;

import java.util.List;

import com.project.model.Offer;
import com.project.repository.DAOUtil;
import com.project.repository.MoneyDAO;

public class MoneyService {
	
	private MoneyDAO md;
	private DAOUtil du;
	
	public MoneyService() {
		this(new MoneyDAO(), new DAOUtil());
	}
	
	public MoneyService(MoneyDAO md, DAOUtil du) {
		this.md = md;
		this.du = du;
	}
	
	public List<Offer> findAll() {
		return md.findAll();
	}
	
	public List<Offer> findAllOwed() {
		return md.findAllOwed();
	}
	
	public Offer findById(Integer i) {
		return md.findById(i);
	}
	
	public Offer create(Offer c) throws Exception {
		Offer result = md.create(c);
		if(result==null) {
			throw new Exception("The offer was not created.");
		}
		return result;
	}
	
	public Offer offerBecomesOwed(Offer o) {
		return md.offerBecomesOwed(o);
	}
	
	public List<Offer> amountOwed(Integer i) {
		return md.amountOwed(i);
	}
	
	public int delete(Integer i) {
		return md.delete(i);
	}

	// Stored procedure
	public void callClearOffers(int x) {
		du.callClearOffers(x);
	}
	
	public int makePayment(Integer x, Integer y) {
		return md.makePayment(x,y);
	}
	
}
