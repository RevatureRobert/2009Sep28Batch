package com.tester.numbers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.numbers.Calculator;
import com.example.numbers.Multiplier;

public class CalTest {

	final static Logger logger = Logger.getLogger(Calculator.class);
	
	static Calculator cal;
	
	static Multiplier m = Mockito.mock(Multiplier.class);
	
	@BeforeClass
	public static void beforeAll() {
		cal=new Calculator(m);
		System.out.println("=======before all=========");
	}
	@AfterClass
	public static void afterAll() {
		System.out.println("======after all=========");
	}
	@Before
	public void beforeTest() {
		System.out.println("==========before test=========");
	}
	@After
	public void afterTest() {
		System.out.println("==========after test=========");
	}
	@Test
	public void testAddition() {
		assertEquals(100, cal.sum(50,50));
	}
	@Test
	public void testMultiply() {
		Mockito.when(m.mult(10, 10)).thenReturn(100);
		Mockito.when(m.mult(4, 5)).thenReturn(20);
		assertEquals(100, cal.multiply(10,10));
		assertEquals(20, cal.multiply(4, 5));
		logger.info("this is a message");
	}
	
	@Test
	public void testBool() {
		assertFalse(cal.checkBool(false));
	}
	
	
}
