package com.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.web.model.Monster;

/**
 * Sessions
 * 		Server side user management
 * 			think of cookies, but for the server
 * */

public class SessionController {
	public void setSession(HttpServletRequest req, Monster m) {
		HttpSession session = req.getSession();
		session.setAttribute("Monester", m);
	}
	public Monster getSessionMonster(HttpServletRequest req) {
		return (Monster)req.getAttribute("monster");
	}
	public void invalidate(HttpServletRequest req) {
		req.getSession().invalidate();
	}
	
}
