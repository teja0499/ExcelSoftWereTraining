//package org.jsp.dao;
//
//import java.io.FileOutputStream;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//public class abx {
//	public void PDF() {
//		System.out.println("Start");
//		Document document = new Document();
//		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
//		String timestamp = dateTimeFormat.format(new Date());
//
//		String path = "C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\";
//		String finalPath = path + timestamp + ".pdf";
//
//		try {
//			System.out.println("try block");
//			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(finalPath));
//			document.setMargins(15f, 15f, 10f, 15f); // Set margins for the document
//			document.open();
//
//			Font tableHeaderStyle = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
//			Font tableContent = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
//
//			PdfPTable mainTable = new PdfPTable(1);
//			mainTable.setWidthPercentage(100f);
//			mainTable.setSpacingBefore(0f);
//
//			float fullPageHeight = document.getPageSize().getHeight();
//			float marginTop = document.topMargin();
//			float marginBottom = document.bottomMargin();
//			float availableHeight = fullPageHeight - marginTop - marginBottom;
//
//			PdfPCell mainCell = new PdfPCell();
//			mainCell.setPadding(0f);
//			mainCell.setBorder(Rectangle.NO_BORDER);
//			
//			mainCell.setMinimumHeight(availableHeight);
//
//			PdfPTable containerTable = new PdfPTable(1);
//			containerTable.setWidthPercentage(100f);
//			containerTable.setSpacingBefore(0f);
//
//			PdfPCell containercell = new PdfPCell();
//			containercell.setPadding(5f);
//			Paragraph paragraph = new Paragraph("SINKHAI HEALTHCARE LTD BHIWANDI", tableHeaderStyle);
//			paragraph.setAlignment(Element.ALIGN_CENTER);
//			containercell.addElement(paragraph);
//			containercell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			containerTable.addCell(containercell);
//
//			containercell = new PdfPCell();
//			containercell.setPadding(0f);
//			containercell.setMinimumHeight(140);
//
//			tableHeaderStyle = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
//			
////			PdfPTable headerTable = new PdfPTable(3);
////			headerTable.setWidthPercentage(100f);
////			headerTable.setSpacingBefore(0f);
////
////			float[] columnWidths = { 20f, 15f, 20f };
////			headerTable.setWidths(columnWidths);
////
////			PdfPCell headercell = new PdfPCell(new Paragraph("PLOT NO:39/8713,", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("PROVISIONAL CLAIM", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("Doc No:21MNR1800077", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("KHATA NO:663/3,GURUKHETRA,", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("Saleable", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("Date :12/04/2018", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("GURUKHETRA,KALIABODA,SIKHARPUR", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headercell.setColspan(2);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("C.S.T. No:21843001056", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("TEL 0671-2442191", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setColspan(2);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("T.I.N No :21843001056", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("Tell No :", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headercell.setColspan(2);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("T.I.N No :21843001056", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("Tell No. ", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setPadding(4);
////			headercell.setColspan(3);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setColspan(2);
////			headerTable.addCell(headercell);
////
////			headercell = new PdfPCell(new Paragraph("NA", tableHeaderStyle));
////			headercell.setBorder(Rectangle.NO_BORDER);
////			headercell.setColspan(2);
////			headerTable.addCell(headercell);
//			Header head=new Header();
//			
//			PdfPTable headerTable = head.header1(tableHeaderStyle);
//
//			containercell.addElement(headerTable);
//			containerTable.addCell(containercell);
//			
//			
//			
//			containercell = new PdfPCell();
//			containercell.setPadding(0f);
//			containercell.setMinimumHeight(140);
//
////			PdfPTable headerTable2 = new PdfPTable(3);
////			headerTable2.setWidthPercentage(100f);
////			headerTable2.setSpacingBefore(0f);
////			headerTable2.setWidths(columnWidths);
////
////			containercell = new PdfPCell();
////			containercell.setPadding(0f);
////			containercell.setMinimumHeight(140);
////
////			PdfPCell headercell2 = new PdfPCell(new Paragraph("To", tableHeaderStyle));
////			headercell2.setColspan(3);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headercell2.setPadding(4);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("AGARAWAL PHARMACEUTICALS", tableHeaderStyle));
////			headercell2.setColspan(2);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("H.Q.    : VIGREKS SUGAR FREE", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("PRESS CHHACK, MADHUPATNA,", tableHeaderStyle));
////			headercell2.setColspan(2);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("AREA     :  VIGREKS SUGAR FREE", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("CUTTACK-753010, ODISHA", tableHeaderStyle));
////			headercell2.setColspan(2);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("SR      :  VIGREKS SUGAR FREE", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("INDIA", tableHeaderStyle));
////			headercell2.setColspan(2);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("D.L. No 1: 20B/CU/5292/W", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("CUTTACK", tableHeaderStyle));
////			headercell2.setColspan(2);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("D.L. No 2: 21B/CU/5293/WC", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("", tableHeaderStyle));
////			headercell2.setColspan(2);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph(" D.L. No 3: NA", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("T.I.N. No :21771200241V", tableHeaderStyle));
////			headercell2.setColspan(3);
////			headercell2.setPadding(4);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////
////			headercell2 = new PdfPCell(new Paragraph("C.S.T No  :21843001056", tableHeaderStyle));
////			headercell2.setPadding(4);
////			headercell2.setColspan(3);
////			headercell2.setBorder(Rectangle.NO_BORDER);
////			headerTable2.addCell(headercell2);
////		
//			
//			PdfPTable headerTable2 = head.header2(tableHeaderStyle);
//			
//			containercell.addElement(headerTable2);
//			containerTable.addCell(containercell);
//
////			float[] columnBodyWidths = { 7.5f, 2f, 2f, 1.5f, 1.5f, 1.5f, 2f, 2f, 1.5f, 1.5f, 3f, 2.5f, 2f };
////			PdfPTable tableBody = new PdfPTable(13);
////			tableBody.setWidthPercentage(100f);
////			tableBody.setSpacingBefore(0f);
////			tableBody.setWidths(columnBodyWidths);
////
////			containercell = new PdfPCell();
////			containercell.setPadding(0f);
////			containercell.setMinimumHeight(250);
////
////			PdfPCell bodyCell = new PdfPCell(
////					new Paragraph("Being value of goods returned as per details mentioned below.", tableHeaderStyle));
////			bodyCell.setColspan(13);
////			bodyCell.setBorder(Rectangle.NO_BORDER);
////			bodyCell.setPadding(4);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("L.R No     :HAND DELIVERY", tableHeaderStyle));
////			bodyCell.setColspan(5);
////			bodyCell.setBorder(Rectangle.NO_BORDER);
////			bodyCell.setPadding(4);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Date      :12/04/2018", tableHeaderStyle));
////			bodyCell.setColspan(8);
////			bodyCell.setBorder(Rectangle.NO_BORDER);
////			bodyCell.setPadding(4);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("ransporter : HAND DELIVERY", tableHeaderStyle));
////			bodyCell.setColspan(5);
////			bodyCell.setBorder(Rectangle.BOTTOM);
////			bodyCell.setPadding(4);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Party Ref : 177", tableHeaderStyle));
////			bodyCell.setColspan(3);
////			bodyCell.setBorder(Rectangle.BOTTOM);
////			bodyCell.setPadding(4);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Date    : 16/03/2018", tableHeaderStyle));
////			bodyCell.setColspan(5);
////			bodyCell.setBorder(Rectangle.BOTTOM);
////			bodyCell.setPadding(4);
////			tableBody.addCell(bodyCell);
////			
////			
////
////			bodyCell = new PdfPCell(new Paragraph("Product Desc.", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Expiry Date", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Batch No.", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Sold Qty", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Free Qty", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Sale rate", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("MRP", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Rate Used", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Prod Disc.", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("VAT/C ST%", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Invoice No.", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Invoice date", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////
////			bodyCell = new PdfPCell(new Paragraph("Goods  Value", tableContent));
////			bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////			bodyCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
////			tableBody.addCell(bodyCell);
////			
////			
////			String demo[]= {"CEFO PLUS 100 TABS 10'S ","10/2018","1516010","25.00","5.00","39.86","62.00","33.22","","","NA","","996.50"};
////			
////			for(int i=0;i<5;i++)
////			{
////				for(int j=0;j<demo.length;j++)
////				{
////					bodyCell = new PdfPCell(new Paragraph(demo[j], tableContent));
////					bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////					bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
////					tableBody.addCell(bodyCell);
////				}
////			}
////			
////			for(int i=0;i<12;i++)
////			{
////				for(int j=0;j<demo.length;j++)
////				{
////					bodyCell = new PdfPCell(new Paragraph());
////					bodyCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////					bodyCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
////					bodyCell.setMinimumHeight(11f);
////					tableBody.addCell(bodyCell);
////				}
////			}
//			
//			
//			containercell = new PdfPCell();
//			containercell.setPadding(0f);
//			containercell.setMinimumHeight(250);
//			
//			
//			PdfPTable tableBody = head.tableBody(tableHeaderStyle, tableContent);
//			
//			
//
//			containercell.addElement(tableBody);
//			containerTable.addCell(containercell);
//			
//			
//			
//			
////			float[] columnFooterWidths = { 50,50 };
////			PdfPTable tableFooter= new PdfPTable(2);
////			tableFooter.setWidthPercentage(100f);
////			tableFooter.setSpacingBefore(0f);
////			tableFooter.setWidths(columnFooterWidths);
////
////			containercell = new PdfPCell();
////			containercell.setPadding(0f);
////			containercell.setMinimumHeight(220);
////			containercell.setBorder(Rectangle.NO_BORDER);
////			containercell.setVerticalAlignment(Element.ALIGN_BOTTOM);
////			
////			
////			PdfPCell footerCell = new PdfPCell(new Paragraph("Rupees :  Five Thousand Four Hundred and Nineteen only", tableHeaderStyle));
////			footerCell.setBorder(Rectangle.NO_BORDER);
////			tableFooter.addCell(footerCell);
////			
////			footerCell = new PdfPCell(new Paragraph("Total Amount :5419.28", tableHeaderStyle));
////			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
////			footerCell.setBorder(Rectangle.NO_BORDER);
////			tableFooter.addCell(footerCell);
////			
////			
////			 footerCell = new PdfPCell(new Paragraph("Rupees :  Five Thousand Four Hundred and Nineteen only", tableHeaderStyle));
////			footerCell.setBorder(Rectangle.NO_BORDER);
////			tableFooter.addCell(footerCell);
////			
////			
////			 footerCell = new PdfPCell(new Paragraph("Grand Total :5419.28", tableHeaderStyle));
////			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
////			footerCell.setBorder(Rectangle.NO_BORDER);
////			tableFooter.addCell(footerCell);
////			
////			
////			 footerCell = new PdfPCell(new Paragraph("Grand Total :5419.28", tableHeaderStyle));
////				footerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
////				footerCell.setBorder(Rectangle.NO_BORDER);
////				footerCell.setColspan(2);
////				
////				
////				footerCell = new PdfPCell(new Paragraph(" SINKHAI HEALTHCARE LTD CUTTACK", tableHeaderStyle));
////				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
////				footerCell.setBorder(Rectangle.NO_BORDER);
////				footerCell.setColspan(2);
////				footerCell.setPaddingTop(15);
////				
////				tableFooter.addCell(footerCell);
//			
//			containercell = new PdfPCell();
//			containercell.setPadding(0f);
//			containercell.setMinimumHeight(220);
//			containercell.setBorder(Rectangle.NO_BORDER);
//			containercell.setVerticalAlignment(Element.ALIGN_BOTTOM);
//				
//			
//			PdfPTable tableFooter=head.tableFooter(tableHeaderStyle, tableContent);
//			
//			containercell.addElement(tableFooter);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			containerTable.addCell(containercell);
//
//			mainCell.addElement(containerTable);
//
//			mainTable.addCell(mainCell);
//			document.add(mainTable);
//			document.close();
//			writer.close();
//			System.out.println("PDF generation complete: " + finalPath);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//			e.printStackTrace();
//		}
//	}
//}
