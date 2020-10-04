package com.friday.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Driver {
	
	public final static Comparator<String> stringDecrease = (a,b) -> b.compareTo(a);
	
	public static void main(String[] args) {
		
//		Animal a = new Animal();
//		System.out.println(a.toString());
		
//		class InnerAnimal extends Animal {
//		}
//		
//		Animal a = new InnerAnimal();
		
//		class TesterClass implements Tester {
//
//			@Override
//			public boolean test() {
//				// TODO Auto-generated method stub
//				return false;
//			}
//			
//		}
//		
//		Tester t = new TesterClass();
//		
//		System.out.println(t.test());
		
		// Anonymous inner class
//		Animal a = new Animal() {
//			@Override
//			public String toString() {
//				return super.toString();
//			}	
//		};
		
		//com.friday.java8.Java8Driver$1.class	class name of anonymous inner class
		
//		Tester t = () -> {
//			return true;
//		};
//		
//		System.out.println(t.test());
//		
//		Tester t2 = () -> true;
		
		List<String> strings = new ArrayList<>();
		strings.add("have");
		strings.add("a");
		strings.add("good");
		strings.add("day");
		System.out.println(strings);
		Collections.sort(strings);
		System.out.println(strings);
//		Comparator<String> c = (String a, String b) -> b.compareTo(a);
//		Collections.sort(strings, c);
		Collections.sort(strings, (a,b) -> b.compareTo(a));
		System.out.println(strings);
		
		List<String> allAs = strings.stream().filter(string -> string.contains("a")).collect(Collectors.toList());
		System.out.println(allAs);
		List<Integer> ints = strings.stream().map(s->s.length()).collect(Collectors.toList());
		System.out.println(ints);
		strings.stream().forEach(s-> System.out.println(s));
		strings
			.stream()
			.filter(s->s.contains("d"))
			.map(s->s.length())
			.forEach(s->System.out.println(s));
		
	}

}
