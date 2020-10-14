package com.revature.service;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountPending;
import com.revature.model.Transaction;
import com.revature.repo.AccountDao;
import com.revature.repo.AccountPendingDao;
import com.revature.repo.TransactionDao;

public class EmployeeService {
	private TransactionDao td = new TransactionDao();
	private AccountDao ad = new AccountDao();
	private AccountPendingDao apd = new AccountPendingDao();
	
	
	//TODO: ensure deletion of accountPending object from database
	public Account approveAccount(AccountPending ap) {
		apd.delete(ap.getAccountPendingID()); //delete from account_pending table
		//insert previous pending account into accounts table
		int accountNumber = (int)(Math.random()*10000) + 1;
		while(ad.findById(accountNumber) != null) { //checks to ensure accountNumber doesn't already exists
			accountNumber = (int)(Math.random()*10000) + 1; //create unique account number
		}
		return ad.create(new Account(((int)(Math.random()*10000) + 1), ap.getAccountType(),  (float)0.00, ap.getCustomerID()));
	}
	
	public List<Transaction> viewTransactionLogs() {
		return td.findAll();
	}
	
	public List<AccountPending> viewPendingAccounts() {
		return apd.findAll();
	}
	
	//TODO BONUS: LET EMPLOYEES APPROVE LOANS
}
