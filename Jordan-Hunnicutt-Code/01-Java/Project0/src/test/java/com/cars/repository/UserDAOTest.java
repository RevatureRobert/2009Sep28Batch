package com.cars.repository;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cars.model.User;

public class UserDAOTest {

	private UserDAO ud;
	
	@Before
	public void setup() {
		ud = new UserDAO();
	}

	@Test
	public void allUsersTest() {
		List<User> users = ud.findAll();
		assertFalse(users.isEmpty());
	}
	
	
}
