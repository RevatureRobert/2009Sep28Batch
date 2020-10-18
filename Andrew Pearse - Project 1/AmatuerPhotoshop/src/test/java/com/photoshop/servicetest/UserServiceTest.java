package com.photoshop.servicetest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.photoshop.model.User;
import com.photoshop.service.UserService;

public class UserServiceTest {

	UserService us;
	
	@Before
	public void startup() {
		us = new UserService();
	}
	
	@Test
	public void testVerifyUserInTable() {
		assertTrue(us.verifyUser("andrew.roy.pearse@gmail.com", "password"));
	}
	
	@Test
	public void testVerifyUserNotInTable() {
		assertFalse(us.verifyUser("andrew.roy.pearse@gmail.com", "not my password"));
	}
}
