package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Oven;
import com.example.util.HibernateUtil;

public class OvenDao implements DaoContract<Oven, Integer> {

	@Override
	public List<Oven> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oven findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Oven o = sess.get(Oven.class, i);
		return o;
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
		return null;
	}

	@Override
	public Oven delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
