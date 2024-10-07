package org.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DEPOT_MASTER {
	@Id
	private int LOC_ID ;
	private String LOC_NAME ;
	private String ISACTIVE;
	private String CURR_STATUS;
	

	@Override
	public String toString() {
		return "DEPOT_MASTER [LOC_ID=" + LOC_ID + ", LOC_NAME=" + LOC_NAME + ", ISACTIVE=" + ISACTIVE + "]";
	}
	public int getLOC_ID() {
		return LOC_ID;
	}
	public void setLOC_ID(int lOC_ID) {
		LOC_ID = lOC_ID;
	}
	public String getLOC_NAME() {
		return LOC_NAME;
	}
	public void setLOC_NAME(String lOC_NAME) {
		LOC_NAME = lOC_NAME;
	}
	public String getISACTIVE() {
		return ISACTIVE;
	}
	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}
	public String getCURR_STATUS() {
		return CURR_STATUS;
	}
	public void setCURR_STATUS(String cURR_STATUS) {
		CURR_STATUS = cURR_STATUS;
	}
	
}
