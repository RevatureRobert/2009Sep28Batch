package com.example;

import java.util.HashSet;

import com.example.dao.OvenDao;
import com.example.model.Oven;
import com.example.model.Turkey;

public class Driver {

	public static void main(String[] args) {
		Oven o = new Oven(0, "stainless steel", 350, new HashSet<>());
		
		Turkey t1 = new Turkey(0, "goongis", 50, true, o);
		Turkey t2 = new Turkey(0, "dongus", 25, true, o);
		Turkey t3 = new Turkey(0, "ra", 100, false, o);
		
		o.getTurkeys().add(t1);
		o.getTurkeys().add(t2);
		o.getTurkeys().add(t3);
		
		OvenDao od = new OvenDao();
		
		od.save(o);
		
		System.out.println(od.findById(1));
	}
}
