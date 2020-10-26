package com.mytest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dao.EmployeeDao;

public class ERATest 
{
	EmployeeDao ed = new EmployeeDao();
	
	@Test
	public void idUserNameMatch()
	{
		assertEquals(2, ed.findUserIDByUserName("FounderJones"));
	}
	
	
}
