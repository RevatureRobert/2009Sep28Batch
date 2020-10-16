package com.revature.repo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Bear;

public class BearDaoTest {
	private BearDao bd;
	
	// typically want to test against a test db ...
	// typically want to test edge cases ...
	
	@Before
	public void setup() {
		bd = new BearDao(null);
	}
	
	@Test
	public void findAllTest() {
		List<Bear> bears = bd.findAll();
		assertFalse(bears.size() == 0);
	}
	
	@Test
	public void findByIdTest() {
		Bear b = bd.findById(1);
		assertNotNull(b);
	}
}
