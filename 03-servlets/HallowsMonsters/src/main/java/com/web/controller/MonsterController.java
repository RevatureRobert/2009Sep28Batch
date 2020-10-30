package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.model.Monster;
import com.web.service.MonsterService;

public class MonsterController {
	private MonsterService ms;
	
	public MonsterController(MonsterService ms){
		super();
		this.ms = ms;
	}
	
	public MonsterController() {
		this(new MonsterService());
	}
	
	public String login(HttpServletRequest req) {
		String monsterName = req.getParameter("name");
		Monster m = ms.findByName(monsterName);
		
		// If the monster exists, we'll go to the monster html page
//		if(Optional.of(m).isPresent())
		
		// deviates from master branch because ms.findByName never returns null, just empty Monster objects
		if(m.getName() != null)
			return "html/monster.html";
		
		// If the monster doesn't exist, go back to the landing page
		return "html/landing.html";
	}
}