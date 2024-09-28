package com.org;


public class EditUser {

	private int id;
	private String name;
	private String dob;
	private String gender;
	private String password;
	private String email;
	private String mobile;
	private String qualification;
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
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


	public String editUser()
	{
		user=new User(id, name, dob, gender, password, email, mobile, qualification);
		System.out.println(id);
		System.out.println(password);
		return "success";
	}
	
}
