package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtil {
// url for jdbc -> jdbc:postgresql://host:port/dbName?currentSchema=schema
	// default schema is public, this can be changed
	private final String url = "jdbc:postgresql://postgresql-class.cks98gmxels6.us-west-1.rds.amazonaws.com"
			+ ":5432/postgres?currentSchema=jdbc_schema";
	private final String username = "jdbc_worker";
	private final String password = "wasspord";

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
