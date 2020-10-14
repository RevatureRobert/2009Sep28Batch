package com.cardealership.repo;

import org.junit.Test;

import com.cardealership.model.Admin;
import com.cardealership.model.Customer;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class CustomerDaoTest {
	private CustomerDao cd;
	@Before
	public void setup() {
		cd = new CustomerDao();
	}
	@Test
	public void findAllTest() {
		List<Customer> customers = cd.findAll();
		System.out.println(customers.get(0).toString());
		assertFalse(customers.size()==0);
	}
	@Test
	public void findByIdTest() {
		Customer customer = cd.findById(1);
		System.out.println(customer.toString());
	}
	@Test
	public void updateCustomerTest() {
		Customer customer = cd.findById(1);
		customer.setUserLastName("Moneybags");
		if(cd.update(customer) == null) {
			System.out.println("No changes made.");
		}
		System.out.println(cd.findById(1).toString());
	}
	@Test
	public void createCustomer() {
		String userName = "testcustomer";
		String password = "password";
		String fname = "Bob";
		String lname = "Builder";
		String email = "Builder@hotmail.com";
		Customer cust = cd.create(userName, password, fname, lname, email);
		System.out.println(cust.toString());
	}
	@Test
	public void deleteAdminTest() {
		int i = cd.delete(20);
		System.out.println(i);
	}
	@Test
	public void getMyCarsTest() {
		System.out.println(cd.myCars(16).toString());
	}
}
