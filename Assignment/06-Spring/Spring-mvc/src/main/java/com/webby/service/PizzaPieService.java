package com.webby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webby.model.PizzaPie;
import com.webby.repo.PizzaPieRepo;

@Service
public class PizzaPieService {
	private PizzaPieRepo ppr;
	
	public PizzaPieRepo getPpr() {
		return ppr;
	}
	
	@Autowired
	public void setPpr(PizzaPieRepo ppr) {
		this.ppr = ppr;
	}
	
	public List<PizzaPie> findAll(){
		return ppr.findAll();
	}
}
