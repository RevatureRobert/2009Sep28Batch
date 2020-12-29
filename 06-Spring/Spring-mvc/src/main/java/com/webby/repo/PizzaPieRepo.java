package com.webby.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.webby.model.PizzaPie;

@Repository
public class PizzaPieRepo {
	List<PizzaPie> pizzaPies;
	
	{
		pizzaPies = new LinkedList<PizzaPie>();
		pizzaPies.add(new PizzaPie(null, "gross", 12, true));
		pizzaPies.add(new PizzaPie(null, "deep dish", 28, false));
	}
	
	public List<PizzaPie> findAll(){
		return pizzaPies;
	}
}
