package com.revature.repo;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.dealership.model.Car;
import com.dealership.repo.EmployeeDaoImpl;

public class EmployeeDaoTest {

	private EmployeeDaoImpl ed;
	
	@Before
	public void setup() {
		ed = new EmployeeDaoImpl();
	}
	
	@Test
	public void validLoginTest() {
		assertTrue(ed.login("employee", "project0").getId() == 1);
	}
	
	@Test
	public void invalidLoginTest() {
		assertTrue(ed.login("abcd", "abcd") == null);
	}
	
	@Test
	public void viewCarsTest() {
		assertTrue(ed.viewCars().size() > 0);
	}
	
//	@Test
//	public void validAddCarTest() {
//		assertTrue(ed.addCar(new Car("junit", "juint", 2000, 10, 10000)) == 1);
//	}	
//	
//	@Test
//	public void editCarTest() {
//		assertTrue(ed.editCar(new Car("junit", "junit", 2000, 10, 11000)) == 1);
//	}
//	
//	@Test
//	public void removeCarTest() {
//		int intial = ed.viewCars().size();
//		ed.removeCar(5);
//		int end = ed.viewCars().size();
//		assertTrue(intial == (end + 1));
//	}
	
	@Test
	public void viewOffersTest() {
		assertTrue(ed.viewOffers().size() > 0);
	}
	
	@Test
	public void rejectOfferTest() {
		int intial = ed.viewOffers().size();
		ed.rejectOffer(4);
		int end = ed.viewOffers().size();
		assertTrue(intial == (end + 1));
	}
	
	@Test
	public void invalidRejectOfferTest() {
		int intial = ed.viewOffers().size();
		ed.rejectOffer(-1);
		int end = ed.viewOffers().size();
		assertTrue(intial == end);
	}
	
	@Test
	public void viewPaymentsTest() {
		assertTrue(ed.viewPayments().size() > 0);
	}
	
}
