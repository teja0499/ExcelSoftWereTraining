package org.jsp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsp.dto.User;
import org.springframework.stereotype.Repository;

import oracle.net.aso.s;




@Repository
public class UserDao {

	public void addUser(User user)
	{

		System.out.println(user);
		Session session = null;
		Transaction transaction = null;
		try {

			//user = new User(name, dob, gender, password, email, mobile, qualification);
			session = NewSessionFactory.getSession().openSession();
			transaction = session.beginTransaction();
			if(user.getId()==0)
			{
				session.save(user);
				System.out.println("save user done");
			}
			else 
			{
				session.merge(user);
				System.out.println("update user done");
			}
			transaction.commit();
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e);
			System.out.println("save user not done");
//			return"error";
		} finally {
			if (session != null)
				session.close();
		}
		System.out.println("final");
	}
	
	public List<User> getAllUser()
	{
		Session session = null;
		List<User>users=null;
		try {
			session=NewSessionFactory.getSession().openSession();
			String hql="from User";
			users=session.createQuery(hql).list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return users;
	}

	public void deleteUserById(int id) {

		Session session = null;
	    Transaction transaction = null;
		try {
			
			 session = NewSessionFactory.getSession().openSession();
		        transaction = session.beginTransaction();
		        User user=user =  (User) session.get(User.class, id);
		        session.delete(user);
		        transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	public List<User> getUserByName(String name){
		Session session = null;
		List<User>users=null;
		try {
			 session = NewSessionFactory.getSession().openSession();
		        String query = "FROM User WHERE name LIKE :name";
		        users = (List<User>) session.createQuery(query)
		                                    .setParameter("name", "%" + name + "%")
		                                    .list();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return users;
	}
	
	public User getuser(int id)
	{
		Session session = null;
		User user = null;
		try {
			session=NewSessionFactory.getSession().openSession();
			 String query = "FROM User WHERE id = :id";
		        user = (User) session.createQuery(query)
		                             .setParameter("id", id)
		                             .uniqueResult(); 
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return user;
	}
}
