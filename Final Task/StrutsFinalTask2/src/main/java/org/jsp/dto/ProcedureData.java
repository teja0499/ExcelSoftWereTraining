package org.jsp.dto;

public class ProcedureData {
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
	
	

	public ProcedureData(int financial_year, int branch, int division, String reportType, int slab11, int slab12,
			int slab21, int slab22, int slab31, int slab32, int slab41, int slab42, int slab51, int slab52, int slab61,
			int stockPoint, int party, String invoice, String endDate, int state,String igDiv) {
		super();
		this.financial_year = financial_year;
		this.branch = branch;
		this.division = division;
		this.reportType = reportType;
		this.slab11 = slab11;
		this.slab12 = slab12;
		this.slab21 = slab21;
		this.slab22 = slab22;
		this.slab31 = slab31;
		this.slab32 = slab32;
		this.slab41 = slab41;
		this.slab42 = slab42;
		this.slab51 = slab51;
		this.slab52 = slab52;
		this.slab61 = slab61;
		this.stockPoint = stockPoint;
		this.party = party;
		this.invoice = invoice;
		this.endDate = endDate;
		this.state = state;
		this.igDiv=igDiv;
	}
	
	
	

	public String getIgDiv() {
		return igDiv;
	}




	public void setIgDiv(String igDiv) {
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

	public int getFinancial_year() {
		return financial_year;
	}

	public int getBranch() {
		return branch;
	}

	public int getDivision() {
		return division;
	}

	public String getReportType() {
		return reportType;
	}

	public int getSlab11() {
		return slab11;
	}

	public int getSlab12() {
		return slab12;
	}

	public int getSlab21() {
		return slab21;
	}

	public int getSlab22() {
		return slab22;
	}

	public int getSlab31() {
		return slab31;
	}

	public int getSlab32() {
		return slab32;
	}

	public int getSlab41() {
		return slab41;
	}

	public int getSlab42() {
		return slab42;
	}

	public int getSlab51() {
		return slab51;
	}

	public int getSlab52() {
		return slab52;
	}

	public int getSlab61() {
		return slab61;
	}

	public int getStockPoint() {
		return stockPoint;
	}

	public int getParty() {
		return party;
	}

	public String getInvoice() {
		return invoice;
	}

	public String getEndDate() {
		return endDate;
	}

	public int getState() {
		return state;
	}




	@Override
	public String toString() {
		return "ProcedureData [financial_year=" + financial_year + ", branch=" + branch + ", division=" + division
				+ ", reportType=" + reportType + ", slab11=" + slab11 + ", slab12=" + slab12 + ", slab21=" + slab21
				+ ", slab22=" + slab22 + ", slab31=" + slab31 + ", slab32=" + slab32 + ", slab41=" + slab41
				+ ", slab42=" + slab42 + ", slab51=" + slab51 + ", slab52=" + slab52 + ", slab61=" + slab61
				+ ", stockPoint=" + stockPoint + ", party=" + party + ", invoice=" + invoice + ", endDate=" + endDate
				+ ", state=" + state + ", igDiv=" + igDiv + "]";
	}


//	public String printDetails() {
//		System.out.println("Financial Year: " + financial_year);
//		System.out.println("Branch: " + branch);
//		System.out.println("Division: " + division);
//		System.out.println("Report Type: " + reportType);
//		System.out.println("Slab 11: " + slab11);
//		System.out.println("Slab 12: " + slab12);
//		System.out.println("Slab 21: " + slab21);
//		System.out.println("Slab 22: " + slab22);
//		System.out.println("Slab 31: " + slab31);
//		System.out.println("Slab 32: " + slab32);
//		System.out.println("Slab 41: " + slab41);
//		System.out.println("Slab 42: " + slab42);
//		System.out.println("Slab 51: " + slab51);
//		System.out.println("Slab 52: " + slab52);
//		System.out.println("Slab 61: " + slab61);
//		System.out.println("Stock Point: " + stockPoint);
//		System.out.println("Party: " + party);
//		System.out.println("Invoice: " + invoice);
//		System.out.println("End Date: " + endDate);
//		System.out.println("State: " + state);
//
//		return "success";
//	}

}
