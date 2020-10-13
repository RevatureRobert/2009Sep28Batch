package com.carsales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.carsales.util.*;;

public class ConnectionUtil {
	
	
	
	private final String url = "jdbc:postgresql://mattdata.czgiz6yidnij.us-east-2.rds.amazonaws.com"
			+ ":5432/postgres?currentSchema=carlot_schema";
	private final String username = "postgres";
	private final String password = "password";

	private static ConnectionUtil instance;

	private ConnectionUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ConnectionUtil getInstance() {
		if (instance == null) {
			instance = new ConnectionUtil();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}
