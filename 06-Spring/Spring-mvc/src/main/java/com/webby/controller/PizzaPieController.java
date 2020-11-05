package com.webby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webby.model.PizzaPie;
import com.webby.service.PizzaPieService;

@Controller
@RequestMapping("/pizza.app")
public class PizzaPieController {

	private PizzaPieService pps;

	public PizzaPieService getPps() {
		return pps;
	}

	@Autowired
	public void setPps(PizzaPieService pps) {
		this.pps = pps;
	}

	@GetMapping
	public @ResponseBody List<PizzaPie> getAll() {
		return pps.findAll();
	}

}
