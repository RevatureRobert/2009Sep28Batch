package com.service;


import com.dao.FinanceManagerDao;
import com.model.FinanceManager;

public class FinanceManagerService 
{

	FinanceManagerDao fmdao;
	
	public FinanceManagerService(FinanceManagerDao financeManagerDao) {
		super();
		this.fmdao = financeManagerDao;
	}

	public FinanceManagerService() {
		this(new FinanceManagerDao());
	}
	
	public FinanceManager findById(int user_id)
	{
		return fmdao.findById(user_id);
	}
	
	
}
