package com.rev.animal;
public class Dog extends Animal{
	private String name;
	private int age;
	
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void bark() {
		yell();
	}
	
	@Override
	protected void yell() {
		// TODO Auto-generated method stub
		System.out.println("Bark Bark Bark");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "Name is : " + name + "Age is : " + age;
		return s;
	}
}
