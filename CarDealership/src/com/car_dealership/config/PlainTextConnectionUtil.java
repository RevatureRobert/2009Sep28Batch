package com.car_dealership.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtil {
	private final String url = "jdbc:postgresql://jkburlison96-db.c79gzmrtwuut.us-east-2.rds.amazonaws.com"
			+ ":5432/postgres?currentSchema=car_dealership_schema";
	private final String username = "jdbc_worker";
	private final String password = "workersPassword";

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
