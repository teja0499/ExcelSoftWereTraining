package org.jsp.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

//import java.util.String;


@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "CNDN_PRINT_VIEW_GSTStoreProcedure",
        query = "CALL CNDN_PRINT_VIEW_GST(?,:YEAR_FLAG, :COMP_CD, :FINID, :LOCID, :FRNUM, :TONUM, :TRANTYPE, :INVTYPE, :STOCKPOINTID, :PERID)",
        callable = true,
        resultClass = PDF_PROCEDURE.class
    )
})
public class PDF_PROCEDURE {
	
	
	 @Id
     @Column(name = "ROWNUM")
     private int rownum;

     @Column(name = "BILLING_NAME")
     private String billingName;

     @Column(name = "LOC_ADDR1")
     private String locAddr1;

     @Column(name = "LOC_ADDR2")
     private String locAddr2;

     @Column(name = "LOC_ADDR3")
     private String locAddr3;

     @Column(name = "LOC_ADDR4")
     private String locAddr4;

     @Column(name = "LOC_TIN_NO")
     private String locTinNo;

     @Column(name = "LOC_CST_NO")
     private String locCstNo;

     @Column(name = "LOC_DLIC1")
     private String locDlic1;

     @Column(name = "LOC_DLIC2")
     private String locDlic2;

     @Column(name = "LOC_DLIC3")
     private String locDlic3;

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

     @Column(name = "CST_NO")
     private String cstNo;

     @Column(name = "DRUG_LIC1")
     private String drugLic1;

     @Column(name = "DRUG_LIC2")
     private String drugLic2;

     @Column(name = "HQ_NAME")
     private String hqName;

     @Column(name = "MSR_NAME")
     private String msrName;

     @Column(name = "AM_NAME")
     private String amName;

     @Column(name = "RM_NAME")
     private String rmName;

     @Column(name = "AREA_NAME")
     private String areaName;

     @Column(name = "CN_NUMBER")
     private String cnNumber;

     @Column(name = "CN_DATE")
     private String cnDate;

     @Column(name = "REF_NO")
     private String refNo;

     @Column(name = "REF_DATE")
     private String refDate;

     @Column(name = "TRANSPORTER")
     private String transporter;

     @Column(name = "LR_NUM")
     private String lrNum;

     @Column(name = "LR_DATE")
     private String lrDate;

     @Column(name = "PROD_NAME")
     private String prodName;

     @Column(name = "BATCH_NO")
     private String batchNo;

     @Column(name = "EXPIRY_DT")
     private String expiryDt;

     @Column(name = "PROD_DISC_AMT")
     private float prodDiscAmt;

     @Column(name = "GOODS_VALUE")
     private float goodsValue;

     @Column(name = "SUPPLY_INV_NO")
     private String supplyInvNo;

     @Column(name = "BILLED_QTY")
     private Long billedQty;

     @Column(name = "FREE_QTY")
     private Long freeQty;

     @Column(name = "RATE")
     private float rate;

     @Column(name = "SCHM_ADJ_RATE")
     private String schmAdjRate;

     @Column(name = "MRP")
     private float mrp;

     @Column(name = "INVOICE_VALUE")
     private String invoiceValue;

     @Column(name = "DIVISION")
     private String division;

     @Column(name = "VAT_RATE")
     private float vatRate;

     @Column(name = "VAT_BILL_AMT")
     private float vatBillAmt;

     @Column(name = "MFG_LOC_ID")
     private String mfgLocId;

     @Column(name = "MANUFACTURER")
     private String manufacturer;

     @Column(name = "VAT_CST_IND")
     private String vatCstInd;

     @Column(name = "SURCHG_RATE")
     private float surchgRate;

     @Column(name = "SURCHG_BILL_AMT")
     private float surchgBillAmt;

     @Column(name = "TAX_AMT_BILLED")
     private float taxAmtBilled;

     @Column(name = "TOT_AMT")
     private float totAmt;

