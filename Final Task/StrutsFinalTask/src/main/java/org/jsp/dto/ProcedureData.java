package org.jsp.dto;

public class ProcedureData {

    private String yearFlag;
    private String finId;
    private String compCd;
    private String locId;
    private String sendStockPointId;
    private String recvLocId;
    private String recvStockPointId;
    private String divId;
    private String prodId;
    private String startDate;
    private String endDate;
    private String reportType;
    
    
	public ProcedureData(String yearFlag, String finId, String compCd, String locId, String sendStockPointId,
			String recvLocId, String recvStockPointId, String divId, String prodId, String startDate, String endDate,
			String reportType) {
		this.yearFlag = yearFlag;
		this.finId = finId;
		this.compCd = compCd;
		this.locId = locId;
		this.sendStockPointId = sendStockPointId;
		this.recvLocId = recvLocId;
		this.recvStockPointId = recvStockPointId;
		this.divId = divId;
		this.prodId = prodId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reportType = reportType;
	}
	
	
	public String getYearFlag() {
		return yearFlag;
	}
	public void setYearFlag(String yearFlag) {
		this.yearFlag = yearFlag;
	}
	public String getFinId() {
		return finId;
	}
	public void setFinId(String finId) {
		this.finId = finId;
	}
	public String getCompCd() {
		return compCd;
	}
	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}
	public String getLocId() {
		return locId;
	}
	public void setLocId(String locId) {
		this.locId = locId;
	}
	public String getSendStockPointId() {
		return sendStockPointId;
	}
	public void setSendStockPointId(String sendStockPointId) {
		this.sendStockPointId = sendStockPointId;
	}
	public String getRecvLocId() {
		return recvLocId;
	}
	public void setRecvLocId(String recvLocId) {
		this.recvLocId = recvLocId;
	}
	public String getRecvStockPointId() {
		return recvStockPointId;
	}
	public void setRecvStockPointId(String recvStockPointId) {
		this.recvStockPointId = recvStockPointId;
	}
	public String getDivId() {
		return divId;
	}
	public void setDivId(String divId) {
		this.divId = divId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}


	@Override
	public String toString() {
		return "ProcedureData [yearFlag=" + yearFlag + ", finId=" + finId + ", compCd=" + compCd + ", locId=" + locId
				+ ", sendStockPointId=" + sendStockPointId + ", recvLocId=" + recvLocId + ", recvStockPointId="
				+ recvStockPointId + ", divId=" + divId + ", prodId=" + prodId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", reportType=" + reportType + "]";
	}
	
	
    
    
}
