package com.revature.repo;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.revature.model.Bear;

public class BearDaoTest {
	private BearDao bd;
	@Before
	public void setup() {
		bd=new BearDao(null);
	}
	@Test
	public void findAllTest() {
		List<Bear> bears = bd.findAll();
		assertFalse(bears.size()==0);
	}
	@Test
	public void findByIdTest() {
		Bear b = bd.findById(1);
		assertNotNull(b);
	}
}
