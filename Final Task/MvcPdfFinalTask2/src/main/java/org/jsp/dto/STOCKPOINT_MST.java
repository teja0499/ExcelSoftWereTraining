package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class STOCKPOINT_MST {

	@Id
	@Column(name = "LOC_ID")
	private int locId;

	@Column(name = "BILLING_NAME")
	private String billingName;

	@Column(name = "STOCK_POINT_ID")
	private int stockPointId;

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public int getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(int stockPointId) {
		this.stockPointId = stockPointId;
	}

	@Override
	public String toString() {
		return "STOCKPOINT_MST [locId=" + locId + ", billingName=" + billingName + ", stockPointId=" + stockPointId
				+ "]";
	}

}
