package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.jsp.NewSessionFactory;
import org.jsp.dto.STOCKPOINT_MST;

public class ReceivingStockPoint {

	
	
	private int LOC_ID;
	private List<STOCKPOINT_MST>msts;
	
	
	
	
    public List<STOCKPOINT_MST> getMsts() {
		return msts;
	}


	public void setMsts(List<STOCKPOINT_MST> msts) {
		this.msts = msts;
	}


	public int getLOC_ID() {
		return LOC_ID;
	}


	public void setLOC_ID(int LOC_ID) {
		this.LOC_ID = LOC_ID;
	}


	public String getReceivingStockPoint() {
		msts=getReceivingStockPointData();
		return "success";
	}
	
	
	
	
	public List<STOCKPOINT_MST> getReceivingStockPointData() {
        Session session = null;
        try {
//        	System.out.println(LOC_ID);
            session = NewSessionFactory.getSession().openSession();
//            System.out.println(1);
            String query = "from STOCKPOINT_MST  where LOC_ID= " +LOC_ID;
            msts = (List<STOCKPOINT_MST>) session.createQuery(query).list();
//            System.out.println(msts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); 
            }
        }
        return msts;
    }
	
	

}
