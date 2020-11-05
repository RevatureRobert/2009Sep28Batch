package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Oven;
import com.example.service.OvenService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OvenController {
	
	private OvenService os;

	public OvenController(OvenService os) {
		this.os = os;
	}
	
	public OvenController() {
		this(new OvenService());
	}
	
	public void findAll(HttpServletRequest req, HttpServletResponse resp){
		resp.setContentType("text/json");
		List<Oven> ovens = os.findAll();
		System.out.println("Got to 2");
		System.out.println(ovens);
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(ovens));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
