package com.springy.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.springy.repo.MockDao;

/**
 *
 * Stereotypes are annotations that tell spring that the class
 * 		is going to be a spring bean and what responsibilities they 
 * 		are going to have. 
 * 
 * There is a hierarchy to stereotypes
 * 		@Component is the parent of them all
 * 		@Service 			denotes a service class
 * 		@Controller			denotes a controller class
 * 		@Configuration		denotes a configuration class
 * 		@Repository			denotes a data access class
 * 		@RestController		denotes a controller for a RESTful api. 
 *
 */

@Service(value = "mockService")
//@Scope("singleton") you can define the scope of the bean here. 
public class MockService {
	@Autowired
	private MockDao md;

//	@Autowired
	public MockService(MockDao md) {
		super();
		this.md = md;
		System.out.println("in the args constructor");
	}

	public MockService() {
		super();
		System.out.println("In the no arg constructor");
	}

	public Map<String, Integer> getAllVotes() {
		return md.getAllVotes();
	}

	public MockDao getMd() {
		return md;
	}
//	@Autowired
	public void setMd(MockDao md) {
		this.md = md;
		System.out.println("In the setter");
	}

}
