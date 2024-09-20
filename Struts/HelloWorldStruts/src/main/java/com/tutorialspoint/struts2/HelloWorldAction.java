package com.tutorialspoint.struts2;

public class HelloWorldAction {
	 private String name;
	 {
		 System.out.println("1");
	 }

	   public String execute() throws Exception {
		   
		   System.out.println(2);
	      return "success";
	   }
	   
	   public String getName() {
		   System.out.println(3);
	      return name;
	   }

	   public void setName(String name) {
		   System.out.println(4);
	      this.name = name;
	   }
}
