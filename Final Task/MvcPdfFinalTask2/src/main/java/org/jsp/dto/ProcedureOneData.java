package org.jsp.dto;

import javax.persistence.Column;

public class ProcedureOneData {
	

    @Column(name = "FINID")
    private int finId;

    @Column(name = "LOCID")
    private int locId;

    @Column(name = "INVGRP")
    private int invGrp;

    @Column(name = "PERID")
    private int perId;

    @Column(name = "STOCKPOINTID")
    private int stockPointId;

    @Column(name = "DOC_TYPE")
    private String docType;

    
    
    
    
    
    
    
    
    
	public ProcedureOneData(int finId, int locId, int invGrp, int perId, int stockPointId, String docType) {
		super();
		this.finId = finId;
		this.locId = locId;
		this.invGrp = invGrp;
		this.perId = perId;
		this.stockPointId = stockPointId;
		this.docType = docType;
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

	public int getInvGrp() {
		return invGrp;
	}

	public void setInvGrp(int invGrp) {
		this.invGrp = invGrp;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public int getStockPointId() {
		return stockPointId;
	}

	public void setStockPointId(int stockPointId) {
		this.stockPointId = stockPointId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Override
	public String toString() {
		return "ProcedureOneData [finId=" + finId + ", locId=" + locId + ", invGrp=" + invGrp + ", perId=" + perId
				+ ", stockPointId=" + stockPointId + ", docType=" + docType + "]";
	}

	
	
}
