package com.example.service;

import java.util.List;

import com.example.dao.TurkeyDao;
import com.example.model.Turkey;

public class TurkeyService {
	
	private TurkeyDao td;

	public TurkeyService(TurkeyDao td) {
		super();
		this.td = td;
	}

	public TurkeyService() {
		this(new TurkeyDao());
	}

	public List<Turkey> findAll() {
		return td.findAll();
	}


}
