package org.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.DEPOT_MASTER;
import org.springframework.stereotype.Component;

@Component
public class Branch {

	
	public List<DEPOT_MASTER> getBranches()
	{
		List<DEPOT_MASTER> branches = new ArrayList();
		Session session = null;
		try {
			session=NewSessionFactory.getSession().openSession();
			String hql="from DEPOT_MASTER order by loc_name";
			branches= (List<DEPOT_MASTER>) session.createQuery(hql).list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return branches;
	}
}
