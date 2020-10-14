package com.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtil {
	
	private final String url = "jdbc:postgresql://carlo-db-instance.cfrkice9i0us.us-east-1.rds.amazonaws.com"
			+ ":5432/myDatabase?currentSchema=carDealership";
	private final String username = "cardealer";
	private final String password = "password";
	
	// to make a singleton
	private static PlainTextConnectionUtil instance;

	private PlainTextConnectionUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static PlainTextConnectionUtil getInstance() {
		if (instance == null) {
			instance = new PlainTextConnectionUtil();
		}
		return instance;
	}

	// to create a connection to the db
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}