package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private String url = System.getenv("url");
	private String password = System.getenv("password");
	private String username = System.getenv("username");
	private static ConnectionUtil instance;
	
	{
		try {
			Class.forName("org.postgresql.Driver"); // driver check
			
			/*
			FileInputStream f = new FileInputStream("src/main/resources/connection.properties");
			Properties p = new Properties();
			
			p.load(f);
			
			username = p.getProperty("username");
			password = p.getProperty("password");
			url = p.getProperty("url");
			*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private ConnectionUtil() {}
	
	public static ConnectionUtil getInstance() {
//		if(!Optional.of(instance).isPresent()) { // Optional is just a wrapper that checks if null
		if(instance == null) {
			instance = new ConnectionUtil();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}