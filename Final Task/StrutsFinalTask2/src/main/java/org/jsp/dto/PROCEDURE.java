package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "PARTYWISE_OS_SPECIFICDATEStoreProcedure", query = "{CALL PARTYWISE_OS_SPECIFICDATE(?,:YEAR_FLAG, :FINYR, :COMP_CD, :LOCID, :ENDT, :REPTYPE, :DIVID, :DOCTYPE, :CUSTID,:SLB1A,:SLB1B,:SLB2A, :SLB2B,:SLB3A,:SLB3B, :SLB4A,:SLB4B, :SLB5A,:SLB5B, :SLB6, :STOCKPOINTID, :EXCLUDE_DEACTIVE_CUST,:EXCLUDE_DEACTIVE_LOC,:IGDIV,:STATEID)}", callable = true, resultClass = PROCEDURE.class) })
public class PROCEDURE {
	@Id
	@Column(name = "ROWNUM")
	private int rowNum;

	@Column(name = "LOC_ID")
	private int locId;

	@Column(name = "LOC_NAME")
	private String locName;

	@Column(name = "STOCK_POINT_ID")
	private int stockPointId;

	@Column(name = "ADJ_DIV_ID")
	private int adjDivId;

	@Column(name = "DIVISION")
	private String division;

	@Column(name = "SL_ACC_ID")
	private int slAccId;

	@Column(name = "CUST_CD")
	private String custCd;

	@Column(name = "CUST_NAME")
	private String custName;

//	TRAN_DATE
//	DUE_DATE
//	ADJ_TYPE
//	DOCUMENT
//	INVOICE_NO
//	ADJ_AMOUNT
//	TOT_CREDIT_LMT
//	ADVANCE
//	RECEIVABLE 
//	SLAB1
//	SLAB2

	@Column(name = "DESTINATION")
	private String destination;

	@Column(name = "TRAN_DATE")
	private String tranDate;

	@Column(name = "DUE_DATE")
	private String dueDate;

	@Column(name = "ADJ_TYPE")
	private int adjType;

	@Column(name = "DOCUMENT")
	private String document;

	@Column(name = "INVOICE_NO")
	private String invoiceNo;

	@Column(name = "ADJ_AMOUNT")
	private int adjAmount;

	@Column(name = "TOT_CREDIT_LMT")
	private int totCreditLmt;

	@Column(name = "ADVANCE")
	private int advance;

	@Column(name = "RECEIVABLE")
	private int receivable;

	@Column(name = "SLAB1")
	private int slab1;

	@Column(name = "SLAB2")
	private int slab2;

	@Column(name = "SLAB3")
	private int slab3;

	@Column(name = "SLAB4")
	private int slab4;

	@Column(name = "SLAB5")
	private int slab5;

