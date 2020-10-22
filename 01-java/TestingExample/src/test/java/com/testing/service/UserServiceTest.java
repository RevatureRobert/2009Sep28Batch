package com.testing.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.testing.dao.DaoInstance;
import com.testing.model.User;

public class UserServiceTest {

	
	UserService us;
	DaoInstance dao;
	
	@Before
	public void setup() {
		dao = Mockito.mock(DaoInstance.class);
		us = new UserService(dao);
	}
	
	@Test
	public void testCheckCreds() {
		Mockito.when(dao.findByUsername("sarah")).thenReturn(new User("sarah","p4ssw0rd",0));
		boolean b1 = us.checkCreds("sarah", "p4ssw0rd");
		assertTrue(b1);
	}
}
