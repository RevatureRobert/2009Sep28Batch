package com.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orm.model.CandyTaco;

@Repository
@Transactional // says that every method in the class is transactional
public class CandyTacoDao {
	
	private SessionFactory sessfact;

	@Autowired
	public CandyTacoDao(SessionFactory sessfact) {
		super();
		this.sessfact = sessfact;
	}
	public CandyTacoDao() {}
	
	@Transactional
	public void insert(CandyTaco ct) {
		/*// Hibernate method without transactional annotation
		Session sess = sessfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(ct);
		tx.commit();
		*/
		
		sessfact.openSession().save(ct);
	}
	
	public CandyTaco findById(int id) {
		return sessfact.openSession().get(CandyTaco.class, id);
	}
	
	public List<CandyTaco> findAll(){
		// Remember: in HQL you get from the class name
		// This has injection protection even when parts are just concatenated in!
		return sessfact.openSession().createQuery("from CandyTaco", CandyTaco.class).list();
	}
	
	
}
