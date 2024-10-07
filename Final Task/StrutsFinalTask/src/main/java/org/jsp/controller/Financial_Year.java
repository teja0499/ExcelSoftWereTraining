package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.jsp.NewSessionFactory;
import org.jsp.dto.FINANCIAL_YEAR;



public class Financial_Year {
 List<FINANCIAL_YEAR>financial_Years;
////
//	public void getFinancial_Years() {
//		for(FINANCIAL_YEAR year:financial_Years)
//		{
//			year.setSTART_DT(formatDate(year.getSTART_DT().substring(0,10)) );
//			year.setEND_DT(formatDate(year.getEND_DT().substring(0,10)) );
//			System.out.println(year.getSTART_DT()+"  "+year.getEND_DT());
//		}
//		return financial_Years;
//	}
//
	public String getFinancialYear()
	{
		 Session session = null;
	        try {
	            session = NewSessionFactory.getSession().openSession();
	            String query = "from FINANCIAL_YEAR";
	            financial_Years = (List<FINANCIAL_YEAR>) session.createQuery(query).list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close(); 
	            }
	        }
	        return "success";
	}
}
////	public String formatDate(String date) {
////		StringBuffer str=new StringBuffer(date);
////		String a=str.reverse().toString().replace('-', '/');
////		System.out.println(a);
////		return a;
////	}
////	
//	
//}
