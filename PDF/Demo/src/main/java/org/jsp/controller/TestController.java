package org.jsp.controller;

import java.io.IOException;

import org.jsp.dto.AddPage;
import org.jsp.dto.GenaratePdf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "/pdf/{n}", method = RequestMethod.GET)
	public String test(@PathVariable("n")int n)
	{
	System.out.println("Working");	
	System.out.println(n);
//	GenaratePdf pdf=new GenaratePdf();
	
	AddPage pdf=new AddPage();
	try {
		pdf.pdf(n);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "pdf";
	}
}
