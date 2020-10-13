package com.carsales.controller;

import java.util.List;

import com.carsales.dao.TestDao;
import com.carsales.model.Testcl;


public class TestController {

	private TestDao yr;

	public TestController() {
		this(new TestDao());
	}

	public TestController(TestDao td) {
		super();
		this.yr = td;
	}
	
	public List<Testcl> findAll(){
		return yr.findAll();
 	}
}
