package org.jsp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NewSessionFactory {

    private static SessionFactory sessionFactory;

    private NewSessionFactory() {
        // Create the Configuration object and configure it
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml"); 
//        sessionFactory = configuration.buildSessionFactory();
    	 sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSession() {
        if (sessionFactory == null) {
            new NewSessionFactory();
        }
        return sessionFactory;
    }
}
