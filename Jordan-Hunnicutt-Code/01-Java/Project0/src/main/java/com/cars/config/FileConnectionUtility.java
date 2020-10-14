package com.cars.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author Revature
 * 
 * Code is directly lifted from HelloJDBC project. This is how we will get the database information
 *
 */
public class FileConnectionUtility{ //safer than plaintext, properties located in one central location outside of java. still not encrypted though
	
	private String url;
	private String username;
	private String password;
	private static FileConnectionUtility instance;
	
	private FileConnectionUtility() {
		
	}
	

	public static FileConnectionUtility getInstance() { //this makes it so there's only one instance of this class
		if (instance == null) {
			instance = new FileConnectionUtility();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	{//instance block, happens once per instance
		try {
			FileInputStream f = new FileInputStream("src/main/resources/connection.properties");
			Properties p = new Properties();
			p.load(f);
			username=p.getProperty("username");
			password=p.getProperty("password");
			url=p.getProperty("url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
