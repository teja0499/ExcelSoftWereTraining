package com.org;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Login {
	private String email;
	private String password;
	private User user;
	public void setEmail(String email) {
		this.email = email;
		System.out.println("setEmail called");
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("setPassword called");
	}

	public List<User> getUsers() {
		Get get = new Get();
		return get.getAll();
	}

	public String login() {
	    Session session = null;
	    Transaction transaction = null;
	    try {
	        session = NewSessionFactory.getSession().openSession();
	        transaction = session.beginTransaction();
	        
	        String query = "FROM User WHERE email = :email AND password = :password";
	        user = (User) session.createQuery(query)
	                             .setParameter("email", email)
	                             .setParameter("password", password) 
	                             .uniqueResult();
	        
	        session.getTransaction().commit();
	        
	        if (user != null) {
	            return "success";
	        } else {
	            return "failure";
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println(e);
	        return "error";
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

	
	
}
