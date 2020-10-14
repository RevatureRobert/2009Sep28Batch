import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
		
	}


	
}