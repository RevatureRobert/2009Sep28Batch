package com.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Monster;
import com.web.service.MonsterService;
import com.web.service.MonsterTypeService;

public class SaveController {
	
	private MonsterService ms;
	private MonsterTypeService mts;
	public SaveController(MonsterService ms, MonsterTypeService mts) {
		super();
		this.ms = ms;
		this.mts = mts;
	}
	public SaveController() {
		this(new MonsterService(), new MonsterTypeService());
	}
	
	
	public void save(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			Monster m = new ObjectMapper().readValue(req.getInputStream(),Monster.class);
			int monResult = ms.save(m);
			int typeResult = mts.save(m.getType());
			res.getWriter().println("the monster is added");
		} catch (IOException e) {
			res.getWriter().println("The monster was not added, something went wrong");
			e.printStackTrace();
		}
	}
	
}
