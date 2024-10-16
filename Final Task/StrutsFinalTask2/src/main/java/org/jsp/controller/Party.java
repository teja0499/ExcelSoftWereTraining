package org.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jsp.dto.CUSTOMER_MASTER;

public class Party {
    
    List<Object[]> resultList = null; 
    private int locId;
    private List<CUSTOMER_MASTER> customerList = new ArrayList<>(); 

    public List<CUSTOMER_MASTER> getCustomerList() {
        return customerList; 
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getParty() {
        Session session = null;

        try {
            session = NewSessionFactory.getSession().openSession();

            String hql = "select cm.custId, cm.custName from CUSTOMER_MASTER cm "
                    + "where cm.locId = :locId and cm.stockPointId = :stockPointId "
                    + "and cm.companyCd = :companyCd "
                    + "and cm.custId in (select ca.custId from CUSTOMER_ALLOCATION ca where ca.companyCd = :companyCdSubquery) "
                    + "order by cm.custName asc";

            Query query = session.createQuery(hql);

            query.setParameter("locId", locId);
            query.setParameter("stockPointId", locId);
            query.setParameter("companyCd", "SNK");
            query.setParameter("companyCdSubquery", "SNK");

            resultList = query.list();


            for (Object[] row : resultList) {
                long custId = (Long) row[0]; 
                String custName = (String) row[1];


                
                CUSTOMER_MASTER customer = new CUSTOMER_MASTER();
                customer.setCustId(custId);
                customer.setCustName(custName);
                customer.setLocId(locId); 
                customer.setStockPointId(locId); 
                customerList.add(customer);
            }

            for (CUSTOMER_MASTER customer : customerList) {
                System.out.println(customer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); 
            }
        }

        return "success";
    }
}
