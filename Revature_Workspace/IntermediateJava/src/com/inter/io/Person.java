package com.inter.io;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int age;
	private int ssn;
	
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
//	public String toString() {
//		return "name: "+ this.name + this.age + this.ssn;
//	}
	
}
