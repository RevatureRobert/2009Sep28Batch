package com.revature.service;

import com.revature.model.Circus;
import com.revature.repo.CircusDao;

public class CircusService {
	private CircusDao cd;
	
	public CircusService() {
		this(new CircusDao());
	}
	
	public CircusService(CircusDao cd) {
		super();
		this.cd = cd;
	}
	
	public Circus create(Circus c) throws Exception {
		Circus result = cd.create(c);
		if(result == null) {
			throw new Exception("the circus was not created");
		}
		
		return result;
	}
}
