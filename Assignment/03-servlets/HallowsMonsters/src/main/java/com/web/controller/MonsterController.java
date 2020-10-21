package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.web.model.Monster;
import com.web.service.MonsterService;
import com.web.util.SessionController;

public class MonsterController {
	
	private MonsterService ms;
	private SessionController sc;

	public MonsterController(MonsterService ms, SessionController sc) {
		super();
		this.ms = ms;
		this.sc = sc;
	}

	public MonsterController() {
		this(new MonsterService(), new SessionController());
	}
	
	public String getSessionMonster(HttpServletRequest req) {
		Monster m = sc.getSessionMonster(req);
		if(m!= null) {
			System.out.println("the session monster is still alive, he is: "+ m.getName());
			return "html/monster.html";
		} else {
			return "doesn't work";
		}
	}
	
	
	public String login(HttpServletRequest req) {
		String monsterName = req.getParameter("name");
		Monster m = ms.findByName(monsterName);
		if(m!=null) {
			sc.setSession(req, m);
			return "html/monster.html";
		} else {
			return "html/landing.html";
		}
	}

}
