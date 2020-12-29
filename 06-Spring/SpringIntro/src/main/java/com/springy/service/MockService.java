package com.springy.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.springy.repo.MockDao;

/**
 * 
 * Stereotypes
 * 	Tells Spring what classes are spring beans and what type of spring bean they'll be
 * 	They're annotations telling Spring that the class is going to be a spring bean and
 * 		what responsibilities they will have.
 * 
 * Stereotype hierarchy
 * 	@Component		The parent of them all
 * 	@Service		service class
 * 	@Controller		controller class
 * 	@Configuration	configuration class
 * 	@Repository		data access class
 * 	@RestController	RESTful API controller
 * 						controller with ...
 */
@Service(value = "mockservice")
@Scope("singleton") // change the scope of the bean; 
public class MockService {
	
	@Autowired // injects into a private field... works but you shouldn't use it; support is unofficial
	private MockDao md;

	public MockService() {
		super();
		System.out.println("MockService No-arg constructor!");
	}

	@Autowired // autowires the MockDao bean into this bean
	public MockService(MockDao md) {
		super();
		this.md = md;
		System.out.println("MockService constructor!");
	}
	
	public Map<String, Integer> getAllVotes(){
		return md.getAllVotes();
	}

	public MockDao getMd() {
		return md;
	}

//	@Autowired // injects a setter
	public void setMd(MockDao md) {
		System.out.println("MockService MockDao setter!");
		
		this.md = md;
	}
}
