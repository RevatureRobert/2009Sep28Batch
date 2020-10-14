package com.cars.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cars.model.Payment;
import com.cars.repository.PaymentDAO;

public class PaymentService {

	private PaymentDAO pd = new PaymentDAO();
	
	public boolean createPaymentService(int amount, int carId, int userId) {
		
		Payment returnedPayment = pd.create(new Payment(amount, 12, carId, userId, Date.valueOf(LocalDate.now())));
		
		try {
			boolean b = returnedPayment.equals(null);
			return true; //the payment object was created
		} catch (NullPointerException e) {
			return false; //the payment object was not created
		}

	}
	
	public List<Payment> getAllPaymentsService() {
		List<Payment> payments = new ArrayList<>();
		payments = pd.findAll();
		try {
			boolean b = payments.isEmpty();
			return payments;
		} catch(NullPointerException e) {
			return null; //didnt get payments
		}
		
		
	}
	
	public List<Payment> getMyPaymentsService(int userId){
		
		List<Payment> payments = pd.findSome(userId);
		
		try {
			boolean b = payments.equals(null);
			return payments;
		} catch(NullPointerException e) {
			return null;
		}

	}
	
	public Payment getPaymentByTwoIds(int carId, int userId) {
		
		Payment p = pd.findByTwoIds(carId, userId);
		
		try {
			boolean b = p.equals(null);
			return p;
		} catch (NullPointerException e) {
			return null;
		}
		
	}
	
	public boolean updatePaymentService(Payment p) {
	
		Payment updatedPayment = pd.update(p);
		
		try {
			boolean b = updatedPayment.equals(null);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
		

	}
	
}
