package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.MonsterController;
import com.web.controller.MonsterDataController;
import com.web.controller.SaveController;

public class RequestForwarder {
	
	
	public String routes(HttpServletRequest req) {
		String s = req.getRequestURI(); // portion of the url that says /HallowsMonsters/stuff.otherstuff/morestuff...
		
		switch (s) {
		case "/HallowsMonsters/login.page":
			// typically don't want to do this;
			// login calls a MonsterService object that isn't instantiated using the
			// default MonsterController() constructor.
			return new MonsterController().login(req);
		default:
				return "html/landing.html";
		}
	}
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/HallowsMonsters/all.json":
			new MonsterDataController().sendAllData(res);
			break;
		case "/HallowsMonsters/monster.json":
			new SaveController().save(req, res);
			break;
		}
	}
}
