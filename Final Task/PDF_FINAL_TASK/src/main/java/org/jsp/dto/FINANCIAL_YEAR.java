package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FINANCIAL_YEAR {

    @Id
    @Column(name = "FIN_YEAR_ID")
    private int finYearId;

    @Column(name = "COMPANY_CD")
    private String companyCd;

    @Column(name = "END_DT")
    private String endDt;

    @Column(name = "ERP_FIN_YEAR")
    private int erpFinYear;

    @Column(name = "FIN_YEAR_CLOSED")
    private String finYearClosed;

    @Column(name = "FIN_YEAR_CLOSE_DATE")
    private String finYearCloseDate;

    @Column(name = "GST_CURR_YEAR")
    private String gstCurrYear;

    @Column(name = "GST_IND")
    private String gstInd;

    @Column(name = "GST_START_DATE")
    private String gstStartDate;

    @Column(name = "START_DT")
    private String startDt;

    @Column(name = "VAT_TRANSITION_END")
    private String vatTransitionEnd;

    // Getters and setters
    public int getFinYearId() {
        return finYearId;
    }

    public void setFinYearId(int finYearId) {
        this.finYearId = finYearId;
    }

    public String getCompanyCd() {
        return companyCd;
    }

    public void setCompanyCd(String companyCd) {
        this.companyCd = companyCd;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public int getErpFinYear() {
        return erpFinYear;
    }

    public void setErpFinYear(int erpFinYear) {
        this.erpFinYear = erpFinYear;
    }

    public String getFinYearClosed() {
        return finYearClosed;
    }

    public void setFinYearClosed(String finYearClosed) {
        this.finYearClosed = finYearClosed;
    }

    public String getFinYearCloseDate() {
        return finYearCloseDate;
    }

    public void setFinYearCloseDate(String finYearCloseDate) {
        this.finYearCloseDate = finYearCloseDate;
    }

    public String getGstCurrYear() {
        return gstCurrYear;
    }

    public void setGstCurrYear(String gstCurrYear) {
        this.gstCurrYear = gstCurrYear;
    }

    public String getGstInd() {
        return gstInd;
    }

    public void setGstInd(String gstInd) {
        this.gstInd = gstInd;
    }

    public String getGstStartDate() {
        return gstStartDate;
    }

    public void setGstStartDate(String gstStartDate) {
        this.gstStartDate = gstStartDate;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getVatTransitionEnd() {
        return vatTransitionEnd;
    }

    public void setVatTransitionEnd(String vatTransitionEnd) {
        this.vatTransitionEnd = vatTransitionEnd;
    }

	@Override
	public String toString() {
		return "FINANCIAL_YEAR [finYearId=" + finYearId + ", companyCd=" + companyCd + ", endDt=" + endDt
				+ ", erpFinYear=" + erpFinYear + ", finYearClosed=" + finYearClosed + ", finYearCloseDate="
				+ finYearCloseDate + ", gstCurrYear=" + gstCurrYear + ", gstInd=" + gstInd + ", gstStartDate="
				+ gstStartDate + ", startDt=" + startDt + ", vatTransitionEnd=" + vatTransitionEnd + "]";
	}
    
    
}

