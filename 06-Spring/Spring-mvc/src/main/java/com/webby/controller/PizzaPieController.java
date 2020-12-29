package com.webby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webby.model.PizzaPie;
import com.webby.service.PizzaPieService;

/**
 * Spring MVC -- what is the DispatcherServlet life cycle?
 * 
 * Crosscutting concern
 * 		If you need to update info and also log info about transactions, you can see what would output to the log
 */

@Controller
@CrossOrigin(origins={"http://localhost:3000*"}) // allows requests from this origin; * for wildcard
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

	@GetMapping("/pie")
	public @ResponseBody List<PizzaPie> getAll(){ // returns the response body that then gets returned as JSON
		return pps.findAll();
	}// If there's no ResponseBody annotation, it'll try to reference an actual view
}
