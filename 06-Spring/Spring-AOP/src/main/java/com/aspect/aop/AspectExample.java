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
 * What is a Joinpoint
 * 		the point in runtime that we can execute our advice.
 * 			our advice take in the joinpoint as a parameter,
 * 			it includes information about the runtime of the 
 * 			program.
 * 
 * What is a pointcut
 * 		used to select certain joinpoints
 * 		used to target certain subsets of
 * 			the joinpoints of the program
 * 
 * Pointcut expressions
 * 		execution			determines that we are looking for joinpoints associated with method executions
 * 		*					wildcard that stands for "anything"
 * 		..					used for parameters for any number
 * 
 * advice timing
 * 		Before
 * 		After
 * 		AfterReturning
 * 		AfterThrowing
 *		Around
 */
@Component
@Aspect
public class AspectExample {
	
	@Before("execution(void paint*(..))")
	public void getPaintReady(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("here is the paint for the pizza captain");
	}
	
	@After("execution(* *(..))")
	public void finishedPainting(JoinPoint jp) {
		System.out.println("the painter has completed another masterpiece");
	}
	
	@AfterReturning("execution(* *(..))")
	public void afterReturn(JoinPoint jp) {
		System.out.println("the method returned something!!!");
	}

	@AfterThrowing("execution(* *(..))")
	public void afterThrow(JoinPoint jp) {
		System.out.println("this got thrown, am i right people?");
	}
	
	@Around("execution(* screamOfJoy())")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("when am i ran?");
		pjp.proceed();
		System.out.println("after, woohoo");
	}
	
}
