package com.dealership.frontend;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dealership.dao.DealershipDAO;
import com.dealership.dao.DealershipMasterDAO;
import com.dealership.pojos.User;
import com.dealership.util.DatabaseConnector;

public class UtlitiesTester {
	
	DealershipDAO dao;
	
	@Before
	public void authenticateConnection() {
		try(Connection conn = DatabaseConnector.getInstance().getConnection()){}
		catch(SQLException e) {};
		
		dao = new DealershipMasterDAO();
	}
	
	@After
	public void closeResources() {
		dao.closeAllConnections();
	}
	
	@Test
	public void userDataTest() {
		User test = dao.getUserData("test");
		System.out.println(test.getColloquialName());
		
		String name = "TEST MAN";
		
		assertEquals(name, test.getColloquialName());
	}
	
	@Test
	public void usernameExistence() {
		assertEquals(true, dao.doesUsernameExist("rconnell"));
	}
	
	@Test
	public void usernameNonexistence() {
		assertEquals(false, dao.doesUsernameExist("unused"));
	}
	
	@Test
	public void colloquialNaming() {
		assertEquals("Robert Connell", dao.getNameForUser("rconnell"));
	}
	
	// Password hasher checked against results from https://onlinemd5.com
	@Test
	public void passwordHashTest() {
		String hash = "5F4DCC3B5AA765D61D8327DEB882CF99".toLowerCase();
		assertEquals(hash, Utilities.hashPassword("password"));
	}
	
	@Test
	public void passwordCapitalizedHashTest() {
		String hash = "C885F95378960CE5130D325335D94EDF".toLowerCase();
		assertEquals(hash, Utilities.hashPassword("Spongebob"));
	}
	
	@Test
	public void passwordWithNumbersHashTest() {
		String hash = "B29B9CCA99E14AFCD1BC2301373A3AF5".toLowerCase();
		assertEquals(hash, Utilities.hashPassword("L337sp34K"));
	}
	
	@Test
	public void passwordPhraseHashTest() {
		String hash = "9E107D9D372BB6826BD81D3542A419D6".toLowerCase();
		assertEquals(hash, Utilities.hashPassword("The quick brown fox jumps over the lazy dog"));
	}
	
	@Test
	public void passwordSpecialCharactersTest() {
		String hash = "B28252D021A7B1F84A345393C3CC2CEC".toLowerCase();
		assertEquals(hash, Utilities.hashPassword("D4M4G3$!"));
	}
}
