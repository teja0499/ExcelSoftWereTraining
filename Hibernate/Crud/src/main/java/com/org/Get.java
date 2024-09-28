package com.org;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Get {
	private List<User> users;

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
public List<User> getAll() {
  users = new ArrayList<>();
    String hql = "FROM User"; 
    Session session = null;
    Transaction transaction = null;
    
    try {
        session = NewSessionFactory.getSession().openSession();
        transaction = session.beginTransaction();
     
        Query query = session.createQuery(hql);
        users = query.list(); 
        
        transaction.commit(); 

    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback(); 
        }
        System.out.println("Error retrieving users: " + e.getMessage());
    } finally {
        if (session != null) {
            session.close(); 
        }
    }

    return users;
  }
}
