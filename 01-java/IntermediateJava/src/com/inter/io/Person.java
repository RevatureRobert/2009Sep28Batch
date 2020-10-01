package com.inter.io;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int age;
	transient private int ssn;
	
	
	
	
	
	public Person(String name, int age, int ssn) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
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
		// TODO Auto-generated method stub
		String s =  "Person Name: " +this.name +"\n Their Age: " + this.age + " \n Their SSN: " +this.ssn;  
		return s;
	}
	
}
