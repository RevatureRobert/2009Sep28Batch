package com.revature.repo;

import java.util.List;
/**
 * 
 * @author Revature
 *
 * @param <T> Type of model
 * @param <I> Primary key for model
 * 
 * This will create a contract for all dao classes to follow. (Data as object)
 */
public interface DaoContract<T, I> { //names can be ambiguous, but you want names to be indicative for the the next person
/**
 * 
 * @return A list of all instances in the db
 */
	List<T> findAll();
	/**
	 * 
	 * @param i primary key of instance
	 * @return instance with same primary key
	 */
	T findById(I i);
	/**
	 * 
	 * @param t the instance to update
	 * @return the updated instance
	 */
	T update(T t);
	/**
	 * 
	 * @param t the instance to create
	 * @return the created instance
	 */
	T create(T t);
	/**
	 * 
	 * @param i the primmary key of the instance to be removed
	 * @return how many were removed [0 if failure, 1 if success]
	 */
	int delete(I i);
}
