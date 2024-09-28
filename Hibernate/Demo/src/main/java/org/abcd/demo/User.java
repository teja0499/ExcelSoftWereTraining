package org.abcd.demo;

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
private String mobile;

public User() {
}



public User(int id, String name, String mobile) {
	super();
	this.id = id;
	this.name = name;
	this.mobile = mobile;
}



public User(String name, String mobile) {
	super();
	this.name = name;
	this.mobile = mobile;
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
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
}
  

  
  
}  
