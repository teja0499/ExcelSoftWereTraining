package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.jsp.dto.STOCKPOINT_MST;

public class StockPoint {

	private int LOC_ID;
	private List<STOCKPOINT_MST> stockpoint_list;

	public List<STOCKPOINT_MST> getStockpoint_list() {
		return stockpoint_list;
	}

	public void setLOC_ID(int lOC_ID) {
		LOC_ID = lOC_ID;
	}

	public String getStockPoint() {
		Session session = null;
		try {
			session = NewSessionFactory.getSession().openSession();
			System.out.println(LOC_ID);
			String query = " from STOCKPOINT_MST where STOCK_POINT_ID=" + LOC_ID;
			stockpoint_list = (List<STOCKPOINT_MST>) session.createQuery(query).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		System.out.println(stockpoint_list);
		return "success";
		
	}

}
