package com.inter.io;

import java.io.Serializable;

public class Person implements Serializable{

	private transient String name; // If an item is marked transient, it will not be written to file
	private int age;
	private int ssn;



	public Person(String name, int age, int ssn) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
	}



	public static void main(String[] args) {
		
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

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
	
	@Override
	public String toString() {
		return ("Person [name = " + name + ", age = " + age + ", ssn = " + ssn + "]");
	}
}
