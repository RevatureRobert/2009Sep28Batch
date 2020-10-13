package com.revature.repo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UtilDaoTest {
	private DaoUtil du;
	
	@Before
	public void setup() {
		du = new DaoUtil();
	}
	@Test
	public void concatSumTest() {
		String r = du.callConcatSum(5, 5, "stringy");
		assertEquals("10stringy",r);
	}
	
	@Test
	public void prepareConcatSumTest() {
		String r = du.prepareConcatSum(5, 5, "stringy");
		assertEquals("10stringy",r);
	}
}
