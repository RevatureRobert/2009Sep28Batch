package com.cars.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlainTextConnectionUtility {
	
	private final String url="";
	private final String username="";
	private final String password="";
	
	
	private static PlainTextConnectionUtility inst;
	
	private PlainTextConnectionUtility() {
		super();
	}
	
	public static PlainTextConnectionUtility getInstance() {
		if(inst == null) {
			inst = new PlainTextConnectionUtility();
		}
		return inst;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
}
