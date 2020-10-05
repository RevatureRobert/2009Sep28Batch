package com.example.oop.inheritance;

public class Parent {

	static {
		System.out.println("In the class block");
	}
	
	//instance block - curly braces with no declaration
	{
		System.out.println("In the instance block - parent");
	}	//this runs first, then parent constructor, then child instance, then child constructor
		//parent has to be completely done before anything can be started in the child
		//this is demonstrating the Order of Instantiation
	
	public int age = 30; //setting the age like this initializes this in case we use the default constructor
						 //fields can be shadowed by casting. we can get the parent's value by upcasting (shadowing)
	private String firstName;
	private String lastName;
	private double height;
	
	//you can create getters and setters by right clicking, source, generate getters and setters
	public int getAge() {
		return age;
	}
	public void setAge(int age) {	//we cannot get the parent's implementation by upcasting (overridden methods cannot be shadowed)
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//you can also generate this using source, generate constructor with fields
	public Parent(int age, String firstName, String lastName, double height) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
	}
	
	//am=nd you can generate this using source
	public Parent() {
		super();
		System.out.println("In the parent constructor"); //using this and the same in the child shows that the parent constructor runs first
	}
	
	{
		System.out.println("Instance block under constructor - parent");
		System.out.println("My age is "+age); //this statement can run in this block, but not in the top one, because age hasn't been initialized yet for the top one
	} //this will run before the constructor, but after the other instance block
	

	
}
