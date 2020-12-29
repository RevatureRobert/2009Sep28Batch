package com.example;

import com.example.dao.TurkeyDao;
import com.example.model.Turkey;

public class Driver {

	public static void main(String[] args) {
		TurkeyDao td = new TurkeyDao();
		Turkey t1 = new Turkey(0,"ronald",56.0,false);
		Turkey t2 = new Turkey(0, "arnold", 23.0, true);
		Turkey t3 = new Turkey(0,"gabriel",421.0, false);
		
		td.save(t1);
		td.save(t2);
		td.save(t3);
		
		System.out.println(td.findAll());
	}
}
