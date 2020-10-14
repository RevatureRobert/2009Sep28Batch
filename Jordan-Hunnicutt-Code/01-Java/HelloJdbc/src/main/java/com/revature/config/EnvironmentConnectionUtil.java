package com.revature.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class EnvironmentConnectionUtil {

	private final String url = System.getenv("url"); //values stored under run as, run configuration, java, driver, environment
	private final String username = System.getenv("username");
	private final String password = System.getenv("password");
	private static EnvironmentConnectionUtil instance;
	
	private EnvironmentConnectionUtil() {
		
	}
	
	public static EnvironmentConnectionUtil getInstance() { //this makes it so there's only one instance of this class
		if (instance == null) {
			instance = new EnvironmentConnectionUtil();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	

	
}
