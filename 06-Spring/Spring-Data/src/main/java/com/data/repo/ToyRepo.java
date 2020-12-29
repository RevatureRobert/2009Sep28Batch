package com.data.repo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.data.model.Toys;

@Repository
public class ToyRepo {
	@Autowired
	private SessionFactory sessfact;
	
	public void save(Toys t) {
		
	}
}
