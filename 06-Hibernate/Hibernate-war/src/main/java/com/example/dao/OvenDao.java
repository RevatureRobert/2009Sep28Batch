package com.example.dao;

import java.util.List;


import com.example.model.Turkey;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Oven;
import com.example.util.HibernateUtil;

public class OvenDao implements DaoContract<Oven, Integer>{

	@Override
	public List<Oven> findAll() {
		List<Oven> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from oven", Oven.class).list();
		return list;
	}

	@Override
	public Oven findById(Integer i) {

		return null;
	}

	@Override
	public Oven update(Oven t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oven save(Oven t) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.persist(t);
		tx.commit();
		return t;
	}

	@Override
	public Oven delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
