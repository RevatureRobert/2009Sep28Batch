package com.dealership.controller;

import java.util.List;

import com.dealership.models.Offer;
import com.dealership.service.OfferService;

public class OfferController {

	OfferService os;
	
	public OfferController() {
		this(new OfferService());
	}
	
	public OfferController(OfferService os) {
		this.os = os;
	}
	
	public Offer findByID(int offerID) {
		return os.findById(offerID);
	}
	
	public Offer makeOffer(Offer offer) {
		return os.makeOffer(offer);
	}
	
	public List<Offer> viewAllPaymentsOnCars(String username){
		return os.viewAllPaymentsOnCars(username);
	}
	
	public List<Offer> viewAllOffersOnACar(int cid){
		return os.viewAllOffersOnACar(cid);
	}
	
	public Offer updateOffer(Offer offer) {
		return os.updateOffer(offer);
	}
	
	public List<Offer> getAllPayments(){
		return os.getAllPayments();
	}
}
