package com.project0.repo;

import java.util.List;

/**
 * 
 * @author Robert
 *
 * @param <T> Type of model
 * @param <I> Primary key for model
 * 
 *            this will create a contract for all dao classes to follow.
 */

public interface DaoContract<T, I> {

	List<T> findAll();

	T findById(I i);

	T update(T t);

	T create(T t);

	int delete(I i);

}
