package com.org;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteUser {
private int id;
private List<User> users;
public List<User> getUsers() {
	Get get=new Get();
	return get.getAll();
}

public void setUsers(List<User> users) {
    this.users = users;
}


public int getId() {
	System.out.println("get id"+ id);
	return id;
}

public void setId(int id) {
	System.out.println("set id "+id);
	this.id = id;
}


public String deleteUser()
{
	 Session session = null;
	    Transaction transaction = null;
	String query = "";
	try {
		
		 session = NewSessionFactory.getSession().openSession();
	        transaction = session.beginTransaction();
	        User user=user =  (User) session.get(User.class, id);
	        session.delete(user);
	        transaction.commit();
		
	}catch (Exception e) {
		// TODO: handle exception
		if (transaction != null) {
			transaction.rollback();
		}
		System.out.println(e);
//		return"error";
	} finally {
		if (session != null)
			session.close();
	}
	return "success";

}

}
