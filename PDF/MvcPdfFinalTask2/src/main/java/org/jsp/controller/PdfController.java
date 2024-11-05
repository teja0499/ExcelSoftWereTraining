package org.jsp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsp.dao.GenratePdf;
import org.jsp.dao.OnLoadData;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PDF_PROCEDURE;
import org.jsp.dto.PERIOD_MASTER;
import org.jsp.dto.ProcedureOneData;
import org.jsp.dto.ProcedurePdfData;
import org.jsp.dto.STOCKPOINT_MST;
import org.jsp.dto.TABLE_PROCEDURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import oracle.net.aso.d;
import oracle.net.aso.l;

@Controller
public class PdfController {

	@Autowired
	OnLoadData loadData;

	@Autowired
	GenratePdf genratePdf;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		System.out.println("Working");

		loadData.test();

//		System.out.println("Branch");

		List<DEPOT_MASTER> branches = loadData.getBranches();

//		for (DEPOT_MASTER m : branches) {
//			System.out.println(m);
//		}

		System.out.println("financial_YEARs");
		List<FINANCIAL_YEAR> financial_YEARs = loadData.getFinancialYear();

//		for (FINANCIAL_YEAR m : financial_YEARs) {
//			System.out.println(m);
//		}

		int finyear = financial_YEARs.get(0).getFinYearId();
		System.out.println("finyear = " + finyear);
		List<PERIOD_MASTER> period = loadData.getPeriod(finyear);

//		for (PERIOD_MASTER m : period) {
//			System.out.println(m);
//		}

//		System.out.println();

		model.addAttribute("branches", branches);
		model.addAttribute("periods", period);
		model.addAttribute("financial_years", financial_YEARs);

		return "firstpage";
	}

	@RequestMapping(value = "/branch/{branch}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<STOCKPOINT_MST> getStockPoint(@PathVariable("branch") int branch) {
//		OnLoadData loadData = new OnLoadData();
//		System.out.println("branch = " + branch);
		List<STOCKPOINT_MST> stockPoints = loadData.getStockPoint(branch);
//		List<STOCKPOINT_MST> stockPoints=new ArrayList();
		return stockPoints;

	}

	@RequestMapping(value = "/period/{finyear}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<PERIOD_MASTER> getPeriod(@PathVariable("finyear") int finyear) {
//		OnLoadData loadData = new OnLoadData();
//		System.out.println("finyear = " + finyear);
		List<PERIOD_MASTER> period = loadData.getPeriod(finyear);
		return period;

	}

	@RequestMapping(value = "/getTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<TABLE_PROCEDURE> getTableData(@RequestParam("stockPoint") int stockPointId,
			@RequestParam("financialYear") int finId, @RequestParam("branch") int locId,
			@RequestParam("invoice") int invGrp, @RequestParam("period") int perId,
			@RequestParam("document") String docType) {

		ProcedureOneData data = new ProcedureOneData(finId, locId, invGrp, perId, stockPointId, docType);
//		System.out.println(data);
		List<TABLE_PROCEDURE> tableList = loadData.getTableData(data);

		return tableList;

	}

	@RequestMapping(value = "/get-pdf", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
//	@RequestMapping(value = "/get-pdf", method = RequestMethod.POST)
	
	public Map<String, String> pdf(
	        @RequestParam("stockPointId") int stockPointId,
	        @RequestParam("finId") int finId,
	        @RequestParam("locId") int locId,
	        @RequestParam("period") int period,  // Ensure this matches "perId" in AJAX if needed
	        @RequestParam("tranType") int tranType,
	        @RequestParam("frNum") String frNum,
	        @RequestParam("toNum") String toNum,
	        @RequestParam("invType") String document
	) {
	    ProcedurePdfData data = new ProcedurePdfData(
	            finId,         // FINID
	            locId,         // LOCID
	            frNum,         // FRNUM
	            toNum,         // TONUM
	            tranType,      // TRANTYPE
	            document,      // INVTYPE
	            stockPointId,  // STOCKPOINTID
	            period         // PERID
	    );
		
//		ProcedurePdfData data = new ProcedurePdfData(15, // FINID
//				11, // LOCID
//				"SZFGC2100044", // FRNUM
//				"SZFGC2100061", // TONUM
//				12, // TRANTYPE
//				"DN", // INVTYPE
//				11, // STOCKPOINTID 
//				9 // PERID
//		);

	    System.out.println(data);
	    System.out.println("Working");

	    // Uncomment these lines once the method is implemented to generate the PDF
	     List<PDF_PROCEDURE> listPdf = loadData.getPDFData(data);
	     System.out.println(listPdf.size());
	     System.out.println("procedure complete");
	     String file="na";
	     if(listPdf.size()!=0)
	     {	    	 
	    	 file= genratePdf.genratePdf(listPdf);
	     }
	      System.out.println("pdf complete");
	      Map<String, String> response = new HashMap<>();
	      response.put("filePath", file);
	       return response;

	}

}
