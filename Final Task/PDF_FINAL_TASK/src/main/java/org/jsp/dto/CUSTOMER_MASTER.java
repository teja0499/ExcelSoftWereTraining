package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "")
@Entity
public class CUSTOMER_MASTER {
	@Id
	@Column(name = "CUST_ID")
	private long cust_id;

	@Column(name = "COMPANY_CD")
	private String companyCd;

	@Column(name = "CUST_NAME")
	private String cust_name;

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


	public long getCust_id() {
		return cust_id;
	}


	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}


	public String getCompanyCd() {
		return companyCd;
	}


	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}


	public String getCust_name() {
		return cust_name;
	}


	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
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


	public String getErpCustCd() {
		return erpCustCd;
	}


	public void setErpCustCd(String erpCustCd) {
		this.erpCustCd = erpCustCd;
	}
	
	
	


}
