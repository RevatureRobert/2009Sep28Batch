package com.revature.service;

import java.util.List;

import com.revature.model.Bear;
import com.revature.repo.BearDao;
import com.revature.repo.CircusDao;

public class BearService {
	
	private BearDao bd;
	
	public BearService() {
		this(new BearDao(new CircusDao()));
	}
	
	

	public BearService(BearDao bearDao) {
		bd = bearDao;
	}



	public BearDao getBd() {
		return bd;
	}

	public void setBd(BearDao bd) {
		this.bd = bd;
	}
	
	public List<Bear> findAll(){
		return bd.findAll();
	}
}
