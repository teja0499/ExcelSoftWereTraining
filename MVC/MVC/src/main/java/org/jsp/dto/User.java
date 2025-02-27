package org.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dob;
	private String gender;
	private String password;
	private String email;
	private String mobile;
	private String qualification;
	
	public User(int id, String name, String dob, String gender, String password, String email, String mobile,
			String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.qualification = qualification;
	}
	
	
	
	public User(String name, String dob, String gender, String password, String email, String mobile,
			String qualification) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.qualification = qualification;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public String execute()
	{
		System.out.println("user");
		return "success";
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile + ", qualification=" + qualification + "]";
	}
}


