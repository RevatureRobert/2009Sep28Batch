package com.project0.repo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project0.model.Customer;

public class CustomerDaoTest {
	private CustomerDao cd;

	@Before
	public void setup() {
		cd = new CustomerDao();
	}

	@Test
	public void findAllTest() {
		List<Customer> customers = cd.findAll();
		assertFalse(customers.size() == 0);
	}

	@Test
	public void findByIdTest() {
		Customer c = cd.findById(1);
		assertNotNull(c);
	}
}
