package com.dealership.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.dealership.service.UserService;

public class UserServiceTest {

	UserService us;
	
	@Before
	public void setup() {
		us = new UserService();
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
