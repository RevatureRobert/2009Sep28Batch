package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.MonsterController;
import com.web.controller.MonsterDataController;
<<<<<<< HEAD
import com.web.controller.SaveController;
||||||| 9817e6de
=======
import com.web.service.SaveController;
>>>>>>> 9ca05587b685d91cfb74715f39a948bd3cfb10b7

public class RequestForwarder {

	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/HallowsMonsters/login.page":
			return new MonsterController().login(req);
		default:
			return "html/landing.html";
		}
	}
<<<<<<< HEAD
	
	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
||||||| 9817e6de
	
	public void data(HttpServletRequest req, HttpServletResponse res) {
		switch(req.getRequestURI()) {
=======

	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch (req.getRequestURI()) {
>>>>>>> 9ca05587b685d91cfb74715f39a948bd3cfb10b7
		case "/HallowsMonsters/all.json":
			new MonsterDataController().sendAllData(res);
			break;
		case "/HallowsMonsters/monster.json":
			new SaveController().save(req, res);
			break;
		}
	}
}