     @Column(name = "SUPPLY_INV_DT")
     private String supplyInvDt;

     @Column(name = "TAXTYPE")
     private String taxtype;

     @Column(name = "TAXABLE_AMT")
     private float taxableAmt;

     @Column(name = "IND")
     private String ind;

     @Column(name = "GL_CODE")
     private String glCode;

     @Column(name = "GL_DESCRIPTION")
     private String glDescription;

     @Column(name = "CN_REASON")
     private String cnReason;

     @Column(name = "NARRATION")
     private String narration;

     @Column(name = "AMOUNT")
     private float amount;

     @Column(name = "CU_PANNO")
     private String cuPanno;

     @Column(name = "STM_PANNO")
     private String stmPanno;

     @Column(name = "RATE_CHARGED")
     private float rateCharged;

     @Column(name = "ACTUAL_RATE")
     private float actualRate;

     @Column(name = "STOCK_TYPE")
     private String stockType;

     @Column(name = "APP_LABEL")
     private String appLabel;

     @Column(name = "LOC_STATEID")
     private String locStateId;

     @Column(name = "CU_STATEID")
     private String cuStateId;

     @Column(name = "LOC_WEBSITE")
     private String locWebsite;

     @Column(name = "CU_WEBSITE")
     private String cuWebsite;

     @Column(name = "LOC_GSTIN")
     private String locGstin;

     @Column(name = "CU_GSTIN")
     private String cuGstin;

     @Column(name = "LOC_STATECD")
     private String locStateCd;

     @Column(name = "LOC_STATE")
     private String locState;

     @Column(name = "CU_STATECD")
     private String cuStateCd;

     @Column(name = "CU_STATE")
     private String cuState;

     @Column(name = "HSN_CODE")
     private String hsnCode;

     @Column(name = "PTS_ACTUALRATE")
     private String ptsActualRate;

     @Column(name = "SGST_IGST_RATE")
     private float sgstIgstRate;

     @Column(name = "SGST_IGST_AMT")
     private float sgstIgstAmt;

     @Column(name = "CGST_RATE")
     private float cgstRate;

     @Column(name = "CGST_AMT")
     private float cgstAmt;

     @Column(name = "CESS_RATE")
     private float cessRate;

     @Column(name = "CESS_BILL_AMT")
     private float cessBillAmt;

     @Column(name = "RATE_DIFF")
     private float rateDiff;

     @Column(name = "UNION_TERRITORY")
     private String unionTerritory;

     @Column(name = "LOC_DESTINATION")
     private String locDestination;

     @Column(name = "CU_DESTINATION")
     private String cuDestination;

     @Column(name = "DUE_DATE")
     private String dueDate;

     @Column(name = "D_NARRATION")
     private String dNarration;

     @Column(name = "COMPANY_NAME")
     private String companyName;

     @Column(name = "CMP_ADDR")
     private String cmpAddr;

     @Column(name = "CMP_WEB")
     private String cmpWeb;

     @Column(name = "CMP_CIN")
     private String cmpCin;

     @Column(name = "CMP_TEL")
     private String cmpTel;

     @Column(name = "PROD_ORD")
     private String prodOrd;

     @Column(name = "SLNO")
     private String slno;

     @Column(name = "IRN_NUMBER")
     private String irnNumber;

     @Column(name = "QR_IMAGE_PATH")
     private String qrImagePath;

     @Column(name = "QR_CODE")
     private String qrCode;

     @Column(name = "DL1_VALID_DT")
     private String dl1ValidDt;

     @Column(name = "DL2_VALID_DT")
     private String dl2ValidDt;

     @Column(name = "DL3_VALID_DT")
     private String dl3ValidDt;

     @Column(name = "STOCK_TYPE_DESC")
     private String stockTypeDesc;

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getLocAddr1() {
		return locAddr1;
	}

