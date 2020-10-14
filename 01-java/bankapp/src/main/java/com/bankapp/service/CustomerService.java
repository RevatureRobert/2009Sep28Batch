package com.bankapp.service;

import java.util.List;

import com.bankapp.model.Users;
import com.bankapp.repo.UsersDao;

public class CustomerService {
	private UsersDao ud;

	public CustomerService() {
		this(new UsersDao());
	}

	public CustomerService(UsersDao ud) {
		super();
		this.ud = ud;
	}
	
	public List<Users> findAll(){
		return ud.findAll();
 	}
	
	public Users update(Users u) throws Exception {
		Users result = ud.update(u);
		if(result == null) {
			throw new Exception("the user was not changed");
		}
		return result;
	}
}
