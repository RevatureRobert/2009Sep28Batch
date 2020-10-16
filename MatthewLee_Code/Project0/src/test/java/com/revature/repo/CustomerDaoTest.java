package com.revature.repo;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dealership.model.Offer;
import com.dealership.repo.CustomerDaoImpl;

public class CustomerDaoTest {

	private CustomerDaoImpl cd;
	
	@Before
	public void setup() {
		cd = new CustomerDaoImpl();
	}
	
	@Test
	public void registerTest() {
		assertTrue(cd.register("junit", "junit") == 1);
	}
	
	@Test
	public void loginTest() {
		assertTrue(cd.login("matthewlee", "abcd") != null);
	}
	
	@Test
	public void viewCarLotTest() {
		assertTrue(cd.viewCarLot().size() > 0);
	}
	
	@Test
	public void makeOfferTest() {
		assertTrue(cd.makeOffer(new Offer(21000, 65, 3, 3)) == 1);
	}
	
	@Test
	public void viewCustomerCarsTest() {
		assertTrue(cd.viewCustomerCars(1).size() > 0);
	}
	
	@Test
	public void viewPaymentsTest() {
		assertTrue(cd.viewPayments(1).size() > 0);
	}
	
}
