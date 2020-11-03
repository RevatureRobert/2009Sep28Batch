package com.example.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Oven;
import com.example.model.Turkey;
import com.example.util.HibernateUtil;

public class OvenDao implements DaoContract<Oven, Integer>{

	@Override
	public List<Oven> findAll() {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		List<Oven> ovens = sess.createNativeQuery("select * from turkeys.oven", Oven.class).list();
		return ovens;
	}

	@Override
	public Oven findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Oven o = sess.get(Oven.class, i);
		return o;
	}

	@Override
	public Oven update(Oven t) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(t);
		tx.commit();
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
		Oven o = findById(i);
		Set<Turkey> turkies = new HashSet<>();
		turkies = o.getTurkeys();

		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();

		sess.delete(turkies);
		sess.delete(o);

		tx.commit();
		return o;
	}

}
