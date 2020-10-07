package com.example.intro;

public class test {
	public static void main(String[] args) {
		String string = "olly olly in come free";
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
		
		
		int wordcount = 0; 
		String word = string.trim();
		for(int i = 0; i<word.length(); i++) {
			char end = (char) word.indexOf(' ');
			if(i == end) {
				i++;
			}
			System.out.println(word.substring(i, end));
//			int last = string.in
			wordcount++;
		}
//		System.out.println(word.charAt(0));
	}
}
