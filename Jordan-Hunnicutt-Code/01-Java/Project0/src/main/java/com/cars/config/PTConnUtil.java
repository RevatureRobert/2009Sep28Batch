package com.cars.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PTConnUtil{

	//url for jdbc -> jdbc:postgresql://endpoint:port/dbName?currentSchema=schema
		//default schema is public, this can be changed
		private final String url="jdbc:postgresql://db-hunni-1.cbv4smezwjgv.us-east-2.rds.amazonaws.com:5432/hunni_db?currentSchema=p_0_schema";
		private final String username="p_0_user";
		private final String password="projectzero";
		//refer to DDL for the above information in dBeaver
		
		//to make a singleton
		private static PTConnUtil instance;

		private PTConnUtil() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public static PTConnUtil getInstance() {
			if(instance == null) {
				instance = new PTConnUtil();
			}
			return instance;
		}
		//to create a connection to the db
		public Connection getConnection() throws SQLException {		
			return DriverManager.getConnection(url, username, password);
		}
	
}
