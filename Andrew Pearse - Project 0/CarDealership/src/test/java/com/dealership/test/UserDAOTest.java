package com.dealership.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dealership.models.User;
import com.dealership.repository.UserDAO;

public class UserDAOTest {

	private UserDAO ud;
	
	@Before
	public void setup() {
		ud = new UserDAO();
	}
	
	@Test
	public void findAllUsersTest() {
		List<User> users = ud.findAll();
		
		assertTrue(users.size() != 0);
	}
	
	@Test
	public void findRealUserByUsername() {
		assertNotNull(ud.findById("arpearse"));
	}
	
	@Test
	public void findFakeUserByUsername() {
		assertNull(ud.findById("mario"));
	}
	
	@Test
	public void updateExistingUsersPassword() {
		User user = ud.findById("bestemp");
		user.setPassword("tuesday");
		
		assertEquals(user.getPassword(), ud.update(new User("bestemp", "tuesday", "Bruh", "Moment", "customer")).getPassword());
	}
	
	@Test
	public void createUserTest() {
		User user = new User("test", "floop", "Ya", "Boi", "customer");
		
		assertNotNull(ud.create(user));
	}

	@Test
	public void deleteUserTest() {
		assertEquals(1, ud.delete("test"));
	}
}
