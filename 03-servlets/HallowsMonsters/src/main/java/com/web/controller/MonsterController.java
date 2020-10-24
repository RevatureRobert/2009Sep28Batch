package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.model.Monster;
import com.web.service.MonsterService;

public class MonsterController {

	private MonsterService ms;

	public MonsterController(MonsterService ms) {
		super();
		this.ms = ms;
	}

	public MonsterController() {
		this(new MonsterService());
	}
	
	public String login(HttpServletRequest req) {
		String monsterName = req.getParameter("name");
		Monster m = ms.findByName(monsterName);
		if(m != null) {
			return "html/monster.html";
		} else {
			return "html/landing.html";
		}
	}
}
