package com.cardealership.repo;

import org.junit.Test;
import com.cardealership.model.Admin;
import com.cardealership.model.Employee;

import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DealershipDaoTest {
	
	static Logger logger = LogManager.getLogger(DealershipDaoTest.class);

	
	AdminDao ad;
	DealershipDao dd;
	@Before
	public void setup() {
		dd = new DealershipDao();
		ad = new AdminDao();
	}
	@Test
	public void viewLotTest() {
		Admin t = ad.findById(2);
		dd.viewLot(t);
	}
	@Test
	public void deleteCarTest() {
		System.out.println(dd.removeCar(20));
	}
	@Test
	public void updateCarTest() {
		System.out.println(dd.updateCar(20, "tester", 321));
	}
	@Test
	public void loggerTest() {
		logger.info("Car sold for " + 40000);
	}
}
