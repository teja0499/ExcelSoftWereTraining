package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.PARAMETERS;

public class Division {
	
	
	public List<PARAMETERS> getDivisions() {

		List<PARAMETERS>divisions=null;
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String query = "  from PARAMETERS  where PARA_TYPE='IVG' order by PARA_DESCR asc";
			divisions = (List<PARAMETERS>) session.createQuery(query).list();
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
