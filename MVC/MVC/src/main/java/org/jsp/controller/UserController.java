package org.jsp.controller;

import java.util.List;

import org.jsp.dao.UserDao;
import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

	@RequestMapping(value = "/alluser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, ModelMap model) {
		System.out.println("adduser: " + user);
		// Here you can save the user to the database
		dao.addUser(user);
		model.addAttribute("users", dao.getAllUser());
		return "allUser";
	}
	
	
	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id, ModelMap model) {
	    // Print the ID of the user to be deleted for debugging
	    System.out.println("deleteUser: ID = " + id);
	    
	   
	    dao.deleteUserById(id);
	    model.addAttribute("users", dao.getAllUser());
	    return "allUser";
	}
	
	
	
	
	@RequestMapping(value = "/edituser/{id}", method = RequestMethod.POST)
	public String editUser(@PathVariable("id") int id, ModelMap model) {
	    // Print the ID of the user to be deleted for debugging
	    System.out.println("deleteUser: ID = " + id);
	    
	   System.out.println(dao.getuser(id));
	    
	    model.addAttribute("user", dao.getuser(id));
	    return "index";
	}

	@RequestMapping(value = "/findbyname", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findByName(@RequestParam("name") String name) {
	   
	    System.out.println("Finding user with name: " + name);
	    
	   
	    List<User> users = dao.getUserByName(name); 
	    for(User user:users)
	    {
	    	System.out.println(user);
	    }

	        return ResponseEntity.ok(users);
	  
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/findbynaame1", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findByName1(@RequestParam("name") String name) {
		   
	    System.out.println("Finding user with name: " + name);
	    
	   
	    List<User> users = dao.getUserByName(name); 
	    for(User user:users)
	    {
	    	System.out.println(user);
	    }

	        return  users;
	  
	}
	
	
}
