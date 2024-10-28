package org.jsp.dto;

public class ClaimData {
	private String invoice;
	private int location;
	private int stockPoint;
	private int financialYear;
	private String claimType;
	
	
	public ClaimData() {};
	
	public ClaimData(String invoice, int location, int stockPoint, int financialYear, String claimType) {
		super();
		this.invoice = invoice;
		this.location = location;
		this.stockPoint = stockPoint;
		this.financialYear = financialYear;
		this.claimType = claimType;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	

	public int getStockPoint() {
		return stockPoint;
	}

	public void setStockPoint(int stockPoint) {
		this.stockPoint = stockPoint;
	}

	public int getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(int financialYear) {
		this.financialYear = financialYear;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Override
	public String toString() {
		return "Chalan [invoice=" + invoice + ", locId=" + location + ", stockPoint=" + stockPoint + ", financialYear="
				+ financialYear + ", claimType=" + claimType + "]";
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

}
