package com.inter.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsExample {
	
	public static void main(String[] args) {
		
		/* ------ Lists ------ */
		
		// ArrayList
//		List<Integer> ints = new ArrayList<>();
//		ints.add(5);
//		ints.add(7);
//		ints.add(9);
//		System.out.println(ints);
//		System.out.println(ints.get(1));
//		System.out.println(ints.size());
		
		// LinkedList
		List<String> strings = new LinkedList<>();
		strings.add("added");
		strings.add(0, "more");
		strings.add(0, "barg");
		strings.add(0, "fest");
		System.out.println(strings);
//		System.out.println(strings.get(0));
//		strings.clear();
//		System.out.println(strings);
		
		/* ------ Sets ------ */
		
		// HashSet
//		Set<Integer> intset = new HashSet<>();
//		intset.add(12);
//		intset.add(9);
//		intset.add(855);
//		intset.add(4);
//		intset.addAll(ints);
//		System.out.println(intset);
//		boolean b = intset.add(5);
//		System.out.println(b);
//		System.out.println(intset);
		
		// TreeSet
		Set<String> sortedStrings = new TreeSet<>();
		sortedStrings.add("Go time");
		sortedStrings.add("a bird in the sky");
		sortedStrings.add("Zoo goers");
		sortedStrings.add("&*&");
		System.out.println(sortedStrings);
		
		/* ------ Queues ------ */
		
		// PriorityQueue
//		PriorityQueue<String> pq = new PriorityQueue<>();
//		pq.add("hey look ma!");
//		pq.add("no hands");
//		System.out.println(pq.remove());
//		System.out.println(pq.remove());
//		ints.get(100);
		
		// Deque
		
		
		
		/* ------ Map ------ */
		
		// HashMap
//		Map<String, String> hashedStrings = new HashMap<>();
//		hashedStrings.put("key1", "value");
//		hashedStrings.put("another key", "another value");
//		hashedStrings.put("key three", "s values");
//		hashedStrings.put("big key", "a value");
//		hashedStrings.put("cig key", "aerg value");
//		hashedStrings.put("dig key", "jtyjta value");
//		System.out.println(hashedStrings);
//		
//		// Hashtable
//		Map<String, String> ht = new Hashtable<>();
//		ht.put("key1", "value");
//		ht.put("another key", "another value");
//		ht.put("key three", "s values");
//		ht.put("big key", "a value");
//		ht.put("cig key", "aerg value");
//		ht.put("dig key", "jtyjta value");
//		System.out.println(ht);
//		
//		// TreeMap
		Map<String, String> dictionary = new TreeMap<>();
		dictionary.put("aardvark", "a difficult to spell animal");
		dictionary.put("hammer", "smashy tool");
		dictionary.put("car", "when a human pilots a missile");
		System.out.println(dictionary);
		Set<String> keys = dictionary.keySet();
		System.out.println(keys);
		Collection<String> values = dictionary.values();
		System.out.println(values);
		System.out.println(values.getClass());
//		
//		System.out.println("\n\n\n");
//		
//		List<Student> students = new ArrayList<>();
//		students.add(new Student(3.4, "Susan", "English"));
//		students.add(new Student(3.0, "Megan", "Basket Weaving"));
//		students.add(new Student(3.3, "Greg", "Computer Science"));
//		students.add(new Student(3.2, "Zach", "Aermican History"));
//		System.out.println(students);
//		Collections.sort(students);
//		System.out.println(students);
//		Collections.sort(students, new StudentNameComparator());
//		System.out.println(students);
		
		// Iterator
		ListIterator<String> stringIterator = strings.listIterator();
//		System.out.println(stringIterator.next());
//		System.out.println(stringIterator.next());
//		System.out.println(stringIterator.previous());
//		System.out.println(stringIterator.hasNext());
		while(stringIterator.hasNext()) {
			System.out.println(stringIterator.next());
		}
		
		for(String s : strings) {
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
			System.out.println("The definition for " +key+" is "+dictionary.get(key));
		}
		
	}
}
