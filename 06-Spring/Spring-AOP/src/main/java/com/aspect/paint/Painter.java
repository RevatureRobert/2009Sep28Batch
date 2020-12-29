package com.aspect.paint;

import org.springframework.stereotype.Component;

@Component("artsyFartsy")
public class Painter {
	
	public void paintPizza() {
		System.out.println("The painter has made the gallery hungry.");
	}
	
	public int paintedPizzas() {
		System.out.println("The painter has painted too many pizzas.");
		
		return 7654;
	}
	
	public int damageFromRageQuitting() {
		System.out.println("lol painter go raaaa");
		
		return 100000;
	}
	
	public void screamOfJoy() {
		System.out.println("ghrawwer");
	}
	
	public void paintPizzaHead() {
		System.out.println("I painted a head in the middle of a pizza, what's your lifelong accomplishment?");
	}
	
	public int throwPaint() {
		System.out.println("i said over easy");
		
		throw new RuntimeException("painting is too hard");
	}
}
