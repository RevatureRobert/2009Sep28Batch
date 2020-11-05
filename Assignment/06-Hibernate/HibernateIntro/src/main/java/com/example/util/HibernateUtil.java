package com.example.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Configuration (class)
 * 		Configurations job is to gather information
 * 				from hibernate.cfg.xml or other sources of configuration information
 * 			and use it to create a sessionFactory. 
 * 
 * SessionFactory (interface)
 * 	SessionFactory's job is to create sessions and store information on how to make a connection to 
 * 		your db. Note:Once it is configured, it is immutable. 
 * 
 * Session(interface)
 * 		Session manages the connection to your db and 
 *
 */
public class HibernateUtil {
	private static SessionFactory sesfact;
	
	private static SessionFactory buildSessionFactory() {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		return config.buildSessionFactory();
	}
		
	
	public static SessionFactory getSessionFactory() {
		if(sesfact==null) {
			sesfact = buildSessionFactory();
		}
		return sesfact;
	}
	
}
