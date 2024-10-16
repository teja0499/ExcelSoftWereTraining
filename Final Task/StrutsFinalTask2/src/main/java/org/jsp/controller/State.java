package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.FINANCIAL_YEAR;
import org.jsp.dto.PARAMETERS;

public class State {
	
	
	public List<PARAMETERS> getstate()
	{

		 Session session = null;
		 List<PARAMETERS> states=null;
	        try {
	            session = NewSessionFactory.getSession().openSession();
	            String query = "FROM PARAMETERS WHERE PARA_TYPE= 'STT'";
	            states = (List<PARAMETERS>) session.createQuery(query).list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (session != null) {
	                session.close(); 
	            }
	        }
	        return states;
	}
}
