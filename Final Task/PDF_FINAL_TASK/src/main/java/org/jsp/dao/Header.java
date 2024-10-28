package org.jsp.dao;

import java.text.DecimalFormat;
import java.util.List;

import org.jsp.dto.PROCEDURE;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Header {
	
	
	static double pageTotal;
	static double grantTotal;
	 DecimalFormat df = new DecimalFormat("#.00");
	
	
	public PdfPTable header1(PROCEDURE procedure, Font tableHeaderStyle) throws DocumentException
	{
		PdfPTable headerTable = new PdfPTable(3);
		headerTable.setWidthPercentage(100f);
		headerTable.setSpacingBefore(0f);

		float[] columnWidths = { 20f, 15f, 20f };
		headerTable.setWidths(columnWidths);

		PdfPCell headercell = new PdfPCell(new Paragraph(procedure.getsAddr1(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("PROVISIONAL CLAIM", tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("Doc No:"+procedure.getInvNumber(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph(procedure.getsAddr2(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("Saleable", tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("Date : "+procedure.getInvDate(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph(procedure.getsAddr3(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headercell.setColspan(2);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("C.S.T. No:"+procedure.getsCstNo(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph(procedure.getsAddr4(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setColspan(2);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("T.I.N No : not found  ",tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("Tell No :", tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headercell.setColspan(2);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("D.L. No : "+procedure.getsDrugLic1(), tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setPadding(4);
		headerTable.addCell(headercell);


		headercell = new PdfPCell(new Paragraph("", tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setColspan(2);
		headerTable.addCell(headercell);

		headercell = new PdfPCell(new Paragraph("NA", tableHeaderStyle));
		headercell.setBorder(Rectangle.NO_BORDER);
		headercell.setColspan(2);
		headerTable.addCell(headercell);
		
		return headerTable;
	}


	
	public PdfPTable header2(PROCEDURE procedure, Font tableHeaderStyle) throws DocumentException
	{
		PdfPTable headerTable2 = new PdfPTable(3);
		headerTable2.setWidthPercentage(100f);
		headerTable2.setSpacingBefore(0f);
		float[] columnWidths = { 20f, 15f, 20f };
		headerTable2.setWidths(columnWidths);

//		containercell = new PdfPCell();
//		containercell.setPadding(0f);
//		containercell.setMinimumHeight(140);

		PdfPCell headercell2 = new PdfPCell(new Paragraph("To", tableHeaderStyle));
		headercell2.setColspan(3);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headercell2.setPadding(4);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph(procedure.getAddr1(), tableHeaderStyle));
		headercell2.setColspan(2);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("H.Q.   :"+procedure.getHq(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph(procedure.getAddr2(), tableHeaderStyle));
		headercell2.setColspan(2);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("AREA     : "+procedure.getArea(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph(procedure.getAddr3(), tableHeaderStyle));
		headercell2.setColspan(2);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("MSR   :  "+procedure.getMsr(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph(procedure.getAddr4(), tableHeaderStyle));
		headercell2.setColspan(2);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("D.L. No 1: "+procedure.getDrugLic1(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("CUTTACK  not found", tableHeaderStyle));
		headercell2.setColspan(2);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("D.L. No 2: "+procedure.getDrugLic2(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("", tableHeaderStyle));
		headercell2.setColspan(2);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph(" D.L. No 3: "+procedure.getDrugLic3(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("T.I.N. No :"+procedure.getTinNo(),  tableHeaderStyle));
		headercell2.setColspan(3);
		headercell2.setPadding(4);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);

		headercell2 = new PdfPCell(new Paragraph("C.S.T No  : "+procedure.getCmCstNo(), tableHeaderStyle));
		headercell2.setPadding(4);
		headercell2.setColspan(3);
		headercell2.setBorder(Rectangle.NO_BORDER);
		headerTable2.addCell(headercell2);
		
		return headerTable2;
	}


	public int tableBody(List<PROCEDURE> procedures, Font tableHeaderStyle,Font tableContent, PdfPCell containercell, PdfPTable containerTable, int rows, int index) throws DocumentException
	{
		float[] columnBodyWidths = { 7.5f, 2.5f, 2.5f, 1.4f, 1.4f, 1.5f, 1.5f, 2f, 1.3f, 1.3f, 3.5f, 2.5f, 2f };
		PdfPTable tableBody = new PdfPTable(13);
		tableBody.setWidthPercentage(100f);
		tableBody.setSpacingBefore(0f);
		tableBody.setWidths(columnBodyWidths);
		String invNum=procedures.get(index).getInvNumber();

//		int n=0;
		PdfPCell bodyCell = new PdfPCell(
				new Paragraph("Being value of goods returned as per details mentioned below.", tableHeaderStyle));
		bodyCell.setColspan(13);
		bodyCell.setBorder(Rectangle.NO_BORDER);
		bodyCell.setPadding(4);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("L.R No     : "+procedures.get(index).getLrNum(), tableHeaderStyle));
		bodyCell.setColspan(5);
		bodyCell.setBorder(Rectangle.NO_BORDER);
		bodyCell.setPadding(4);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Date      : "+procedures.get(index).getLrDate(), tableHeaderStyle));
		bodyCell.setColspan(8);
		bodyCell.setBorder(Rectangle.NO_BORDER);
		bodyCell.setPadding(4);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("ransporter :" + procedures.get(index).getTransporter(), tableHeaderStyle));
		bodyCell.setColspan(5);
		bodyCell.setBorder(Rectangle.BOTTOM);
		bodyCell.setPadding(4);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Party Ref : "+procedures.get(index).getLetRefNum(), tableHeaderStyle));
		bodyCell.setColspan(3);
		bodyCell.setBorder(Rectangle.BOTTOM);
		bodyCell.setPadding(4);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Date    : "+procedures.get(index).getLetRefDate(), tableHeaderStyle));
		bodyCell.setColspan(5);
		bodyCell.setBorder(Rectangle.BOTTOM);
		bodyCell.setPadding(4);
		tableBody.addCell(bodyCell);
		
		

		bodyCell = new PdfPCell(new Paragraph("Product Desc.", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Expiry Date", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Batch No.", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Sold Qty", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Free Qty", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Sale rate", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("MRP", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Rate Used", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Prod Disc.", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("VAT/C ST%", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Invoice No.", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Invoice date", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);

		bodyCell = new PdfPCell(new Paragraph("Goods  Value", tableContent));
		bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tableBody.addCell(bodyCell);
		
		
		String demo[]= {"CEFO PLUS 100 TABS 10'S ","10/2018","1516010","25.00","5.00","39.86","62.00","33.22","","","NA","","996.50"};
		int i=index;
		int rowIndex=0;
		for(;rowIndex<rows && rowIndex<4 ;rowIndex++,i++)
		{
			
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getProdName(), tableContent));
//				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getExpiryDt(), tableContent));
//				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getBatchNo(), tableContent));
//				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getBilledQty()+"", tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getFreeQty()+"", tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph(setDecimal(procedures.get(i).getRate()), tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				
			
				
				bodyCell = new PdfPCell(new Paragraph(setDecimal( procedures.get(i).getMrp()), tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph(setDecimal(  procedures.get(i).getRateUsed()), tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph("", tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph("", tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getInvNumber(), tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				bodyCell = new PdfPCell(new Paragraph(procedures.get(i).getInvDate(), tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				 
				
				bodyCell = new PdfPCell(new Paragraph(setDecimal(procedures.get(i).getGoodsValue())+"", tableContent));
				bodyCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
				tableBody.addCell(bodyCell);
				
				pageTotal=pageTotal+   Double.parseDouble(procedures.get(i).getGoodsValue()) ;
				
				if(i==procedures.size()-1   || !invNum.equals(procedures.get(i+1).getInvNumber()))
				{
					break;
				}
				
			
		}
		
		if(rowIndex!=15)
		{
			for(int k=rowIndex;k<=15;k++)
			{
				for(int j=0;j<demo.length;j++)
				{
					bodyCell = new PdfPCell(new Paragraph());
					bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
					bodyCell.setMinimumHeight(11f);
					tableBody.addCell(bodyCell);
				}
			}
		}
		containercell.addElement(tableBody);
		containerTable.addCell(containercell);
		return rowIndex;
	}



	public PdfPTable tableFooter(List<PROCEDURE> procedures, Font tableHeaderStyle,Font tableContent , int currentindex ,int size, String invnum) throws DocumentException
	{
		float[] columnFooterWidths = { 50,50 };
		PdfPTable tableFooter= new PdfPTable(2);
		tableFooter.setWidthPercentage(100f);
		tableFooter.setSpacingBefore(0f);
		tableFooter.setWidths(columnFooterWidths);
		
	   Helper helper=new Helper();

		
	   pageTotal= Math.round(pageTotal * 100.0) / 100.0;
	   System.out.println(pageTotal);
		
		PdfPCell footerCell = new PdfPCell(new Paragraph("Rupees : "+ helper.convert(pageTotal) , tableHeaderStyle));
		footerCell.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(footerCell);
		
		footerCell = new PdfPCell(new Paragraph("Total Amount : "+ setDecimal(pageTotal+""), tableHeaderStyle));
		footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		footerCell.setBorder(Rectangle.NO_BORDER);
		tableFooter.addCell(footerCell);
		grantTotal =grantTotal+pageTotal;
		pageTotal=0;
		
		System.out.println("size  = "+size+" currentindex = "+currentindex);
		
		if(size==currentindex+1 || !procedures.get(currentindex+1).getInvNumber().equals(invnum) )
		{
			grantTotal=Math.round(grantTotal * 100.0) / 100.0;
			footerCell = new PdfPCell(new Paragraph("Rupees : "+ helper.convert(grantTotal) , tableHeaderStyle));
			footerCell.setBorder(Rectangle.NO_BORDER);
			tableFooter.addCell(footerCell);
			
			
			 footerCell = new PdfPCell(new Paragraph("Grand Total : "+setDecimal(grantTotal+""), tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerCell.setBorder(Rectangle.NO_BORDER);
			tableFooter.addCell(footerCell);
		}
		
		
			
			
			footerCell = new PdfPCell(new Paragraph(procedures.get(currentindex).getStockPointName(), tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerCell.setColspan(2);
			footerCell.setPaddingTop(15);
			
			tableFooter.addCell(footerCell);
			return tableFooter;
			
		
		
	}


	
	
	public String setDecimal(String dec)
	{
		if(dec==null)return dec;
		if(dec.contains("."))
		{
		int	i=dec.length()-dec.indexOf(".");
		System.out.println(dec +"  "+i+"  "+dec.length()+"   "+dec.indexOf("."));
		if(i==2)return dec +"0";
		return dec;
		}
		
		return dec+".00";
	}








}
