package com.inter.collections;

import java.util.ArrayList;
import java.util.Collection;
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
 * 																							Comparable (I)
 * 																							Comparator (I)
 * 
 * 
 * 											Iterable (interface)							Collections(C)
 * 													^
 * 													|
 * 											Collection (interface)
 * 									/					|					\
 * 								List (I)			Set (I)				Queue (I) FIFO						Map (I)
 * 									^					^					^									^
 * 									|					|					|									|
 * 							ArrayList (C)			HashSet (C)			PriorityQueue (C)					HashMap (C)
 * 							LinkedList (C)			TreeSet (C)			Deque (I)							TreeMap (C)
 * 							Stack (C) LIFO
 * 
 * 
 * 
 * 
 * 
 */
public class CollectionsExample {

	public static void main(String[] args) {
		
		//ArrayList
		//		expands the underlying array by 50%, not synchronized (NOT THREAD SAFE)
		//Vector
		//		implements list, expand underlying array by 100%, is synchronized (THREAD SAFE)
		List<Integer> ints = new ArrayList<>();
		ints.add(4);
		ints.add(8);
		ints.add(4);
		System.out.println(ints);
		System.out.println(ints.get(1));
		System.out.println(ints.size());
		
		//LinkedList
		//		doubly linked list. It has pointers to the next and previous node. The underlying data structure
		//			does not house a conventional array, it will add nodes to the list and point to the previous 
		//			and next nodes. It implements the Deque interface, so retrieving from the first and last 
		//			positions will be O(1), however retrieving from the middle of the list, will be the same as
		//			a normal array.
		List<String> strings = new LinkedList<>();
		strings.add("addeed");
		strings.add(0, "jhdsalo");
		System.out.println(strings);
		System.out.println(strings.get(0));
		strings.clear();
		System.out.println(strings);
		
		//Sets
		
		//HashSet
		//		Uses a underlying HashTable to organize and store the values
		Set<Integer> intset = new HashSet<>();
		intset.add(9);
		intset.add(10);
		intset.add(855);
		intset.add(1);
		intset.add(-55);
		intset.addAll(ints);
		boolean b = intset.add(4162132);		//returns a boolean determining whether or not the value was added
		System.out.println(intset);
		System.out.println(b);
		
		//TreeSet
		//		Uses a red black tree algorithm for sorting the values
		Set<String> sortedStrings = new TreeSet<>();
		sortedStrings.add("go Time");
		sortedStrings.add("a bird in the sky");
		sortedStrings.add("Zoo goers");
		sortedStrings.add("&*&");
		sortedStrings.add(" ");
		System.out.println(sortedStrings);
		
		//Queue
		
		//PriorityQueue
		//		keeps everything organized by priority. Queue customarily keeps values in order as they are put
		//			in, this will keep them in order by priotity. The first one out will be the one with the 
		//			highest priority.
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("hey look mah");
		pq.add("no hands");
		System.out.println(pq.remove());
		System.out.println(pq.remove());
//		System.out.println(pq.remove());
//		ints.get(100);
		
		//Deque
		//		Double ended queue, can retrieve from either end.
		
		//Map
		
		//HashMap
		//		HashMap is like HashTable, but is not synchronized and is faster
		Map<String, String> hashedStrings = new HashMap<>();
		hashedStrings.put("key", "value");
		hashedStrings.put("another key", "another value");
		System.out.println(hashedStrings);
		
		//TreeMap
		//		Like TreeSet, is going to organize the elements according to their natural sorting order
		Map<String, String> dictionary = new TreeMap<>();
		dictionary.put("hammer", "a noun associated with a blunt object");
		dictionary.put("aardvark", "a difficult to spell animal");
		dictionary.put("car", "goes vroom vroom");
		System.out.println(dictionary);
		Set<String> keys = dictionary.keySet();
		System.out.println(keys);
		Collection<String> values = dictionary.values();
		System.out.println(values);
		System.out.println(values.getClass());
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(3.4, "susan", "English"));
		students.add(new Student(3.0, "greg", "basket weaving"));
		students.add(new Student(3.3, "megan", "Computer Science"));
		System.out.println(students);
		
	}
	
}
