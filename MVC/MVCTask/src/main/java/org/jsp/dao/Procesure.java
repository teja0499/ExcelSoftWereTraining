package org.jsp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;

public class Procesure {

	public List<PROCEDURE> doProcesure(ProcedureData data) {
		Session session = null;
		Transaction transaction = null;
		List<PROCEDURE> procedures = null;
		String isCurentYear = isCurentFinacialYear(data.getFinYr());
		System.out.println("finYrFlag: " + isCurentYear);
		System.out.println("finYr: " + data.getFinYr());
		System.out.println("compCd: " + "SNK");
		System.out.println("locId: " + data.getLocId());
		System.out.println("stdt: " + data.getStdt());
		System.out.println("endt: " + data.getEndt());
		System.out.println("divId: " + data.getDivId());
		System.out.println("custId: " + data.getCustId());
		System.out.println("detail: " + "N");
		System.out.println("stockPointId: " + data.getStockPointId());
		try {

			session = NewSessionFactory.getSession().openSession();
			Query query = session.getNamedQuery("DISPATCH_REGISTERStoreProcedure");
			query.setParameter("FIN_YR_FLAG", isCurentYear);
			query.setParameter("FINYR", data.getFinYr());
			query.setParameter("COMP_CD", "SNK");
			query.setParameter("LOCID", data.getLocId());
			query.setParameter("STDT", data.getStdt());
			query.setParameter("ENDT", data.getEndt());
			query.setParameter("DIVID", data.getDivId());
			query.setParameter("CUSTID", data.getCustId());
			query.setParameter("DETAIL", 'N');
			query.setParameter("STOCKPOINTID", data.getStockPointId());
			procedures = query.list();
			System.out.println("Procedure size = " + procedures.size());
			
			for(PROCEDURE procedure:procedures)
			{
				System.out.println(procedure);
				break;
			}

			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
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
	
	public String formatDate(String date)
	{
//		if(date==null || data)return date;
//		String []dt=date.substring(0,10).split("-");
//		String finalDate=dt[2]+"/"+dt[1]+"/"+dt[0];
//		System.out.println(finalDate);
//		
		return date;
	}
}
