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

public class CollectionsExample {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(4);
		ints.add(8);
		ints.add(4);
		System.out.println(ints);
		System.out.println(ints.get(1));
		System.out.println(ints.size());
		System.out.println();
		
		
		List<String> strings = new LinkedList<>();
		strings.add("added");
		strings.add(0,"sofgdfsgsdg");
		System.out.println(strings);
		System.out.println(strings.get(0));
		strings.clear();
		System.out.println(strings);
		System.out.println();
		
		
		Set<Integer> intset = new HashSet<>();
		intset.add(4);
		intset.add(8);
		intset.add(10);
		intset.add(855);
		intset.add(1);
		intset.add(-55);
		intset.addAll(ints);
		boolean b = intset.add(4);
		boolean a = intset.add(203045);
		System.out.println(intset);
		System.out.println(b);
		System.out.println(a);
		System.out.println();
		
		
		Set<String> sortedStrings = new TreeSet<>();
		sortedStrings.add("go Time");
		sortedStrings.add("a bird in the sky");
		sortedStrings.add("Zoo goers");
		sortedStrings.add("&*&");
		sortedStrings.add(" ");
		sortedStrings.add("");
		System.out.println(sortedStrings);
		System.out.println();
		
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Hey look mah");
		pq.add("no hands");
		System.out.println(pq.remove());
		System.out.println(pq.remove()); 
		System.out.println();
		
		Map<String,String> hashedStrings = new HashMap<>();
		hashedStrings.put("key", "Value");
		hashedStrings.put("another key", "another Value");
		System.out.println(hashedStrings);
		System.out.println();
		
		Map<String,String> dictionary = new TreeMap<>();
		dictionary.put("Hammer", "A noun associated with a blunt object");
		dictionary.put("Aardvark","sfdgfdsgdfsg");
		dictionary.put("car", "Goes Vroom vroom");
		System.out.println(dictionary);
		Collection<String> values = dictionary.values();
		Set<String> keys = dictionary.keySet();
		System.out.println(values);
		System.out.println(values.getClass());
		System.out.println(keys);
	}                                                                         
	
	
}
