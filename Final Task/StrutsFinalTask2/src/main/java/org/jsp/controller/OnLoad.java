package org.jsp.controller;

import java.util.List;

import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PARAMETERS;

import oracle.net.aso.s;

public class OnLoad {
	 private List<FINANCIAL_YEAR>financial_Years;
	 private List<DEPOT_MASTER>branches;
	 private List<PARAMETERS>divisions;
	 private List<PARAMETERS>states;

	public List<PARAMETERS> getStates() {
		return states;
	}


	public void setStates(List<PARAMETERS> states) {
		this.states = states;
	}


	public void setFinancial_Years(List<FINANCIAL_YEAR> financial_Years) {
		this.financial_Years = financial_Years;
	}


	public void setBranches(List<DEPOT_MASTER> branches) {
		this.branches = branches;
	}


	public void setDivisions(List<PARAMETERS> divisions) {
		this.divisions = divisions;
	}


	public List<PARAMETERS> getDivisions() {
		return divisions;
	}


	public List<FINANCIAL_YEAR> getFinancial_Years() {
		return financial_Years;
	}
	

	public List<DEPOT_MASTER> getBranches() {
		return branches;
	}


	public String getFinancialYear()
	{
		System.out.println("Onload start");
		Fin_Year year=new Fin_Year();
		financial_Years=year.getFinancialYear();
		
		System.out.println("Financial Year");
//		
		Branch branch=new Branch();
		branches=branch.getBranch();
		System.out.println("Branch");
//		System.out.println(branches.get(0));
		
		
//		
		
		Division division=new Division();
		divisions= division.getDivisions();
		System.out.println("division ");
		
		State state=new State();
		states=state.getstate();
		System.out.println("State");
//		for(PARAMETERS s:states)
//		{
//			System.out.println(s);
//		}
		
		 return "success";
	}
	 
	 
}
