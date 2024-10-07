package org.jsp.controller;

import java.util.List;

import org.hibernate.Session;
import org.jsp.NewSessionFactory;
import org.jsp.dto.DEPOT_MASTER;

public class ReceivingLoction {

    private List<DEPOT_MASTER> masters;
    private int LOC_ID;
  
    public int getLOC_ID() {
		return LOC_ID;
	}

	public void setLOC_ID(int LOC_ID) {
		this.LOC_ID = LOC_ID;
	}

	public List<DEPOT_MASTER> getMasters() {
//    	 System.out.println(masters);
        return masters;
    }

    public void setMasters(List<DEPOT_MASTER> masters) {
        this.masters = masters;
    }
    
    public String getReceivingLoction() {
    	masters = getReceivingLoctionData(); 
//    	for (int i = 0; i < masters.size(); i++) {
//    		System.out.println(masters.get(i).toString());
//    	}
    	return "success";
    }

    public List<DEPOT_MASTER> getReceivingLoctionData() {
        Session session = null;
        try {
            session = NewSessionFactory.getSession().openSession();
            String query = "from DEPOT_MASTER where ISACTIVE='Y' and  LOC_ID != "+LOC_ID+"  order by LOC_NAME asc";
            masters = (List<DEPOT_MASTER>) session.createQuery(query).list();
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
