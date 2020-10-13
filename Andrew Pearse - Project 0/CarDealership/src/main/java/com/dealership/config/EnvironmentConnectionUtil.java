package com.dealership.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EnvironmentConnectionUtil {

	private final String url = System.getenv("url");
	private final String username = System.getenv("username");
	private final String password = System.getenv("password");
	
	private static EnvironmentConnectionUtil instance;
	
	private EnvironmentConnectionUtil() {
		super();
	}
	
	public static EnvironmentConnectionUtil getInstance() {
		if(instance == null)
			instance = new EnvironmentConnectionUtil();
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
