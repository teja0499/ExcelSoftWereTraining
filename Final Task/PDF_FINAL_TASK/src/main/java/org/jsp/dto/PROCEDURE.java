package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;



@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "RET_CLM_PRINTStoreProcedure", query = "{CALL RET_CLM_PRINT(?,:YEAR_FLAG, :FINID, :COMP_CD, :LOCID, :STOCKPOINTID, :START_NUM, :END_NUM, :INVTYPE, :INVGRP)}", callable = true, resultClass = PROCEDURE.class) })

public class PROCEDURE {

	
	
//	ROWNUM
//	TRAN_ID
//	INV_NUMBER
//	INV_DATE
//	LR_NUM
//	LR_DATE
//	LET_REF_NUM
//	LET_REF_DATE
//	TRANSPORTER
//	CST_NO 
	
	@Id
	@Column(name = "ROWNUM")
	private int rownum;

	@Column(name = "TRAN_ID")
	private int tranId;

	@Column(name = "INV_NUMBER")
	private String invNumber;

	@Column(name = "INV_DATE")
	private String invDate;

	@Column(name = "LR_NUM")
	private String lrNum;

	@Column(name = "LR_DATE")
	private String lrDate;

	@Column(name = "LET_REF_NUM")
	private String letRefNum;

	@Column(name = "LET_REF_DATE")
	private String letRefDate;

	@Column(name = "TRANSPORTER")
	private String transporter;

	@Column(name = "CST_NO")
	private String cstNo;
	
	
//	DADDR1
//	DADDR2
//	DADDR3
//	DADDR4
//	D_DRUG_LIC1
//	D_DRUG_LIC2
//	D_DRUG_LIC3
//	LST_NO
//	STATE_ID
//	BILLING_NAME
//	COMPANY_CD
//	STATUS 
	
	

	@Column(name = "DADDR1")
	private String daddr1;

	@Column(name = "DADDR2")
	private String daddr2;

	@Column(name = "DADDR3")
	private String daddr3;

	@Column(name = "DADDR4")
	private String daddr4;

	@Column(name = "D_DRUG_LIC1")
	private String dDrugLic1;

	@Column(name = "D_DRUG_LIC2")
	private String dDrugLic2;

	@Column(name = "D_DRUG_LIC3")
	private String dDrugLic3;

	@Column(name = "LST_NO")
	private String lstNo;

	@Column(name = "STATE_ID")
	private String stateId;

	@Column(name = "BILLING_NAME")
	private String billingName;

	@Column(name = "COMPANY_CD")
	private String companyCd;

	@Column(name = "STATUS")
	private String status;
	
	
//	CLAIM_NUM
//	LOC_ID
//	INV_GROUP
//	TOT_GOODS_VAL
//	TRAN_TYPE
//	COMMON_INVOICE
//	INVOICE_VALUE
//	INV_TYPE
//	VAT_CST_IND
//	CUST_ID
//	FIN_YEAR_ID
//	DIV_ID
	
	
	

	@Column(name = "CLAIM_NUM")
	private String claimNum;
	
	@Column(name = "LOC_ID")
	private String locId;

	@Column(name = "INV_GROUP")
	private String invGroup;

	@Column(name = "TOT_GOODS_VAL")
	private String totGoodsVal;

	@Column(name = "TRAN_TYPE")
	private String tranType;

	@Column(name = "COMMON_INVOICE")
	private String commonInvoice;

	

	@Column(name = "INVOICE_VALUE")
	private String invoiceValue;

	@Column(name = "INV_TYPE")
	private String invType;

	@Column(name = "VAT_CST_IND")
	private String vatCstInd;

	@Column(name = "CUST_ID")
	private int custId;

	@Column(name = "FIN_YEAR_ID")
	private int finYearId;

	@Column(name = "DIV_ID")
	private int divId;

	@Column(name = "PROD_NAME")
	private String prodName;

	@Column(name = "BATCH_NO")
	private String batchNo;

	@Column(name = "EXPIRY_DT")
	private String expiryDt;

	@Column(name = "BILLED_QTY")
	private int billedQty;

	@Column(name = "FREE_QTY")
	private int freeQty;

