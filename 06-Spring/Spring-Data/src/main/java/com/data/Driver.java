package com.data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.data.model.Toys;
import com.data.repo.ToyRepository;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
//		ac.getBean(ToyRepository.class).save(new Toys(0, "soldier", false));
	}

}
