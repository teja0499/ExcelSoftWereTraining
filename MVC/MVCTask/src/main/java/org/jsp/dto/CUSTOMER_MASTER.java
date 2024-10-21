package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class CUSTOMER_MASTER {
	@Id
	@Column(name = "CUST_ID")
	private long custId;

	@Column(name = "COMPANY_CD")
	private String companyCd;

	@Column(name = "CUST_NAME")
	private String custName;

	@Column(name = "LOC_ID")
	private int locId;

	@Column(name = "STOCK_POINT_ID")
	private int stockPointId;

	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "CUST_CD")
	private String custCd;
	
	@Column(name = "DELETED")
	private String deleted;
	
	
	@Column(name = "ERP_CUST_CD ")
	private String erpCustCd;
	
	
	
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCompanyCd() {
		return companyCd;
	}

	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public int getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(int stockPointId) {
		this.stockPointId = stockPointId;
	}

	@Override
	public String toString() {
		return "CUSTOMER_MASTER [custId=" + custId + ", companyCd=" + companyCd + ", custName=" + custName + ", locId="
				+ locId + ", stockPointId=" + stockPointId + ", destination=" + destination + ", custCd=" + custCd
				+ ", deleted=" + deleted + ", erpCustCd=" + erpCustCd + "]";
	}


}
