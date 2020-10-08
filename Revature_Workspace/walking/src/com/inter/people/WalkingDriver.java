package com.inter.people;

import com.inter.animals.*;

public class WalkingDriver {
public static void main(String[] args) {
	Person me = new Person();
	Dog hanky = new Dog();
	
	System.out.println(hanky.makeSound());
	
	System.out.println(me.getPet());
}
}
