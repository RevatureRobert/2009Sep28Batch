package com.project.repository;

import org.junit.Before;
import org.junit.Test;

public class UtilDAOTest {

	private DAOUtil du;
	@Before
	public void setup() {
		du = new DAOUtil();
	}
	
	@Test
	public void clearOffersTest() {
		du.callClearOffers(-1);
	}
	
}
