package com.revature.controller;

import java.util.List;

import com.revature.model.Bear;
import com.revature.repo.BearDao;
import com.revature.repo.CircusDao;

public class BearService {
	private BearDao bd;
	
	public BearService() {
		this(new BearDao(new CircusDao()));
	}
	
	public BearService(BearDao dao) {
		super();
		this.bd = dao;
	}
	
	public List<Bear> findAll(){
		return bd.findAll();
	}
}
