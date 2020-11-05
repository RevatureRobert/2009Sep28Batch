package com.springy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springy.repo.MockDao;
import com.springy.service.MockService;

/**
 * What is Spring?
 * 		Spring is a module based, open source, java framework
 * 		It provides support for enterprise level applications
 * 		It provides infrastructure so you can focus on your 
 * 			applications business logic.
 * 
 * 		Spring has modules, little libraries, that lets you add on top of the spring framework
 * 			Spring core, spring beans, and spring context are the core modules of spring
 *
 * What is a module?
 * 		A grouping of libraries that work together to achieve some goal using reusable abstracted code.
 * 		In spring, it is a spring dependency. 
 * 
 * What are some core modules of spring?
 * 		spring core, spring beans, spring context, spring mvc, spring orm, spring aop, spring security
 * 			spring boot, spring data, spring session, etc. 
 * 
 * How does Spring achieve its goals?
 * 		Inversion of Control(IOC)
 * 		Model View Controller(MVC)
 * 		Abstraction API
 * 		Aspect Oriented Programming
 * 		
 * What is Bean wiring?
 * 		Creating an association between Spring's container and an object
 * 			you want spring to manage. This is how we define what beans are
 * 			a dependency on another and let spring manage them.
 * 
 * Benefits to Dependency Injection
 * 		Maintainability, Cleaner code, scalability, testability,
 * 			reduces complexity, and decouples our code. 
 * 
 * What is Application Context?
 * 		ApplicationContext is a BeanFactory. It inherits from BeanFactory
 * 				interface. It add more functionality such as:
 * 					internationalization, Annotation support, Enterprise Services, etc. 
 * 
 *
 */
public class Driver {
	 
	public static void main(String[] args) {
//		MockService ms = new MockService(new MockDao());
		ApplicationContext ac = 
				//new ClassPathXmlApplicationContext("beans.xml");
				new ClassPathXmlApplicationContext("beans2.xml");
		MockService ms = ac.getBean(MockService.class, "mockservice");
//		 ac.getBean(MockService.class);
//		 ac.getBean(MockService.class);
//		 ac.getBean(MockService.class);
//		 ac.getBean(MockService.class);
//		 ac.getBean(MockService.class);
		System.out.println(ms.getAllVotes());
	}

}
