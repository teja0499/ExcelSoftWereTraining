package com.org;

import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Update {

	private User user;
	private List<User> users;
	public List<User> getUsers() {
		Get get=new Get();
		return get.getAll();
	}

	

	public void setUser(User user) {
		System.out.println(user);
		this.user = user;
	}

	 public String updateUser() throws Exception {
	        Session session = null;
	        Transaction transaction = null;
	        
	        try {
	            session = NewSessionFactory.getSession().openSession();
	            transaction = session.beginTransaction();
	            
	            Criteria crit = session.createCriteria(User.class);
	            crit.add(Restrictions.eq("id", user.getId()));  

	            User userToUpdate = (User) crit.uniqueResult(); 
	            
	            if (userToUpdate != null) {
	                userToUpdate.setName(user.getName());
	                userToUpdate.setDob(user.getDob());
	                userToUpdate.setGender(user.getGender());
	                userToUpdate.setEmail(user.getEmail());
	                userToUpdate.setMobile(user.getMobile());
	                userToUpdate.setQualification(user.getQualification());
	                userToUpdate.setPassword(user.getPassword());

	                session.update(userToUpdate);  	            }
	            
	            transaction.commit();   

	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();  
	            }
	            e.printStackTrace();
	            return "error";
	        } finally {
	            if (session != null) {
	                session.close();  
	            }
	        }
	        
	        return "success";
	    }
	    


	public User getUser() {
		return user;
	}

}
