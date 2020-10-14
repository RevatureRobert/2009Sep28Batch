package com.cars.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cars.model.Payment;
import com.cars.service.PaymentService;
import com.cars.ui.TextEffects;

public class PaymentController {

	private PaymentService ps = new PaymentService();
	
	public List<String> getAllPaymentsController(){
		List<String> strings = new ArrayList<>();
		List<Payment> payments = ps.getAllPaymentsService();
		
		try {
			boolean b = payments.isEmpty();
		} catch (NullPointerException e) {
			return Arrays.asList("No payments were found");
		}
		
		for(Payment p : payments) {
			String line1 = "User with ID: "+p.getUserId()+" purchased vehicle with ID: "+p.getCarId()+" on "+p.getPurchaseDate()+" and has "+p.getNumOf()+" payments left of $"+(p.getAmount()/12);
			strings.add(line1);
		}
		
		return strings;
	}
	
	public List<String> getMyPaymentsController(int userId){
		
		List<Payment> payments = ps.getMyPaymentsService(userId);
		List<String> strings = new ArrayList<>();
		
		try {
			
			if(payments.isEmpty()) {
				return Arrays.asList(TextEffects.ANSI_RED+"No payments found.");
			}
			
			for(Payment p : payments) {
				String line1 = "There are " + p.getNumOf() + " payments left of $" + (p.getAmount()/12) + " on car with ID: " + p.getCarId();
				strings.add(line1);
			}
			
			return strings;
		} catch(NullPointerException e) {
			return Arrays.asList(TextEffects.ANSI_RED+"No payments found.");
		}
		
	}
	
	public String makePaymentController(int carId, int userId) {
		
		Payment currentPayment = ps.getPaymentByTwoIds(carId, userId);
		int num;
		
		try {
			num = currentPayment.getNumOf();
		} catch (NullPointerException e){
			return TextEffects.ANSI_RED+"No payment was found for that ID.";
		}
		
		if(num == 0) {
			return TextEffects.ANSI_RED+"That car is already paid off";
		}
		
		currentPayment.setNumOf(num - 1);
		boolean b = ps.updatePaymentService(currentPayment);
		if(b) {
			return TextEffects.ANSI_RED+"You successfully made a payment.";
		} else {
			return TextEffects.ANSI_RED+"Something went wrong, no payment was successfully made.";
		}

	}
	
}
