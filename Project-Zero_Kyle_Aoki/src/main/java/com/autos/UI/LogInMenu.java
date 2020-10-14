package com.autos.UI;

import com.autos.UI.dashboards.Selector;
import com.autos.UI.dashboards.UserContext;
import com.autos.controller.validators.LogInValidator;

import java.util.Scanner;

public class LogInMenu {

	public Scanner scanner = ScannerSingleton.getInstance().getScanner();
	private final LogInValidator liv = new LogInValidator();
	
	public void logIn() {

		boolean successfulLogIn = false;
		String username;
		String password;

		logIn:
		while (true) {

			System.out.println("Enter Username: ");
			username = scanner.nextLine();
			if (username.equals("b")) break;

			System.out.println("Enter Password: ");
			password = scanner.nextLine();
			if (password.equals("b")) break;

			if (liv.validate(username, password)) {
				successfulLogIn = true;
				System.out.println("Log In Attempt Successful");
				break;
			} else {
				System.out.println("Log In Attempt Failed");
			}

			while (true) {
				System.out.println("(1) Try Again, or Enter (b) to Go Back");
				String response = scanner.nextLine();
				if (response.equals("b")) { break logIn; }
				else if (response.equals("1")) break;
			}

		}

		if (successfulLogIn) {
			UserContext.setUser(username);
			Selector selector = new Selector();
			selector.enterDashboard(username, true);
		}
	}


}