	public void setLocAddr1(String locAddr1) {
		this.locAddr1 = locAddr1;
	}

	public String getLocAddr2() {
		return locAddr2;
	}

	public void setLocAddr2(String locAddr2) {
		this.locAddr2 = locAddr2;
	}

	public String getLocAddr3() {
		return locAddr3;
	}

	public void setLocAddr3(String locAddr3) {
		this.locAddr3 = locAddr3;
	}

	public String getLocAddr4() {
		return locAddr4;
	}

	public void setLocAddr4(String locAddr4) {
		this.locAddr4 = locAddr4;
	}

	public String getLocTinNo() {
		return locTinNo;
	}

	public void setLocTinNo(String locTinNo) {
		this.locTinNo = locTinNo;
	}

	public String getLocCstNo() {
		return locCstNo;
	}

	public void setLocCstNo(String locCstNo) {
		this.locCstNo = locCstNo;
	}

	public String getLocDlic1() {
		return locDlic1;
	}

	public void setLocDlic1(String locDlic1) {
		this.locDlic1 = locDlic1;
	}

	public String getLocDlic2() {
		return locDlic2;
	}

	public void setLocDlic2(String locDlic2) {
		this.locDlic2 = locDlic2;
	}

	public String getLocDlic3() {
		return locDlic3;
	}

