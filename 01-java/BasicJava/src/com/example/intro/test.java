package com.example.intro;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
		String string = "one fish two fish red fish blue fish";
//		StringBuilder number = new StringBuilder(string);
//		for(int i = 0; i < number.length(); i++) {
//			char c = number.charAt(i);
//			if(c == '(' || c == ')' || c ==' ' || c =='-' || c == '.' ) {
//				number.deleteCharAt(i);
//				i--;
//				
////				if (i != 0) {
////				i--;
//					
////				}
//			}
////			if(c == '(' || c == ')' || c ==' ' || c =='-' || c == '.' && i != 0) {
////				number.deleteCharAt(i);
////				i--;
////			}
//		}
//		
//		System.out.println(string);
//		System.out.println(number);
////		return;
		
//		int wordcount = 0;
		int instance = 0;
		Map<String, Integer> wordCount = new HashMap();
		String parts[] = string.split("[ ,,,\n]");
		for (int i = 0; i < parts.length; i++) {
			System.out.println(parts[i]);
			if(wordCount.containsKey(parts[i])) {
				System.out.println("if statement");
				 wordCount.replace(parts[i], wordCount.get(parts[i])+1);
			}
			else {
				System.out.println("else statement");
				wordCount.put(parts[i], 1);
			}
//			wordCount.put(parts[i], instance);

		}
		for(Map.Entry pairEntry: wordCount.entrySet()) {
			System.out.println(pairEntry.getKey() + ", " + pairEntry.getValue());
		}
//		String word = string.trim();
//		for(int i = 0; i<word.length(); i++) {
//			char end = (char) word.indexOf(' ');
//			if(i == end) {
//				i++;
//			}
//			System.out.println(word.substring(i, end));
////			int last = string.in
//			wordcount++;
//		}
//		System.out.println(word.charAt(0));
	}
}
