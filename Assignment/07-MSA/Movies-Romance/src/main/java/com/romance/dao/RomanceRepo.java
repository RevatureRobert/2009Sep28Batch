package com.romance.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.romance.model.Romance;

@Repository
public class RomanceRepo {
	
	List<Romance> movies;
	{
		movies=new ArrayList<>();
		movies.add(new Romance(1, "love force", 19));
		
	}
	
	public void save (Romance r) {
		movies.add(r);
	}
	
	public List<Romance> findAll(){
		return movies;
	}

}
