package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CUSTOMER_ALLOCATION {
	@Id
	@Column(name = "CUST_ID")
	private int custId;

	@Column(name = "COMPANY_CD")
	private String companyCd;

	@Column(name = "CUST_NAME")
	private String custName;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
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

	@Override
	public String toString() {
		return "CUSTOMER_ALLOCATION [custId=" + custId + ", companyCd=" + companyCd + ", custName=" + custName + "]";
	}
}
