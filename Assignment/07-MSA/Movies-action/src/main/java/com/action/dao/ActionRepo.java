package com.action.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.action.model.Action;



@Repository
public class ActionRepo {
	
	private List<Action> movies;
	{
		movies = new ArrayList<>();
		movies.add(new Action(1, "Pizza Action",  15));
		movies.add(new Action(2, "action force", 7));
		movies.add(new Action(3, "action the movie part 9", 18));
	}
	
	public List<Action> findAll() {
		return movies;
	}
	
	public void save(Action r) {
		movies.add(r);
	}

}