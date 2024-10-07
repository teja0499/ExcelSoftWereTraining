package org.jsp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Static {

	 public static String formatDate( String inputDate) throws Exception{
        
//       String inputDate = "2021-04-01";

      
       SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
       Date date = inputFormat.parse(inputDate);

      
       SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
       String formattedDate = outputFormat.format(date);

    return formattedDate+"";
   }
}
