package com.testing.dao;

import java.util.HashMap;
import java.util.Map;

import com.testing.model.User;

public class DaoInstance {

	Map<String, User> users = new HashMap<>();
	
	{
		User u = new User("mike", "wasspord", 77);
		User u2 = new User("sarah", "p4ssw0rd", 33);
		User u3 = new User("harry", "something", 88);
		users.put(u.getUsername(), u);
		users.put(u2.getUsername(), u2);
		users.put(u3.getUsername(), u3);
	}
	
	public User findByUsername(String username) {
		return null;
	}
}
