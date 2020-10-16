package com.photoshop.repotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.photoshop.repo.ReimbursementDao;
import com.photoshop.repo.UserDao;

public class DaoTest {

	private UserDao ud;
	private ReimbursementDao rd;
	
	@Before
	public void startup() {
		ud = new UserDao();
		rd = new ReimbursementDao();
	}
	
	@Test
	public void findAllTestUserIsNotEmpty() {
		assertTrue(!ud.findAll().isEmpty());
	}
	
	@Test
	public void findAllTestUserHasNumberOfEntries() {
		assertEquals(2, ud.findAll().size());
	}

	@Test
	public void findByIdUserNotNull() {
		assertNotNull(ud.findById(2));
	}
	
	@Test
	public void findByIdUserEqualsMyUsername() {
		assertEquals("arpearse", ud.findById(2).getUsername());
	}
}
