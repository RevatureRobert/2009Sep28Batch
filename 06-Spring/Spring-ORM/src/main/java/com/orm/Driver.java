package com.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dao.CandyTacoDao;
import com.orm.model.CandyTaco;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		CandyTacoDao ctd = ac.getBean(CandyTacoDao.class);
		ctd.insert(new CandyTaco(0, true, "chocolate", "m&m's"));
		ctd.insert(new CandyTaco(0, false, "hot cream", "skittles"));
		System.out.println(ctd.findAll());
		System.out.println(ctd.findBySauce("chocolate"));
	}
}
