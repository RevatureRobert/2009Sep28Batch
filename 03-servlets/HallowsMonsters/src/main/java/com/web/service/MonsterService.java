package com.web.service;

import java.util.List;

import com.web.model.Monster;
import com.web.repo.DaoContract;
import com.web.repo.MonsterDao;

public class MonsterService {

	private DaoContract<Monster, Integer> mdao;

	public MonsterService(DaoContract<Monster, Integer> mdao) {
		super();
		this.mdao = mdao;
	}

	public MonsterService() {
		this(new MonsterDao());
	}
	
	public Monster findByName(String name) {
		return mdao.findByName(name);
	}
	
	public List<Monster> findAll(){
		return mdao.findAll();
	}
	
	public int save(Monster t) {
		return mdao.create(t);
	}
}
