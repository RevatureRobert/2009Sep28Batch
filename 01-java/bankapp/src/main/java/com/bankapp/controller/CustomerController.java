package com.bankapp.controller;

import java.util.List;

import com.bankapp.model.Users;
import com.bankapp.service.CustomerService;

public class CustomerController {
	private CustomerService cs;

	public CustomerController() {
		this(new CustomerService());
	}

	public CustomerController(CustomerService cs) {
		super();
		this.cs = cs;
	}

	public List<Users> findAll() {
		return cs.findAll();
	}
	public String insert(Users c) {
		try {
			Users result = cs.update(c);
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
