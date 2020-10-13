package com.project0.repo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.project0.model.Bid;

public class BidDaoTest {
	private BidDao bd;

	@Before
	public void setup() {
		bd = new BidDao();
	}

	@Test
	public void findByIdTest() {
		Bid b = bd.findById(1);
		assertNotNull(b);
	}
}
