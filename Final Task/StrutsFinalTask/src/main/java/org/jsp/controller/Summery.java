package org.jsp.controller;

import java.util.List;

import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;

import oracle.net.aso.e;
import oracle.net.aso.p;

public class Summery {

	private String financial_years;
	private String receivingLocation;
	private String sendinglocation;
	private String receivingStockPoint;
	private String sendingStockPoint;
	private String startdate;
	private String endDate;
	private ProcedureData procedureData;
	private List<PROCEDURE> procedures;
	private String excelLink=null;
	
//	jstl tags s:if , s:test

	public String getExcelLink() {
		System.out.println(excelLink);
		return excelLink;
	}



	public void setExcelLink(String excelLink) {
		System.out.println(excelLink);
		this.excelLink = excelLink;
	}



	public void setProcedureData(ProcedureData procedureData) {
		this.procedureData = procedureData;
	}



	public String getFinancial_years() {
		return financial_years;
	}



	public String getReceivingLocation() {
		return receivingLocation;
	}



	public String getSendinglocation() {
		return sendinglocation;
	}



	public String getReceivingStockPoint() {
		return receivingStockPoint;
	}



	public String getSendingStockPoint() {
		return sendingStockPoint;
	}



	public String getStartdate() {
		return startdate;
	}



	public String getEndDate() {
		return endDate;
	}



	public ProcedureData getProcedureData() {
		return procedureData;
	}



	public List<PROCEDURE> getProcedures() {
		return procedures;
	}



	public void setFinancial_years(String financial_years) {
		this.financial_years = financial_years;
	}

	public void setReceivingLocation(String receivingLocation) {
		this.receivingLocation = receivingLocation;
	}

	public void setSendinglocation(String sendinglocation) {
		this.sendinglocation = sendinglocation;
	}

	public void setReceivingStockPoint(String receivingStockPoint) {
		this.receivingStockPoint = receivingStockPoint;
	}

	public void setSendingStockPoint(String sendingStockPoint) {
		this.sendingStockPoint = sendingStockPoint;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setProcedures(List<PROCEDURE> procedures) {

		Procedure procedure = new Procedure();
		String isCurrentYear = procedure.getCurrentFinancialYear(1);

		procedures = procedure.doProcedure(isCurrentYear, financial_years, "SNK", sendinglocation, sendingStockPoint,
				receivingLocation, receivingStockPoint, null, null, startdate, endDate, "S");
		this.procedures = procedures;
	}

	public String Summery() throws Exception {
		System.out.println("summery");

		
		Procedure procedure = new Procedure();
		String isCurrentYear = procedure.getCurrentFinancialYear(1);
		System.out.println(isCurrentYear);
		procedureData = new ProcedureData(isCurrentYear, financial_years, "SNK", sendinglocation, sendingStockPoint,
				receivingLocation, receivingStockPoint, null, null, Static.formatDate(startdate), Static.formatDate(endDate), "S");
		System.out.println("procedureData :-   " + procedureData);
		procedures = procedure.doProcedure(isCurrentYear, financial_years, "SNK", sendinglocation, sendingStockPoint,
				receivingLocation, receivingStockPoint, null, null, startdate, endDate, "S");

		System.out.println("procedures size " + procedures.size());

		ExcelSummery excel = new ExcelSummery();
		System.out.println("Start");
		if(procedures.size()>0) excelLink= excel.genrateExcel(procedures, procedureData);
		System.out.println("End");
		for (PROCEDURE p : procedures) {
			System.out.println(p);
		}
		return "success";
		
	}

}
