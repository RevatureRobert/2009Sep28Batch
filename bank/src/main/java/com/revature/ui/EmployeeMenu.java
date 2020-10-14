package com.revature.ui;

import java.util.Scanner;

import com.revature.controller.EmployeeController;
import com.revature.controller.MiscController;
import com.revature.model.Transaction;
import com.revature.repo.AccountPendingDao;

public class EmployeeMenu {
	private EmployeeController ec = new EmployeeController();
	private AccountPendingDao apd = new AccountPendingDao();
	private MiscController mc = new MiscController();
	
	public EmployeeMenu() {
		super();
	}
	
	public EmployeeMenu(EmployeeController ec) {
		this.ec = ec;
	}
	
	public String employeeMenu(Scanner scan) {
		System.out.println("Please make a selection");
		System.out.println("1. View pending accounts");
		System.out.println("2. Approve pending account");
		System.out.println("3. View transaction logs");
		System.out.println("4. Remove all pending accounts with custom stored procedure");
		System.out.println("0. Return");
		int selection = scan.nextInt();
		switch(selection) {
		case 1:
			System.out.println(viewPendingAccounts(scan));
			break;
		case 2:
			System.out.println(approveAccount(scan));
			break;
		case 3:
			System.out.println(viewTransactionLogs(scan));
		case 4:
			mc.removePending();
		case 0:
			return null;
		default:
			System.out.println("Please choose a valid option!");
		}
		return employeeMenu(scan);
	}
	
	public String viewPendingAccounts(Scanner scan) {
		return ec.viewPendingAccount().toString();
	}
	
	public String approveAccount(Scanner scan) {
		System.out.println("Enter in the id of the pending account:");
		int pendingAccountID = scan.nextInt();
		return ec.approveAccount(apd.findById(pendingAccountID)).toString();
	}
	
	public String viewTransactionLogs(Scanner scan) {
		String withNewLines = "";
		for(Transaction transaction : ec.viewTransactionLogs()) {
			withNewLines = withNewLines.concat(transaction.toString());
			withNewLines = withNewLines.concat("\n");
		}
		return withNewLines;
	}
}
