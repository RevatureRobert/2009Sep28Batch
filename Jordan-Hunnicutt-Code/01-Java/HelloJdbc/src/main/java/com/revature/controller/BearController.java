package com.revature.controller;

import java.util.List;

import com.revature.model.Bear;
import com.revature.service.BearService;

public class BearController {

	private BearService bs;
	
	public BearController() {
		this(new BearService());
	}
	
	public BearController(BearService bs) {
		super();
		this.bs = bs;
	}
	
	public List<Bear> findAll(){
		return bs.findAll();
	}
	
}
