package com.inter.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsExample {
	public static void main(String[] args) {
		// ArrayList
		// Expends the underlying array by 50% each time the size needs to increase, not synchronized (!THREAD SAFE)
		//Vector
		//implements list, expands the underlying array by 100% each time the size needs to increase,is synchronized (THREAD SAFE)
		List<Integer> ints = new ArrayList<>();
		ints.add(4);
		ints.add(7);
		ints.add(4);
		System.out.println(ints);
		System.out.println(ints.get(1));
		System.out.println(ints.size());
		
//		LinkedList
//		Doubly linked list. It has pointers to the next and previous node. The underlying data structure
//			does not house a conventional array, it will add nodes to the list and reference it to the previous 
//			and next nodes. It implements the Deque interface, so retrieving from the first and last
//			positions will be O(1), however retrieving from the middle of the list, will be the same as 
//			a noraml array.
		
//		It is important to upcast because all the classes that read it provide implementations to the interface.
		List<String> strings = new LinkedList<>();
		strings.add("added");
		strings.add(0, "idybfilsd");
		System.out.println(strings);
		System.out.println(strings.get(0));
		strings.clear();
		System.out.println(strings);

//		Sets 
//		HashSet
//			Uses a underlying HashTable to organize and store the values.
		Set<Integer> inset = new HashSet<>();
		
		inset.add(8);
		inset.add(10);
		inset.add(855);
		inset.add(340);
		
		System.out.println(inset);
		inset.addAll(ints);
		boolean b = inset.add(7456); //returns a boolean determining whther or not the value was added
		System.out.println(inset);
		System.out.println(b);
		
//		TreeSet
//		Uses a red black tree algorithm for sorting the values.
		Set<String> sortedStrings = new TreeSet<>();
		sortedStrings.add("Go Time");
		sortedStrings.add("A bird in the sky");
		sortedStrings.add("zoo goers");
		sortedStrings.add("(*&$@%");
		System.out.println(sortedStrings);
		
//		Queue
//		
//		Priority Queue
//			Keeps everything organized by priority. Quque customarily keeps values in order as they are put
//			in, this will keep them in order by priority. The first one out will be the one with the highest priority.
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("hey look mah");
		pq.add("no hands");
		System.out.println(pq.remove());
		System.out.println(pq.remove());

//		Deque
//			Double ended queue, can retrieve from either end.
		
//		Map
//		HashMap
//			HashMap is like HashTable, but it is not synchronized and is faster
		
		Map<String, String> hashedStrings = new HashMap<>();
		hashedStrings.put("key", "value");
		hashedStrings.put("akey", "avalue");
		System.out.println(hashedStrings);
		
//		TrreMap
//		Like TreeSet, is going to organize the elements according to their natural sorting order
		Map<String, String> dictionary = new TreeMap<>();
		dictionary.put("green", "green color");
		dictionary.put("blue", "blue color");
		dictionary.put("orange", "orange color");
		System.out.println(dictionary);
		
		Set<String> keys = dictionary.keySet();
		System.out.println(keys);
		System.out.println(dictionary.values());
		
		List<Student> students = new ArrayList();
		students.add(new Student(4.0, "Alex", "Computer Science"));
//		students.add(new Student(4.8Student, "rob", "Computer Science"));
		students.add(new Student(4.0, "liz", "Computer Science"));
		
		System.out.println(students);
		Collections.sort(students);
		System.out.println(students);
		
		Set<Integer> test = new LinkedHashSet<>();
		}
	
}
