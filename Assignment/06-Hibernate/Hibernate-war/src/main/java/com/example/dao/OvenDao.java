package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Oven;
import com.example.model.Turkey;
import com.example.util.HibernateUtil;

public class OvenDao implements DaoContract<Oven,Integer>{

	@Override
	public List<Oven> findAll() {
		List<Oven> list = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from oven", Oven.class).list();
		return list;
	}

	@Override
	public Oven findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Oven o = sess.get(Oven.class,  i);
		return o;
	}

	@Override
	public Oven update(Oven t) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.update(t);
		return t;
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
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.createQuery("delete from Oven where id = '" + i + "'", Oven.class);
		return null;
	}

}
