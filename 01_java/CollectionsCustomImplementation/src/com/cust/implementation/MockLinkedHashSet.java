package com.cust.implementation;

import java.util.LinkedList;
import java.util.List;

public class MockLinkedHashSet {
	public static void main(String[] args) {
		List<String> strings = new LinkedList<>();
		strings.add("addeed");
		strings.add(0, "jhdsalo");
		System.out.println(strings);
		System.out.println(strings.get(0));
		strings.clear();
		System.out.println(strings);
		
	}

}
