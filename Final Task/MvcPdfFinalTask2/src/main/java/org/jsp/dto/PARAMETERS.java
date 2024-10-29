package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETERS")
public class PARAMETERS {
	@Id
	@Column(name="PARA_ID")
	private String paraId;

	@Column(name="PARA_CODE")
	private String paraCode;

	@Column(name="PARA_DESCR")
	private String paraDescr;

	@Column(name="PARA_ID_1")
	private String paraId1;

	@Column(name="TEXT1")
	private String text1;

	@Column(name="TEXT2")
	private String text2;

	@Column(name="TEXT3")
	private String text3;

	@Column(name="TEXT4")
	private String text4;

	@Column(name="MEDICO1")
	private String medico1;

	@Column(name="MEDICO2")
	private String medico2;

	@Column(name="VAL1")
	private String val1;

	@Column(name="PARA_TYPE")
	private String paraType;

	public String getParaId() {
		return paraId;
	}

	public void setParaId(String paraId) {
		this.paraId = paraId;
	}

	public String getParaCode() {
		return paraCode;
	}

	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}

	public String getParaDescr() {
		return paraDescr;
	}

	public void setParaDescr(String paraDescr) {
		this.paraDescr = paraDescr;
	}

	public String getParaId1() {
		return paraId1;
	}

	public void setParaId1(String paraId1) {
		this.paraId1 = paraId1;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public String getText3() {
		return text3;
	}

	public void setText3(String text3) {
		this.text3 = text3;
	}

	public String getText4() {
		return text4;
	}

	public void setText4(String text4) {
		this.text4 = text4;
	}

	public String getMedico1() {
		return medico1;
	}

	public void setMedico1(String medico1) {
		this.medico1 = medico1;
	}

	public String getMedico2() {
		return medico2;
	}

	public void setMedico2(String medico2) {
		this.medico2 = medico2;
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getParaType() {
		return paraType;
	}

	public void setParaType(String paraType) {
		this.paraType = paraType;
	}

	@Override
	public String toString() {
		return "PARAMETERS [paraId=" + paraId + ", paraCode=" + paraCode + ", paraDescr=" + paraDescr + ", paraId1="
				+ paraId1 + ", text1=" + text1 + ", text2=" + text2 + ", text3=" + text3 + ", text4=" + text4
				+ ", medico1=" + medico1 + ", medico2=" + medico2 + ", val1=" + val1 + ", paraType=" + paraType + "]";
	}




}
