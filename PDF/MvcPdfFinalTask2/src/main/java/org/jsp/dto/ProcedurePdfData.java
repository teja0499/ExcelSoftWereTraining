package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

public class ProcedurePdfData {

    @Column(name = "FINID")
    private int finId;

    @Column(name = "LOCID")
    private int locId;

    @Column(name = "FRNUM")
    private String frNum;

    @Column(name = "TONUM")
    private String toNum;

    @Column(name = "TRANTYPE")
    private int tranType;

    @Column(name = "INVTYPE")
    private String invType;

    @Column(name = "STOCKPOINTID")
    private int stockPointId;

    @Column(name = "PERID")
    private int perId;

    // Getters and Setters
  

	@Override
	public String toString() {
		return "ProcedurePdfData [finId=" + finId + ", locId=" + locId + ", frNum=" + frNum + ", toNum=" + toNum
				+ ", tranType=" + tranType + ", invType=" + invType + ", stockPointId=" + stockPointId + ", perId="
				+ perId + "]";
	}

	public ProcedurePdfData(int finId, int locId, String frNum, String toNum, int tranType, String invType,
			int stockPointId, int perId) {
		super();
		this.finId = finId;
		this.locId = locId;
		this.frNum = frNum;
		this.toNum = toNum;
		this.tranType = tranType;
		this.invType = invType;
		this.stockPointId = stockPointId;
		this.perId = perId;
	}

	public int getFinId() {
		return finId;
	}

	public void setFinId(int finId) {
		this.finId = finId;
	}

	public int getLocId() {
		return locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public String getFrNum() {
		return frNum;
	}

	public void setFrNum(String frNum) {
		this.frNum = frNum;
	}

	public String getToNum() {
		return toNum;
	}

	public void setToNum(String toNum) {
		this.toNum = toNum;
	}

	public int getTranType() {
		return tranType;
	}

	public void setTranType(int tranType) {
		this.tranType = tranType;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public int getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(int stockPointId) {
		this.stockPointId = stockPointId;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}
    
}

