package com.bankapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.bankapp.config.PlainTextConnectionUtil;        

public class PlainTextConnectionUtil {
	// url for jdbc -> jdbc:postgresql://host:port/dbName?currentSchema=schema
		// default schema is public, this can be changed
		private final String url = "jdbc:postgresql://my2009db.ccvyk1j1maonx.us-east-2.rds.amazonaws.com:5432/postgres";
		private final String username = "bank_user";
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
