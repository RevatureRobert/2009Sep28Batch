package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountPending;
import com.revature.model.Transaction;
import com.revature.repo.AccountDao;
import com.revature.repo.AccountPendingDao;
import com.revature.repo.TransactionDao;

public class CustomerService {
	private AccountDao ad = new AccountDao();
	private TransactionDao td = new TransactionDao();
	private AccountPendingDao apd = new AccountPendingDao();
	
	//function for user to register for an account
	public AccountPending registerAccount(AccountPending a) {
		return apd.create(a);
	}
	
	//Fetches all accounts for a given customer so account info can be displayed to customer
	public List<Account> accountInfo(int customerID) {
		return ad.findAccountsByCustomerId(customerID);
	}
	
	//Deposits money given from argument 2 into account from argument 1
	public Account depositMoney(Account a, float amount) {
		float currentBalance = a.getBalance(); //get current balance
		currentBalance += amount;			   //add amount to current balance
		a.setBalance(currentBalance);          //set the new balance
		//Since this is a deposit, accountFrom is N/A, -1 is a stand in for null, handled in the create function
		Transaction depositTransaction = new Transaction("deposit", -1, a.getAccountID(), amount, a.getCustomerID());
		td.create(depositTransaction);
		return ad.update(a);	//push updated account balance to database
	}
	
	//Withdraw the amount given in argument 2 from the account given in argument 1
	public Account withdrawMoney(Account a, float amount) throws Exception {
		float currentBalance = a.getBalance(); //get current balance
		currentBalance -= amount;			   //subtract amount from current balance
		if(currentBalance < 0) {			   //check that transaction is possible
			throw new Exception("Cannot withdraw that amount."); //system rejects invalid transactions
		}
		else { //transaction is accepted
			a.setBalance(currentBalance);
			Transaction withdrawTransaction = new Transaction("withdraw", a.getAccountID(), -1, amount, a.getCustomerID());
			td.create(withdrawTransaction);
			return ad.update(a); //update account balance
		}
	}
	
	//Transfers the amount in argument 3 from account a to account b
	public List<Account> moneyTransfer(Account a, Account b, float amount) throws Exception {
		List<Account> accounts = new ArrayList<>();
		float balanceA = a.getBalance();
		float balanceB = b.getBalance();
		balanceA -= amount;
		balanceB += amount;
		if(balanceA < 0) {
			throw new Exception("Cannot transfer that amount"); //system rejects invalid transactions
		}
		a.setBalance(balanceA); //update balance for account a
		b.setBalance(balanceB); //update balance for account b
		accounts.add(ad.update(a));		  //update both accounts to database
		accounts.add(ad.update(b));
		Transaction transferTransaction = new Transaction("transfer", a.getAccountID(), b.getAccountID(), amount, a.getCustomerID());
		td.create(transferTransaction);
		return accounts;				  //return info for both updated accounts
	}
	
	//TODO BONUS: LET CUSTOMER TAKE OUT A LOAN
	
	//TODO BONUS: LET CUSTOMER MAKE PAYMENTS ON A LOAN
}
