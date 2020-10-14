package com.bankapp.controller;

import java.util.List;

import com.bankapp.model.Users;
import com.bankapp.service.UserService;

public class UsersController {
	private UserService us;

	public UsersController() {
		this(new UserService());
	}

	public UsersController(UserService us) {
		super();
		this.us = us;
	}

	public List<Users> findAll() {
		return us.findAll();
	}
	public String insert(Users c) {
		try {
			Users result = us.create(c);
			return result.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
