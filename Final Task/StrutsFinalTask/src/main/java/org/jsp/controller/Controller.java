package org.jsp.controller;

import com.opensymphony.xwork2.ActionSupport;

import oracle.net.aso.d;

public class Controller extends ActionSupport {
	
	
	 @Override
	    public String execute() {
		 demo();
	        return SUCCESS;
	    }
	 
	 
	 public void demo()
	 {
		 System.out.println("Test");
	 }
}
