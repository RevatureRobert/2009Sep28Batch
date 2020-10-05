package com.present.hashset;

public class HSetRunner {

	public static void main(String[] args) {
		HashSet<String> ourHash = new HashSet<>();

		ourHash.addTo("Bill");
		
		System.out.println(ourHash.getHashArray());
		System.out.println(ourHash.getHashObjects());
		
		System.out.println(ourHash.getHashCode("Bill"));
		
		ourHash.addTo("Bill");
		
		ourHash.remove("Bill");
	}
	
}
