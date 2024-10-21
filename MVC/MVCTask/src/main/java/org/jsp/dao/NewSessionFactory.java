package org.jsp.dao;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

public class NewSessionFactory {

    private static SessionFactory sessionFactory;

//    private NewSessionFactory() {
//        // Create the StandardServiceRegistry
//        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
//                .build();
//
//        // Create the MetadataSources
//        MetadataSources metadataSources = new MetadataSources(standardRegistry);
//
//        // Create Metadata
//        Metadata metadata = metadataSources.getMetadataBuilder().build();
//
//        // Create the SessionFactory
//        sessionFactory = metadata.getSessionFactoryBuilder().build();
//    }
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
