package com.cust.implementation;

import java.util.LinkedHashSet;

public class CustomImplementation {
	public static void main(String[] args) {
		
		//LinkedHashSet sample code
		LinkedHashSet<String> lhset = new LinkedHashSet<String>();
		lhset.add("This is an example");
		lhset.add("of a linked hash set.");
		lhset.add("This section is added before checking the implementation.");
		System.out.println(lhset);
		boolean b = lhset.add("This section is added after checking the boolean value of implementation.");
		System.out.println(b);
		System.out.println(lhset);
	}

}
