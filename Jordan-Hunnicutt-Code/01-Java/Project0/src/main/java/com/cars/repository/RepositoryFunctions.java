package com.cars.repository;

import java.util.List;

public interface RepositoryFunctions<T, I> {

//	public static void lotRepo() {	//gets relevant cars from the database, sends the results back down
//		
//		System.out.println("I'm in lot repo");
//		
//	}
//	
//	public static void registerRepo(User user) {
//		System.out.println("User added to repository");
//	}
//	
//	public static void connectToDB() {
//		
//	}
	
	List<T> findAll();
	
	T findById(I i);
	
	T update(T t);
	
	T create(T t);
	
	int delete(I i);
	
}
