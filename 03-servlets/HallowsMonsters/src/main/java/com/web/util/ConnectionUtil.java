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
	
	private String url = System.getenv("url");
	private String password = System.getenv("password");
	private String username = System.getenv("username");
	private static ConnectionUtil instance;
	
	private ConnectionUtil() {}
	
	public static ConnectionUtil getInstance() {
//		if(!Optional.of(instance).isPresent()) { // Optional is just a wrapper that checks if null
		if(instance == null) {
			instance = new ConnectionUtil();
		}
		
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
