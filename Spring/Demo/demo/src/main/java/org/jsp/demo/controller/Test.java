package org.jsp.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	@GetMapping("/")
	public String test()
	{
		System.out.println("working");
		return "working";
	}
}
