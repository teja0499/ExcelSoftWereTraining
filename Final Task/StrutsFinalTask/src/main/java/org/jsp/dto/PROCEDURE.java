package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "STOCK_TRANSFER_RECO_STATStoreProcedure", query = "{CALL STOCK_TRANSFER_RECO_STAT(?,:YEAR_FLAG, :FINID, :COMP_CD, :LOCID, :SEND_STOCKPOINTID, :RECV_LOCID, :RECV_STOCKPOINTID, :DIVID, :PRODID, :ST_DT, :EN_DT, :REPTYPE)}", callable = true, resultClass = PROCEDURE.class) })
public class PROCEDURE {
	@Id
	@Column(name = "ROWNUM")
	private int rownum;


	@Column(name = "TRF_DATE")
	private String trfDate;

	@Column(name = "TRANSFER_NO")
	private String transferNo;

	@Column(name = "SENDING_LOCATION")
	private String sendingLocation;
	
	@Column(name = "SENDING_CST")
	private String sendingCST;

	@Column(name = "SENDING_TIN")
	private String sendingTin;
	
	@Column(name = "SENDING_STATE")
	private String sendingState;

	@Column(name = "TRANSPORTER")
	private String transporter;

	@Column(name = "LR_NO")
	private String lrNo;

	@Column(name = "LR_DATE")
	private String lrDate;

	@Column(name = "RECEIVEING_LOCATION")
	private String receivingLocation;

	@Column(name = "RECEIVING_CST")
	private String receivingCst;

	@Column(name = "RECEIVING_TIN")
	private String receivingTin;

	@Column(name = "RECEIVING_STATE")
	private String receivingState;

