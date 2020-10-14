package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.controller.MiscController;
import com.revature.model.AccountPending;
import com.revature.model.Customer;
import com.revature.model.Transaction;
import com.revature.repo.AccountPendingDao;

public class CallableTest {
	private AccountPendingDao apd;
	private MiscController mc;
	
	@Before
	public void setup() {
		apd = new AccountPendingDao();
		mc = new MiscController();
		apd.create(new AccountPending("checking", new Customer(1, "tucker", "fritz", "tf@gmail.com", "password")));
		apd.create(new AccountPending("checking", new Customer(1, "tucker", "fritz", "tf@gmail.com", "password")));
		apd.create(new AccountPending("checking", new Customer(1, "tucker", "fritz", "tf@gmail.com", "password")));

	}
	
	@Test
	public void removePending() {
		mc.removePending(); //remove all pending accounts
		List<AccountPending> accountsPending = apd.findAll(); //should return list of size 0
		assertEquals(accountsPending.size(), 0);
	}
	
}