	public void setLocDlic3(String locDlic3) {
		this.locDlic3 = locDlic3;
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

	public String getCstNo() {
		return cstNo;
	}

	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
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

	public String getHqName() {
		return hqName;
	}

	public void setHqName(String hqName) {
		this.hqName = hqName;
	}

	public String getMsrName() {
		return msrName;
	}

	public void setMsrName(String msrName) {
		this.msrName = msrName;
	}

	public String getAmName() {
		return amName;
	}

	public void setAmName(String amName) {
		this.amName = amName;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCnNumber() {
		return cnNumber;
	}

	public void setCnNumber(String cnNumber) {
		this.cnNumber = cnNumber;
	}

	public String getCnDate() {
		return cnDate;
	}

	public void setCnDate(String cnDate) {
		this.cnDate = cnDate;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
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

	public float getProdDiscAmt() {
		return prodDiscAmt;
	}

	public void setProdDiscAmt(float prodDiscAmt) {
		this.prodDiscAmt = prodDiscAmt;
	}

	public float getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(float goodsValue) {
		this.goodsValue = goodsValue;
	}

	public String getSupplyInvNo() {
		return supplyInvNo;
	}

	public void setSupplyInvNo(String supplyInvNo) {
		this.supplyInvNo = supplyInvNo;
	}

	public Long getBilledQty() {
		return billedQty;
	}

	public void setBilledQty(Long billedQty) {
		this.billedQty = billedQty;
	}

	public Long getFreeQty() {
		return freeQty;
	}

	public void setFreeQty(Long freeQty) {
		this.freeQty = freeQty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getSchmAdjRate() {
		return schmAdjRate;
	}

	public void setSchmAdjRate(String schmAdjRate) {
		this.schmAdjRate = schmAdjRate;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public String getInvoiceValue() {
		return invoiceValue;
	}

	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public float getVatRate() {
		return vatRate;
	}

	public void setVatRate(float vatRate) {
		this.vatRate = vatRate;
	}

	public float getVatBillAmt() {
		return vatBillAmt;
	}

	public void setVatBillAmt(float vatBillAmt) {
		this.vatBillAmt = vatBillAmt;
	}

	public String getMfgLocId() {
		return mfgLocId;
	}

	public void setMfgLocId(String mfgLocId) {
		this.mfgLocId = mfgLocId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVatCstInd() {
		return vatCstInd;
	}

	public void setVatCstInd(String vatCstInd) {
		this.vatCstInd = vatCstInd;
	}

	public float getSurchgRate() {
		return surchgRate;
	}

	public void setSurchgRate(float surchgRate) {
		this.surchgRate = surchgRate;
	}

	public float getSurchgBillAmt() {
		return surchgBillAmt;
	}

	public void setSurchgBillAmt(float surchgBillAmt) {
		this.surchgBillAmt = surchgBillAmt;
	}

	public float getTaxAmtBilled() {
		return taxAmtBilled;
	}

	public void setTaxAmtBilled(float taxAmtBilled) {
		this.taxAmtBilled = taxAmtBilled;
	}

	public float getTotAmt() {
		return totAmt;
	}

	public void setTotAmt(float totAmt) {
		this.totAmt = totAmt;
	}

	public String getSupplyInvDt() {
		return supplyInvDt;
	}

	public void setSupplyInvDt(String supplyInvDt) {
		this.supplyInvDt = supplyInvDt;
	}

	public String getTaxtype() {
		return taxtype;
	}

	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public String getInd() {
		return ind;
	}

	public void setInd(String ind) {
		this.ind = ind;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getGlDescription() {
		return glDescription;
	}

	public void setGlDescription(String glDescription) {
		this.glDescription = glDescription;
	}

	public String getCnReason() {
		return cnReason;
	}

	public void setCnReason(String cnReason) {
		this.cnReason = cnReason;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCuPanno() {
		return cuPanno;
	}

	public void setCuPanno(String cuPanno) {
		this.cuPanno = cuPanno;
	}

	public String getStmPanno() {
		return stmPanno;
	}

	public void setStmPanno(String stmPanno) {
		this.stmPanno = stmPanno;
	}

	public float getRateCharged() {
		return rateCharged;
	}

	public void setRateCharged(float rateCharged) {
		this.rateCharged = rateCharged;
	}

	public float getActualRate() {
		return actualRate;
	}

	public void setActualRate(float actualRate) {
		this.actualRate = actualRate;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getAppLabel() {
		return appLabel;
	}

	public void setAppLabel(String appLabel) {
		this.appLabel = appLabel;
	}

	public String getLocStateId() {
		return locStateId;
	}

	public void setLocStateId(String locStateId) {
		this.locStateId = locStateId;
	}

	public String getCuStateId() {
		return cuStateId;
	}

	public void setCuStateId(String cuStateId) {
		this.cuStateId = cuStateId;
	}

	public String getLocWebsite() {
		return locWebsite;
	}

	public void setLocWebsite(String locWebsite) {
		this.locWebsite = locWebsite;
	}

	public String getCuWebsite() {
		return cuWebsite;
	}

	public void setCuWebsite(String cuWebsite) {
		this.cuWebsite = cuWebsite;
	}

	public String getLocGstin() {
		return locGstin;
	}

	public void setLocGstin(String locGstin) {
		this.locGstin = locGstin;
	}

	public String getCuGstin() {
		return cuGstin;
	}

	public void setCuGstin(String cuGstin) {
		this.cuGstin = cuGstin;
	}

	public String getLocStateCd() {
		return locStateCd;
	}

	public void setLocStateCd(String locStateCd) {
		this.locStateCd = locStateCd;
	}

	public String getLocState() {
		return locState;
	}

	public void setLocState(String locState) {
		this.locState = locState;
	}

	public String getCuStateCd() {
		return cuStateCd;
	}

	public void setCuStateCd(String cuStateCd) {
		this.cuStateCd = cuStateCd;
	}

	public String getCuState() {
		return cuState;
	}

	public void setCuState(String cuState) {
		this.cuState = cuState;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getPtsActualRate() {
		return ptsActualRate;
	}

	public void setPtsActualRate(String ptsActualRate) {
		this.ptsActualRate = ptsActualRate;
	}

	public float getSgstIgstRate() {
		return sgstIgstRate;
	}

	public void setSgstIgstRate(float sgstIgstRate) {
		this.sgstIgstRate = sgstIgstRate;
	}

	public float getSgstIgstAmt() {
		return sgstIgstAmt;
	}

	public void setSgstIgstAmt(float sgstIgstAmt) {
		this.sgstIgstAmt = sgstIgstAmt;
	}

	public float getCgstRate() {
		return cgstRate;
	}

	public void setCgstRate(float cgstRate) {
		this.cgstRate = cgstRate;
	}

	public float getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(float cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public float getCessRate() {
		return cessRate;
	}

	public void setCessRate(float cessRate) {
		this.cessRate = cessRate;
	}

	public float getCessBillAmt() {
		return cessBillAmt;
	}

	public void setCessBillAmt(float cessBillAmt) {
		this.cessBillAmt = cessBillAmt;
	}

	public float getRateDiff() {
		return rateDiff;
	}

	public void setRateDiff(float rateDiff) {
		this.rateDiff = rateDiff;
	}

	public String getUnionTerritory() {
		return unionTerritory;
	}

	public void setUnionTerritory(String unionTerritory) {
		this.unionTerritory = unionTerritory;
	}

	public String getLocDestination() {
		return locDestination;
	}

	public void setLocDestination(String locDestination) {
		this.locDestination = locDestination;
	}

	public String getCuDestination() {
		return cuDestination;
	}

	public void setCuDestination(String cuDestination) {
		this.cuDestination = cuDestination;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getdNarration() {
		return dNarration;
	}

	public void setdNarration(String dNarration) {
		this.dNarration = dNarration;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCmpAddr() {
		return cmpAddr;
	}

	public void setCmpAddr(String cmpAddr) {
		this.cmpAddr = cmpAddr;
	}

	public String getCmpWeb() {
		return cmpWeb;
	}

	public void setCmpWeb(String cmpWeb) {
		this.cmpWeb = cmpWeb;
	}

	public String getCmpCin() {
		return cmpCin;
	}

	public void setCmpCin(String cmpCin) {
		this.cmpCin = cmpCin;
	}

	public String getCmpTel() {
		return cmpTel;
	}

	public void setCmpTel(String cmpTel) {
		this.cmpTel = cmpTel;
	}

	public String getProdOrd() {
		return prodOrd;
	}

	public void setProdOrd(String prodOrd) {
		this.prodOrd = prodOrd;
	}

	public String getSlno() {
		return slno;
	}

	public void setSlno(String slno) {
		this.slno = slno;
	}

	public String getIrnNumber() {
		return irnNumber;
	}

	public void setIrnNumber(String irnNumber) {
		this.irnNumber = irnNumber;
	}

	public String getQrImagePath() {
		return qrImagePath;
	}

	public void setQrImagePath(String qrImagePath) {
		this.qrImagePath = qrImagePath;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getDl1ValidDt() {
		return dl1ValidDt;
	}

	public void setDl1ValidDt(String dl1ValidDt) {
		this.dl1ValidDt = dl1ValidDt;
	}

	public String getDl2ValidDt() {
		return dl2ValidDt;
	}

	public void setDl2ValidDt(String dl2ValidDt) {
		this.dl2ValidDt = dl2ValidDt;
	}

	public String getDl3ValidDt() {
		return dl3ValidDt;
	}

	public void setDl3ValidDt(String dl3ValidDt) {
		this.dl3ValidDt = dl3ValidDt;
	}

	public String getStockTypeDesc() {
		return stockTypeDesc;
	}

	public void setStockTypeDesc(String stockTypeDesc) {
		this.stockTypeDesc = stockTypeDesc;
	}

	@Override
	public String toString() {
		return "PDF_PROCEDURE [rownum=" + rownum + ", billingName=" + billingName + ", locAddr1=" + locAddr1
				+ ", locAddr2=" + locAddr2 + ", locAddr3=" + locAddr3 + ", locAddr4=" + locAddr4 + ", locTinNo="
				+ locTinNo + ", locCstNo=" + locCstNo + ", locDlic1=" + locDlic1 + ", locDlic2=" + locDlic2
				+ ", locDlic3=" + locDlic3 + ", custName=" + custName + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", addr3=" + addr3 + ", addr4=" + addr4 + ", tinNo=" + tinNo + ", cstNo=" + cstNo + ", drugLic1="
				+ drugLic1 + ", drugLic2=" + drugLic2 + ", hqName=" + hqName + ", msrName=" + msrName + ", amName="
				+ amName + ", rmName=" + rmName + ", areaName=" + areaName + ", cnNumber=" + cnNumber + ", cnDate="
				+ cnDate + ", refNo=" + refNo + ", refDate=" + refDate + ", transporter=" + transporter + ", lrNum="
				+ lrNum + ", lrDate=" + lrDate + ", prodName=" + prodName + ", batchNo=" + batchNo + ", expiryDt="
				+ expiryDt + ", prodDiscAmt=" + prodDiscAmt + ", goodsValue=" + goodsValue + ", supplyInvNo="
				+ supplyInvNo + ", billedQty=" + billedQty + ", freeQty=" + freeQty + ", rate=" + rate
				+ ", schmAdjRate=" + schmAdjRate + ", mrp=" + mrp + ", invoiceValue=" + invoiceValue + ", division="
				+ division + ", vatRate=" + vatRate + ", vatBillAmt=" + vatBillAmt + ", mfgLocId=" + mfgLocId
				+ ", manufacturer=" + manufacturer + ", vatCstInd=" + vatCstInd + ", surchgRate=" + surchgRate
				+ ", surchgBillAmt=" + surchgBillAmt + ", taxAmtBilled=" + taxAmtBilled + ", totAmt=" + totAmt
				+ ", supplyInvDt=" + supplyInvDt + ", taxtype=" + taxtype + ", taxableAmt=" + taxableAmt + ", ind="
				+ ind + ", glCode=" + glCode + ", glDescription=" + glDescription + ", cnReason=" + cnReason
				+ ", narration=" + narration + ", amount=" + amount + ", cuPanno=" + cuPanno + ", stmPanno=" + stmPanno
				+ ", rateCharged=" + rateCharged + ", actualRate=" + actualRate + ", stockType=" + stockType
				+ ", appLabel=" + appLabel + ", locStateId=" + locStateId + ", cuStateId=" + cuStateId + ", locWebsite="
				+ locWebsite + ", cuWebsite=" + cuWebsite + ", locGstin=" + locGstin + ", cuGstin=" + cuGstin
				+ ", locStateCd=" + locStateCd + ", locState=" + locState + ", cuStateCd=" + cuStateCd + ", cuState="
				+ cuState + ", hsnCode=" + hsnCode + ", ptsActualRate=" + ptsActualRate + ", sgstIgstRate="
				+ sgstIgstRate + ", sgstIgstAmt=" + sgstIgstAmt + ", cgstRate=" + cgstRate + ", cgstAmt=" + cgstAmt
				+ ", cessRate=" + cessRate + ", cessBillAmt=" + cessBillAmt + ", rateDiff=" + rateDiff
				+ ", unionTerritory=" + unionTerritory + ", locDestination=" + locDestination + ", cuDestination="
				+ cuDestination + ", dueDate=" + dueDate + ", dNarration=" + dNarration + ", companyName=" + companyName
				+ ", cmpAddr=" + cmpAddr + ", cmpWeb=" + cmpWeb + ", cmpCin=" + cmpCin + ", cmpTel=" + cmpTel
				+ ", prodOrd=" + prodOrd + ", slno=" + slno + ", irnNumber=" + irnNumber + ", qrImagePath="
				+ qrImagePath + ", qrCode=" + qrCode + ", dl1ValidDt=" + dl1ValidDt + ", dl2ValidDt=" + dl2ValidDt
				+ ", dl3ValidDt=" + dl3ValidDt + ", stockTypeDesc=" + stockTypeDesc + "]";
	}


}
