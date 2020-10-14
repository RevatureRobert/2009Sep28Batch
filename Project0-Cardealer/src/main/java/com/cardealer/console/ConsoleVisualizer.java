package com.cardealer.console;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.*;

import com.cardealer.config.RDBConnection;
import com.cardealer.model.*;


public class ConsoleVisualizer {
	static Scanner sc;
	static Account CurrentAccount;
	
	private static final Logger logger = Logger.getLogger(ConsoleVisualizer.class);
	
	
	private static Connection RDB;
	
	public static void shutDown() {
		logger.info("Application Closing");
		System.out.println("Exiting Program");
		sc.close();
		try {
			RDB.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, SQLException {
		logger.info("Application Started");
		RDB = RDBConnection.CreateRDBConnection(logger);
		
		//Database fails causes program stop
		if(RDB == null) {
			logger.warn("Failed to connect to database. Exiting program...");
			logger.info("Application Closing");
			System.out.println("Exiting program");
			return;
		}
		
		
		sc = new Scanner(System.in);
		
		MainMenu mm = new MainMenu(logger, sc);
		
		int response = mm.logInMenu();
		
		//System.out.println(test.toString());
		//Account was logged into
		
		if(response == 1) {
			CurrentAccount = mm.returnCurrent();
			System.out.println("Hello " + CurrentAccount.getFullName());
			if(CurrentAccount.isAdminPrivilages()) {
				AdminMenu admin = new AdminMenu(logger, sc, CurrentAccount);
				admin.adminMenu();
			}
			else {
				CustomerMenu cust = new CustomerMenu(logger, sc, CurrentAccount);
				cust.userMenu();
			}
			

		}
		else {
			shutDown();
			return;
		}
		shutDown();
		return;
	}

}
