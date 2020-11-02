package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.example.model.Turkey;
import com.example.util.HibernateUtil;

/**
 * Ways of making queries in hibernate
 * 
 * 		session methods
 * 			oop style crud operations
 * 		native queries
 * 			sql syntax used in session methods
 * 		Criteria API
 * 			an oop design for make complex queries
 * 		HQL
 * 			Hibernate Query Language, a mix of oop queries
 * 				and sql queries
 */
public class TurkeyDao implements DaoContract<Turkey, Integer>{
	

	@Override
	public List<Turkey> findAll() {
		List<Turkey> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from turkey", Turkey.class).list();
		return list;
	}

	@Override
	public Turkey findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Turkey update(Turkey t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Turkey save(Turkey t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Turkey delete(Integer i) {
		return null;
	}
	
	public Turkey findByName(String name) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		//Criteria API
		//	Hibernate 4
//		Criteria criteria = sess.createCriteria(Turkey.class);
//		criteria.add(Restrictions.like("name", name));
//		return (Turkey) criteria.list().get(0);
		
		//	hibernate 5
//		CriteriaBuilder cb = sess.getCriteriaBuilder();
//		CriteriaQuery<Turkey> cq = cb.createQuery(Turkey.class);
//		Root<Turkey> rt = cq.from(Turkey.class);
//		cq.select(rt).where(cb.like(rt.get("name"),  name));
//		Query<Turkey> q = sess.createQuery(cq);
//		return q.getResultList().get(0);
		
		//	HQL
		return sess.createQuery("from Turkey where name = '"+name+"'", Turkey.class).list().get(0);
//		return null;
	}

}
