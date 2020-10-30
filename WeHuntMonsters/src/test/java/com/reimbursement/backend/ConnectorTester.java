package com.reimbursement.backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.reimbursement.util.DBConnector;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConnectorTester {
	
	@Test
	public void A_getsDBAuthenticationProperties() {
		DBConnector connector = DBConnector.getInstance();
		
		assertNotNull(connector);
	}
	
	@Test
	public void B_authenticatesConnection() {
		boolean authenticates = false;
		
		try (Connection conn = DBConnector.getInstance().getConnection()){
			authenticates = true;
		} catch (SQLException e) { e.printStackTrace(); }
		
		assertTrue(authenticates);
	}
}
