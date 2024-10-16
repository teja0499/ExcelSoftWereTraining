package org.jsp.controller;

import java.text.ParseException;
import java.util.List;

import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;

public class Details {

	private int financial_year;
	private int branch;
	private int division;
	private String reportType;
	private int slab11;
	private int slab12;
	private int slab21;
	private int slab22;
	private int slab31;
	private int slab32;
	private int slab41;
	private int slab42;
	private int slab51;
	private int slab52;
	private int slab61;
	private int stockPoint;
	private int party;
	private String invoice;
	private String endDate;
	private int state;
	private String igDiv;
	private List<PROCEDURE> procedures;
	private ProcedureData data;
	private String excelLink=null;

	public List<PROCEDURE> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<PROCEDURE> procedures) {
		this.procedures = procedures;
	}

	public ProcedureData getData() {
		return data;
	}

	public void setData(ProcedureData data) {
		this.data = data;
	}

	public void setIgDiv(String igDiv) {
		System.out.println("igDiv " + igDiv);
		this.igDiv = igDiv;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setFinancial_year(int financial_year) {
		this.financial_year = financial_year;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public void setSlab11(int slab11) {
		this.slab11 = slab11;
	}

	public void setSlab12(int slab12) {
		this.slab12 = slab12;
	}

	public void setSlab21(int slab21) {
		this.slab21 = slab21;
	}

	public void setSlab22(int slab22) {
		this.slab22 = slab22;
	}

	public void setSlab31(int slab31) {
		this.slab31 = slab31;
	}

	public void setSlab32(int slab32) {
		this.slab32 = slab32;
	}

	public void setSlab41(int slab41) {
		this.slab41 = slab41;
	}

	public void setSlab42(int slab42) {
		this.slab42 = slab42;
	}

	public void setSlab51(int slab51) {
		this.slab51 = slab51;
	}

	public void setSlab52(int slab52) {
		this.slab52 = slab52;
	}

	public void setSlab61(int slab61) {
		this.slab61 = slab61;
	}

	public void setStockPoint(int stockPoint) {
		this.stockPoint = stockPoint;
	}

	public void setParty(int party) {
		this.party = party;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String details() {
		System.out.println("details");
		System.out.println("branch = " + branch);
		System.out.println("division = " + division);
		System.out.println("stockPoint = " + stockPoint);
		System.out.println("party = " + party);
		System.out.println("igDiv = " + igDiv);

		data = new ProcedureData(financial_year, branch, division, reportType, slab11, slab12, slab21, slab22, slab31,
				slab32, slab41, slab42, slab51, slab52, slab61, stockPoint, party, invoice, endDate, state, igDiv);
//		
		Procesure procesure = new Procesure();
		procedures = procesure.doProcedure(financial_year, branch, division, reportType, slab11, slab12, slab21, slab22,
				slab31, slab32, slab41, slab42, slab51, slab52, slab61, stockPoint, party, invoice, endDate, state,
				igDiv);

		GenrateExcel excel = new GenrateExcel();
		try {
			excelLink=	excel.getExcel(procedures, data);
			System.out.println("excelLink = "+excelLink);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	public String getExcelLink() {
		return excelLink;
	}

	public void setExcelLink(String excelLink) {
		this.excelLink = excelLink;
	}

}
