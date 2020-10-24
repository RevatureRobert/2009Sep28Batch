
package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionUtil {
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	private String url = System.getenv("url");
//	private String password = System.getenv("password");
//	private String username = System.getenv("username");
	private String url = "jdbc:postgresql://orr-revature.ce4gqsgkvzew.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=hallows_monster";
	private String password = "wasspord";
	private String username = "jdbc_worker";
	private static ConnectionUtil instance;

	private ConnectionUtil() {
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