package com.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.model.Toys;

@Repository
public interface ToyRepository extends JpaRepository<Toys, Integer> {
	
	public Toys save();
}
