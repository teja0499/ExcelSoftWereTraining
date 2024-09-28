package org.abcd.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Controller {

    private String name;
    private String mobile;
    private User user;
    private int id;
    
    private Session getSession() {
        return new AnnotationConfiguration().configure("hibernate.cfg.xml")
                                             .buildSessionFactory()
                                             .openSession();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User getUser() {
        return user;
    }

    public String saveUser() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            System.out.println("Inside saveUser method");
            user = new User(name, mobile);
            session.save(user);
            transaction.commit();
            System.out.println("Successfully saved user: " + user);
            return "success";
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return "failure";
        } finally {
            session.close();
        }
    }

    public String getUserById() {
        Session session = getSession();
        
        try {
            user = (User) session.get(User.class, id);
            if (user != null) {
                System.out.println("User found: " + user);
                return "success";
            } else {
                System.out.println("User with id " + id + " not found.");
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        } finally {
            session.close();
        }
    }

    public String deleteUser() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            System.out.println("Attempting to delete user with id = " + id);
            user = (User) session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                transaction.commit();
                System.out.println("Successfully deleted user: " + user);
                return "success";
            } else {
                System.out.println("User with id " + id + " not found.");
                return "error";
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); 
            }
            e.printStackTrace();
            return "failure";
        } finally {
            session.close();
        }
    }


    public String updateUser() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            System.out.println("Inside updateUser method");
            user = new User(id, name, mobile);
            session.update(user);
            transaction.commit();
            System.out.println("Successfully updated user: " + user);
            return "success";
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return "failure";
        } finally {
            session.close();
        }
    }
}
