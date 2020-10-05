package com.present.hashset;

import java.util.ArrayList;
import java.util.List;

public class HashSet<T> {
	
	private List<Double> hashHolder = new ArrayList<>();
	private List<T> hashObjects = new ArrayList<>();
	private double hashCode;
	
	HashSet(){
			super();
	}
	
	private double generateHashCode() {			
		hashCode = Math.random();	
		return hashCode;
	}
	
	public double getHashCode(T o) {		
		if (hashObjects.contains(o)) {
			int objInd = hashObjects.indexOf(o);
			return hashHolder.get(objInd);
		} else {
			System.out.println("Object not found");
		}
		
		return 0;
	}
	
	public void addTo(T o){
		boolean dupeCheck = checkForDuplicates(o);
		if(dupeCheck) {
			System.out.println("Duplicate item, not added");
		}else {
			hashObjects.add(o);
			hashHolder.add(generateHashCode());
		}
	}
	
	public void remove(T o) {
		if (hashObjects.contains(o)) {
			int objInd = hashObjects.indexOf(o);
			hashObjects.remove(objInd);
			hashHolder.remove(objInd);
			System.out.println("Object removed.");
		} else {
			System.out.println("Object not found");
		}
		
	}
	
	public List<Double> getHashArray() {
		return hashHolder;
	}
	
	public List<T> getHashObjects() {		
		return hashObjects;
	}
	
	private boolean checkForDuplicates(T o) {	
		return hashObjects.contains(o);		
	}
	
	
}
