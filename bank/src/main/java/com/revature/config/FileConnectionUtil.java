package com.revature.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FileConnectionUtil {
	

	private String url;
	private String username;
	private String password;
	private static  FileConnectionUtil instance;
	
	public static FileConnectionUtil getInstance() {
		if(instance == null) {
			instance = new FileConnectionUtil();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	{
		try {
				FileInputStream f = new FileInputStream("src/main/resources/connection.properties");
				Properties p = new Properties();
				p.load(f);
				username=p.getProperty("username");
				password=p.getProperty("password");
				url=p.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
