package com.rev.animal;
public class Cat extends Animal {
	private int age;
	private String name;
	public Cat(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public void meow() {
		yell();
	}
	
	@Override
	protected void yell() {
		// TODO Auto-generated method stub
		System.out.println("meow meow");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "Name is : " + name + "Age is : " + age;
		return s;
	}
	

}
