package com.cars.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class EnvConnUtil{

	private final String url = System.getenv("url"); //values stored under run as, run configuration, java, driver, environment
	private final String username = System.getenv("username");
	private final String password = System.getenv("password");
	private static EnvConnUtil instance;
	
	private EnvConnUtil() {
		
	}
	
	public static EnvConnUtil getInstance() { //this makes it so there's only one instance of this class
		if (instance == null) {
			instance = new EnvConnUtil();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	
}
