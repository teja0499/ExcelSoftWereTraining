package org.jsp.controller;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsp.NewSessionFactory;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PROCEDURE;

public class Procedure {

	private List<PROCEDURE> procedures;
	private List<FINANCIAL_YEAR> financial_YEAR;

	public List<PROCEDURE> doProcedure(String YEAR_FLAG, String FINID, String COMP_CD, String LOCID,
			String SEND_STOCKPOINTID, String RECV_LOCID, String RECV_STOCKPOINTID, String DIVID, String PRODID,
			String ST_DT, String EN_DT, String REPTYPE) {
		
		 String printStatement = String.format("Parameters:\n" +
		            "YEAR_FLAG: %s\n" +
		            "FINID: %s\n" +
		            "COMP_CD: %s\n" +
		            "LOCID: %s\n" +
		            "SEND_STOCKPOINTID: %s\n" +
		            "RECV_LOCID: %s\n" +
		            "RECV_STOCKPOINTID: %s\n" +
		            "DIVID: %s\n" +
		            "PRODID: %s\n" +
		            "ST_DT: %s\n" +
		            "EN_DT: %s\n" +
		            "REPTYPE: %s",
		            YEAR_FLAG, FINID, COMP_CD, LOCID, 
		            SEND_STOCKPOINTID, RECV_LOCID, RECV_STOCKPOINTID, 
		            DIVID, PRODID, ST_DT, EN_DT, REPTYPE);
		    
		    System.out.println(printStatement);
		    
		    
		    
		    
		Session session = null;
		Transaction transaction = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			Query query=session.getNamedQuery("STOCK_TRANSFER_RECO_STATStoreProcedure");
			 query.setParameter("YEAR_FLAG", YEAR_FLAG);
			 query.setParameter("FINID", FINID); 
			 query.setParameter("COMP_CD", COMP_CD);
			 query.setParameter("LOCID", LOCID);
			query.setParameter("SEND_STOCKPOINTID", SEND_STOCKPOINTID);
			query.setParameter("RECV_LOCID", RECV_LOCID); 
			query.setParameter("RECV_STOCKPOINTID", RECV_STOCKPOINTID);
			query.setParameter("DIVID", DIVID);
			query.setParameter("PRODID", PRODID);
			query.setParameter("ST_DT", ST_DT);
			 query.setParameter("EN_DT", EN_DT); 
			 query.setParameter("REPTYPE", REPTYPE);
			 procedures=query.list();
//			 System.out.println(procedures);

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

	public String getCurrentFinancialYear(int financialYear) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			transaction = session.beginTransaction();

			String query = " from FINANCIAL_YEAR where FIN_YEAR_CLOSED='N'";
			financial_YEAR = (List<FINANCIAL_YEAR>) session.createQuery(query).list();
//			System.out.println(financial_YEAR);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

//		for(int i=0;i<financial_YEAR.size();i++)
		for (FINANCIAL_YEAR fy : financial_YEAR) {
			if (financialYear == fy.getFIN_YEAR_ID()) {
				return "CURRENT";
			}
		}

		return "PREVIOUS";
	}
}
