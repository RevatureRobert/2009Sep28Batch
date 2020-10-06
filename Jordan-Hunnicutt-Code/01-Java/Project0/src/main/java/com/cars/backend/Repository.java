package com.cars.backend;
/*
 * 		layers of project 0
 * 			UI
 * 				Gather input from the user
 * 				Display information to the user
 * 				Get actions from the user (I want to put an offer on a car)
 * 			Controller
 * 				Gather information from the UI
 * 				Use the data to communicate with service layer
 * 				Send information back to the UI
 * 				Send information to the Service layer
 * 			Service
 * 				Gather information from the Repository
 * 				Use the data to perform logic with the controller
 * 				Send information to the controller
 * 				Send information to the repository layer
 * 			Repository
 * 				Gather information from the service layer
 * 				Communicate with the database
 * 				send and gather information to/from the db
 * 
 * 			Model (accessible throughout) (what does the data look like? the other layers are about dataflow, this is about the actual data)
 * 				Provide classes meant to represent real world objects
 */
public class Repository {

	public static void lotRepo() {	//gets relevant cars from the database, sends the results back down
		
		System.out.println("I'm in lot repo");
		
	}
	
	
	
}
