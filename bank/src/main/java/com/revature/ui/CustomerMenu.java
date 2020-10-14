package com.revature.ui;

import java.util.Scanner;

import com.revature.controller.CustomerController;
import com.revature.model.Account;
import com.revature.model.AccountPending;
import com.revature.model.Customer;
import com.revature.repo.AccountDao;
import com.revature.repo.CustomerDao;

public class CustomerMenu {
	private CustomerController cc = new CustomerController();
	private AccountDao ad = new AccountDao();
	private CustomerDao cd = new CustomerDao();
	private int customerID;
	
	public CustomerMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerMenu( Customer c) {
		super();
		this.customerID = c.getCustomerID();
	}
	
	public String customerMenu(Scanner scan) {
		System.out.println("Please make a selection");
		System.out.println("1. View list of your accounts");
		System.out.println("2. Withdraw from account");
		System.out.println("3. Deposit into an account");
		System.out.println("4. Transfer money between accounts");
		System.out.println("5. Set up banking account");
		System.out.println("0. Return");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println(viewAccounts(scan));
			break;
		case 2:
			System.out.println(withdrawFromAccount(scan));
			break;
		case 3:
			System.out.println(depositToAccount(scan));
			break;
		case 4:
			System.out.println(transferBetweenAccounts(scan));
			break;
		case 5:
			System.out.println(registerAccount(scan));
			break;
		case 0:
			return null;
		default:
			System.out.println("Please make a valid selection :)");
		}
		return customerMenu(scan);
	}
	
	public String viewAccounts(Scanner scan) {
		String withNewLine = "";
		for(Account a : cc.accountInfo(customerID)) {
			withNewLine = withNewLine.concat(a.toString() + "\n");
		}
		return withNewLine;
	}
	
	public String registerAccount(Scanner scan) {
		System.out.println("Enter 1 for checking or 2 for savings");
		int choice = scan.nextInt();
		String input = "";
		if(choice == 1) {
			input = "checking";
		}
		else if(choice == 2) {
			input = "saving";
		}
		else {
			System.out.println("Invalid input");
			return null;
		}
		//return cc.registerAccount(new AccountPending(choice, this.customerID).toString();
		return cc.registerAccount(new AccountPending(input, cd.findById(customerID))).toString();
	}
	
	public String withdrawFromAccount(Scanner scan) {
		System.out.println("Please enter account number of the account you want to withdraw from:");
		int acctNum = scan.nextInt();
		System.out.println("Please enter amount that you want to withdraw");
		float amount= scan.nextFloat();
		System.out.println("Withdrawing " + amount + " from account#" + acctNum);
		try {
			Account a = ad.findById(acctNum);
			if(a != null && a.getCustomerID().getCustomerID() == this.customerID) {
				return cc.withdrawMoney(ad.findById(acctNum), amount).toString();
			}
			else {
				System.out.println("Invalid account number or permissions.");
			}
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Cannot withdraw that amount");
		}
		return null;
	}
	
	public String depositToAccount(Scanner scan) {
		System.out.println("Please enter account number of the account you want to deposit to:");
		int acctNum = scan.nextInt();
		System.out.println("Please enter amount that you want to deposit");
		float amount= scan.nextFloat();
		System.out.println("Depositing " + amount + " to account#" + acctNum);
		try {
			Account a = ad.findById(acctNum);
			if(a != null && a.getCustomerID().getCustomerID() == this.customerID) { 
			return cc.depositMoney(ad.findById(acctNum), amount).toString();
			}
			else {
				System.out.println("Invalid account number or permissions.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String transferBetweenAccounts(Scanner scan) {
		System.out.println("Please enter account number of the account you want to transfer from:");
		int acctNum1 = scan.nextInt();
		System.out.println("Please enter account number of the account you want to deposit to:");
		int acctNum2 = scan.nextInt();
		System.out.println("Please enter amount that you want to transfer");
		float amount= scan.nextFloat();
		System.out.println("Depositing " + amount + " to account#" + acctNum2 + " from account " + acctNum1);
		try {
			Account a = ad.findById(acctNum1);
			Account b = ad.findById(acctNum2);
			if(a != null && b != null && a.getCustomerID().getCustomerID() == this.customerID) {
				return cc.moneyTransfer(ad.findById(acctNum1), ad.findById(acctNum2), amount).toString();
			}
			else {
				System.out.println("One of the account numbers were invalid or invalid permissions.");
			}
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Cannot transfer that amount");
		}
		return null;
	}
}
