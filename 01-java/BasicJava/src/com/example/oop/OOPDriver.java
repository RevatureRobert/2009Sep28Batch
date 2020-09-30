package com.example.oop;


// * brings in all classes inside a package, but not sub packages
// you can create naming collisions by importing two classes with 
//		the same name. If that is the case, you need to specify it.
import com.example.oop.encapsulation.HubCap;
import com.example.oop.inheritance.Child;
import com.example.oop.inheritance.Parent;
import com.example.oop.abstraction.FirstAbstract;
import com.example.oop.accesscheck.*;
public class OOPDriver {

	
	public static void main(String[] args) {
		
		// encapsulation
//		HubCap h = new HubCap(17.5, "orange", "badCapsShop");
//		// fully quialified name
//		//com.example.oop.accesscheck.FirstHubCap first = new com.example.oop.accesscheck.FirstHubCap();
//		FirstHubCap first = new FirstHubCap();
		
		// inheritance
//		Parent p = new Parent(35, "Samantha", "Smith", 6.0);
//		System.out.println(p.getHeight());
//		Child c = new Child(12, "brat", "danger", 3.0);
//		System.out.println(c.getLastName());
		
		//casting
//		Parent c = new Child();
//		System.out.println(c.age);  // parents value, because we are using a parent reference (up casting)
//		System.out.println(((Child)c).age);	// childs value, because we are using the child reference (down casting)
//		Child p = (Child) new Parent();  // this is a no no
		
//		Parent p = new Child();
//		System.out.println(p.getAge());
//		System.out.println(((Child)p).getAge());
//		
		
		Child c = new Child();
		toString(c);
		
//		FirstAbstract f = new FirstAbstract();  // cannot instantiate an abstract class
	}
	
	// polymorphic parameters: the ability to up-cast to a parent gives us the ability to make a method that
	//		takes in a parent or interface and we can use whatever instance we want with it, as long as it inherits
	//		from the parent or interface.
	public static String toString(Parent p) {
		return p.toString();
	}
}
