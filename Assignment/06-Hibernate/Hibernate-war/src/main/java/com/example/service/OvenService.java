package com.example.service;

import java.util.List;

import com.example.dao.OvenDao;
import com.example.model.Oven;

public class OvenService {
	
	private OvenDao od;

	public OvenService(OvenDao od) {
		this.od = od;
	}
	
	public OvenService() {
		this(new OvenDao());
	}
	
	
	public List<Oven> findAll(){
		return od.findAll();
	}
	
	
	
	

}
