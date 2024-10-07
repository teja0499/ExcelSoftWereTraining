package org.jsp.controller;

import java.util.List;
import org.hibernate.Session;
import org.jsp.NewSessionFactory;
import org.jsp.dto.DEPOT_MASTER;
import org.jsp.dto.FINANCIAL_YEAR;

public class SendingLocation {
    private List<DEPOT_MASTER> masters;
    
    private List<FINANCIAL_YEAR>financial_Years;

  
    public List<DEPOT_MASTER> getMasters() {
//    	 System.out.println(masters);
        return masters;
    }
    
    
    
	public List<FINANCIAL_YEAR> getFinancial_Years() {
//		for(FINANCIAL_YEAR year:financial_Years)
//		{
////			year.setSTART_DT(formatDate(year.getSTART_DT().substring(0,10)) );
////			year.setEND_DT(formatDate(year.getEND_DT().substring(0,10)) );
//			System.out.println(year.getSTART_DT()+"  "+year.getEND_DT());
//		
//		}
		return financial_Years;
	}



	
//	public List<FINANCIAL_YEAR> getFinancialYear()
//	{
//		 Session session = null;
//	        try {
//	            session = NewSessionFactory.getSession().openSession();
//	            String query = "from FINANCIAL_YEAR";
//	            financial_Years = (List<FINANCIAL_YEAR>) session.createQuery(query).list();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        } finally {
//	            if (session != null) {
//	                session.close(); 
//	            }
//	        }
//	        return financial_Years;
//	}
	
	
	

 

	public List<DEPOT_MASTER> getSendingLocationData() {
	    Session session = null;
	    try {
	        session = NewSessionFactory.getSession().openSession();
	        String query = "from DEPOT_MASTER where CURR_STATUS='A'";
	        masters = (List<DEPOT_MASTER>) session.createQuery(query).list();
	        
	        String fquery = "from FINANCIAL_YEAR order by FIN_YEAR_ID desc";
	        financial_Years = (List<FINANCIAL_YEAR>) session.createQuery(fquery).list();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close(); 
	        }
	    }
	    return masters;
	}



    public String getSendingLocation() {
        masters = getSendingLocationData(); 
//        if (masters == null || masters.isEmpty()) {
//        } else {
//            for (DEPOT_MASTER master : masters) {
////                System.out.println(master.toString());
//            }
//        }
        return "success";
    }

    
    public String formatDate(String date) {
		String []a=date.split("-");
		String newDate="";
		
//			newDate=a[2]+'/'+a[1]+'/'+a[0];
			return a[2]+'/'+a[1]+'/'+a[0];
//		System.out.println(newDate);
//		return date;
		
	}
	




}


