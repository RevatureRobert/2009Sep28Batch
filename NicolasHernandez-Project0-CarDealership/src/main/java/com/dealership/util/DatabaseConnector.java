package com.dealership.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
	
	private String username;
	private String password;
	private String url;
	
	private static DatabaseConnector instance;
	
	private DatabaseConnector(String username, String password, String url) {
		this.username = username;
		this.password = password;
		this.url = url;
	}
	
	public static DatabaseConnector getInstance() {
		if(instance == null) {
			try {
				Properties p = new Properties();
				p.load(new FileInputStream("src/main/resources/dbconnector.properties"));
				
				instance = new DatabaseConnector(
					p.getProperty("username"),
					p.getProperty("password"),
					p.getProperty("url")
				);
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("dbconnector.properties file not found!\nCheck src/main/resources/ \n");
			}
		}
		
		return instance;
	}
	
	
	
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
}
