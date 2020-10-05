package com.inter.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * 
 * Collections Framework
 * 																							Comparable (I) (gives natural sorting order for class (by default))
 * 																							Comparator (I) (gives unnatural (secondary) sorting order for class)
 * 
 * These are the most common collections you will work with
 * 
 * 										Iterable (interface)								Collections (C) (Static Utility Class meant to work with a collection)
 * 												^
 * 												|
 * 										Collection (interface)											Completely Separate from Iterable and Collections
 * 							/					|						\											|
 * 						List (I)			Set (I)					Queue (I)									Map (I) (no duplicate keys.  You can turn the keys into a set)
 * 							^					^						^											^
 * 							|					|						|											|
 * 					ArrayList (C)		HashSet (C)					PriorityQueue (C)							HashMap (C)
 * 					LinkedList (C)		TreeSet (C)					Deque (I)									TreeMap (C)
 * 					Stack (C)			
 * 
 * 
 * note: sets don't keep order, and they don't allow duplicates
 * 		remove duplicates from an array? Turn it into a set
 * 
 * Queue: first in, first out
 * Stack: first in, last out (or Last in, first out, LIFO)
 * 
 * Note: LinkedList implements List and Deque
 * 
 * Maps are the most efficient at retrieving values, more than anything else
 * Sets are more efficient than lists
 * 
 * ArrayList expands by 50% each time
 * LinkedLists are double ended nodes linked to each other
 * 		first and last values are easiest to grab
 * 		grabbing a value in the middle is same efficiency as arraylist
 * 
 */
public class CollectionsExample {

	public static void main(String[] args) {
		
		//Lists
		
		// ArrayList
		//		expands the underlying array by 50%, not synchronized (not thread safe, faster)
		// Vector
		//		implements list, expands underlying array by 100%, is synchronized (thread safe, slower)
		List<Integer> ints = new ArrayList<>();
		ints.add(4); //add value to array
		ints.add(8);
		ints.add(4);
		System.out.println(ints);
		System.out.println(ints.get(1)); //gets value at index
		System.out.println(ints.size()); //gets size of arraylist
		
		// LinkedList
		// 		doubly linked list.  Has references to the next and previous node.  The underlying data structure
		//		does not house a conventional array, it will add nodes to the list and references it to the previous
		//		and next nodes. It implements the Deque interface, so retrieving from the first and last
		//		positions will be O(1), however retrieving from the middle of the list, will be the same as a
		//		normal array.
		List<String> strings = new LinkedList<>(); //note, we're upcasting here, gives us methods from list
		strings.add("added");
		strings.add(0, "another one"); //you can add an index of where you want things inserted
		System.out.println(strings);
		System.out.println(strings.get(0));
		//strings.clear();
		System.out.println(strings);
		
		
		//Sets
		
		//HashSet
		//		Uses an underlying HashTable to organize and store the values
		Set<Integer> intset = new HashSet<>();
		intset.add(9);
		intset.add(11);
		intset.add(10);
		intset.add(855);
		intset.add(1);
		intset.add(-55);
		System.out.println(intset);
		intset.addAll(ints); //we can add other collections
		System.out.println(intset);
		boolean b = intset.add(4); //this returns a boolean saying whether or not the value was added
		System.out.println(b);
		System.out.println(intset);
		
		//TreeSet
		//		Uses a red black tree algorithm for sorting the values
		Set<String> sortedStrings = new TreeSet<>();
		sortedStrings.add("tree time");
		sortedStrings.add("a bird in the bush is worth two in the hand");
		sortedStrings.add("Go to the Zoo");
		sortedStrings.add("&*&");
		sortedStrings.add(" ");
		System.out.println(sortedStrings); //sorts by ascii code
		
		//Queues
		
		//PriorityQueue
		//		keeps everything organized by priority.  Queue customarily keeps values in order as they are put in,
		//		this will keep them in order by priority.  The first one out will be the one with the highest
		//		priority.
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Look at me");
		pq.add("I am the captain now"); //looks like you have to implement comparator to figure out how to make priority
		System.out.println(pq.remove());
		System.out.println(pq.remove());
//		System.out.println(pq.remove()); //this one should throw an exception
		
		//Deque
		//		Double ended queue, can retrieve from either end.
		
		//Maps
		
		//HashMap
		//		HashMap is like HashTable but is not synchronized (not thread safe, faster)
		Map<String, String> hashedStrings = new HashMap<>();
		hashedStrings.put("key", "value");
		hashedStrings.put("another key","another value");
		System.out.println(hashedStrings); //gets organized based on algorithm underlying
		
		//TreeMap
		//		Like TreeSet, organizes the elements according to their natural sorting order
		Map<String, String> dictionary = new TreeMap<>();
		dictionary.put("aardvark", "an animal that is usually first in a dictionary");
		dictionary.put("hammer", "down, Boiler up"); //I graduated from Purdue
		dictionary.put("car", "goes vroom");
		System.out.println(dictionary);
		Set<String> keys = dictionary.keySet();
		System.out.println(keys);
		Collection<String> values = dictionary.values();
		System.out.println(values);
		System.out.println(values.getClass()); //class java.util.TreeMap$Values is output, $indicates an inner class
		
//		List<Student> students = new ArrayList<>();
//		students.add(new Student(3.4, "susan", "English"));
//		students.add(new Student(3.0, "greg", "Basket Weaving"));
//		students.add(new Student(3.3, "megan", "Computer Science"));
//		students.add(new Student(3.2, "zachary", "American History"));
// 		System.out.println(students);
//		Collections.sort(students);
//		System.out.println(students);
//		Collections.sort(students, new StudentNameComparator());
//		System.out.println(students);
		
		//Iterator
		
		//you can have an object with a complete collection that you can iterate
		
		//list iterator has a previous method, it is able to traverse the list back and forth
		ListIterator<String> stringIterator = strings.listIterator();	//not creating new thing
//		System.out.println(stringIterator.next());
//		System.out.println(stringIterator.next());
//		System.out.println(stringIterator.previous());
//		System.out.println(stringIterator.previous());
//		System.out.println(stringIterator.previous());	//error, ran out of elements
//		System.out.println(stringIterator.hasNext());
		while(stringIterator.hasNext()) {
			System.out.println(stringIterator.next());
		}
		
		for (String s : strings) { //this is the same as the above while loop.  This is why we typically don't use iterators
			System.out.println(s);
		}
		
		Iterator<String> setIterator = sortedStrings.iterator();
		System.out.println(setIterator.next());
		System.out.println(setIterator.next());
		System.out.println(setIterator.next());
		System.out.println(setIterator.next());
		
		while(setIterator.hasNext()) {
			System.out.println(setIterator.next());
		}
		
		Iterator<String> dictionaryIterator = dictionary.keySet().iterator();
		
		while(dictionaryIterator.hasNext()) {
			String key = dictionaryIterator.next();
			System.out.println("The definition for "+key+" is: "+dictionary.get(key));
		}
	}
	
	
	
}
