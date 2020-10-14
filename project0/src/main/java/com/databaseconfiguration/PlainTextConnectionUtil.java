package com.databaseconfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtil 
{
	private final String url = "jdbc:postgresql://project0.cdyups40a2es.us-west-1.rds.amazonaws.com:5432/postgres";
	
	private final String username = "postgres";
	
	private final String password = "IloveGod!1991";
	
	// To make a Singleton
	private static PlainTextConnectionUtil instance;

	public PlainTextConnectionUtil() {
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
