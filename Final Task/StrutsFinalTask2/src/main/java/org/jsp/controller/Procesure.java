package org.jsp.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PROCEDURE;

public class Procesure {

	public List<PROCEDURE> doProcedure(int financial_year, int branch, int division, String reportType, int slab11,
			int slab12, int slab21, int slab22, int slab31, int slab32, int slab41, int slab42, int slab51, int slab52,
			int slab61, int stockPoint, int party, String invoice, String endDate, int state ,String igDiv) {
		Session session = null;
		Transaction transaction = null;
		List<PROCEDURE> procedures = null;

		String isCurentYear = isCurentFinacialYear(financial_year);

		System.out.println("YEAR_FLAG: " + isCurentYear);
		System.out.println("FINYR: " + financial_year);
		System.out.println("COMP_CD: ICP");
		System.out.println("LOCID: " + branch);
		System.out.println("ENDT: " + endDate);
		System.out.println("REPTYPE: D");
		System.out.println("DIVID: " + division);
		System.out.println("DOCTYPE: DUE");
		System.out.println("CUSTID: " + party);
		System.out.println("SLB1A: " + slab11);
		System.out.println("SLB1B: " + slab12);
		System.out.println("SLB2A: " + slab21);
		System.out.println("SLB2B: " + slab22);
		System.out.println("SLB3A: " + slab31);
		System.out.println("SLB3B: " + slab32);
		System.out.println("SLB4A: " + slab41);
		System.out.println("SLB4B: " + slab42);
		System.out.println("SLB5A: " + slab51);
		System.out.println("SLB5B: " + slab52);
		System.out.println("SLB6: " + (slab61 - 1));
		System.out.println("STOCKPOINTID: " + stockPoint);
		System.out.println("EXCLUDE_DEACTIVE_CUST: null");
		System.out.println("EXCLUDE_DEACTIVE_LOC: null");
		System.out.println("IGDIV: "+igDiv);
		System.out.println("STATEID: " + state);

		System.out.println("isCurentYear = " + isCurentYear);
		try {
			session = NewSessionFactory.getSession().openSession();
			Query query = session.getNamedQuery("PARTYWISE_OS_SPECIFICDATEStoreProcedure");
			query.setParameter("YEAR_FLAG", isCurentYear);
			query.setParameter("FINYR", financial_year);
			query.setParameter("COMP_CD", "SNK");
			query.setParameter("LOCID", branch);
			query.setParameter("ENDT", "2022-12-31");
			query.setParameter("REPTYPE", "D");
			query.setParameter("DIVID", division);
			query.setParameter("DOCTYPE", "DUE");
			query.setParameter("CUSTID", party);
			query.setParameter("SLB1A", slab11);
			query.setParameter("SLB1B", slab12);
			query.setParameter("SLB2A", slab21);
			query.setParameter("SLB2B", slab22);
			query.setParameter("SLB3A", slab31);
			query.setParameter("SLB3B", slab32);
			query.setParameter("SLB4A", slab41);
			query.setParameter("SLB4B", slab42);
			query.setParameter("SLB5A", slab51);
			query.setParameter("SLB5B", slab52);
			query.setParameter("SLB6", slab61 - 1);
			query.setParameter("STOCKPOINTID", stockPoint);
			query.setParameter("EXCLUDE_DEACTIVE_CUST", null);
			query.setParameter("EXCLUDE_DEACTIVE_LOC", null);
			query.setParameter("IGDIV", igDiv);
			query.setParameter("STATEID", state);

			procedures = query.list();
			
			int i=0;
			
		
			
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
		for(PROCEDURE procedure:procedures)
		{
			System.out.println(procedure);
			procedure.setTranDate(formatDate(procedure.getTranDate()));
			procedure.setDueDate(formatDate(procedure.getDueDate()));
			procedure.setLrDate(formatDate(procedure.getLrDate()));
		}
		return procedures;

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
	
	public String formatDate(String date)
	{
		if(date==null)return date;
		String []dt=date.substring(0,10).split("-");
		String finalDate=dt[2]+"/"+dt[1]+"/"+dt[0];
		System.out.println(finalDate);
		
		return finalDate;
	}

}

//YEAR_FLAG := 'PREVIOUS';
//FINYR := 16;
//COMP_CD := 'SNK';
//LOCID := '10';
//ENDT := '2022-12-31';
//REPTYPE := 'D';
//DIVID := '0';
//DOCTYPE := 'DUE';
//CUSTID := '0';
//SLB1A := 1;
//SLB1B := 30;
//SLB2A := 31;
//SLB2B := 60;
//SLB3A := 61;
//SLB3B := 90;
//SLB4A := 91;
//SLB4B := 180;
//SLB5A := 181;
//SLB5B := 360;
//SLB6 := 361;
//STOCKPOINTID := '0';
//EXCLUDE_DEACTIVE_CUST := 'N';
//EXCLUDE_DEACTIVE_LOC  := 'N';
//EXCLUDE_DEACTIVE_LOC := 'N';
//STATEID := 0;
