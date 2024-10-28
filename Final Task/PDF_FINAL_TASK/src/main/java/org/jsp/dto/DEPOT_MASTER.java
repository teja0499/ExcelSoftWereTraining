package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DEPOT_MASTER {

    @Id
    @Column(name = "LOC_ID")
    private int locId;

    @Column(name = "LOC_NAME")
    private String locName;

    @Column(name = "ISACTIVE")
    private String isActive;

    @Column(name = "CURR_STATUS")
    private String currStatus;
    
    
    
    public DEPOT_MASTER(int locId, String locName) {
		super();
		this.locId = locId;
		this.locName = locName;
	}

	public DEPOT_MASTER() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DEPOT_MASTER [locId=" + locId + ", locName=" + locName + ", isActive=" + isActive + ", currStatus="
				+ currStatus + "]";
	}

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(String currStatus) {
        this.currStatus = currStatus;
    }
    
}
