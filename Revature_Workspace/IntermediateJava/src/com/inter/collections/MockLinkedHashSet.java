package com.inter.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class MockLinkedHashSet<E> extends HashSet<E> implements Set<E> {
	private int capacity;
	private double loadFactor;
	private LinkedList<E> linkedListValues= new LinkedList<>();//maintains the insertion order
	private HashSet<E> values = new HashSet();//entries are unique
	
	
	
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

	public void ourAdd(E e) {
		boolean doesNotContain = values.add(e);
		if(this.isAtCapacity() && doesNotContain){
			this.sizeIncrease();
		}
		
		if(doesNotContain) {
			linkedListValues.add(e);
		}
	}
	public void sizeIncrease() {
		int newCap = capacity*2;
		System.out.println(newCap);		
		HashSet<E> store = new HashSet<>();
		store.addAll(values);
		values = null;
		values = new HashSet<E>(newCap);
		values.addAll(store);
		capacity = newCap;		
	}
	
	public boolean isAtCapacity(){
		if(values.size() >= capacity * loadFactor) {
			return true;
		}
		else
			return false;
						
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
