package com.car_dealership_cli.repo;

import java.sql.Connection;

import java.sql.SQLException;

import com.car_dealership_cli.config.FileConnectionsUtil;

public class DAOUtilities {


	//jdbc:postgresql://endpoint:port/dbName?currentSchema=schema

	static FileConnectionsUtil fc = FileConnectionsUtil.getInstance();
	private static Connection connection;
	
	public static synchronized Connection getConnection(){
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			}catch(ClassNotFoundException e){
				System.out.println("Could not register driver");
				e.printStackTrace();
			}
			try {
				connection = fc.getConnection();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		try {
			if (connection.isClosed()) {
				System.out.println("Opening new connection...");
				try {
					connection = fc.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
}
