package com.revature.repo;

import java.util.List;

/**
 * @author Alex
 * 
 * @param <T> type of model
 * @param <I> primary key for model
 * 
 * this will crea a contract for all dao classes to follow
 * 
 * */

public interface DaoContract<T, I> {
	
	/**
	 * @param i primary key of the instance
	 *@return the instance with the same pk 
	 */
	List<T> findAll();
	/**
	 * 
	 *@param t instance to update
	 *@return the updated instance 
	 */
	T findById(I i);
	/**
	 *@param t the instance to update
	 *@return the updated instance
	 *
	 **/
	T update(T t);
	/**
	 *@param t the instance to create
	 *@return the updated created
	 *
	 **/
	T create(T t);
	/**
	 *@param i the primary key of the instance to be removed
	 *@return return how many were removed;
	 **/
	int delete(I i);
}
