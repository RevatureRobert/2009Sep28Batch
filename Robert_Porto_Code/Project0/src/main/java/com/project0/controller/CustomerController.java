package com.project0.controller;

import java.util.List;

import com.project0.model.Customer;
import com.project0.service.CustomerService;

public class CustomerController {
	private CustomerService cs;

	public CustomerController() {
		this(new CustomerService());
	}

	public CustomerController(CustomerService cs) {
		super();
		this.cs = cs;
	}

	public List<Customer> findAll() {
		return cs.findAll();
	}

	public Customer findByLogin(String name, String password) {
		return cs.findByLogin(name, password);
	}

	public Customer newCustomer(Customer customer) {
		return cs.newCustomer(customer);
	}
}
