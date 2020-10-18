package com.photoshop.repotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import com.photoshop.model.Reimbursement;
import com.photoshop.model.ReimbursementStatus;
import com.photoshop.model.ReimbursementType;
import com.photoshop.model.User;
import com.photoshop.model.UserRole;
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
		assertEquals(3, ud.findAll().size());
	}

	@Test
	public void findByIdUserNotNull() {
		assertNotNull(ud.findById(2));
	}
	
//	@Test
//	public void findByIdUserEqualsMyUsername() {
//		assertEquals("arpearse", ud.findById(2).getUsername());
//	}
	
	@Test
	public void createUserEqualsZero() {
		assertEquals(0, ud.create(new User(0, "sbeve", "123", "Steve", "FromMinecraft", "steve_fromminecraft@mojang.com", new UserRole(1, ""))));
	}
	
	@Test
	public void updateIncorrectUserReturnsZero() {
		assertEquals(0, ud.update(new User(0, null, null, null, null, null, new UserRole(0, null))));
	}
	
	@Test
	public void updateCorrectUserReturnsOne() {
		assertEquals(1, ud.update(ud.findById(2)));
	}
	
//	@Test
//	public void verifyUserInformation() {
//		User user = ud.findById(2);
//		user.setPassword("password");
//		assertTrue(ud.verifyUser(user));
//	}
	
	@Test
	public void findAllTestReimbursementIsNotEmpty() {
		assertTrue(!rd.findAll().isEmpty());
	}
	
	@Test
	public void findAllTestReimbursementHasNumberOfEntries() {
		assertEquals(1, rd.findAll().size());
	}

	@Test
	public void findByIdReimbursementNotNull() {
		assertNotNull(rd.findById(4));
	}
	
	@Test
	public void findByIdReimbursementEqualsMyAuthor() {
		assertEquals(2, rd.findById(4).getAuthor().getId());
	}
	
//	@Test
//	public void createReimbursementEqualsZero() {
//		assertEquals(0, rd.create(new Reimbursement(0, 300f, new Timestamp(System.currentTimeMillis()), null, "Photoshop bill", 
//									"https://project1receipts.s3.us-east-2.amazonaws.com/ARP+Photoshop+Bill.png", 
//									new User(2, null, null, null, null, null, null), null, new ReimbursementStatus(1, null), 
//									new ReimbursementType(4, null))));
//	}
	
	@Test
	public void updateIncorrectReimbursementReturnsZero() {
		Reimbursement r = rd.findById(4);
		r.setId(0);
		r.setResolver(ud.findById(2));
		assertEquals(0, rd.update(r));
	}
	
}
