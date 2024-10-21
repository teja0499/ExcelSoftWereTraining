package org.jsp.dto;

public class ProcedureData {
    
    private int finYr;
    private String compCd;
    private int locId;
    private String stdt;
    private String endt;
    private int divId;
    private int custId;
    private String detail;
    private int stockPointId;
    private String locName;

    // Getter and Setter methods
    
    

  

    public int getFinYr() {
        return finYr;
    }

    public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public void setFinYr(int finYr) {
        this.finYr = finYr;
    }

    public String getCompCd() {
        return compCd;
    }

    public void setCompCd(String compCd) {
        this.compCd = compCd;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getStdt() {
        return stdt;
    }

    public void setStdt(String stdt) {
        this.stdt = stdt;
    }

    public String getEndt() {
        return endt;
    }

    public void setEndt(String endt) {
        this.endt = endt;
    }

    public int getDivId() {
        return divId;
    }

    public void setDivId(int divId) {
        this.divId = divId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
	public String toString() {
		return "ProcedureData [finYr=" + finYr + ", compCd=" + compCd + ", locId=" + locId + ", stdt=" + stdt
				+ ", endt=" + endt + ", divId=" + divId + ", custId=" + custId + ", detail=" + detail
				+ ", stockPointId=" + stockPointId + ", locName=" + locName + "]";
	}

	public int getStockPointId() {
        return stockPointId;
    }

    public void setStockPointId(int stockPointId) {
        this.stockPointId = stockPointId;
    }


}
