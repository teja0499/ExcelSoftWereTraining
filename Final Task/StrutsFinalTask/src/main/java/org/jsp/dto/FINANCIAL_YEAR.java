package org.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FINANCIAL_YEAR {
	
	@Id
	private int FIN_YEAR_ID ;
	private String COMPANY_CD;
	private String END_DT ;
	private int ERP_FIN_YEAR ;
	private String FIN_YEAR_CLOSED;
	private String  FIN_YEAR_CLOSE_DATE ;
	private String GST_CURR_YEAR ;
	private String GST_IND ;
	private String	GST_START_DATE ;
	private String START_DT ;
	private String VAT_TRANSITION_END ;
	public int getFIN_YEAR_ID() {
		return FIN_YEAR_ID;
	}
	public void setFIN_YEAR_ID(int fIN_YEAR_ID) {
		FIN_YEAR_ID = fIN_YEAR_ID;
	}
	public String getCOMPANY_CD() {
		return COMPANY_CD;
	}
	public void setCOMPANY_CD(String cOMPANY_CD) {
		COMPANY_CD = cOMPANY_CD;
	}
	public String getEND_DT() {
		return END_DT;
	}
	public void setEND_DT(String eND_DT) {
		END_DT = eND_DT;
	}
	public int getERP_FIN_YEAR() {
		return ERP_FIN_YEAR;
	}
	public void setERP_FIN_YEAR(int eRP_FIN_YEAR) {
		ERP_FIN_YEAR = eRP_FIN_YEAR;
	}
	public String getFIN_YEAR_CLOSED() {
		return FIN_YEAR_CLOSED;
	}
	public void setFIN_YEAR_CLOSED(String fIN_YEAR_CLOSED) {
		FIN_YEAR_CLOSED = fIN_YEAR_CLOSED;
	}
	public String getFIN_YEAR_CLOSE_DATE() {
		return FIN_YEAR_CLOSE_DATE;
	}
	public void setFIN_YEAR_CLOSE_DATE(String fIN_YEAR_CLOSE_DATE) {
		FIN_YEAR_CLOSE_DATE = fIN_YEAR_CLOSE_DATE;
	}
	public String getGST_CURR_YEAR() {
		return GST_CURR_YEAR;
	}
	public void setGST_CURR_YEAR(String gST_CURR_YEAR) {
		GST_CURR_YEAR = gST_CURR_YEAR;
	}
	public String getGST_IND() {
		return GST_IND;
	}
	public void setGST_IND(String gST_IND) {
		GST_IND = gST_IND;
	}
	public String getGST_START_DATE() {
		return GST_START_DATE;
	}
	public void setGST_START_DATE(String gST_START_DATE) {
		GST_START_DATE = gST_START_DATE;
	}
	public String getSTART_DT() {
		return START_DT;
	}
	public void setSTART_DT(String sTART_DT) {
		START_DT = sTART_DT;
	}
	public String getVAT_TRANSITION_END() {
		return VAT_TRANSITION_END;
	}
	public void setVAT_TRANSITION_END(String vAT_TRANSITION_END) {
		VAT_TRANSITION_END = vAT_TRANSITION_END;
	}
	@Override
	public String toString() {
		return "FINANCIAL_YEAR [FIN_YEAR_ID=" + FIN_YEAR_ID + ", COMPANY_CD=" + COMPANY_CD + ", END_DT=" + END_DT
				+ ", ERP_FIN_YEAR=" + ERP_FIN_YEAR + ", FIN_YEAR_CLOSED=" + FIN_YEAR_CLOSED + ", FIN_YEAR_CLOSE_DATE="
				+ FIN_YEAR_CLOSE_DATE + ", GST_CURR_YEAR=" + GST_CURR_YEAR + ", GST_IND=" + GST_IND
				+ ", GST_START_DATE=" + GST_START_DATE + ", START_DT=" + START_DT + ", VAT_TRANSITION_END="
				+ VAT_TRANSITION_END + "]";
	}
}