	@Column(name = "RATE")
	private String rate;

	@Column(name = "MRP")
	private String mrp;

	@Column(name = "RATE_USED")
	private String rateUsed;

	@Column(name = "SUPP_INV_DATE")
	private String suppInvDate;

	@Column(name = "GOODS_VALUE")
	private String goodsValue;

	@Column(name = "CUST_NAME")
	private String custName;

	@Column(name = "ADDR1")
	private String addr1;

	@Column(name = "ADDR2")
	private String addr2;

	@Column(name = "ADDR3")
	private String addr3;

	@Column(name = "ADDR4")
	private String addr4;

	@Column(name = "TIN_NO")
	private String tinNo;

	@Column(name = "CM_CST_NO")
	private String cmCstNo;

	@Column(name = "DRUG_LIC1")
	private String drugLic1;

	@Column(name = "DRUG_LIC2")
	private String drugLic2;

	@Column(name = "DRUG_LIC3")
	private String drugLic3;

	@Column(name = "MSR")
	private String msr;

	@Column(name = "RM")
	private String rm;

	@Column(name = "HQ")
	private String hq;

	@Column(name = "AREA")
	private String area;

	@Column(name = "STOCK_POINT_ID")
	private String stockPointId;

	@Column(name = "STOCK_POINT_NAME")
	private String stockPointName;

	@Column(name = "S_CSTNO")
	private String sCstNo;

	@Column(name = "SADDR1")
	private String sAddr1;

	@Column(name = "SADDR2")
	private String sAddr2;

	@Column(name = "SADDR3")
	private String sAddr3;

	@Column(name = "SADDR4")
	private String sAddr4;

	@Column(name = "S_DRUG_LIC1")
	private String sDrugLic1;

	@Column(name = "S_LSTO")
	private String sLsto;

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public String getInvNumber() {
		return invNumber;
	}

