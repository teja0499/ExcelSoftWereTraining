package org.jsp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NewSessionFactory {
	 private static SessionFactory sessionFactory;
	 
	    private NewSessionFactory() {

	    	 sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    }

	    public static SessionFactory getSession() {
	        if (sessionFactory == null) {
	            new NewSessionFactory();
	        }
	        return sessionFactory;
	    }
}
