package com.org;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class GetAllUsers {
	private List<User> users;

	public List<User> getUsers() {
		System.out.println(3333);

		Get get = new Get();
		return get.getAll();

	}

	public void setUsers(List<User> users) {
		System.out.println(111111);
		this.users = users;
	}

	public String getAllUsers() throws ParseException {
		System.out.println(222222);
		formatDate("");

		return "success";
	}

	public String formatDate(String da1te) throws ParseException {
		  // Create a Date obj (current date and time)
        Date date = new Date();

        // Create a Simpledateformat  with desired format
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Format the Date obj to a string
        String formattedDate = dateFormat.format(date);
        
        // Print the formated date
        System.out.println("Formatted Date: " + formattedDate);
		return "";
	}
}
