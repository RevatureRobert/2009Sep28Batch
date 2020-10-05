package com.example.oop.inheritance;

public class Child extends Parent{
	
	//instance block - curly braces with no declaration
	{
		System.out.println("In the instance block - child");
	}
	
	
	public int age = 12; //setting the age like this initializes this in case we use the default constructor
	private String firstName;
	private double height;
	
	public int getAge() {
		return age;
	}
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
	
	//super() and this() call the parent and child constructor respectively.  They must be
	//		on the first line of the constructor, and both cannot be in the same one.
	public Child() {
		super();
//		this(15, "joe", "doe" 5.4);
		System.out.println("In the child constructor"); //using this and the same in the parent shows that the parent constructor runs first
	}
	public Child(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
	}
	
	
	
}
