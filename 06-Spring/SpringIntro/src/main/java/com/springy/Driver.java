package com.springy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springy.service.MockService;

/**
 * 
 * What is Spring?
 * 	Spring is a module-based open-source Java framework.
 * 	It provides support for enterprise-level applications.
 * 	It provides infrastructure so you can focus on business logic.
 * 	Open-source
 * 
 * Module-based
 * 	A module is a grouping of libraries that work together
 * 		goal is using reusable abstracted code..
 * 		In spring, it is a spring dependency
 * 	Core modules
 * 		ESSENTIALS: Spring-core, Spring-beans, and Spring-context
 * 		ADDED CORE: MVC, ORM, AOP, Security, Boot, Data, Session, ...
 * 		Boot and Data are not allowed for Project 2 because
 * 			they abstract too much of the program; no more daos?
 * 
 * How does Spring achieve its goals?
 * 	Inversion of Control (IoC)
 * 		Give much of the control to Spring
 * 		Don't have to worry so much about ...
 * 		The IoC Container does this,
 * 			what does it do? 
 * 	Model View Controller (MVC)
 * 	Abstraction API -- not discussed here; it does abstract a bit much
 * 	Aspect-Oriented Programming
 * 
 * What is Bean Wiring?
 * 	Creating an association between Spring's container and an object
 * 		you want Spring to manage. This is how we define what beans
 * 		are a dependency on another and let Spring manage them.
 * 
 * Benefits to Dependency Injection
 * 		Maintainability, Cleaner Code, Scalability, Testability,
 * 			reduced complexity, and decouples our code
 * 
 * What is Application Context?
 * 	ApplicationContext is a BeanFactory. It inherits from BeanFactory
 * 		interface. It adds more functionality such as:
 * 			Internationalization, Annotation Support, Enterprise Services, etc.
 * 
 */
public class Driver {

	public static void main(String[] args) {
//		MockService ms = new MockService(new MockDao());
		
		ApplicationContext ac =
				//new ClassPathXmlApplicationContext("beans.xml");
				new ClassPathXmlApplicationContext("beans2.xml");
		
		MockService ms =
//		ac.getBean(MockService.class, "mockwahlburg");
		ac.getBean(MockService.class);
		ac.getBean(MockService.class);
		ac.getBean(MockService.class); // constructor calls only once; this is a singleton!
		
		System.out.println(ms.getAllVotes());
	}

}
