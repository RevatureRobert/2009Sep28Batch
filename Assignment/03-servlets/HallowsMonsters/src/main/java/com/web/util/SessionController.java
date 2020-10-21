package com.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.web.model.Monster;

/*
 * sessions
 * 
 * 		server side user management
 * 				think of cookies but for the server. 
 * 		you can store whatever inside the session, objects, ints, etc.
 * 		We stored the monster object inside the session, as a session attribute. 
 * 	
 * 
 * create a route that will get the monster out of the session and print it out. Have a button that goes to controller that prints out the session/validates the session. 
 */
public class SessionController {
	
	public void setSession(HttpServletRequest req, Monster m) {
		HttpSession session = req.getSession();
		System.out.println("This got here");
		session.setAttribute("monster", m);
	}
	
	public Monster getSessionMonster(HttpServletRequest req) {
		return (Monster)req.getSession().getAttribute("monster");
	}
	
	public void invalidate(HttpServletRequest req) {
		req.getSession().invalidate();
	}

}
