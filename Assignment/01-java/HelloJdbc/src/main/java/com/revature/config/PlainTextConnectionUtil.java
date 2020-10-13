package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtil {
															//currentSchema is optional,, default is public
	//url for jdbc -> jdbc:postgresql://endpoint:port/dbName?currentSchema=schema
	private final String url="jdbc:postgresql://mydb1.ctqn1wf3ao57.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=jdbc_schema";
	private final String username ="jdbc_user";
	private final String password = "wasspord";
	
	private static PlainTextConnectionUtil instance;
	
	private PlainTextConnectionUtil() {
		
		super();
		
	}
	
	//makes this a singleton
	public static PlainTextConnectionUtil getInstance() {
		if(instance == null) {
			instance = new PlainTextConnectionUtil();
		}
		return instance;
	}
	
	//to create a connection to the db
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	
	
	
}//end of class
