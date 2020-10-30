package com.reimbursement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private String username;
	private String password;
	private String url;
	
	private static DBConnector instance;
	
	{
		try {
			Class.forName("org.postgresql.Driver"); // driver check
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private DBConnector(String username, String password, String url) {
		this.username = username;
		this.password = password;
		this.url = url;
	}

	public static DBConnector getInstance() {
		if(instance == null) {
			/*
			try {
				Properties p = new Properties();
				p.load(new FileInputStream("src/main/resources/dbconnector.properties"));
				
				instance = new DBConnector(
					p.getProperty("username"),
					p.getProperty("password"),
					p.getProperty("url")
				);
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("dbconnector.properties file not found!\nCheck src/main/resources/ \n");
			}
			*/
			instance = new DBConnector(
				"reimb_client", "password",
				"jdbc:postgresql://database-1.c2fwjr2ekpz7.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=reimbursement_schema");
		}
		
		return instance;
	}
	
	
	
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
}
