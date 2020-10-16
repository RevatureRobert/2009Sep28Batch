package com.web.service;

import com.web.model.Monster;
import com.web.repo.DaoContract;
import com.web.repo.MonsterDao;

public class MonsterService {
	private DaoContract<Monster, Integer> mdao;

	public MonsterService() {
		this(new MonsterDao());
	}
	
	public MonsterService(DaoContract<Monster, Integer> mdao) {
		super();
		this.mdao = mdao;
	}
	
	
	public Monster findByName(String name) {
		return mdao.findByName(name);
	}
}
