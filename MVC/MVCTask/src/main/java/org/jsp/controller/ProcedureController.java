package org.jsp.controller;

import java.text.ParseException;
import java.util.List;

import org.jsp.dao.Branch;
import org.jsp.dao.Customer;
import org.jsp.dao.Division;
import org.jsp.dao.Excel;
import org.jsp.dao.FinYear;
import org.jsp.dao.Procesure;
import org.jsp.dao.StockPoint;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PARAMETERS;
import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;
import org.jsp.dto.STOCKPOINT_MST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.net.aso.b;

@Controller
public class ProcedureController {

	@Autowired
	private Branch branch;
	@Autowired
	private Customer customer;
	@Autowired
	private Division division;

	@Autowired
	private StockPoint stockPoint;

	@Autowired
	private FinYear finYear;
	
	
	@Autowired
	private Excel excel;
	
	List<FINANCIAL_YEAR> financial_years;
	List<DEPOT_MASTER> branches;
	List<PARAMETERS> divisions;

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String onLoad(ModelMap model) {
		System.out.println("Onload");
		

		branches = branch.getBranches();

		System.out.println("branches " + branches.size());

		financial_years = finYear.getFinancialYear();

		System.out.println("Fin year " + financial_years.size());

		divisions = division.getDivision();

		System.out.println("division = " + divisions.size());

		model.addAttribute("branches", branches);
		model.addAttribute("finYears", financial_years);
		model.addAttribute("divisions", divisions);

		return "home";
	}

	@RequestMapping(value = "/branchId/{branchId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<STOCKPOINT_MST> getStockPoint(@PathVariable("branchId") int branchId) {
		System.out.println("branchId = " + branchId);
		List<STOCKPOINT_MST> stockPoints = stockPoint.getStockPoint(branchId);

		return stockPoints;

	}

	@RequestMapping(value = "/Customer/{branchId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Object[]> getCustomer(@PathVariable("branchId") int branchId) {
		System.out.println("getCustomer branchId  = " + branchId);
		Customer c = new Customer();
		return c.getCustomer();

	}
	
	@RequestMapping(value = "summery", method = RequestMethod.POST)
	public String editUser(@ModelAttribute ("data") ProcedureData data, ModelMap model) {
	    // Print the ID of the user to be deleted for debugging
		String excelLink="";
		System.out.println(data);
		
		
		
		Procesure procesureData=new Procesure();
		Procesure procesure=new Procesure();
		
		
		List<PROCEDURE> procedureData=procesure.doProcesure(data);
		
		for(int i=0;i<branches.size();i++)
		{
			if(branches.get(i).getLocId()==data.getLocId())
			{
				data.setLocName(branches.get(i).getLocName());
			}
		}
		
		System.out.println(data);
		
		
	
		
		
		
		
		try {
			 excelLink=excel.getExcel(procedureData, data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		model.addAttribute("procedureData", procedureData);
		model.addAttribute("inputData", data);
		model.addAttribute("excelLink", excelLink);
		
	    return "summery";
	}

}
