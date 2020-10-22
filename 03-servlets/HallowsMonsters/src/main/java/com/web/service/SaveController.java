package com.web.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Monster;

public class SaveController {

	private MonsterService ms;
	private MonsterTypeService mts;

	public SaveController() {
		this(new MonsterService(), new MonsterTypeService());
	}

	public SaveController(MonsterService ms, MonsterTypeService mts) {
		super();
		this.ms = ms;
		this.mts = mts;
	}

	public void save(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			Monster m = new ObjectMapper().readValue(req.getInputStream(), Monster.class);
			int typeResult = mts.save(m.getType());

			int monResult = ms.save(m);
			res.getWriter().println("the monster is added");
		} catch (IOException e) {
			e.printStackTrace();
			res.getWriter().println("something went wrong");
		}

	}

}
