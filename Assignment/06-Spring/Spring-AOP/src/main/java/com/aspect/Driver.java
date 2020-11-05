package com.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aspect.paint.Painter;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beaniebaby.xml");
		Painter p = ac.getBean(Painter.class);
		p.paintPizza();
		p.paintedPizzas();
		p.screamOfJoy();
	
	}
}