package com.revature.controller;

import java.util.List;

import com.revature.model.Account;
import com.revature.model.AccountPending;
import com.revature.model.Transaction;
import com.revature.service.EmployeeService;

public class EmployeeController {
	private EmployeeService es = new EmployeeService();
	
	
	public EmployeeController() {
		super();
	}


	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}

	public Account approveAccount(AccountPending ap) {
		return es.approveAccount(ap);
	}
	
	public List<Transaction> viewTransactionLogs() {
		return es.viewTransactionLogs();
	}
	
	public List<AccountPending> viewPendingAccount() {
		return es.viewPendingAccounts();
	}
}
