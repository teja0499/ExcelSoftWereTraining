package org.jsp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	 List<Object[]> resultList = null; 
	public List<Object[]> getCustomer()
	{
		Session session;
		try {
			//destination  custCd deleted
			session=NewSessionFactory.getSession().openSession();
			String hql="select DISTINCT CM.custId, CM.custName, CM.destination,CM.custCd, CM.erpCustCd from CUSTOMER_MASTER CM,CUSTOMER_ALLOCATION CA\r\n"
					+ "WHERE CM.custId=CA.custId AND CM.locId =:locId AND (CM.deleted ='N' OR CM.deleted IS NULL)  ORDER BY CM.custName";
			
			  Query query = session.createQuery(hql);

	            query.setParameter("locId", 10);
	            
	            resultList = query.list();
	
	            
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return resultList;
	}
}
