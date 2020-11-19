package com.springy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springy.model.Toy;
import com.springy.repo.ToyRepo;

@RestController
@RequestMapping("/toy")
public class ToyController {
	
	@Autowired
	private ToyRepo tr;
	
	@GetMapping
	public List<Toy> getAll(){
		return tr.findByOrderByNameAsc();
	}
	
	@PostMapping
	public String insert(@RequestBody Toy t) {
		tr.save(t);
		return "inserted";
	}
	
	
	
	@GetMapping("/fluffy")
	public List<Toy>  findByFluffy(@RequestParam boolean fluffy){
		return tr.findByFluffy(fluffy);
	}
	
	@GetMapping("/restTemplate")
	public String goToGoogle() {
		String body = new RestTemplate().getForEntity("http://www.google.com", String.class).getBody();
		return body;
	}

}
