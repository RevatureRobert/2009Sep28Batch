package com.example.oop;

import com.example.oop.encapsulation.HubCap;
import com.example.oop.accesscheck.*;    //* brings all of the classes within this package, but not sub packages
										 // can't bring accesscheck.HubCap because it means there are 2 classes named HubCap, creates a naming collision.  In that case, you must specify it.
import com.example.oop.inheritance.Parent;
import com.example.oop.inheritance.Child;

public class OOPDriver {
	
	public static void main(String[] args) {
		
		/* Encapsulation
		
		HubCap h = new HubCap(17.5, "orange", "badCapsShop"); //even though this is a 'parent' package, still have to import the class
		//the above statement doesn't cause an error because we specifically imported this class instead of using a wildcard
		//that gives this hubcap class priority over the other one
		
		//say you didn't want to add an import statement.  Like if you wanted to use something once and that's it.
		//you can use a fully qualified name
		//this is also useful if you had classes from multiple packages with the same name, like two hubcaps
		//com.example.oop.accesscheck.FirstHubCap first = new com.example.oop.accesscheck.FirstHubCap();
		FirstHubCap second = new FirstHubCap(); //since we imported accesscheck, we can use this method without having to use fully qualified name
		
		*/
		
		//inheritance
	//	Parent p = new Parent(35, "Samantha", "Smith", 6.0);
	//	System.out.println(p.getHeight());
	//	Child c = new Child(12, "brat", "danger", 4.5);
	//	System.out.println(c.getFirstName());
	//	Parent c2 = new Child(); //this is casting
	//	System.out.println(c2.age);	//parents value, because we use parent reference (up casting)
	//	System.out.println(((Child)c2).age); //child's value, because we use child reference (down casting)
	//	Child p2 = (Child) new Parent(); //you can't do this, causes an error
		
		//you cannot cast using overwritten methods, it will always reference the specific instance.  A parent acting as a child ref will always use child's getAge. A child acting as a parent ref will always use parent's getAge.
		
	//	Parent c3 = new Child(); //test this part with parent getage commented, and then child getage commented
	//	System.out.println(c3.getAge());
	//	System.out.println(((Child)c3).getAge());
		
	//	Child c4 = new Child();
	//	toString(c4);
		
	//	FirstAbstract fa = new FirstAbstract();   //This doesn't work, you can't instantiate an abstract class
	}
	
	//When would you want to upcast?
	public static String toString(Object p) { //this allows you to take as many classes as you need to, and treat them all as a parent
		//this is an example of polymorphic parameters
		return p.toString();
	}
	
}
