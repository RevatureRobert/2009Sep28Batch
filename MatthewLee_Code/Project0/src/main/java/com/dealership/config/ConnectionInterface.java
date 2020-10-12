package com.dealership.config;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionInterface {
	
	/**
	 * Connect to database
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException;
	
}
