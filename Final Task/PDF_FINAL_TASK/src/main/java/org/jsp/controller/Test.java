package org.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Test {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test()
	{
	System.out.println("Working");	
//	System.out.println(n);
	
	
	return "home";
	}
}
