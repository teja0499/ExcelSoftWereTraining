package org.jsp.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PARAMETERS;
import org.jsp.dto.PDF_PROCEDURE;
import org.jsp.dto.PERIOD_MASTER;
import org.jsp.dto.ProcedureOneData;
import org.jsp.dto.ProcedurePdfData;
import org.jsp.dto.STOCKPOINT_MST;
import org.jsp.dto.TABLE_PROCEDURE;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import oracle.net.aso.p;

@Component
public class OnLoadData {

	List<FINANCIAL_YEAR> years;

	public List<DEPOT_MASTER> getBranches() {

		List<DEPOT_MASTER> locations = new ArrayList();
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String hql = "from DEPOT_MASTER where ISACTIVE='Y' order by LOC_NAME asc";
			locations = (List<DEPOT_MASTER>) session.createQuery(hql).list();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return locations;
	}

	public List<FINANCIAL_YEAR> getFinancialYear() {
		years = new ArrayList();
		;
		Session session = null;

		try {

			session = NewSessionFactory.getSession().openSession();
			String query = "from FINANCIAL_YEAR order by FIN_YEAR_ID desc";
			years = (List<FINANCIAL_YEAR>) session.createQuery(query).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return years;
	}

	public List<STOCKPOINT_MST> getStockPoint(int location) {
		List<STOCKPOINT_MST> stockpoint = new ArrayList<STOCKPOINT_MST>();
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String query = "from STOCKPOINT_MST  where LOC_ID= " + location;
			stockpoint = (List<STOCKPOINT_MST>) session.createQuery(query).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return stockpoint;
	}

	public String isCurentFinacialYear(int financialYear) {

		Session session = null;
		Transaction transaction = null;
		List<FINANCIAL_YEAR> financial_Years = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			transaction = session.beginTransaction();

			String query = " from FINANCIAL_YEAR where FIN_YEAR_CLOSED='N'";
			financial_Years = (List<FINANCIAL_YEAR>) session.createQuery(query).list();
			System.out.println("isCurentFinacialYear = " + financialYear);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		for (FINANCIAL_YEAR fy : financial_Years) {
			if (financialYear == fy.getFinYearId()) {
				return "CURRENT";
			}
		}

		return "PREVIOUS";
	}

	public List<PERIOD_MASTER> getPeriod(int yearId) {
		List<PERIOD_MASTER> period = new ArrayList();
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String query = "from PERIOD_MASTER where finYearId = " + yearId + "order by periodId asc";
			period = (List<PERIOD_MASTER>) session.createQuery(query).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		for (PERIOD_MASTER p : period) {
			System.out.println(p);
		}
		return period;
	}

	public List<TABLE_PROCEDURE> getTableData(ProcedureOneData data) {
		Session session;
		List<TABLE_PROCEDURE> procedures = new ArrayList<TABLE_PROCEDURE>();
		String isCurentYear = isCurentFinacialYear(data.getFinId());
		System.out.println("Parameter YEAR_FLAG: " + isCurentYear);
		System.out.println("Parameter FINID: " + data.getFinId());
		System.out.println("Parameter COMP_CD: SNK");
		System.out.println("Parameter LOCID: " + data.getLocId());
		System.out.println("Parameter INVGRP: " + data.getInvGrp());
		System.out.println("Parameter PERID: " + data.getPerId());
		System.out.println("Parameter STOCKPOINTID: " + data.getStockPointId());
		System.out.println("Parameter DOC_TYPE: " + data.getDocType());
		
		try {
			System.out.println("Start procedure one");
			session = NewSessionFactory.getSession().openSession();
			Query query = session.getNamedQuery("CNDN_PRINT_UIStoreProcedure");
			query.setParameter("YEAR_FLAG", isCurentYear);
			query.setParameter("FINID", data.getFinId());
			query.setParameter("COMP_CD", "SNK");
			query.setParameter("LOCID", data.getLocId());
			query.setParameter("INVGRP", data.getInvGrp());
			query.setParameter("PERID", data.getPerId());
			query.setParameter("STOCKPOINTID", data.getStockPointId());
			query.setParameter("DOC_TYPE", data.getDocType());
		
			procedures = query.list();
			
			System.out.println("Complete procedure one");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		
		for(TABLE_PROCEDURE tb:procedures)
		{
			System.out.println(tb);
		}
		return procedures;
	}
	
	
	
	public List<PDF_PROCEDURE> getPDFData(ProcedurePdfData data)
	{
		
		Session session;
		List<PDF_PROCEDURE> procedures = new ArrayList();
		String isCurentYear = isCurentFinacialYear(data.getFinId());
		
		
		try {
			
//			  YEAR_FLAG := 'PREVIOUS';
//			  COMPCD := 'SNK';
//			  FINID := '15';
//			  LOCID := '11';
//			  FRNUM := 'SZFGC2100044';
//			  TONUM := 'SZFGC2100061';
//			  TRANTYPE := '12';
//			  INVTYPE := 'CR';
//			  STOCKPOINTID := '11';
//			  PERID := '9';
			
			System.out.println("Start procedure pdf");
			session = NewSessionFactory.getSession().openSession();
//			query = "CALL CNDN_PRINT_VIEW_GST(    , :STOCKPOINTID, :PERID)",
			Query query = session.getNamedQuery("CNDN_PRINT_VIEW_GSTStoreProcedure");
			query.setParameter("YEAR_FLAG", isCurentYear);
			query.setParameter("COMP_CD", "SNK");
			query.setParameter("FINID", data.getFinId());
			query.setParameter("LOCID", data.getLocId());
			query.setParameter("FRNUM", data.getFrNum());
			query.setParameter("TONUM", data.getToNum());
			query.setParameter("TRANTYPE", data.getTranType());
			query.setParameter("INVTYPE", data.getInvType()); 
			query.setParameter("STOCKPOINTID", data.getStockPointId());
			query.setParameter("PERID", data.getPerId());

			
		
			procedures = query.list();
			
			System.out.println("Complete procedure pdf");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		
		for(PDF_PROCEDURE tb:procedures)
		{
			System.out.println(tb);
		}
		return procedures;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void test() {
		System.out.println("data");
	}

}















