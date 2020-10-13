package com.carsales.controller;

import java.util.LinkedList;
import java.util.List;

import com.carsales.dao.AutoDao;
import com.carsales.dao.OfferDao;
import com.carsales.dao.PaymentDao;
import com.carsales.model.Auto;
import com.carsales.model.Offer;
import com.carsales.model.Payment;

public class PaymentController {
	
private PaymentDao pd;
private OfferDao of;
private AutoDao ad;
	
	public PaymentController(PaymentDao paydao)
	{
		super();
		this.pd = paydao;
	}
	
	public PaymentController()
	{
		this(new PaymentDao());
	}
	
	public int addPayment(Payment pay)
	{
		return pd.AddPayments(pay);
	}
	
	public List<Payment> getPaymentbyCar(int id )
	{
		return pd.getPaymentbvCar(id);
	}
	
	public List<Payment> getallpayment()
	{
		return pd.getAllPayment();
	}
	
	public int removePayment(int pay)
	{
		return pd.removePayment(pay);
	}
	
	public int PopulatePayments(Offer off)
	{
		Payment pay;
		of = new OfferDao();
		ad = new AutoDao();
		List<Payment> payl = new LinkedList<Payment>();
		for(int i = 0; i < 12; i ++)
		{
			pd.AddPayments(new Payment((i +1), off.getCar_id(),off.getUser_id(),off.getUsername(), (off.getAmount()/12)));
		}
		of.removeOffer(off.getOffer_id());
		ad.UpdateAutoOwner(off.getUsername(), off.getCar_id(), off.getAmount());
		
		
		return -1;
	}

}
