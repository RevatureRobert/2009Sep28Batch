package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil 
{
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	private String url = "jdbc:postgresql://dawitdatabase2.c9nhssljfmjz.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=Project1";
	private String password = "IloveGod!1991";
	private String username = "blackmamba24";
	private static ConnectionUtil instance;
	private ConnectionUtil() {}
	public static ConnectionUtil getInstance() 
	{
		if(instance == null)
		{
			instance = new ConnectionUtil();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username, password);
	}
}
