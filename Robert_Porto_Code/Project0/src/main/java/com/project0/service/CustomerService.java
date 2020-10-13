package com.project0.service;

import java.util.List;

import com.project0.model.Customer;
import com.project0.repo.CustomerDao;

public class CustomerService {
	private CustomerDao cd;

	public CustomerService(CustomerDao cd) {
		super();
		this.cd = cd;

	}

	public CustomerService() {
		this(new CustomerDao());

	}

	public List<Customer> findAll() {
		return cd.findAll();
	}

	public Customer findByLogin(String name, String password) {
		return cd.findByLogin(name, password);
	}

	public Customer newCustomer(Customer customer) {
		return cd.newCustomer(customer);
	}
}
