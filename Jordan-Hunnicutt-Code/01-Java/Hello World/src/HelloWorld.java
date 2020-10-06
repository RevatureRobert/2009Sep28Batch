import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Notes about Java
/*
•	Why Java? Write Once, Run Anywhere
o	Also Object oriented language
o	Strictly typed
o	Modular
o	Been around, widely used
o	Strong backing from oracle
o	Automatic garbage collection
•	Jdk (java development kit), jre (java runtime environment), jvm (java virtual machine)
o	Jvm allows java compiled into bytecode to run on any machine
o	Jre holds jvm and core library, minimum needed to run a java program
o	Jdk holds compiler are jre, minimum needed to write java code
•	OOP is programming paradigm viewing everything as objects
o	4 Pillars
	A – Abstraction: hiding implementation or logic, we don’t care how its done, as long as it is done
	P – Polymorphism: the ability to differ in the same ability. Do something different, even though it is the same action
	I – Inheritance: class based inheritance, classes inherit traits and properties from its parent
	E – Encapsulation: restricting direct access to data
•	A class is a blueprint for an object, an object is the building blocks of a program

*/
public class HelloWorld{
	
	public static void main(String[] args) {
		System.out.println("Hello World");

		//System.out.println(Integer.MAX_VALUE);
		
	}

	public int calculateNthPrime(int i) throws IllegalArgumentException{
		// TODO Write an implementation for this method declaration
		List<Integer> primeArr = new ArrayList<>(); //first, we make an array to hold all of the prime numbers we find
		
		if(i <= 0) {	//if looking for the 0th or negative prime integer, throw an exception
			throw new IllegalArgumentException();
		}
		
		for(int j = 0; i != primeArr.size(); j++) { //here, j will be the number we're checking to see if it is prime
													//as long as i is not equal to the size of the array, we'll keep checking
													//each time we loop, we increase j so we can check a new int
			
			if(primeArr.isEmpty()) {	//first, if the prime array is empty
				primeArr.add(2);		//we add 2
				j = 2;					//and we set j to be 2
			} else {
				for(int prime : primeArr) {	//otherwise, we're going to iterate through the array of prime numbers
					
					if(j % prime == 0) {	//if j can be divided by the prime numbers with no remainder,
						break;				//break out of this loop, the number is not prime
					} else {
						//if()
						
						
						
					}
				}
				
			}
			
			if(i == primeArr.size()) { //if the prime number array is big enough to hold the index we're looking for
				return primeArr.get(i - 1);	//return the prime number at that index
			}
			
			

			
		}
		
		
		return 0;
	}
	

	
	
}