	public void setInvNumber(String invNumber) {
		this.invNumber = invNumber;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public String getLrNum() {
		return lrNum;
	}

	public void setLrNum(String lrNum) {
		this.lrNum = lrNum;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getLetRefNum() {
		return letRefNum;
	}

	public void setLetRefNum(String letRefNum) {
		this.letRefNum = letRefNum;
	}

	public String getLetRefDate() {
		return letRefDate;
	}

	public void setLetRefDate(String letRefDate) {
		this.letRefDate = letRefDate;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public String getCstNo() {
		return cstNo;
	}

	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}

	public String getDaddr1() {
		return daddr1;
	}

	public void setDaddr1(String daddr1) {
		this.daddr1 = daddr1;
	}

	public String getDaddr2() {
		return daddr2;
	}

	public void setDaddr2(String daddr2) {
		this.daddr2 = daddr2;
	}

	public String getDaddr3() {
		return daddr3;
	}

	public void setDaddr3(String daddr3) {
		this.daddr3 = daddr3;
	}

	public String getDaddr4() {
		return daddr4;
	}

	public void setDaddr4(String daddr4) {
		this.daddr4 = daddr4;
	}

	public String getdDrugLic1() {
		return dDrugLic1;
	}

	public void setdDrugLic1(String dDrugLic1) {
		this.dDrugLic1 = dDrugLic1;
	}

	public String getdDrugLic2() {
		return dDrugLic2;
	}

	public void setdDrugLic2(String dDrugLic2) {
		this.dDrugLic2 = dDrugLic2;
	}

	public String getdDrugLic3() {
		return dDrugLic3;
	}

	public void setdDrugLic3(String dDrugLic3) {
		this.dDrugLic3 = dDrugLic3;
	}

	public String getLstNo() {
		return lstNo;
	}

	public void setLstNo(String lstNo) {
		this.lstNo = lstNo;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getCompanyCd() {
		return companyCd;
	}

	public void setCompanyCd(String companyCd) {
		this.companyCd = companyCd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getInvGroup() {
		return invGroup;
	}

	public void setInvGroup(String invGroup) {
		this.invGroup = invGroup;
	}

	public String getTotGoodsVal() {
		return totGoodsVal;
	}

	public void setTotGoodsVal(String totGoodsVal) {
		this.totGoodsVal = totGoodsVal;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	
	public String getCommonInvoice() {
		return commonInvoice;
	}

	public void setCommonInvoice(String commonInvoice) {
		this.commonInvoice = commonInvoice;
	}

	public String getInvoiceValue() {
		return invoiceValue;
	}

	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public String getVatCstInd() {
		return vatCstInd;
	}

	public void setVatCstInd(String vatCstInd) {
		this.vatCstInd = vatCstInd;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(int finYearId) {
		this.finYearId = finYearId;
	}

	public int getDivId() {
		return divId;
	}

	public void setDivId(int divId) {
		this.divId = divId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getExpiryDt() {
		return expiryDt;
	}

	public void setExpiryDt(String expiryDt) {
		this.expiryDt = expiryDt;
	}

	public int getBilledQty() {
		return billedQty;
	}

	public void setBilledQty(int billedQty) {
		this.billedQty = billedQty;
	}

	public int getFreeQty() {
		return freeQty;
	}

	public void setFreeQty(int freeQty) {
		this.freeQty = freeQty;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMrp() {
		return mrp;
	}

	public void setMrp(String mrp) {
		this.mrp = mrp;
	}

	public String getRateUsed() {
		return rateUsed;
	}

	public void setRateUsed(String rateUsed) {
		this.rateUsed = rateUsed;
	}

	public String getSuppInvDate() {
		return suppInvDate;
	}

	public void setSuppInvDate(String suppInvDate) {
		this.suppInvDate = suppInvDate;
	}

	public String getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(String goodsValue) {
		this.goodsValue = goodsValue;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getCmCstNo() {
		return cmCstNo;
	}

	public void setCmCstNo(String cmCstNo) {
		this.cmCstNo = cmCstNo;
	}

	public String getDrugLic1() {
		return drugLic1;
	}

	public void setDrugLic1(String drugLic1) {
		this.drugLic1 = drugLic1;
	}

	public String getDrugLic2() {
		return drugLic2;
	}

	public void setDrugLic2(String drugLic2) {
		this.drugLic2 = drugLic2;
	}

	public String getDrugLic3() {
		return drugLic3;
	}

	public void setDrugLic3(String drugLic3) {
		this.drugLic3 = drugLic3;
	}

	public String getMsr() {
		return msr;
	}

	public void setMsr(String msr) {
		this.msr = msr;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getHq() {
		return hq;
	}

	public void setHq(String hq) {
		this.hq = hq;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(String stockPointId) {
		this.stockPointId = stockPointId;
	}

	public String getStockPointName() {
		return stockPointName;
	}

	public void setStockPointName(String stockPointName) {
		this.stockPointName = stockPointName;
	}

	public String getsCstNo() {
		return sCstNo;
	}

	public void setsCstNo(String sCstNo) {
		this.sCstNo = sCstNo;
	}

	public String getsAddr1() {
		return sAddr1;
	}

	public void setsAddr1(String sAddr1) {
		this.sAddr1 = sAddr1;
	}

	public String getsAddr2() {
		return sAddr2;
	}

	public void setsAddr2(String sAddr2) {
		this.sAddr2 = sAddr2;
	}

	public String getsAddr3() {
		return sAddr3;
	}

	public void setsAddr3(String sAddr3) {
		this.sAddr3 = sAddr3;
	}

	public String getsAddr4() {
		return sAddr4;
	}

	public void setsAddr4(String sAddr4) {
		this.sAddr4 = sAddr4;
	}

	public String getsDrugLic1() {
		return sDrugLic1;
	}

	public void setsDrugLic1(String sDrugLic1) {
		this.sDrugLic1 = sDrugLic1;
	}

	public String getsLsto() {
		return sLsto;
	}

	public void setsLsto(String sLsto) {
		this.sLsto = sLsto;
	}

	public String getClaimNum() {
		return claimNum;
	}

	public void setClaimNum(String claimNum) {
		this.claimNum = claimNum;
	}

	public String getLocId() {
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder("PROCEDURE Details:\n");
	    sb.append("rownum: ").append(rownum).append("\n")
	      .append("tranId: ").append(tranId).append("\n")
	      .append("invNumber: ").append(invNumber).append("\n")
	      .append("invDate: ").append(invDate).append("\n")
	      .append("lrNum: ").append(lrNum).append("\n")
	      .append("lrDate: ").append(lrDate).append("\n")
	      .append("letRefNum: ").append(letRefNum).append("\n")
	      .append("letRefDate: ").append(letRefDate).append("\n")
	      .append("transporter: ").append(transporter).append("\n")
	      .append("cstNo: ").append(cstNo).append("\n")
	      .append("daddr1: ").append(daddr1).append("\n")
	      .append("daddr2: ").append(daddr2).append("\n")
	      .append("daddr3: ").append(daddr3).append("\n")
	      .append("daddr4: ").append(daddr4).append("\n")
	      .append("dDrugLic1: ").append(dDrugLic1).append("\n")
	      .append("dDrugLic2: ").append(dDrugLic2).append("\n")
	      .append("dDrugLic3: ").append(dDrugLic3).append("\n")
	      .append("lstNo: ").append(lstNo).append("\n")
	      .append("stateId: ").append(stateId).append("\n")
	      .append("billingName: ").append(billingName).append("\n")
	      .append("companyCd: ").append(companyCd).append("\n")
	      .append("status: ").append(status).append("\n")
	      .append("claimNum: ").append(claimNum).append("\n")
	      .append("locId: ").append(locId).append("\n")
	      .append("invGroup: ").append(invGroup).append("\n")
	      .append("totGoodsVal: ").append(totGoodsVal).append("\n")
	      .append("tranType: ").append(tranType).append("\n")
	      .append("commonInvoice: ").append(commonInvoice).append("\n")
	      .append("invoiceValue: ").append(invoiceValue).append("\n")
	      .append("invType: ").append(invType).append("\n")
	      .append("vatCstInd: ").append(vatCstInd).append("\n")
	      .append("custId: ").append(custId).append("\n")
	      .append("finYearId: ").append(finYearId).append("\n")
	      .append("divId: ").append(divId).append("\n")
	      .append("prodName: ").append(prodName).append("\n")
	      .append("batchNo: ").append(batchNo).append("\n")
	      .append("expiryDt: ").append(expiryDt).append("\n")
	      .append("billedQty: ").append(billedQty).append("\n")
	      .append("freeQty: ").append(freeQty).append("\n")
	      .append("rate: ").append(rate).append("\n")
	      .append("mrp: ").append(mrp).append("\n")
	      .append("rateUsed: ").append(rateUsed).append("\n")
	      .append("suppInvDate: ").append(suppInvDate).append("\n")
	      .append("goodsValue: ").append(goodsValue).append("\n")
	      .append("custName: ").append(custName).append("\n")
	      .append("addr1: ").append(addr1).append("\n")
	      .append("addr2: ").append(addr2).append("\n")
	      .append("addr3: ").append(addr3).append("\n")
	      .append("addr4: ").append(addr4).append("\n")
	      .append("tinNo: ").append(tinNo).append("\n")
	      .append("cmCstNo: ").append(cmCstNo).append("\n")
	      .append("drugLic1: ").append(drugLic1).append("\n")
	      .append("drugLic2: ").append(drugLic2).append("\n")
	      .append("drugLic3: ").append(drugLic3).append("\n")
	      .append("msr: ").append(msr).append("\n")
	      .append("rm: ").append(rm).append("\n")
	      .append("hq: ").append(hq).append("\n")
	      .append("area: ").append(area).append("\n")
	      .append("stockPointId: ").append(stockPointId).append("\n")
	      .append("stockPointName: ").append(stockPointName).append("\n")
	      .append("sCstNo: ").append(sCstNo).append("\n")
	      .append("sAddr1: ").append(sAddr1).append("\n")
	      .append("sAddr2: ").append(sAddr2).append("\n")
	      .append("sAddr3: ").append(sAddr3).append("\n")
	      .append("sAddr4: ").append(sAddr4).append("\n")
	      .append("sDrugLic1: ").append(sDrugLic1).append("\n")
	      .append("sLsto: ").append(sLsto);
	    
	    return sb.toString();
	}


	

}
