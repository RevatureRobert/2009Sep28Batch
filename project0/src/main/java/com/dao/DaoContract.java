package com.dao;

import java.util.List;

/* 
 *  T is the model or instance
 *  I is the primary key
 */

public interface DaoContract <T, I>
{
/*
 * Pass in the primary key of the instance as a parameter
 * Return the instance with the same primary key as the parameter	
 */
	
T findById(I i);


/*
 *  Return a list of all the instances 
 */

List <T> findAll();


/*
 *  Pass in the instance to create
 *  Return the created instance
 */

T create(T t);

/* 
 *  Pass in the instance to update
 *  Return the updated instance
 */

T update(T t);

/*
 *  Pass in the primary key of the instance to delete
 *  Return the number instances deleted (0 for failure, 1 for success)
 */

int delete(T t);

}
