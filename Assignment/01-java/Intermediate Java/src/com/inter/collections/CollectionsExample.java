package com.inter.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Collections Framework
 * 
 * 																								Comparable(interface)
 * 																								Comparator(interface)
 * 
 * 
 * 
 * 
 * 
 * 											Iterable(interface)									Collections(class)
 * 												^
 * 												|
 * 											Collection(interface)     
 * 									/				|				\
 * 						List(interface)		Set(interface)			Queue(interface)	              Map(interface)
 * 								^				  ^							^								^
 * 								|				  |							|								|
 * 					ArrayList(class)		HashSet(class)				PriorityQueue(class)			HashMap (class)
 * 					LinkedList(class)		TreeSet(class)				Dequeue(interface)				TreeMap(class)
 * 					Stack(class)
 * 
 * 
 * 
 * Collections(class) is a static class that works with instances of collection.
 * 
 * Collections.sort(comparable/comparator). 
 * Comparable(interface) gives a natural sorting order
 * Comparator(interface) gives an unnatural sorting order, one that is set up by coder. 
 * 
 * 
 * Lists keep the order and allow duplicates
 * Sets don't keep the order and don't allow duplicates.
 * 		HashSet is ordered most efficiently
 * 		TreeSet is ordered using Comparable.  
 * Priority Q: LIFO: last in first out. 
 * Dequeue: FIFO: First in First Out.
 * 
 * Map's keys can be turned into a set. 
 * HashMap doesn't order the keys, but is faster O(1). 
 * TreeMap orders the keys in ascending order, but is a little slower O(Log(n))
 * 
 * 
 */

public class CollectionsExample {
		
	public static void main(String[] args) {
		
		
//ArrayList
//expands the underlying array by 50%, not synchronized. Faster,not thread safe. 
//Vector
//implements list, also expands the underlying array by 100%, is synchronized. Slower, but thread safe.   
		 
	List<Integer> ints = new ArrayList<>();
	ints.add(4);
	ints.add(8);
	ints.add(4);
	System.out.println(ints);
	System.out.println(ints.get(1));
	System.out.println(ints.size());
	
	//LinkedList
	//	doubly linked list of nodes. Each node has pointers pointing to the next and previous node. The underlying data structure
	//  does not have a conventional array, it will add nodes to the list and point it to the previous and next nodes. 
	//  Implements the dequeue interface, so retrieving from the first and last positions will be O(1), however retrieving from the middle
	//	of the list will be the same as a normal array. 
	
	List<String> strings = new LinkedList<>();
	strings.add("added");
	strings.add(0,"sofff");
	System.out.println(strings);
	System.out.println(strings.get(0));
	strings.clear();
	System.out.println(strings);
	
	//Sets
	
	//HashSet
	// uses a underlying HashTable to organize and store the values
	Set<Integer> intset = new HashSet<>();
	intset.add(8);
	intset.add(10);
	intset.add(855);
	intset.add(1);
	intset.add(-55);
	intset.addAll(ints);
	boolean b = intset.add(4);
	System.out.println(intset);
	System.out.println(b); //false, already contains 4 from ints. 
	
	//TreeSet
	// USes a red black tree algorithm for sorting the values
	Set<String> sortedStrings = new TreeSet<>();
	sortedStrings.add("go time");
	sortedStrings.add("a bird in the sky");
	sortedStrings.add("Zoo goers");
	sortedStrings.add("&*&");
	sortedStrings.add(" ");
	System.out.println(sortedStrings);
	
	//Queue
	
	//PriorityQueue
	//		each queue item is given a priority, and the queue is organized by the priority of the items. 
	//		The first one out will be the one with the highest priority.
	PriorityQueue<String> pq = new PriorityQueue<>();
	pq.add("hey wasup man");
	pq.add("wassup");
	System.out.println(pq);
	System.out.println(pq.remove());
	
	//Dequeue
	//		Double ended queue, can retreive from either end.
	
	//Map
	
	//HashMap
	//		HAshMap is like HashTable, but is not synchronized and is faster
	Map<String,String> hashedStrings = new HashMap<>();
	hashedStrings.put("key", "value");
	hashedStrings.put("another key", "another value");
	System.out.println(hashedStrings);
	
	//TreeMap
	//		Like TreeSet is going to organize the elements according to their natural sorting order
	Map<String,String> dict = new TreeMap<>();
	dict.put("hammer", "a blunt object");
	dict.put("aardvark",  "an animal");
	dict.put("car", "drives itself sometimes");
	System.out.println(dict);
	Set<String> keys = dict.keySet();
	System.out.println(keys);
	Collection<String> values = dict.values();
	System.out.println(values);
	System.out.println(values.getClass());
	
	System.out.println("\n\n\n Students example");
	
	List<Student> students = new ArrayList<>();
	students.add(new Student(3.4, "susan", "English"));
	students.add(new Student(3.0, "bob", "Math"));
	students.add(new Student(3.3, "meg", "cs"));
	System.out.println(students);
	Collections.sort(students, new StudentNameComparator());
	System.out.println(students);
	
	
	
	}
	

	

}
