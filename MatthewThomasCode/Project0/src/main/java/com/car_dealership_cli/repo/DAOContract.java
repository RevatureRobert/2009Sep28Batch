package com.car_dealership_cli.repo;

import java.util.List;

/**
 * 
 * @author Matthew
 *
 * @param <T> Type of model
 * @param <I> Primary key for model
 * 
 * This will create a contract for all dao classes to follow
 */
public interface DAOContract<T,I> {
	
	List<T> findAll();
	
	T findById(I i);
	
	T update(T t);
	
	T create(T t);
	
	int delete(I i);
	
}