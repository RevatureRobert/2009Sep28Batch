package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//this a singleton for testability purposes. easier to unit test than all static
public class PlainTextConnectionUtil {
	//url for jdbc -> jdbc:postgresql://endpoint:port/dbName?currentSchema=schema
	//default schema is public, this can be changed
	private final String url="jdbc:postgresql://db-hunni-1.cbv4smezwjgv.us-east-2.rds.amazonaws.com:5432/hunni_db?currentSchema=jdbc_db_schema";
	private final String username="jdbc_db_user";
	private final String password="wasspord";
	//refer to DDL for the above information in dBeaver
	
	//to make a singleton
	private static PlainTextConnectionUtil instance;

	private PlainTextConnectionUtil() {
		super();
		// TODO Auto-generated constructor stub
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