	@Column(name = "PRODUCT_CODE")
	private String productCode;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "BATCH")
	private String batch;

	@Column(name = "DIVISION")
	private String division;

	@Column(name = "EXPIRY_DATE")
	private String expiryDate;

	@Column(name = "MFG_DT")
	private String mfgDt;

	@Column(name = "RATE")
	private String rate;

	@Column(name = "TRANSFERRED_VALUE")
	private String transferredValue;

	@Column(name = "TRANSFERRED_QTY")
	private int transferredQty;

	@Column(name = "GRN_DATE")
	private String grnDate;

	@Column(name = "GRN_NUMBER")
	private String grnNumber;

	@Column(name = "RECEIVED_QTY")
	private int receivedQty;

	@Column(name = "RECEIVED_VALUE")
	private String receivedValue;

	@Column(name = "DIFFERENCE_VALUE")
	private String differenceValue;

	@Column(name = "DIFFERENCE_QTY")
	private int differenceQty;

	@Column(name = "MAX_LEAD_TIME")
	private int maxLeadTime;

	@Column(name = "DELAY_DAYS")
	private int delayDays;

	@Column(name = "F_FORM_NO")
	private String fFormNo;

	@Column(name = "F_FORM_DT")
	private String fFormDt;

	@Column(name = "EXPECTED_GRN_DT")
	private String expectedGrnDt;

	@Column(name = "SEND_STOCK_POINT_NM")
	private String sendStockPointNm;

	@Column(name = "RECV_STOCK_POINT_NM")
	private String receivedStockPointNm;

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getTrfDate() {
		return trfDate;
	}

	public void setTrfDate(String trfDate) {
		this.trfDate = trfDate;
	}

	public String getTransferNo() {
		return transferNo;
	}

	public void setTransferNo(String transferNo) {
		this.transferNo = transferNo;
	}

	public String getSendingLocation() {
		return sendingLocation;
	}

	public void setSendingLocation(String sendingLocation) {
		this.sendingLocation = sendingLocation;
	}

	public String getSendingCST() {
		return sendingCST;
	}

	public void setSendingCST(String sendingCST) {
		this.sendingCST = sendingCST;
	}

	public String getSendingTin() {
		return sendingTin;
	}

	public void setSendingTin(String sendingTin) {
		this.sendingTin = sendingTin;
	}

	public String getSendingState() {
		return sendingState;
	}

	public void setSendingState(String sendingState) {
		this.sendingState = sendingState;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getReceivingLocation() {
		return receivingLocation;
	}

	public void setReceivingLocation(String receivingLocation) {
		this.receivingLocation = receivingLocation;
	}

	public String getReceivingCst() {
		return receivingCst;
	}

	public void setReceivingCst(String receivingCst) {
		this.receivingCst = receivingCst;
	}

	public String getReceivingTin() {
		return receivingTin;
	}

	public void setReceivingTin(String receivingTin) {
		this.receivingTin = receivingTin;
	}

	public String getReceivingState() {
		return receivingState;
	}

	public void setReceivingState(String receivingState) {
		this.receivingState = receivingState;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getMfgDt() {
		return mfgDt;
	}

	public void setMfgDt(String mfgDt) {
		this.mfgDt = mfgDt;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTransferredValue() {
		return transferredValue;
	}

	public void setTransferredValue(String transferredValue) {
		this.transferredValue = transferredValue;
	}

	public int getTransferredQty() {
		return transferredQty;
	}

	public void setTransferredQty(int transferredQty) {
		this.transferredQty = transferredQty;
	}

	public String getGrnDate() {
		return grnDate;
	}

	public void setGrnDate(String grnDate) {
		this.grnDate = grnDate;
	}

	public String getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getReceivedValue() {
		return receivedValue;
	}

	public void setReceivedValue(String receivedValue) {
		this.receivedValue = receivedValue;
	}

	public String getDifferenceValue() {
		return differenceValue;
	}

	public void setDifferenceValue(String differenceValue) {
		this.differenceValue = differenceValue;
	}

	public int getDifferenceQty() {
		return differenceQty;
	}

	public void setDifferenceQty(int differenceQty) {
		this.differenceQty = differenceQty;
	}

	public int getMaxLeadTime() {
		return maxLeadTime;
	}

	public void setMaxLeadTime(int maxLeadTime) {
		this.maxLeadTime = maxLeadTime;
	}

	public int getDelayDays() {
		return delayDays;
	}

	public void setDelayDays(int delayDays) {
		this.delayDays = delayDays;
	}

	public String getfFormNo() {
		return fFormNo;
	}

	public void setfFormNo(String fFormNo) {
		this.fFormNo = fFormNo;
	}

	public String getfFormDt() {
		return fFormDt;
	}

	public void setfFormDt(String fFormDt) {
		this.fFormDt = fFormDt;
	}

	public String getExpectedGrnDt() {
		return expectedGrnDt;
	}

	public void setExpectedGrnDt(String expectedGrnDt) {
		this.expectedGrnDt = expectedGrnDt;
	}

	public String getSendStockPointNm() {
		return sendStockPointNm;
	}

	public void setSendStockPointNm(String sendStockPointNm) {
		this.sendStockPointNm = sendStockPointNm;
	}

	public String getReceivedStockPointNm() {
		return receivedStockPointNm;
	}

	public void setReceivedStockPointNm(String receivedStockPointNm) {
		this.receivedStockPointNm = receivedStockPointNm;
	}

	@Override
	public String toString() {
		return "PROCEDURE [rownum=" + rownum + ", trfDate=" + trfDate + ", transferNo=" + transferNo
				+ ", sendingLocation=" + sendingLocation + ", sendingCST=" + sendingCST + ", sendingTin=" + sendingTin
				+ ", sendingState=" + sendingState + ", transporter=" + transporter + ", lrNo=" + lrNo + ", lrDate="
				+ lrDate + ", receivingLocation=" + receivingLocation + ", receivingCst=" + receivingCst
				+ ", receivingTin=" + receivingTin + ", receivingState=" + receivingState + ", productCode="
				+ productCode + ", productName=" + productName + ", batch=" + batch + ", division=" + division
				+ ", expiryDate=" + expiryDate + ", mfgDt=" + mfgDt + ", rate=" + rate + ", transferredValue="
				+ transferredValue + ", transferredQty=" + transferredQty + ", grnDate=" + grnDate + ", grnNumber="
				+ grnNumber + ", receivedQty=" + receivedQty + ", receivedValue=" + receivedValue + ", differenceValue="
				+ differenceValue + ", differenceQty=" + differenceQty + ", maxLeadTime=" + maxLeadTime + ", delayDays="
				+ delayDays + ", fFormNo=" + fFormNo + ", fFormDt=" + fFormDt + ", expectedGrnDt=" + expectedGrnDt
				+ ", sendStockPointNm=" + sendStockPointNm + ", receivedStockPointNm=" + receivedStockPointNm + "]";
	}

}
