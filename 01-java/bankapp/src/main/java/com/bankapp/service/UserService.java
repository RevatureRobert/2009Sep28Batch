package com.bankapp.service;

import com.bankapp.model.Users;
import com.bankapp.repo.UsersDao;

public class UserService {
	private UsersDao ud;

	public UserService() {
		this(new UsersDao());
	}

	public UserService(UsersDao ud) {
		super();
		this.ud = ud;
	}
	
	public Users create(Users u) throws Exception {
		Users result = ud.create(u);
		if(result == null) {
			throw new Exception("the user was not created");
		}
		return result;
	}
}
