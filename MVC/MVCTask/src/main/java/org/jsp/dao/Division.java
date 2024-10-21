package org.jsp.dao;

import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.PARAMETERS;
import org.springframework.stereotype.Component;

@Component
public class Division {

	public List<PARAMETERS> getDivision()
	{
		Session session=null;
		 List<PARAMETERS>  divisions = null;
		 try {
			session=NewSessionFactory.getSession().openSession();
			String hql=" from PARAMETERS  where PARA_TYPE ='DIV'";
			divisions=(List<PARAMETERS>) session.createQuery(hql).list();
			
			
//			for(PARAMETERS div:divisions)
//				{
//					System.out.println(div);
//				}
			
			
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); 
            }
        }		
		 
		 
		 return divisions;
	}
}
