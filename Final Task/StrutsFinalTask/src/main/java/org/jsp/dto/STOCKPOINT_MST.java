package org.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class STOCKPOINT_MST {
	
	@Id
	private int  STOCK_POINT_ID;
	private int LOC_ID  ;
	private String BILLING_NAME ;
	public int getSTOCK_POINT_ID() {
		return STOCK_POINT_ID;
	}
	public void setSTOCK_POINT_ID(int sTOCK_POINT_ID) {
		STOCK_POINT_ID = sTOCK_POINT_ID;
	}
	public int getLOC_ID() {
		return LOC_ID;
	}
	public void setLOC_ID(int lOC_ID) {
		LOC_ID = lOC_ID;
	}
	public String getBILLING_NAME() {
		return BILLING_NAME;
	}
	public void setBILLING_NAME(String bILLING_NAME) {
		BILLING_NAME = bILLING_NAME;
	}
	@Override
	public String toString() {
		return "STOCKPOINT_MST [STOCK_POINT_ID=" + STOCK_POINT_ID + ", LOC_ID=" + LOC_ID + ", BILLING_NAME="
				+ BILLING_NAME + "]";
	}
	
}
