package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.ImageController;
import com.web.controller.MonsterController;
import com.web.controller.MonsterDataController;

public class RequestForwarder {

	private ImageController ic;

	
	//this determines the routes that we'll be making. 
	//every time we add functionality we'll add a route. 
	
	public void routes(HttpServletRequest req, HttpServletResponse resp) {
		//req.getRequestURT(); // gives the portion of the url after the main hallows_monster/
		try {
			switch(req.getRequestURI()){
			case "/HallowsMonsters/login.page":
				req.getRequestDispatcher(new MonsterController().login(req)).forward(req, resp);
				break;
			case "/HallowsMonsters/addimage.page":
				req.getRequestDispatcher(new ImageController().addImage(req)).forward(req, resp);
				break;
			case "/HallowsMonsters/getimage.page":
				ic = new ImageController();
				ic.getImage(req, resp);
				break;
			case "/HallowsMonsters/session.page":
				req.getRequestDispatcher(new MonsterController().getSessionMonster(req)).forward(req, resp);
				break;
			default:
				req.getRequestDispatcher("html/landing.html").forward(req, resp);
				break;
				
			}
			
		} catch(ServletException | IOException e) {
			e.printStackTrace();
		} 
	}//end of routes method
	
	public void data(HttpServletRequest req, HttpServletResponse resp) {
		switch(req.getRequestURI()) {
		case "/HallowsMonsters/all.json":
			new MonsterDataController().sendAllData(resp);
		}
	}
}
