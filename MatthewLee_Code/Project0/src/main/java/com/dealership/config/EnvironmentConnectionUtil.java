package com.dealership.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EnvironmentConnectionUtil implements ConnectionInterface {
	
	private final String url = System.getenv("URL");
	private final String username = System.getenv("USERNAME");
	private final String password = System.getenv("PASSWORD");
	
	private static EnvironmentConnectionUtil instance;

	private EnvironmentConnectionUtil() {
		super();
	}
	
	public static EnvironmentConnectionUtil getInstance() {
		if (instance == null) {
			instance = new EnvironmentConnectionUtil();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}