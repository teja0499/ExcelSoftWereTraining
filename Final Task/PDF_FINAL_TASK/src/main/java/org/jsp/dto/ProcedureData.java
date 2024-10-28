package org.jsp.dto;



public class ProcedureData {
private String invoiceGrp;
private int location;
private int stockPoint;
private int financialYear;
private String claimType;
private String fromClaimNo;
private String toClaimNo;



public ProcedureData(String invoiceGrp, int location, int stockPoint, int financialYear, String claimType,
		String fromClaimNo, String toClaimNo) {
	super();
	this.invoiceGrp = invoiceGrp;
	this.location = location;
	this.stockPoint = stockPoint;
	this.financialYear = financialYear;
	this.claimType = claimType;
	this.fromClaimNo = fromClaimNo;
	this.toClaimNo = toClaimNo;
}
public ProcedureData() {
	// TODO Auto-generated constructor stub
}
public String getInvoiceGrp() {
	return invoiceGrp;
}
public void setInvoiceGrp(String invoiceGrp) {
	this.invoiceGrp = invoiceGrp;
}

public int getLocation() {
	return location;
}
public void setLocation(int location) {
	this.location = location;
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
public String getFromClaimNo() {
	return fromClaimNo;
}
public void setFromClaimNo(String fromClaimNo) {
	this.fromClaimNo = fromClaimNo;
}
public String getToClaimNo() {
	return toClaimNo;
}
public void setToClaimNo(String toClaimNo) {
	this.toClaimNo = toClaimNo;
}
@Override
public String toString() {
	return "ProcedureData [invoiceGrp=" + invoiceGrp + ", location=" + location + ", stockPoint=" + stockPoint
			+ ", financialYear=" + financialYear + ", claimType=" + claimType + ", fromClaimNo=" + fromClaimNo
			+ ", toClaimno=" + toClaimNo + "]";
}

}
