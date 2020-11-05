package com.example.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.OvenController;
import com.example.controller.TurkeyController;

public class RequestForwarder {
	
	public void data(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		switch(req.getRequestURI()) {
		case "/Hibernate-war/all.json":
			System.out.println("got to the request forwarder all.json");
			new OvenController().findAll(req, resp);
			break;
		case "/Hibernate-war/turkeys.json":
			System.out.println("Got to the request forwarder: turkey.json");
			new TurkeyController().findAll(req,resp);
		}
	}
	
	
}
