package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Monster;
import com.web.service.MonsterService;

public class MonsterDataController {
	private MonsterService ms;
	
	// This constructor exists so you can pass in a mocked MonsterService object
	public MonsterDataController(MonsterService ms) {
		super();
		this.ms = ms;
	}
	public MonsterDataController() {
		this(new MonsterService());
	}
	
	public void sendAllData(HttpServletResponse res) {
		res.setContentType("text/json");
		
		List<Monster> monsters = ms.findAll();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(monsters));
		} catch (IOException e) {
			
		}// installed postman to check the responses...
	}
}
