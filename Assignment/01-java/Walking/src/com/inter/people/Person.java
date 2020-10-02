package com.inter.people;

import com.inter.pets.Cat;

public class Person {
	
	private Cat bob;
	
	public Person() {
		this.bob = new Cat();
	}

	public Cat getBob() {
		return bob;
	}

	public void setBob(Cat bob) {
		this.bob = bob;
	}
	
	

}
