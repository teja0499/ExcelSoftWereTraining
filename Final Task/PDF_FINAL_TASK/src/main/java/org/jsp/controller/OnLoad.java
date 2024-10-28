package org.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsp.dao.GennratePdf;
import org.jsp.dao.OnLoadData;
import org.jsp.dto.ClaimData;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PARAMETERS;
import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;
import org.jsp.dto.STOCKPOINT_MST;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OnLoad {

//	@Autowired
//	private OnLoadData loadData;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		OnLoadData loadData = new OnLoadData();
		System.out.println("Get loactrion");
		List<DEPOT_MASTER> locations = loadData.getLocation();
		System.out.println("invoiceGrp");
		List<PARAMETERS> invoiceGrp = loadData.getInvoiceGrp();
		System.out.println("years");
		List<FINANCIAL_YEAR> financial_years = loadData.getFinancialYear();

//		System.out.println("claims");
//		
//		loadData.getClaim();

//		for(DEPOT_MASTER m:locations)
//		{
//			System.out.println(m);
//		}
//		
		for (PARAMETERS m : invoiceGrp) {
			System.out.println(m);
		}
//		
//		for(FINANCIAL_YEAR m:years)
//		{
//			System.out.println(m);
//		}

		model.addAttribute("locations", locations);
		model.addAttribute("financial_years", financial_years);
		model.addAttribute("invoiceGrp", invoiceGrp);

		return "home";
	}




	@RequestMapping(value = "/location/{location}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<STOCKPOINT_MST> getStockPoint(@PathVariable("location") int location) {
		OnLoadData loadData = new OnLoadData();
		System.out.println("location = " + location);
		List<STOCKPOINT_MST> stockPoints = loadData.getStockPoint(location);
//		List<STOCKPOINT_MST> stockPoints=new ArrayList();
		return stockPoints;

	}

	@RequestMapping(value = "/getClaim", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Object[]> getClaim(@ModelAttribute("claimData") ClaimData claimData) {
		OnLoadData loadData = new OnLoadData();
		System.out.println("claimData = " + claimData);
		List<Object[]> claimList = loadData.getClaim(claimData);
//		List<Object[]>claimList=new ArrayList<Object[]>();
		return claimList;

	}
	
	
	
	
	
	
	@RequestMapping(value = "get-pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> getPdf(
	        @RequestParam("invoiceGrp") String invoiceGrp,
	        @RequestParam("location") int location,
	        @RequestParam("stockPoint") int stockPoint,
	        @RequestParam("financialYear") int financialYear,
	        @RequestParam("claimType") String claimType,
	        @RequestParam("fromClaimNo") String fromClaimNo,
	        @RequestParam("toClaimNo") String toClaimNo) {

	    ProcedureData data = new ProcedureData();
	    data.setInvoiceGrp(invoiceGrp);
	    data.setLocation(location);
	    data.setStockPoint(stockPoint);
	    data.setFinancialYear(financialYear);
	    data.setClaimType(claimType);
	    data.setFromClaimNo(fromClaimNo);
	    data.setToClaimNo(toClaimNo);

	    OnLoadData loadData = new OnLoadData();
	    List<PROCEDURE> procedures = loadData.getProdureData(data);

	    GennratePdf pdf = new GennratePdf();
	    String filePath = pdf.PDF(procedures);

	    // Return as JSON
	    Map<String, String> response = new HashMap<>();
	    response.put("pdfLink", filePath);
	    return ResponseEntity.ok(response);
	}


}
