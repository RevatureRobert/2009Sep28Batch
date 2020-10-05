package com.friday.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 *  JAVA 8
 * 
 * 		Java 8 was a major version update for the java programming language.
 * 
 * 		Most notably, it introduced functional interfaces and lambdas.
 * 
 * 		Functional interfaces are interfaces with only one method.
 * 
 * 		Lambdas are in-line implementations for functional interfaces.
 * 			Behind the scenes, they are anonymous inner classes that
 * 			only need to implement one method.
 * 
 * 		Default methods were introduced for interfaces to provide a default
 * 			implementation to newly introduced methods, as to not introduce a
 * 			breaking change.
 * 
 * 		Streams API
 * 			Introduced more functional programming style into java. Made working
 * 				with collections and working with the individual methods more
 * 				declarative than imperative. Now we can create an inline implementation
 * 				using lambdas where we would normally spend several lines to get the result.
 * 
 */
public class Java8Driver {
	
	public static Comparator<String> stringDecrease = (a,b) -> b.compareTo(a); //we just used a lambda as a field that we can use anywhere
	
	public static void main(String[] args) {
//		Animal a = new Animal() {};			//we just instantiated an abtract class? NO. We just instantiated a field that extends it
//		
//		System.out.println(a.toString());
		
//		class InnerAnimal extends Animal{ 
//			
//		}
//		
//		Animal b = new InnerAnimal();	//this is functionally the same as the Animal a = new Animal() {};
		
//		class TesterClass implements Tester{ //we can create inner classes that implement interfaces
//			
//			@Override
//			public boolean test() {
//				return false;
//			}
//			
//			
//		}
//		Tester t = new TesterClass();
//		
//		System.out.println(t.test());
		
		//Anonymous Inner Class
		
		//If I only need a class to do one thing one time, if i need to implement a functional interface, this is great
		
//		Animal c = new Animal() { //com.friday.java8.Java8Driver$1.class (class name for this anonymous inner class, java assigned it a name)
//			public String toString() {
//				return super.toString();
//			}
//		};
		
//		Tester t = () -> {	//This is an anonymous inner class for a lambda
//			return true;	//This was introduced as Java's first step into functional programming, to try to keep it relevant
//		};
//		System.out.println(t.test());
//		
//		Tester t2 = () -> true;
//		
//		System.out.println(t2.test());
		
		//When a lambda might be useful
		List<String> strings = new ArrayList<>();
		strings.add("have");
		strings.add("a");
		strings.add("good");
		strings.add("day");
		System.out.println(strings); //should print insertion order
		Collections.sort(strings);
		System.out.println(strings);
//		Comparator<String> c = (String a, String b) -> b.compareTo(a); //compareTo is in comparator, extending comparable, and looks like black magic, but it reverses the array
//		Collections.sort(strings, c);
		Collections.sort(strings, (a,b) -> b.compareTo(a)); //we decreased an entire class, instantiation, and put it into one line
		System.out.println(strings);
		
		
		List<String> allAs = strings.stream().filter(string -> string.contains("a")).collect(Collectors.toList()); //will filter through a list, but will NOT alter it
														   														   //another introduction to functional programming with j8
		System.out.println(allAs);
		List<Integer> ints = strings.stream().map(s->s.length()).collect(Collectors.toList()); //.collect is how we apply whatever map or filter to the list
		System.out.println(ints);
		strings.stream().forEach(s -> System.out.println(s));
		strings.stream().filter(s->s.contains("d")).map(s->s.length()).forEach(s->System.out.println(s));
		
		
	} //end main()
	
	
} //end java8 class
