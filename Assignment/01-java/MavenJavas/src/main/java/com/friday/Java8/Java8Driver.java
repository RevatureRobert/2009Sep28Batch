package com.friday.Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 
 * JAVA 8
 * 
 * 
 * 		Java 8 was a major version update to the java programming language.
 * 
 * 		Most notable was the introduction of functional interfaces and lambdas
 * 
 * 		Functional interfaces are interfaces with only one method
 * 
 * 		lambdas are in line implementations for functional interfaces. 
 * 			Behind the scenes they are anonymous inner classes that only need to
 * 			implement one method.
 * 
 * 
 * 		StreamsAPI
 * 
 * 		Introduced more functional programming style into JAva. made working with collections
 * 			and working with the individual methods more
 * 			declarative than imperative. Now we can create an inline implementation
 * 			using lambdas where we would normally spend several lines to get the result
 */

public class Java8Driver {
	
	public final static Comparator<String> stringDecrease = (a,b) -> b.compareTo(a);
	
	public static void main(String[] args) {
//		Animal a = new Animal() {};
//		
//		class InnerAnimal extends Animal{
//			
//		}
//		
//		Animal a = new InnerAnimal();
		
//		class TesterClass implements Tester{
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
		
		//Anonymous inner class
//		
//		Animal a = new Animal() {
//			@Override
//			public String toString() {
//				return super.toString();
//			}
//		};
//		
		//com.friday.java8.Java8Driver$1.class // the name of the anonymous inner class that was just created 
//		
//		Tester t = () -> {
//			return true;
//		};
//		
//		System.out.println(t.test());
//		
//		Tester t2 = () -> true;
//		
//		System.out.println(t2.test());
		
		List<String> strings = new ArrayList<>();
		strings.add("have");
		strings.add("a");
		strings.add("good");
		strings.add("day");
		System.out.println(strings);
		Collections.sort(strings);
		System.out.println(strings);
		Comparator<String> c = (String a, String b)-> b.compareTo(a);
		Collections.sort(strings,c);
		System.out.println(strings);
		Collections.sort(strings,c);
		System.out.println(strings);
		
		List<String> allAs = strings.stream().filter(string -> string.contains("a")).collect(Collectors.toList());
		System.out.println(allAs);
		List<Integer> ints = strings.stream().map(s-> s.length()).collect(Collectors.toList());
		System.out.println(ints);
		strings.stream().forEach(s -> System.out.println(s));
		strings.stream().filter(s->s.contains("d")).map(s->s.length()).forEach(s->System.out.println(s));
		
		
		
	}

}
