package com.inter.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class MockLinkedHashSet<E> extends HashSet<E> implements Set<E> {
	private int capacity; 										// Max size of the HashSet
	private double loadFactor; 									// The load factor indicates the percentage of the capacity at which the will double in size
	private LinkedList<E> linkedListValues= new LinkedList<>();	//maintains the insertion order
	private HashSet<E> hashSetValues = new HashSet();			//entries are unique
	
	
	//CONSTRUCTORS//
	public MockLinkedHashSet() {
		this.capacity = 16;
		this.loadFactor = 0.75;
	}
	public MockLinkedHashSet(int capacity) {
		this.capacity = capacity;
		this.loadFactor = 0.75;
	}
	public MockLinkedHashSet(int capacity,double loadFactor ) {
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}
	public MockLinkedHashSet(double loadFactor) {
		this.capacity = 16;
		this.loadFactor = loadFactor;
	}
	//END CONSTRUCTORS//
	
	
	public void ourAdd(E e) {
		boolean doesNotContain = hashSetValues.add(e); //returns true if the value is unique AND adds the value to the HashSet
		if(doesNotContain) {
			linkedListValues.add(e);
		}
		if(this.isAtCapacity() && doesNotContain){ 	 
			this.sizeIncrease();
		}
	}
	//checks if the hashSet meets the size increase threshold
	public boolean isAtCapacity(){
		if(hashSetValues.size() >= capacity * loadFactor) {
			return true;
		}
		else
			return false;			
	}	
	public void sizeIncrease() {
		int newCap = capacity*2;
		System.out.println(newCap);		//this is just so you can see the size increase of the HashSet during runtime
		HashSet<E> store = new HashSet<>();
		store.addAll(hashSetValues);
		hashSetValues = null;
		hashSetValues = new HashSet<E>(newCap);
		hashSetValues.addAll(store);
		capacity = newCap;		
	}
	public String toString() {
		String string = "[";
		for(int i=0;i<linkedListValues.size();i++) {
			if(i!= linkedListValues.size()-1)
				string += linkedListValues.get(i) + ", ";
			else
				string += linkedListValues.get(i);
		}
		string+="]";
		return string;
	}
	
}
