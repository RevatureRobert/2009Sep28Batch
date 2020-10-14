package com.autos.UI;

import com.autos.service.UsersService;
import com.autos.controller.validators.AccountCreationValidator;
import com.autos.models.User;

import java.util.HashMap;
import java.util.Scanner;

public class AccountCreationPage {

	public Scanner scanner = ScannerSingleton.getInstance().getScanner();
	private final UsersService uds = new UsersService();
	private final AccountCreationValidator acv = new AccountCreationValidator();
	
	public void createAccountInitialPrompt() {
		System.out.println("Select Type of Account To Create: ");
		System.out.println("(1) Customer Account");
		System.out.println("(2) Employee Account");
		System.out.println("(3) Manager Account");
		String accountType = scanner.nextLine();
		switch (accountType) {
			case "b": break;
			case "1":
				this.createAccountInformationGathering("Customer");
				break;
			case "2": {
				boolean validKey = false;
				while (true) {
					System.out.println("Enter Employee Account Creation Key: ");
					String key = scanner.nextLine();
					if (key.equals("b")) { break; }
					else if (key.equals("JordanBelfort")) {
						validKey = true;
						break;
					} else {
						System.out.println("Invalid Key");
						System.out.println("(1) Try Again");
						System.out.println("(any) Go Back");
						String response = scanner.nextLine();
						if (!response.equals("1")) {
							break;
						}
					}
				}
				if (validKey) this.createAccountInformationGathering("Employee");
				break;
			}
			case "3": {
				boolean validKey = false;
				while (true) {
					System.out.println("Enter Manager Account Creation Key: ");
					String key = scanner.nextLine();
					if (key.equals("b")) { break; }
					else if (key.equals("GordonGecko")) {
						validKey = true;
						break;
					} else {
						System.out.println("Invalid Key");
						System.out.println("(1) Try Again");
						System.out.println("(any) Go Back");
						String response = scanner.nextLine();
						if (!response.equals("1")) {
							break;
						}
					}
				}
				if (validKey) this.createAccountInformationGathering("Manager");
				break;
			}
			default:
				System.out.println("Invalid Input, Try Again");
				break;
		}
	}
	
	public void createAccountInformationGathering(String accountType) {
		String username, passw, passwconfirm;
		HashMap<String, String> userInfo = new HashMap<>();
		boolean goBack = false;
		while (true) {

			System.out.println("Create Username: ");
			username = scanner.nextLine();
			if (username.equals("b")) { goBack = true; break; }
			System.out.println("Create Password: ");
			passw = scanner.nextLine();
			if (passw.equals("b")) { goBack = true; break; }
			System.out.println("Confirm Password: ");
			passwconfirm = scanner.nextLine();
			if (passwconfirm.equals("b")) { goBack = true; break; }
			System.out.println("Please Wait, We're Validating Your Information");
			
			// validate account information, order matters
			String[] values = {username, passw, passwconfirm, accountType};
			userInfo = this.createHashMapOfUserInfo(values);
			String validationStatus = acv.validateAccountCreationInfo(userInfo);
			
			if (validationStatus.equals("Good To Go")) {
				break;
			} else {
				System.out.println(validationStatus);
				System.out.println("Try again or back to main menu?");
				System.out.println("(1) Try Again");
				System.out.println("(any) Back To Main Menu");
				String response = scanner.nextLine();
				if (!response.equals("1")){ goBack = true; break; }
			}

		}
		if (!goBack){
			System.out.println("Information Validated, Creating New Account");
			User u1 = this.generateUserObject(userInfo);
			uds.insertUser(u1);
		}

	}

	private HashMap<String, String> createHashMapOfUserInfo(String[] values){
		HashMap<String, String> userInfo = new HashMap<>();

		userInfo.put("username", values[0]);
		userInfo.put("password", values[1]);
		userInfo.put("password confirmation", values[2]);
		userInfo.put("accounttype", values[3]);

		return userInfo;
	}

	private User generateUserObject(HashMap<String, String> userInfo){
		return new User(userInfo.get("username"), userInfo.get("password"), userInfo.get("accounttype"));
	}

}
