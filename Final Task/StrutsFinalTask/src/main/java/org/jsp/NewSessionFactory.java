package org.jsp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class NewSessionFactory {

	private static SessionFactory sessionFactory;

	private NewSessionFactory() {
		sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSession() {
		if (sessionFactory == null) {
			new NewSessionFactory();
		}
		return sessionFactory;
	}

}
