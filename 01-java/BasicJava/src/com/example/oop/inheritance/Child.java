package com.example.oop.inheritance;

public class Child extends Parent {
	
	static {
		System.out.println("in the child static block");
	}
	
	{
		System.out.println("in the instance block for the child");
	}

	public int age = 12;		//fields can be shadowed by casting. we can get the parents value by up-casting (shadowing)
	private String firstName;
	private double height;

//	public int getAge() {		// we cannot get the parents implementation by upcasting (overridden methods cannot be shadowed)
//		return age;
//	}

	public void setAge(int age) {	
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// super() and this() call the parent and child constructor respectively. They must be 
	//		on the first line of the constructor and cannot both be in the same one.
	public Child() {
		super();
//		this(15, "joe", "doe", 5.4);
		System.out.println("in the child constructor");
	}

	public Child(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
	}

}
