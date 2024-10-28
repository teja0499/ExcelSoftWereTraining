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
import org.jsp.dto.ClaimData;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PARAMETERS;
import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;
import org.jsp.dto.STOCKPOINT_MST;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import java.util.List;

@Service
public class OnLoadData {

	List<FINANCIAL_YEAR> years;

	public List<DEPOT_MASTER> getLocation() {

		List<DEPOT_MASTER> locations = new ArrayList();
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String hql = "from DEPOT_MASTER order by loc_name";
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

	public List<PARAMETERS> getInvoiceGrp() {

		Session session = null;
		List<PARAMETERS> InvoiceGrp = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String hql = " from PARAMETERS where PARA_TYPE='IVG'";
			InvoiceGrp = (List<PARAMETERS>) session.createQuery(hql).list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return InvoiceGrp;

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

	public List<Object[]> getClaim(ClaimData claimData) {
		Session session = null;

//	    FINANCIAL_YEAR finyr=

		List<Object[]> resultList = null;
		try {
			session = NewSessionFactory.getSession().openSession();

			String q = "from FINANCIAL_YEAR where FIN_YEAR_ID =" + claimData.getFinancialYear();
			FINANCIAL_YEAR finyr = (FINANCIAL_YEAR) session.createQuery(q).uniqueResult();

			System.out.println(finyr);

			String sql = "SELECT p1.para_descr, c2.cust_name, c1.inv_number, c1.inv_date, c1.invoice_value "
					+ "FROM RET_CLAIM_HEADER_ARC c1, CUSTOMER_MASTER c2, PARAMETERS p1 "
					+ "WHERE c1.COMPANY_CD = 'SNK' " + "AND c1.loc_id = :location "
					+ "AND c1.STOCK_POINT_ID = :stockPoint " + "AND c1.inv_type = :claimType "
					+ "AND c1.CANCELLED != 'Y' " + "AND c1.FIN_YEAR_ID = :financialYear "
					+ "AND c1.INV_GROUP = :invoice " + "AND c1.cust_id = c2.cust_id " + "AND c1.INV_GROUP = p1.para_id "
					+ "ORDER BY c1.inv_number";

//	        
//	        String sql = "SELECT p1.para_descr, c2.cust_name, c1.inv_number, c1.inv_date, c1.invoice_value " +
//                    "FROM RET_CLAIM_HEADER_ARC c1, CUSTOMER_MASTER c2, PARAMETERS p1 " +
//                    "WHERE c1.COMPANY_CD='SNK' AND c1.loc_id=21 AND c1.STOCK_POINT_ID=21 " +
//                    "AND c1.inv_type='SA' AND c1.CANCELLED != 'Y' AND c1.FIN_YEAR_ID=15 " +
//                    "AND c1.INV_GROUP=471 AND c1.cust_id=c2.cust_id AND c1.INV_GROUP=p1.para_id " +
//                    "ORDER BY c1.inv_number";

			// Create a native query
			Query query = session.createSQLQuery(sql);
			query.setParameter("location", claimData.getLocation());
			query.setParameter("stockPoint", claimData.getStockPoint());
			query.setParameter("claimType", claimData.getClaimType());
			query.setParameter("financialYear", claimData.getFinancialYear());
			query.setParameter("invoice", claimData.getInvoice());

			 
			 resultList = claimDataFormat(query.list(), finyr);
			// Iterate over results

//	        for (Object[] row : resultList) {
//	            System.out.println(Arrays.toString(row));
//	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return resultList;
	}

	public List<Object[]> claimDataFormat(List<Object[]> data, FINANCIAL_YEAR finyr) {
//		String startDate = 
//        String endDate = finyr.getEndDt();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		LocalDateTime startDate = LocalDateTime.parse(finyr.getStartDt(), formatter);
		LocalDateTime endDate = LocalDateTime.parse(finyr.getEndDt(), formatter);

		System.out.println("startDate = " + startDate);
		System.out.println("endDate = " + endDate);

		List<Object[]> finalList=new ArrayList<Object[]>();
		for (Object[] row : data) {
			String invDate = (String) row[3].toString();
			LocalDateTime objDate = LocalDateTime.parse(invDate, formatter);

			if ((objDate.isEqual(startDate) || objDate.isAfter(startDate))
					&& (objDate.isEqual(endDate) || objDate.isBefore(endDate))) {
				finalList.add(row);

			}
		}
		
		return finalList;
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
			System.out.println("isCurentFinacialYear = "+ financialYear);
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
	
	
	
	
	
	public List<PROCEDURE> getProdureData(ProcedureData data)
	{
		
		Session session = null;
		Transaction transaction = null;
		List<PROCEDURE> procedures = null;

		String isCurentYear = isCurentFinacialYear(data.getFinancialYear());
		
		try {
			session = NewSessionFactory.getSession().openSession();
			Query query = session.getNamedQuery("RET_CLM_PRINTStoreProcedure");
			query.setParameter("YEAR_FLAG", isCurentYear);
			query.setParameter("FINID", data.getFinancialYear());
			query.setParameter("COMP_CD", "SNK");
			query.setParameter("LOCID", data.getLocation());
			query.setParameter("STOCKPOINTID", data.getStockPoint());
			query.setParameter("START_NUM", data.getFromClaimNo());
			query.setParameter("END_NUM", data.getToClaimNo());
			query.setParameter("INVTYPE", data.getClaimType());
			query.setParameter("INVGRP", data.getInvoiceGrp());

			procedures = query.list();
			
			
		for(PROCEDURE p:procedures)
		{
			System.out.println(p);
//			break;
		}
			
			 System.out.println("Procedure size = " +procedures.size());
			 

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
//			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return procedures;
		
	}
	
	
	
	
	
	

}
