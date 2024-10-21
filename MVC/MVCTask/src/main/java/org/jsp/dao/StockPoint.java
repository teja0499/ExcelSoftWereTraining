package org.jsp.dao;

import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.STOCKPOINT_MST;
import org.springframework.stereotype.Component;

@Component
public class StockPoint {
	List<STOCKPOINT_MST> stockpoint;

	public List<STOCKPOINT_MST> getStockPoint(int branchId) {
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			String query = "from STOCKPOINT_MST  where LOC_ID= " + branchId;
			stockpoint = (List<STOCKPOINT_MST>) session.createQuery(query).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return stockpoint;
	}

}
