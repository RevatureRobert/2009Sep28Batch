package com.project0.repo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project0.model.Car;

public class CarDaoTest {
	private CarDao cd;

	@Before
	public void setup() {
		cd = new CarDao();
	}

	@Test
	public void findAllTest() {
		List<Car> cars = cd.findAll();
		assertFalse(cars.size() == 0);
	}

	@Test
	public void findByIdTest() {
		Car c = cd.findById(1);
		assertNotNull(c);
	}

}
