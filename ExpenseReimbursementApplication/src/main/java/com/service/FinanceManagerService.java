package com.service;

import com.dao.DaoContract;
import com.dao.FinanceManagerDao;
import com.model.FinanceManager;

public class FinanceManagerService 
{
	private DaoContract <FinanceManager, Integer> fmdao;

	public FinanceManagerService(DaoContract<FinanceManager, Integer> fmdao) {
		super();
		this.fmdao = fmdao;
	}

	public FinanceManagerService() {
		this(new FinanceManagerDao());
	}
	
	public FinanceManager findById(int user_id)
	{
		return fmdao.findById(user_id);
	}
}
