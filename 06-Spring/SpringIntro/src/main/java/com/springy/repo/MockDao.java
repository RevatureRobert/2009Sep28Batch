package com.springy.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class MockDao {
	public Map<String, Integer> getAllVotes(){
		Map<String, Integer> votes = new HashMap<>();
		
		// all these are in a table, and we're going to a DB to get this info ...
		votes.put("florida", 5);
		votes.put("texas", 9);
		votes.put("california", 4);
		
		return votes;
	}
}
