package com.project0.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class EnvironmentConnectionUtil {
	final static Logger log = Logger.getLogger("EnvironmentConnectionUtil");														//currentSchema is optional,, default is public
	//url for jdbc -> jdbc:postgresql://endpoint:port/dbName?currentSchema=schema
	private final String url=System.getenv("url");
	private final String username =System.getenv("username");
	private final String password = System.getenv("password");	
	//for junit testing
//	private final String url="jdbc:postgresql://mydb1.ctqn1wf3ao57.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=project0";
//	private final String username ="dealer";
//	private final String password = "ship";	
	private static EnvironmentConnectionUtil instance;
	
	private EnvironmentConnectionUtil() {
		
		super();
		
	}
	
	//makes this a singleton
	public static EnvironmentConnectionUtil getInstance() {
		if(instance == null) {
			instance = new EnvironmentConnectionUtil();
		}
		return instance;
	}
	
	//to create a connection to the db
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	
	
	
}//end of class
