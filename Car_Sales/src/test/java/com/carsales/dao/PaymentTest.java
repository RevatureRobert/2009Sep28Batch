package com.carsales.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.carsales.model.Auto;

public class PaymentTest {
	PaymentDao pd = new PaymentDao();
	
	
	
	@Test
	public void removepaymenttest() {
		int value = pd.removePayment(12);
		assertTrue(value == 1);
	}

}
