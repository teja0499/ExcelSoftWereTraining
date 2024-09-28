package com.org;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class SearchFunction {

	private String name;
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {

		return users;
	}

	


	public void setName(String name) {
		this.name = name;
	}

	public String search() {
		users= searchByName(name);
		return "success";
	}

	
	public List<User> searchByName(String name) {
	    Session session = null;
	    List<User> users = new ArrayList<>();
	    try {
	    	System.out.println(1);
	        session = NewSessionFactory.getSession().openSession();
	        System.out.println(2);
	        String query = "FROM User WHERE name LIKE :name";
	        users = (List<User>) session.createQuery(query)
	                                    .setParameter("name", "%" + name + "%")
	                                    .list();
	        
	        
	        System.out.println(3);
	        System.out.println(users);
	        return users;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

}
