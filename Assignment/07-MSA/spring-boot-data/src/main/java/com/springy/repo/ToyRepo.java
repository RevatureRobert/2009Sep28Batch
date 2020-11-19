package com.springy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springy.model.Toy;


/**
 * 
 * This is spring data. Spring data will provide us with
 * 		the interfaces for performing our sql operations
 * 		and working with our orm (hibernate). It does a few things
 * 		for us. 
 * 			#1 it provides us with interfaces
 * 			for the basic sql queries and a few others
 * 			#2 it provides functionality for generating unwritten methods
 * 			with sql queries based on the names of the custom names provided. 
 * 
 *
 */

@Repository
public interface ToyRepo extends JpaRepository<Toy, Integer> {
	
	List<Toy> findByFluffy(boolean fluffy);
	
	List<Toy> findByFluffyAndName(boolean fluffy, String name);
	
	List<Toy> findByOrderByNameAsc();
	

}
