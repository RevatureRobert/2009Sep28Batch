package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Turkey;
import com.example.service.TurkeyService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TurkeyController {
	
	private TurkeyService ts;

	public TurkeyController(TurkeyService ts) {
		super();
		this.ts = ts;
	}
	
	public TurkeyController() {
		this(new TurkeyService());
	}

	public void findAll(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json");
		List<Turkey> turkeys = ts.findAll();
		System.out.println("Got to 2 for turkeys");
		System.out.println(turkeys);
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(turkeys));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
