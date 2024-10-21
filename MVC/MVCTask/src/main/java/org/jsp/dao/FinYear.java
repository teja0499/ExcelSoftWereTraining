package org.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.FINANCIAL_YEAR;
import org.springframework.stereotype.Component;

@Component
public class FinYear {

	
	public List<FINANCIAL_YEAR> getFinancialYear()
	{
		List<FINANCIAL_YEAR> years = new ArrayList();;
		Session session=null;
		
		try {
			
			session=NewSessionFactory.getSession().openSession();
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
}
