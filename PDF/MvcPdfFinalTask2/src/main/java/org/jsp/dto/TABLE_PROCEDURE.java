package org.jsp.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "CNDN_PRINT_UIStoreProcedure", query = "{CALL CNDN_PRINT_UI(?,:YEAR_FLAG, :FINID, :COMP_CD, :LOCID, :INVGRP, :PERID, :STOCKPOINTID, :DOC_TYPE)}", callable = true, resultClass = TABLE_PROCEDURE.class) })

public class TABLE_PROCEDURE {

	
	
	
	
	
	
	
	
	@Id
    @Column(name = "ROWNUM")
    private int rownum;

    @Column(name = "INV_GROUP")
    private String invGroup;

    @Column(name = "CUST_NAME")
    private String custName;

    @Column(name = "CN_DATE")
    private String cnDate;

    @Column(name = "CN_NUMBER")
    private String cnNumber;

    @Column(name = "VAL")
    private int val;

    @Column(name = "CN_ID")
    private int cnId;

    
    
    
    
    
	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getInvGroup() {
		return invGroup;
	}

	public void setInvGroup(String invGroup) {
		this.invGroup = invGroup;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCnDate() {
		return cnDate;
	}

	public void setCnDate(String cnDate) {
		this.cnDate = cnDate;
	}

	public String getCnNumber() {
		return cnNumber;
	}

	public void setCnNumber(String cnNumber) {
		this.cnNumber = cnNumber;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getCnId() {
		return cnId;
	}

	public void setCnId(int cnId) {
		this.cnId = cnId;
	}

	@Override
	public String toString() {
		return "TABLE_PROCEDURE [rownum=" + rownum + ", invGroup=" + invGroup + ", custName=" + custName + ", cnDate="
				+ cnDate + ", cnNumber=" + cnNumber + ", val=" + val + ", cnId=" + cnId + "]";
	}


}
