package org.jsp.dto;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Header {
	public PdfPTable getHeader() throws MalformedURLException, IOException, DocumentException
	{
		PdfPTable table = new PdfPTable(13);
		table.setWidthPercentage(100f);
		table.setSpacingBefore(0f);
		float[] columnWidths = { 8f, 2.5f, 2f, 2.5f, 2.5f, 2f, 2.5f,3f, 3.5f, 2f, 2f, 2.5f, 3f };
		table.setWidths(columnWidths);
		Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);

		Paragraph para = new Paragraph("SINKHAI HEALTHCARE LTD BHIWANDI", headerFont);
		PdfPCell headerCell = new PdfPCell(para);
		headerCell.setColspan(13);
		headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		headerCell.setBorder(PdfPCell.NO_BORDER);
		table.addCell(headerCell);

		headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD, BaseColor.BLACK);
		para = new Paragraph("TAX INVOICE", headerFont);
		headerCell = new PdfPCell(para);
		headerCell.setColspan(13);
		headerCell.setBorder(PdfPCell.NO_BORDER);
		headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(headerCell);

		headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 6, Font.BOLD, BaseColor.BLACK);
//		para = ;
		headerCell = new PdfPCell(new Paragraph("Original/DR,uplicate/Triplicate", headerFont));
		headerCell.setColspan(13);
		headerCell.setBorder(PdfPCell.NO_BORDER);
		headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(headerCell);

//		

		Font tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.BLACK);
		Font tableContent = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);
		PdfPCell cell = new PdfPCell(new Paragraph("SINKHAI HEALTHCARE LTD BHIWANDI", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Place of supply:", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("BHIWANDI", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("GSTIN", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("27AAACZ2364F1ZC", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
		
		
		
		
		Image img = Image.getInstance("C:\\Users\\canncopierservicepvt\\Pictures\\Screenshots\\Screenshot 2024-10-23 173807.png");
		img.scaleToFit(60, 60); 
		cell = new PdfPCell(img);// ----------------------------------->QR code
		cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setRowspan(6);
		cell.setColspan(4);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("GODOWN NO.10,BLDG NO.E4,SHREE ", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("State :", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("MAHARASHTRA", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("DL No:", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("20B 360888", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("ARIHANT COMPLEX,KALHER VILLAGE", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Code :", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("27 ", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("21B 360889", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("TAL.BHIWANDI,-THANE 421302.", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Pan No:", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("AAACZ2364F", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("TEL 9545351684 ", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph(":", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Website : ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("NA", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("IRN NUMBER :", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
//		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(
				new Paragraph("3d9b7b0758b630a6bb5454c5e671849caa2f50ca61d822c4333ef1bd08d043fb", tableContent));
		cell.setColspan(8);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
		cell = new PdfPCell(new Paragraph("", tableContent));
		cell.setColspan(13);
		cell.setBorder(Rectangle.BOTTOM);
		table.addCell(cell);

//		cell = new PdfPCell(new Paragraph("Bill To, BAHETI DISTRIBUTORS", tableContent));
//		cell.setColspan(13);
////		cell.setBorder(Rectangle.BOTTOM);
//		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("Bill To, BAHETI DISTRIBUTORS", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("GST Doc Type:", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("INVOICE - INTRA ST", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Invoice No: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("BWMNI2100001", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Date : ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("07/04/2021", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("C.S.NO.576, H.N.542, ", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Cheque No:", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Delivery No:", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("BWMNI2100001", tableHeaderStyle));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Date : ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("07/04/2021", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("DATE GANPATI BOLE, 1ST FLOOR,", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Bank Name: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Order No: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("NA ", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Date : ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("07/04/2021", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("SOLAPUR CITY DIST.SOLAPURSOLAPUR", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Sales Rep: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Prashant Yakkald", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("LR No:  ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("8077705 ", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Date : ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("07/04/2021", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

//	 

		cell = new PdfPCell(new Paragraph("DATE GANPATI BOLE, 1ST FLOOR,", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(4);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Bank Name: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Order No: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("NA ", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Date : ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("07/04/2021", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("GSTIN:", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("27AATPB4495P1ZT", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("HQ: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("SOLAPUR", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Transporter: ", tableHeaderStyle));
//		cell.setColspan();
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("BATCO ", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Due Date:  ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("08/05/2021", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("Drug Lic No: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setRowspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("20B/381839 ", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Inv group: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("MAIN", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Destination: ", tableHeaderStyle));
//		cell.setColspan();
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("SOLAPUR ", tableContent));
		cell.setColspan(4);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		cell = new PdfPCell(new Paragraph("20B/381840", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Pan No: ", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("AATPB4495P", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("State", tableHeaderStyle));
//		cell.setColspan();
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("MAHARASTRA", tableContent));
		cell.setColspan(2);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("Code :", tableHeaderStyle));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		cell = new PdfPCell(new Paragraph("27", tableContent));
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);

		// -------------------------------new
		// row---------------------------------------------------

		tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
		PdfPCell tableHeaderCell = new PdfPCell(new Paragraph("Product Description", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("HSN", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);

		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Mfg", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Batch", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Expiry", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("MRP", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("PTR", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Quantity", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setColspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Rate", tableHeaderStyle));
		tableHeaderCell.setRowspan(2);
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("CGST/SGST", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setColspan(2);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Value", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableHeaderCell.setRowspan(2);
		table.addCell(tableHeaderCell);

		// -------------------------------new
		// row---------------------------------------------------

		tableHeaderCell = new PdfPCell(new Paragraph("Billed", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Free", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("%", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tableHeaderCell);

		tableHeaderCell = new PdfPCell(new Paragraph("Amount", tableHeaderStyle));
		tableHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(tableHeaderCell);

		// -------------------------------new
		// row---------------------------------------------------

	
		
		return table;
	}
}