	@Column(name = "SLAB6")
	private int slab6;

//	REMARK
//	RECEIVABLE_REMARK
//	LR_DATE
//	LR_NUMBER
//	FIN_YEAR_ID
//	ENT_CUST_ID
//	ENT_CUST_CODE
//	STATE
//	HQ
//	UNADJ_CR

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "RECEIVABLE_REMARK")
	private String receivableRemark;

	@Column(name = "LR_DATE")
	private String lrDate;

	@Column(name = "LR_NUMBER")
	private String lrNumber;

	@Column(name = "FIN_YEAR_ID")
	private int finYearId;

	@Column(name = "ENT_CUST_ID")
	private String entCustId;

	@Column(name = "ENT_CUST_CODE")
	private String entCustCode;

	@Column(name = "STATE")
	private String state;

	@Column(name = "HQ")
	private String hq;

	@Column(name = "UNADJ_CR")
	private int unadjCr;

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public int getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(int stockPointId) {
		this.stockPointId = stockPointId;
	}

	public int getAdjDivId() {
		return adjDivId;
	}

	public void setAdjDivId(int adjDivId) {
		this.adjDivId = adjDivId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getSlAccId() {
		return slAccId;
	}

	public void setSlAccId(int slAccId) {
		this.slAccId = slAccId;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTranDate() {
		return tranDate;
	}

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getAdjType() {
		return adjType;
	}

	public void setAdjType(int adjType) {
		this.adjType = adjType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public int getAdjAmount() {
		return adjAmount;
	}

	public void setAdjAmount(int adjAmount) {
		this.adjAmount = adjAmount;
	}

	public int getTotCreditLmt() {
		return totCreditLmt;
	}

	public void setTotCreditLmt(int totCreditLmt) {
		this.totCreditLmt = totCreditLmt;
	}

	public int getAdvance() {
		return advance;
	}

	public void setAdvance(int advance) {
		this.advance = advance;
	}

	public int getReceivable() {
		return receivable;
	}

	public void setReceivable(int receivable) {
		this.receivable = receivable;
	}

	public int getSlab1() {
		return slab1;
	}

	public void setSlab1(int slab1) {
		this.slab1 = slab1;
	}

	public int getSlab2() {
		return slab2;
	}

	public void setSlab2(int slab2) {
		this.slab2 = slab2;
	}

	public int getSlab3() {
		return slab3;
	}

	public void setSlab3(int slab3) {
		this.slab3 = slab3;
	}

	public int getSlab4() {
		return slab4;
	}

	public void setSlab4(int slab4) {
		this.slab4 = slab4;
	}

	public int getSlab5() {
		return slab5;
	}

	public void setSlab5(int slab5) {
		this.slab5 = slab5;
	}

	public int getSlab6() {
		return slab6;
	}

	public void setSlab6(int slab6) {
		this.slab6 = slab6;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReceivableRemark() {
		return receivableRemark;
	}

	public void setReceivableRemark(String receivableRemark) {
		this.receivableRemark = receivableRemark;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getLrNumber() {
		return lrNumber;
	}

	public void setLrNumber(String lrNumber) {
		this.lrNumber = lrNumber;
	}

	public int getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(int finYearId) {
		this.finYearId = finYearId;
	}

	public String getEntCustId() {
		return entCustId;
	}

	public void setEntCustId(String entCustId) {
		this.entCustId = entCustId;
	}

	public String getEntCustCode() {
		return entCustCode;
	}

	public void setEntCustCode(String entCustCode) {
		this.entCustCode = entCustCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHq() {
		return hq;
	}

	public void setHq(String hq) {
		this.hq = hq;
	}

	public int getUnadjCr() {
		return unadjCr;
	}

	public void setUnadjCr(int unadjCr) {
		this.unadjCr = unadjCr;
	}

	@Override
	public String toString() {
		return "PROCEDURE [rowNum=" + rowNum + ", locId=" + locId + ", locName=" + locName + ", stockPointId="
				+ stockPointId + ", adjDivId=" + adjDivId + ", division=" + division + ", slAccId=" + slAccId
				+ ", custCd=" + custCd + ", custName=" + custName + ", destination=" + destination + ", tranDate="
				+ tranDate + ", dueDate=" + dueDate + ", adjType=" + adjType + ", document=" + document + ", invoiceNo="
				+ invoiceNo + ", adjAmount=" + adjAmount + ", totCreditLmt=" + totCreditLmt + ", advance=" + advance
				+ ", receivable=" + receivable + ", slab1=" + slab1 + ", slab2=" + slab2 + ", slab3=" + slab3
				+ ", slab4=" + slab4 + ", slab5=" + slab5 + ", slab6=" + slab6 + ", remark=" + remark
				+ ", receivableRemark=" + receivableRemark + ", lrDate=" + lrDate + ", lrNumber=" + lrNumber
				+ ", finYearId=" + finYearId + ", entCustId=" + entCustId + ", entCustCode=" + entCustCode + ", state="
				+ state + ", hq=" + hq + ", unadjCr=" + unadjCr + "]";
	}

}

//YEAR_FLAG := 'PREVIOUS';
//FINYR := 14;
//COMP_CD := 'ICP';
//LOCID := '0';
//ENDT := '2021-12-31';
//REPTYPE := 'D';
//DIVID := '0';
//DOCTYPE := 'DUE';
//CUSTID := '0';
//SLB1A := 1;
//SLB1B := 30;
//SLB2A := 31;
//SLB2B := 60;
//SLB3A := 61;
//SLB3B := 90;
//SLB4A := 91;
//SLB4B := 180;
//SLB5A := 181;
//SLB5B := 360;
//SLB6 := 361;
//STOCKPOINTID := '0';
//EXCLUDE_DEACTIVE_CUST := 'N';
//EXCLUDE_DEACTIVE_LOC  := 'N';
//IGDIV := 'N';
//STATEID := 0;