package com.friday.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * JAVA 8
 * 	
 * 		Java 8 was a major version update to the java programming language.
 * 
 * 		Most notable was the introduction of functional interfaces and lambdas.
 * 
 * 		Functional interfaces are interfaces with only one method.
 * 
 * 		lambdas are in line implementations for functional interfaces.
 * 			Behind the scenes they are anonymous inner classes that only need to 
 * 			implement one method.
 * 
 * 		default methods were introduced for interfaces to provide a default
 * 			implementation to newly introduced methods as to not introduce a 
 * 			breaking change.
 * 
 * 
 * 		Streams API
 * 			Introduced more functional programming style into java. Made working
 * 				with collections and working with the individual methods more 
 * 				declarative than imperative. Now we can create an inline implementation
 * 				using lambdas where we would normally spend several lines to get the result.		
 * 
 */
public class Java8Driver {

	public final static Comparator<String> stringDecrease = (a, b) -> b.compareTo(a);

	public static void main(String[] args) {
//		Animal a = new Animal() {};
//		
//		System.out.println(a.toString());

//		class InnerAnimal extends Animal{
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
//		Tester t = new TesterClass();
//		
//		System.out.println(t.test());

		// anonymous inner class
//		
//		Animal a = new Animal() {
//			@Override
//			public String toString() {
//				// TODO Auto-generated method stub
//				return super.toString();
//			}
//		};
//		
		// com.friday.java8.Java8Driver$1.class class name of anonymous inner class

//		Tester t = () -> {
//			return true;
//		};
//		
//		System.out.println(t.test());
//		
//		Tester t2 = () -> true;
//		
//		System.out.println(t2.test());
//		
//		

		List<String> strings = new ArrayList<>();
		strings.add("have");
		strings.add("a");
		strings.add("good");
		strings.add("day");
		System.out.println(strings);
		Collections.sort(strings);
		System.out.println(strings);
//		Comparator<String> c = (String a, String b)->b.compareTo(a);
//		Collections.sort(strings, c);
		Collections.sort(strings, (a, b) -> b.compareTo(a));
		System.out.println(strings);

		// Stream api
		List<String> allAs = strings.stream().filter(string -> string.contains("a")).collect(Collectors.toList());
		System.out.println(allAs);
		List<Integer> ints = strings.stream().map(s -> s.length()).collect(Collectors.toList());
		System.out.println(ints);
		strings.stream().forEach(s -> System.out.println(s));
		strings
			.stream()
				.filter(s -> s.contains("d"))
				.map(s -> s.length())
				.forEach(s -> System.out.println(s));

	}
}
