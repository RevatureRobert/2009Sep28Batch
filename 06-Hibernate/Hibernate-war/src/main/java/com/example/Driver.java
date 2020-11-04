package com.example;

import java.util.HashSet;

import com.example.dao.OvenDao;
import com.example.model.Oven;
import com.example.model.Turkey;

public class Driver {

	public static void main(String[] args) {
		Oven o = new Oven(0, "stainless steel", 350, new HashSet<>());
		Turkey t1 = new Turkey(0, "googis", 100, true, o);
		Turkey t2 = new Turkey(0, "dont care", 25, true, o);
		Turkey t3 = new Turkey(0, "hallows turkey",50, true, o);
		o.getTurkeys().add(t1);
		o.getTurkeys().add(t2);
		o.getTurkeys().add(t3);
		OvenDao od = new OvenDao();
		od.save(o);
		System.out.println(od.findById(1));

		System.out.println(":D :D :D :D :D");
	}
}
