package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;




@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "DISPATCH_REGISTERStoreProcedure", query = "{CALL DISPATCH_REGISTER(?,:FIN_YR_FLAG, :FINYR, :COMP_CD, :LOCID,:STDT, :ENDT,:DIVID,:CUSTID,:DETAIL ,:STOCKPOINTID)}", callable = true, resultClass = PROCEDURE.class) })
public class PROCEDURE {

	@Id
    @Column(name = "ROWNUM")
    private String rowNum;

    @Column(name = "DSP_ID")
    private String dspId;

    @Column(name = "DIV_ID")
    private String divId;

    @Column(name = "DIVISION")
    private String division;

    @Column(name = "DSP_TRN_NO")
    private String dspTrnNo;

    @Column(name = "DSP_DT")
    private String dspDt;

    @Column(name = "CHALLAN_NO")
    private String challanNo;

    @Column(name = "CUST_ID")
    private String custId;

    @Column(name = "CUST_NAME")
    private String custName;

    @Column(name = "DESTINATION")
    private String destination;

    @Column(name = "TRANSPORTER")
    private String transporter;

    @Column(name = "DSP_VALUE")
    private String dspValue;

    @Column(name = "INV_NO")
    private String invNo;

    @Column(name = "LR_NUM")
    private String lrNum;

    @Column(name = "LR_DATE")
    private String lrDate;

    @Column(name = "NO_OF_CASES")
    private int noOfCases;

    @Column(name = "PROD_ID")
    private String prodId;

    @Column(name = "PROD_CD")
    private String prodCd;

    @Column(name = "PROD_NAME")
    private String prodName;

    @Column(name = "BATCH_ID")
    private String batchId;

    @Column(name = "BATCH_NO")
    private String batchNo;

    @Column(name = "ORDER_NO")
    private String orderNo;

    @Column(name = "SOLD")
    private String sold;

    @Column(name = "FREE")
    private String free;

    @Column(name = "REPL")
    private String repl;

    @Column(name = "RATE")
    private String rate;

    @Column(name = "GOODS_VALUE")
    private String goodsValue;

    @Column(name = "TAX")
    private String tax;

    @Column(name = "DISCOUNT")
    private String discount;

    @Column(name = "FORM_NUM")
    private String formNum;

    @Column(name = "CFORM_DATE")
    private String cformDate;

    @Column(name = "CFORM_VALUE")
    private int cformValue;

    @Column(name = "DELAY_DAYS")
    private int delayDays;

    @Column(name = "DRIVER_NAME")
    private String driverName;

    @Column(name = "LORRY_NO")
    private String lorryNo;

    @Column(name = "POD_NUM")
    private String podNum;

    @Column(name = "POD_DATE")
    private String podDate;

    @Column(name = "POD_REASON")
    private String podReason;

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public String getDspId() {
		return dspId;
	}

	public void setDspId(String dspId) {
		this.dspId = dspId;
	}

	public String getDivId() {
		return divId;
	}

	public void setDivId(String divId) {
		this.divId = divId;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDspTrnNo() {
		return dspTrnNo;
	}

	public void setDspTrnNo(String dspTrnNo) {
		this.dspTrnNo = dspTrnNo;
	}

	public String getDspDt() {
		return dspDt;
	}

	public void setDspDt(String dspDt) {
		this.dspDt = dspDt;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public String getDspValue() {
		return dspValue;
	}

	public void setDspValue(String dspValue) {
		this.dspValue = dspValue;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
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

	public int getNoOfCases() {
		return noOfCases;
	}

	public void setNoOfCases(int noOfCases) {
		this.noOfCases = noOfCases;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdCd() {
		return prodCd;
	}

	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSold() {
		return sold;
	}

	public void setSold(String sold) {
		this.sold = sold;
	}

	public String getFree() {
		return free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public String getRepl() {
		return repl;
	}

	public void setRepl(String repl) {
		this.repl = repl;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(String goodsValue) {
		this.goodsValue = goodsValue;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getFormNum() {
		return formNum;
	}

	public void setFormNum(String formNum) {
		this.formNum = formNum;
	}

	public String getCformDate() {
		return cformDate;
	}

	public void setCformDate(String cformDate) {
		this.cformDate = cformDate;
	}

	public int getCformValue() {
		return cformValue;
	}

	public void setCformValue(int cformValue) {
		this.cformValue = cformValue;
	}

	public int getDelayDays() {
		return delayDays;
	}

	public void setDelayDays(int delayDays) {
		this.delayDays = delayDays;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getLorryNo() {
		return lorryNo;
	}

	public void setLorryNo(String lorryNo) {
		this.lorryNo = lorryNo;
	}

	public String getPodNum() {
		return podNum;
	}

	public void setPodNum(String podNum) {
		this.podNum = podNum;
	}

	public String getPodDate() {
		return podDate;
	}

	public void setPodDate(String podDate) {
		this.podDate = podDate;
	}

	public String getPodReason() {
		return podReason;
	}

	public void setPodReason(String podReason) {
		this.podReason = podReason;
	}

	@Override
	public String toString() {
		return "PROCEDURE [rowNum=" + rowNum + ", dspId=" + dspId + ", divId=" + divId + ", division=" + division
				+ ", dspTrnNo=" + dspTrnNo + ", dspDt=" + dspDt + ", challanNo=" + challanNo + ", custId=" + custId
				+ ", custName=" + custName + ", destination=" + destination + ", transporter=" + transporter
				+ ", dspValue=" + dspValue + ", invNo=" + invNo + ", lrNum=" + lrNum + ", lrDate=" + lrDate
				+ ", noOfCases=" + noOfCases + ", prodId=" + prodId + ", prodCd=" + prodCd + ", prodName=" + prodName
				+ ", batchId=" + batchId + ", batchNo=" + batchNo + ", orderNo=" + orderNo + ", sold=" + sold
				+ ", free=" + free + ", repl=" + repl + ", rate=" + rate + ", goodsValue=" + goodsValue + ", tax=" + tax
				+ ", discount=" + discount + ", formNum=" + formNum + ", cformDate=" + cformDate + ", cformValue="
				+ cformValue + ", delayDays=" + delayDays + ", driverName=" + driverName + ", lorryNo=" + lorryNo
				+ ", podNum=" + podNum + ", podDate=" + podDate + ", podReason=" + podReason + "]";
	}
    
    
    
    
    

   
}
