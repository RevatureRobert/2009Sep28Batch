package com.revature.controller;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountPending;
import com.revature.service.CustomerService;

public class CustomerController {
	private CustomerService cs;
	
	public CustomerController() {
		this.cs = new CustomerService();
	}
	
	public CustomerController(CustomerService cs) {
		this.cs = cs;
	}
	
	public AccountPending registerAccount(AccountPending a) {
		return cs.registerAccount(a);
	}
	
	public List<Account> accountInfo(int customerID) {
		return cs.accountInfo(customerID);
	}
	
	public Account depositMoney(Account a, float amount) {
		return cs.depositMoney(a, amount);
	}
	
	public Account withdrawMoney(Account a, float amount) throws Exception {
		return cs.withdrawMoney(a, amount);
	}
	
	public List<Account> moneyTransfer(Account a, Account b, float amount) throws Exception {
		return cs.moneyTransfer(a, b, amount);
	}
}
