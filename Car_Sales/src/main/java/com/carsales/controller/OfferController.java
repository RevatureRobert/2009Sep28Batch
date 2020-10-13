package com.carsales.controller;

import java.util.List;

import com.carsales.dao.OfferDao;
import com.carsales.model.Offer;

public class OfferController {
	
	private OfferDao odd;
	
	public OfferController(OfferDao offdao)
	{
		super();
		this.odd = offdao;
	}
	
	public OfferController()
	{
		this(new OfferDao());
	}
	
	public int addOffer(Offer off)
	{
		return odd.addOffer(off);
	}
	
	public int removeOffer(int id)
	{
		return odd.removeOffer(id);
	}
	
	public List<Offer> GetallOffer()
	{
		return odd.getAllOffer();
	}

}
