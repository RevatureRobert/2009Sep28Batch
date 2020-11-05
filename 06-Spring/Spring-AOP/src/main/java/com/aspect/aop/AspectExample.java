package com.aspect.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * AOP
 * 		Aspect Oriented Programming
 * 		meant to compliment oop
 * 
 * Spring AOP is an implementation of aspectj
 * 		It simplifies aspectj, but reduces the 
 * 		functionality also.
 * 
 * What is an Aspect?
 * 		In java, a class is the embodyment of 
 * 			an aspect. Conceptually, you can
 * 			think of it as a collection of advice.
 * 
 * What is Advice?
 * 		A procedure for interacting with the program
 * 			during runtime. These take the form
 * 			of methods in Spring AOP.
 * 
 * Crosscutting concerns
 * 		tangling			spaghetti code
 * 		scattering			code duplications
 * 			spring aop attempts to modularize cross cutting concerns
 * 
 * 
 *
 */
@Component
@Aspect
public class AspectExample {
	
	@Before("execution(void paint*())")
	public void getPaintReady(JoinPoint jp) {
		System.out.println("here is the paint for the pizza captain");
	}

}
