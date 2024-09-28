package com.org;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Register {

	private String name;
	private String dob;
	private String gender;
	private String password;
	private String email;
	private String mobile;
	private String qualification;
	private User user;

	public void setName(String name) {
		System.out.println(" set name " + name);
		this.name = name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String register() {

		Session session = null;
		Transaction transaction = null;
		try {

			user = new User(name, dob, gender, password, email, mobile, qualification);
			session = NewSessionFactory.getSession().openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			System.out.println("save user done");

		} catch (Exception e) {
			// TODO: handle exception
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e);
//			return"error";
		} finally {
			if (session != null)
				session.close();
		}
		return "success";

	}

}
