package com.friday.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * JAVA 8
 * 
 * 	Java 8 is the most current major version update to the Java programming language.
 * 
 * 	Most notable was the introduction of functional interfaces and lambdas.
 * 
 * 	Functional interfaces are interfaces with only one method.
 * 
 * 	Lambdas are inline implementations for functional interfaces.
 * 		Behind the scenes, they are anonymous inner classes that only need to implement one method.
 * 
 *	Default methods were introduced for interfaces to provide a default implementation to newly
 *		introduced methods as to not cause changes to break any implementing classes
 *
 *	Streams API
 *		Introduced a more functional programming style into Java.
 *		Makes working with collections and working with the individual methods more declarative than imperative.
 *		Allows inline implementation of custom method bodies using lambda notation.
 */

public class Java8Driver {

	public static Comparator<String> stringDecrease = (a, b) -> b.compareTo(a);
	
	public static void main(String[] args) {
		
		
		// Inner class
		class TesterClass implements Tester{

			public boolean test() {
				return false;
			}
		}
		Tester tc = new TesterClass();
		
		
		
		// Instantiating an interface with an anonymous class block
		Tester t = new Tester() {
			public boolean test() {
				return true;
			}
			
			@Override
			public String toString() {
				return super.toString();
			}
		}; // com.friday.java8.Java8Driver$1.class
		
		
		
		// Lambda expression in place of making a whole nested class
		Tester tLambda = () -> {
			return true;
		};
		System.out.println(tLambda.test());
		
		Tester tLambda2 = () -> false;
		System.out.println(tLambda2.test());
		
		
		
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
		
		Collections.sort(strings, (a, b) -> b.compareTo(a));
		System.out.println(strings);
		
		
		
		// Stream API
		List<String> allAs = strings.stream().filter(str -> str.contains("a")).collect(Collectors.toList());
		System.out.println(allAs);
		List<Integer> ints = strings.stream().map(s -> s.length()).collect(Collectors.toList());
		System.out.println(ints);
		
		strings.stream().forEach(s -> System.out.println(s));
		
		strings.stream().filter(s -> s.contains("d")).map(s -> s.length()).forEach(s -> System.out.println(s));
		// Inline custom methods being chained together using lambdas!
	}

}
