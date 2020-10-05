package com.inter.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
 * Collections Framework
 * 
 * Starts with the Iterable interface:
 * 
 * interface Collection extends Iterable...
 * 
 * 3 types of collection:
 * Lists, Sets, and Queues
 * 
 * List is just a collection of items (duplicates allowed), keeps the order by a set of indices
 * Set is a collection of UNIQUE items (no duplicates allowed), keeps order based on an internal algorithm
 * Queue is first in / first out
 * 
 * Map uses a set of key-value pairs; get a value by specifying its key
 * 
 * 						Iterable					Collections (Class; utility static class like Arrays)
 * 							^						Comparator (Interface; for secondary sorting methods)
 * 							|
 * 						Collection
 * 				/			 |			\
 * 			List			Set			Queue								Map
 * 			^				^				^								^
 * 			|				|				|								|
 * 	ArrayList			HashSet			PriorityQueue					HashMap
 * 	LinkedList			TreeSet			Deque (Interface)				TreeMap
 * 	Stack																HashTable
 * 																		SortedSet
 * Stack is first in / last out (like a deck of cards)
 * TreeSet stores Comparable items and uses the items' compareTo method to 
 * 
 */

public class CollectionsExample {
	
	
	public static void main(String[] args) {
		// ArrayList
		// 	expands the underlying array by 50%, not synchronized (NOT THREAD SAFE)
		// Vector
		// 	Implements List, expands the underlying array by 100% instead of 50%, IS synchronized (THREAD SAFE)
		
		List<Integer> ints = new ArrayList<>();
		
		ints.add(4);
		ints.add(8);
		ints.add(4);
		ints.add(9);
		
		System.out.println(ints);
		System.out.println(ints.get(1));
		System.out.println(ints.size());
		
		// LinkedList
		// 	doubly linked list. It has references to next and previous node. The underlying data structure
		//		does not house a conventional array; it will add nodes to the list and point it to the previous
		//		and next nodes. It implements the Deque interface, so retrieving from the first and last
		//		positions will be O(1). However, retrieving from the middle of the list will be the same as
		//		a normal array.
		
		List<String> strings = new LinkedList<>();
		
		strings.add("added");
		strings.add("sodafighoiu");
		
		System.out.println(strings);
		System.out.println(strings.get(0));
		
//		strings.clear();
		
		System.out.println(strings);
		
		// Sets
		
		// HashSet
		// 	Uses an underlying HashTable to organize and store values
		
		Set<Integer> intset = new HashSet<>();
		
		intset.add(4);
		intset.add(8);
		intset.add(10);
		intset.add(855);
		intset.add(1);
		intset.add(-55);
		boolean b = intset.add(4); // returns whether or not it was added to the set
		System.out.println(intset);
		intset.addAll(ints);
		System.out.println(b);
		
		// TreeSet
		// 	Uses a red black tree algorithm for sorting the values; sorts strings by ASCII codes
		Set<String> sortedStrings = new TreeSet<>();
		sortedStrings.add("to time");
		sortedStrings.add("a bird in the sky");
		sortedStrings.add("Zoo goers");
		sortedStrings.add("&*&");
		sortedStrings.add(" ");
		System.out.println(sortedStrings);
		
		// Queue
		
		// PriorityQueue
		//		keeps everything organized according to a defined priority
		//		While Queue typically keeps values in order as they are put in, this will keep them
		//			in order by priority. The first out will be the highest-priority one.
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("hey look mah");
		pq.add("no hands");
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		
		// System.out.println(pq.remove());
		// ints.get(100);
		
		// Deque
		//	Double ended queue; can retrieve from either end
		
		// Map
		
		// HashMap
		// 	HashMap is like HashTable, but is not synchronized and is faster
		Map<String, String> hashedStrings = new HashMap<>();
		hashedStrings.put("key", "value");
		hashedStrings.put("another key", "another value");
		System.out.println(hashedStrings);
		
		// TreeMap
		// 	Like TreeSet, is going to organize the elements according to their natural sorting order
		Map<String, String> dictionary = new TreeMap<>();
		dictionary.put("hammer", "a noun associated with a blunt object");
		dictionary.put("aardvark", "a difficult-to-spell animal");
		dictionary.put("car", "goes vroom vroom");
		System.out.println(dictionary);
		
		Set<String> keys = dictionary.keySet();
		System.out.println(keys);
		
		Collection<String> values = dictionary.values();
		System.out.println(values);
		System.out.println(values.getClass());
		
		System.out.println("\n\n\n");
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(3.4, "susan", "English"));
		students.add(new Student(3.0, "greg", "Basket Weaving"));
		students.add(new Student(3.2, "megan", "CS"));
		students.add(new Student(4.0, "carlos", "SCIENCE"));
		System.out.println(students);
		
		Collections.sort(students);
		System.out.println(students);
		
		Collections.sort(students, new StudentNameComparator());
		System.out.println(students);
		
		// ASSIGNMENT: something besides iterable, collection, list, set, queue, and map
		// Team members: COLLIN SCHULTZ, NATHAN RICKS
		
		// Stack s = new Stack<String>();
		
		// Iterator
		// Used by the foreach loop
		
		// ListIterayot has a previous method, it is able to reaverse the list back and forth
		ListIterator<String> stringIterator = strings.listIterator();
		System.out.println(stringIterator.next());
		System.out.println(stringIterator.next());
		System.out.println(stringIterator.previous());
		System.out.println(stringIterator.previous());
		System.out.println(stringIterator.hasNext());
		
		while(stringIterator.hasNext())
			System.out.println(stringIterator.next());
		
		for(String s: strings)
			System.out.println(s);
		
		Iterator<String> setIterator = sortedStrings.iterator();
		System.out.println(setIterator.next());
		System.out.println(setIterator.next());
		System.out.println(setIterator.next());
		System.out.println(setIterator.next());
		
		while(setIterator.hasNext())
			System.out.println(setIterator.next());
		
		Iterator<String> dictionaryIterator = dictionary.keySet().iterator();
		
		while(dictionaryIterator.hasNext()) {
			String key = dictionaryIterator.next();
			System.out.println("The definition for " + key + " is " + dictionary.get(key));
		}
		
		int[] array = new int[3];
		Arrays.asList(array); // returns a List object for the given array
	}
}
