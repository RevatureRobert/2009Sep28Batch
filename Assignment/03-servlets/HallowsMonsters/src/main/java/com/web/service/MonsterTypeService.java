package com.web.service;

import com.web.model.MonsterType;
import com.web.repo.DaoContract;
import com.web.repo.MonsterTypeDao;

public class MonsterTypeService {
	
	private DaoContract<MonsterType,Integer> mtd;

	public MonsterTypeService(DaoContract<MonsterType, Integer> mtd) {
		super();
		this.mtd = mtd;
	}
	
	public MonsterTypeService() {
		this(new MonsterTypeDao());
		// TODO Auto-generated constructor stub
	}

	public int save (MonsterType t) {
		return mtd.create(t);
	}

}
