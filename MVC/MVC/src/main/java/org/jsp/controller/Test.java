package org.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Test {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        System.out.println("Hello Working");
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }
    
    @RequestMapping(value = "/addouser",method = RequestMethod.POST)
    public String addUser()
    {
    	return "";
    }
}
