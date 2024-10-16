package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsp.dto.FINANCIAL_YEAR;

public class Fin_Year {

	 private List<FINANCIAL_YEAR>financial_Years;


		public List<FINANCIAL_YEAR> getFinancialYear()
		{
			 Session session = null;
		        try {
		            session = NewSessionFactory.getSession().openSession();
		            String query = "from FINANCIAL_YEAR order by FIN_YEAR_ID desc";
		            financial_Years = (List<FINANCIAL_YEAR>) session.createQuery(query).list();
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (session != null) {
		                session.close(); 
		            }
		        }
		        return financial_Years;
		       
		}
		
		
	

}
