//package org.jsp.dao;
//
//import java.text.DecimalFormat;
//import java.util.List;
//
//import org.jsp.dto.PDF_PROCEDURE;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//
//public class Header {
//	
//	public void getHeader()
//	{
//		mainCell = new PdfPCell();
//		mainCell.setMinimumHeight(availableHeight);
//		mainCell.setPadding(0f);
//		mainCell.setBorder(Rectangle.NO_BORDER);
//
//		containerTable = new PdfPTable(1);
//		containerTable.setWidthPercentage(100f);
//		containerTable.setSpacingBefore(0f);
//
//		containerCell = new PdfPCell();
//		containerCell.setPadding(0f);
//
//		PdfPTable headerTable = new PdfPTable(15);
//		headerTable.setWidthPercentage(100f);
//		headerTable.setSpacingBefore(0f);
//
//		PdfPCell headerCell = new PdfPCell(new Paragraph(procedure.getBillingName(), tableHeaderStyle));
//		headerCell.setColspan(15);
//		headerCell.setBorder(Rectangle.NO_BORDER); 
//		headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//		headerTable.addCell(headerCell);
//
//		String[] tableHeaders = { "Product Description", "HSN Code", "Batch", "Expiry", "MRP", "Quantity",
//				"Actual rate", "Rate Used", "Rate Differnce", "CGST", "SGST", "Goods Value", "Billed", "Free",
//				"%", "Amount", "%", "Amount" };
//		float[] tableHeaderWidths = { 7f, 2.4f, 2.4f, 2f, 2f, 2f, 1.6f, 2f, 2f, 2.5f, 1.4f, 2.4f, 1.4f, 2.4f,
//				2.2f };
//		headerTable.setWidths(tableHeaderWidths);
//
//		tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getBillingName(), tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Original/Duplicate/Triplicate", tableHeaderStyle));
//		headerCell.setColspan(4);
//		headerCell.setRowspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("GSTIN:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocGstin(), tableContent));
//		headerCell.setColspan(3);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("------", tableHeaderStyle));
//		headerCell.setColspan(4);
//		headerCell.setRowspan(6);
//		headerCell.setBorder(Rectangle.BOTTOM);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocAddr1(), tableContent));
//		headerCell.setColspan(6);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("D.L. No:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocDlic1(), tableContent));
//		headerCell.setColspan(3);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getAddr2(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Place of supply:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocDestination(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocDlic2(), tableContent));
//		headerCell.setColspan(3);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getAddr3(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("State:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocState() + "", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("PAN No.", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getStmPanno(), tableContent));
//		headerCell.setColspan(3);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("-", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("State Code:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLocStateCd(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Website", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("NA", tableContent));
//		headerCell.setColspan(3);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("IRN NO:", tableHeaderStyle));
//		headerCell.setBorder(Rectangle.BOTTOM);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getIrnNumber(), tableContent));
//		headerCell.setColspan(10);
//		headerCell.setBorder(Rectangle.BOTTOM);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("To,", tableContent));
//		headerCell.setColspan(15);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCustName(), tableContent));
//		headerCell.setColspan(7);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("C.N. No.", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCnNumber(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Date :", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCnDate(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getAddr1(), tableContent));
//		headerCell.setColspan(7);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Customer Ref.", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getRefNo(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Date :", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getRefDate(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getAddr2(), tableContent));
//		headerCell.setColspan(7);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("L.R. No.", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLrNum(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Date :", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getLrDate(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getAddr3(), tableContent));
//		headerCell.setColspan(7);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Due Date:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getDueDate(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getAddr4(), tableContent));
//		headerCell.setColspan(3);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Sales Rep:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("DUMMY MSR", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Transporter:", tableHeaderStyle));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getTransporter(), tableContent));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("GSTIN :", tableHeaderStyle));
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCuGstin(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("HQ", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Dummy HQ", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Destination", tableHeaderStyle));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCuDestination(), tableContent));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Drug Lic Nos:", tableHeaderStyle));
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getDrugLic1(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("Invoicing Group:", tableHeaderStyle));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getDivision(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("State", tableHeaderStyle));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCuState(), tableContent));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getDrugLic2(), tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("", tableContent));
//		headerCell.setColspan(2);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph("State Code", tableHeaderStyle));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		headerCell = new PdfPCell(new Paragraph(procedure.getCuStateCd(), tableContent));
//		headerCell.setColspan(4);
//		headerCell.setBorder(Rectangle.NO_BORDER);
//		headerCell.setPadding(5);
//		headerTable.addCell(headerCell);
//
//		tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.BLACK);
//
//		for (int i = 0; i < tableHeaders.length; i++) {
//			headerCell = new PdfPCell(new Paragraph(tableHeaders[i], tableHeaderStyle));
//
//			headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//			if (i == 5 || i == 9 || i == 10) {
//				headerCell.setColspan(2);
//			}
//
//			if (i != 5 && i != 9 && i != 10 && i <= 11) {
//
//				headerCell.setRowspan(2);
//				System.out.println(tableHeaders[i] + " = " + i);
//			}
//			headerCell.setPadding(5);
//			headerTable.addCell(headerCell);
//		}
//
//		
//		
//		
//	}
//	
//}
