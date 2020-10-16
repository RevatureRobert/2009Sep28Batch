package com.revature.controller;

import com.revature.model.Circus;
import com.revature.service.CircusService;

public class CircusController {
	private CircusService cs;
	
	public CircusController() {
		this(new CircusService());
	}

	public CircusController(CircusService cs) {
		super();
		this.cs = cs;
	}
	
	public String insert(Circus c) {
		try {
			Circus result = cs.create(c);
			return result.toString();
		} catch(Exception e) {
			return e.getMessage();
		}
	}
}
