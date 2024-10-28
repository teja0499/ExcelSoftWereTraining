package org.jsp.dto;



import javax.persistence.*;
import java.util.Date;

@Entity
public class RET_CLAIM_HEADER_ARC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INV_NUMBER")  // Column name in the table
    private Long inv_number;

    @Column(name = "INV_DATE")  // Assuming it's of type Date
    @Temporal(TemporalType.DATE)
    private Date inv_date;

    @Column(name = "INVOICE_VALUE")
    private Double invoice_value;

    @Column(name = "COMPANY_CD")
    private String COMPANY_CD;

    @Column(name = "LOC_ID")
    private Integer loc_id;

    @Column(name = "STOCK_POINT_ID")
    private Integer STOCK_POINT_ID;

    @Column(name = "INV_TYPE")
    private String inv_type;

    @Column(name = "CANCELLED")
    private String CANCELLED;

    @Column(name = "FIN_YEAR_ID")
    private Integer FIN_YEAR_ID;

    @Column(name = "INV_GROUP")
    private Integer INV_GROUP;

    @Column(name = "CUST_ID")
    private Long cust_id;

	public Long getInv_number() {
		return inv_number;
	}

	public void setInv_number(Long inv_number) {
		this.inv_number = inv_number;
	}

	public Date getInv_date() {
		return inv_date;
	}

	public void setInv_date(Date inv_date) {
		this.inv_date = inv_date;
	}

	public Double getInvoice_value() {
		return invoice_value;
	}

	public void setInvoice_value(Double invoice_value) {
		this.invoice_value = invoice_value;
	}

	public String getCOMPANY_CD() {
		return COMPANY_CD;
	}

	public void setCOMPANY_CD(String cOMPANY_CD) {
		COMPANY_CD = cOMPANY_CD;
	}

	public Integer getLoc_id() {
		return loc_id;
	}

	public void setLoc_id(Integer loc_id) {
		this.loc_id = loc_id;
	}

	public Integer getSTOCK_POINT_ID() {
		return STOCK_POINT_ID;
	}

	public void setSTOCK_POINT_ID(Integer sTOCK_POINT_ID) {
		STOCK_POINT_ID = sTOCK_POINT_ID;
	}

	public String getInv_type() {
		return inv_type;
	}

	public void setInv_type(String inv_type) {
		this.inv_type = inv_type;
	}

	public String getCANCELLED() {
		return CANCELLED;
	}

	public void setCANCELLED(String cANCELLED) {
		CANCELLED = cANCELLED;
	}

	public Integer getFIN_YEAR_ID() {
		return FIN_YEAR_ID;
	}

	public void setFIN_YEAR_ID(Integer fIN_YEAR_ID) {
		FIN_YEAR_ID = fIN_YEAR_ID;
	}

	public Integer getINV_GROUP() {
		return INV_GROUP;
	}

	public void setINV_GROUP(Integer iNV_GROUP) {
		INV_GROUP = iNV_GROUP;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}



   
}