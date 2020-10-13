package com.carsales.controller;

import java.util.List;

import com.carsales.dao.AutoDao;
import com.carsales.model.Auto;

public class AutoController {
	
	private AutoDao dd;
	
	public AutoController () {
		this(new AutoDao());
	}
	
	public AutoController(AutoDao autoDao) {
		super();
		this.dd = autoDao;
	}

	public List<Auto> getAutos()
	{
		return dd.getAllAuto();
	}
	
	public int addAuto(Auto auto) {
		return dd.addAuto(auto);
	}
	
	public int removeAuto(int id) {
		return dd.removeAuto(id);
	}
	
	public Auto getAutobyId(int id) {
		return dd.getAutoById(id);
	}
	
	public List<Auto> getAutobyOwner(String owner) {
		return dd.getAutoByOwner(owner);
	}
	
	
}
