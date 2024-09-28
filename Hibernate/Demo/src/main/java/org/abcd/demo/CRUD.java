package org.abcd.demo;

public class CRUD {
	
private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public String saveUser()
{
	System.out.println(name);
	return "success";
}
}
