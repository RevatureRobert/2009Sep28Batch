package com.carsales.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.carsales.model.Auto;

public class AutoDaoTest {
	
	private AutoDao ad;
	
	@Before
	public void setup() {
		ad = new AutoDao();
		ad.addAuto(new Auto(1990, "Honda", "Civic", 100, 1000));
	}
	
	@Test
	public void findAllTest() {
		List<Auto> autos = ad.getAllAuto();
		assertFalse(autos.size() == 0);
	}
	
	@Test
	public void AddAutoTest() {
		int value = ad.addAuto(new Auto(1990, "Honda", "Civic", 100, 1000));
		assertTrue(value == -1);
	}
	
}

