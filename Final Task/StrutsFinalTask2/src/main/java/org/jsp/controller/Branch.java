package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;

import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.STOCKPOINT_MST;

public class Branch {
	
	





	public List<DEPOT_MASTER> getBranch() {

		List<DEPOT_MASTER>masters=null;
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String query = " from DEPOT_MASTER where ISACTIVE='Y' order by LOC_NAME asc";
			masters = (List<DEPOT_MASTER>) session.createQuery(query).list();
			DEPOT_MASTER master=new DEPOT_MASTER(0,"All"); 
			masters.add(0,master);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return masters;
	}
	
	

}
