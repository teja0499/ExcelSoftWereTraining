//package com.org;
//
//import javax.persistence.criteria.CriteriaBuilder;
//
//import org.hibernate.Session;
//
//public class Repo {
//
//	 public static User getUserByEmail(String email)  {
//	       
//	        Session  session = NewSessionFactory.getSession().openSession();
//	        session.beginTransaction();
//
//	        CriteriaBuilder cb = session.getCriteriaBuilder();
//
//	        CriteriaQuery<User> cr = cb.createQuery(User.class);
//	        Root<User> root = cr.from(User.class);
//	        cr.select(root).where(cb.equal(root.get("email"), email));  //here you pass a class field, not a table column (in this example they are called the same)
//
//	        Query<User> query = session.createQuery(cr);
//	        query.setMaxResults(1);
//	        List<User> result = query.getResultList();
//	        session.close();
//
//	        return result.get(0);
//	  }
//}
