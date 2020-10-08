package com.revature.service;

import java.util.List;

import com.revature.model.Bear;
import com.revature.repo.BearDao;

public class BearService {

	private BearDao bd;

	public BearService() {
		this(new BearDao());
	}
	
	private BearService(BearDao bd) {
		super();
		this.bd = bd;
	}
	
	public List<Bear> findAll(){
		return bd.findAll();
	}
	
}
