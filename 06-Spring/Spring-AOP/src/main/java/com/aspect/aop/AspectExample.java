package com.aspect.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * AOP
 * 	Aspect-Oriented Programming
 * 		Meant to complement OOP to decouple winding logic / spaghetti code
 * 
 * 	Spring AOP is an implementation of AspectJ
 * 		AspectJ is the standardization of AOP in Java
 * 		Spring AOP simplifies AspectJ, losing some functionality for ease of use
 * 
 * 	What is an Aspect?
 * 		A class that's the embodiment of a group of advice to interact with the runtime
 * 
 * 	What is advice?
 * 		A method that's the procedure for interacting with the program during runtime.
 * 		Outside of Spring AOP, it's not always a method; we're not concerned with this.
 * 
 * 	Crosscutting concerns that this addresses...
 * 		tangling		Concerns that cut across your app; a problem in class A that originates in class B
 * 						Spaghetti code
 * 		scattering		Code duplication
 * 						One function requiring several classes to carry out
 * 
 * Point cuts, join points, timing, ...
 * 
 * 	What is a JoinPoint?
 * 		The points in time that we can join in at
 * 		They have information about the runtime
 * 		
 * 		The implementation is the point in runtime that we execute our advice;
 * 			our advice takes in the joinpoint as a parameter, and it includes the info
 * 			about runtime of the program, a bit like hooks
 * 
 * 	What is a pointcut?
 * 		The point in time that we can cut into; at what point are we looking at to cut into?
 * 		Used to target certain subsets of the joinpoints of the program
 * 
 * 	Pointcut expressions
 * 		execution		Determines what we are looking for joinpoints associated with method executions
 * 		*				Wildcard that stands for "anything"
 * 		..				Varargs; used for any number of parameters
 * 
 * 	Advice timing
 * 		Before
 * 		After
 * 		AfterReturning
 * 		AfterThrowing
 * 		Around				Can prevent the method from executing
 */

@Component
@Aspect
public class AspectExample {
	
	// When the execution occurs on a method that uses this signature, run this method before that
	@Before("execution(void paint*())")
	public void getPaintReady(JoinPoint jp) {
		System.out.println(jp.getSignature());
		
		System.out.println("here is the paint for the pizza, captain");
	}
	
	
	@After("execution(* *(..))") // * * means any return type and any method name
	public void finishedPainting(JoinPoint jp) {
		System.out.println("The painter has completed another masterpiece!");
	}
	
	@AfterReturning("execution(* *(..))")
	public void afterReturn(JoinPoint jp) {
		System.out.println("The method returned something!!");
	}
	
	// shows up before "After"
	@AfterThrowing("execution(* *(..))")
	public void afterThrow(JoinPoint jp) {
		System.out.println("This got thrown.");
	}
	
	@Around("execution(* screamOfJoy())")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		pjp.getArgs(); // returns an Object array of all the args
		
		System.out.println("AROUND: When am I run?");
		
		pjp.proceed(); // makes it run the method
		
		System.out.println("after, woo");
	}
}
