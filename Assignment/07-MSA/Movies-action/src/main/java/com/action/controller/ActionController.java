package com.action.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.action.dao.ActionRepo;
import com.action.model.Action;


@RestController
@RequestMapping("/action")
public class ActionController {
	@Autowired
	private ActionRepo ar;
	
	@GetMapping
	public List<Action> findAll(){
		return ar.findAll();
	}
	
	@PostMapping
	public String save(@RequestBody Action h) {
		ar.save(h);
		return "saved";
	}
}
