package com.springy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring boot is an opinionated answer to common web applications.
 * It is opinionated because of the pure bulk that comes with packaging
 * 		the application and the selected modules that go into it. 
 * 
 * The application is packaged as an executable jar with tomcat bundled
 * 		inside of it. Executing it will start tomcat and the rest of 
 * 		the spring modules.
 * 
 * The spring initializr(this is spelled right) is a way of creating a spring boot application. You can also use spring.starter.io
 *
 */

@SpringBootApplication
public class SpringBootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataApplication.class, args);
	}

}
