package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtil {
	
	
	private static PlainTextConnectionUtil instance;
	
	//url for jdbc -> jdbc:postgresql://endpoint:port/dbname?currentSchema=schema
//	deaulft schema is public, this can be changed
	private final String url="jdbc:postgresql://orr-revature.ce4gqsgkvzew.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=jdbc_schema";
	private final String username="jdbc_worker";
	private final String password="wasspord";
	
	private PlainTextConnectionUtil() {
		super();
	}
	
	public static PlainTextConnectionUtil getInstance() {
		if(instance == null) {
			instance = new PlainTextConnectionUtil();
		}
		return instance;
	}
	//to create a connection to the db
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
