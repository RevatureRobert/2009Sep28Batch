package com.inter.collections;

public class Student implements Comparable<Student> {
	
	private double gpa;
	private String name;
	private String major;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(double gpa, String name, String major) {
		super();
		this.gpa = gpa;
		this.name = name;
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "Student [gpa="+gpa+", name=" + name + ", major=" + major+"]";
	}
	
	
	@Override
	public int compareTo(Student o) {
		return (int)(this.gpa*10 - o.gpa*10);
	}
	
	

}
