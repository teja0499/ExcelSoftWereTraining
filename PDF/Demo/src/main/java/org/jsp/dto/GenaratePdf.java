package org.jsp.dto;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenaratePdf {
	public void pdf() throws MalformedURLException, IOException {
		System.out.println("Start");
		Document document = new Document();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date());

		String path = "C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\";
		String finalPath = path + timestamp + ".pdf";
		try {
			System.out.println("try block");
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(finalPath));
			document.setMargins(15f, 15f, 10f, 15f); // Set margins for the document
			document.open();

			// Create the main table (parent table)
			PdfPTable mainTable = new PdfPTable(1);
			PdfPCell mainCell = new PdfPCell();
			
			
			PdfPTable containerTable = new PdfPTable(1);
			PdfPCell containercell = new PdfPCell();
//			containercell.setMinimumHeight(600);
			
			containerTable.setWidthPercentage(100f);
			containerTable.setSpacingBefore(0f);

			
			
			mainCell.setPadding(0f);
			containercell.setPadding(0f);
			containercell.setMinimumHeight(520);
			 float fullPageHeight = document.getPageSize().getHeight();
	            float marginTop = document.topMargin();
	            float marginBottom = document.bottomMargin();
	            float availableHeight = fullPageHeight - marginTop - marginBottom;
	            System.out.println(availableHeight);
			mainCell.setMinimumHeight(availableHeight);
			mainTable.setWidthPercentage(100f);
			mainTable.setSpacingBefore(0f);

			// Create a nested table with 13 columns
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
//			para = ;
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
//            cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
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
//			cell.setColspan(2);
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

//			cell = new PdfPCell(new Paragraph("Bill To, BAHETI DISTRIBUTORS", tableContent));
//			cell.setColspan(13);
////			cell.setBorder(Rectangle.BOTTOM);
//			table.addCell(cell);

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
//			cell.setColspan();
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
//			cell.setColspan();
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
//			cell.setColspan();
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

			PdfPCell tabledata = new PdfPCell(new Paragraph("Division :MAIN", tableHeaderStyle));
			tabledata.setColspan(13);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			// -------------------------------new
			// row---------------------------------------------------
			
			for(int i=0;i<6;i++) {

			tabledata = new PdfPCell(new Paragraph("CEFO L 200", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("30042019 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("170 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("B00131 ", tableContent));
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("11-2022  ", tableContent));
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("137.50 ", tableContent));
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("98.22 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("100 ", tableContent));
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("0 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("88.40 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("12.00 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("484.64 ", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("8840.00", tableContent));
			tabledata.setBorder(Rectangle.NO_BORDER);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(tabledata);

			// -------------------------------new
			// row---------------------------------------------------

			tabledata = new PdfPCell(new Paragraph("DISCOUNT - 20%,AMT : 1768 1768.00", tableContent));
			tabledata.setColspan(12);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("1768", tableContent));
			tabledata.setColspan(13);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);
			}


//-------------------------------new
//row---------------------------------------------------

			tabledata = new PdfPCell(new Paragraph("Division Total", tableHeaderStyle));
			tabledata.setColspan(12);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);

			tabledata = new PdfPCell(new Paragraph("42724.00", tableHeaderStyle));
//			tabledata.setColspan(13);
			tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tabledata.setBorder(Rectangle.NO_BORDER);
			table.addCell(tabledata);
			
//			tabledata= new PdfPCell(new Paragraph("", tableHeaderStyle));
//			tabledata.setBorder(Rectangle.NO_BORDER );
//			tabledata.setColspan(13);
//			tabledata.setRowspan(3);
//			tabledata.setMinimumHeight(40f);
//			table.addCell(tabledata);
			
			
			
//			tabledata = new PdfPCell(new Paragraph("", tableHeaderStyle));
//			tabledata.setColspan(13);
//			tabledata.setBorder(Rectangle.BOTTOM);
//			table.addCell(tabledata);
			
			
			containercell.addElement(table);
			containerTable.addCell(containercell);
			
			
			containercell = new PdfPCell();
			containercell.setPadding(0f);
			
//			mainCell.addElement(table);
//-------------------------------new
//row---------------------------------------------------

			// Create custom fonts
			
			
			
			//footer table ---------------------------------------------------------------------------------------------------------
			
//			tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
//			 tableContent = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL, BaseColor.BLACK);
			
			PdfPTable footerTable = new PdfPTable(9);
			footerTable.setWidthPercentage(100f);
			footerTable.setSpacingBefore(0f);
			float[] tableWidths = { 3f,2f,4f,4f,2f,2f,3f, 5f,5f};
			footerTable.setWidths(tableWidths);
			
			
//			PdfPCell tabledata = new PdfPCell(new Paragraph("Division :MAIN", tableHeaderStyle));
//			tabledata.setColspan(13);
//			tabledata.setBorder(Rectangle.NO_BORDER);
//			table.addCell(tabledata);
			
				PdfPCell data= new PdfPCell(new Paragraph("Manufacturing\r\n"
						+ " Locations :", tableHeaderStyle));
				data.setColspan(2);
				data.setRowspan(2);;
				data.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(data);
				
			 data= new PdfPCell(new Paragraph("170-MEDLEY PHARMACEUTICALS LIMITED - DAMAN, - ,170-MEDLEY\r\n"
			 		+ "PHARMACEUTICALS LIMITED - DAMAN, - ,170-MEDLEY PHARMACEUTICALS\r\n"
			 		+ "LIMITED - DAMAN,", tableContent));
				data.setColspan(5);
				data.setRowspan(2);

				data.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("Total goods Value:", tableHeaderStyle));
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("42724.00", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Product Discount", tableHeaderStyle));
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("-7278.40", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
							
				//new row ----------------------------------------------------------------------------------------------------------------------------
				
				
				data= new PdfPCell(new Paragraph("Tax Type", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("%", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Goods Value", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Taxable Amt", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Tax Amt", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Cess %", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Cess Amt", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerTable.addCell(data);
				
				
				
				//new row ----------------------------------------------------------------------------------------------------------------------------
				
				for(int i=0;i<2;i++) {
				data= new PdfPCell(new Paragraph("SGST", tableContent));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("6.00%", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("42724.00 ", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("35445.60", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				
				
				data= new PdfPCell(new Paragraph("2126.74", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("0.00", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("0.00", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Total Taxable Amt :", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("35445.60", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				}
				for(int i=0;i<7;i++)
				{
					data= new PdfPCell(new Paragraph("", tableContent));
					footerTable.addCell(data);
				}
				
				data= new PdfPCell(new Paragraph("CGST :", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("35445.60", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				tableContent= new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.WHITE);
				for(int i=0;i<27;i++)
				{
					data= new PdfPCell(new Paragraph("T", tableContent));
					footerTable.addCell(data);
				}
				
				tableContent= new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);
				
				data= new PdfPCell(new Paragraph("Rupees in Words :", tableContent));
				data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
				data.setColspan(2);
				
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph(" Thirty Nine Thousand Six Hundred and Ninety Nine Only .", tableContent));
				data.setColspan(5);
				data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableContent));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableContent));
				footerTable.addCell(data);
				

				data= new PdfPCell(new Paragraph("Note :", tableHeaderStyle));
				data.setColspan(2);
				data.setRowspan(2);
				data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableContent));
				data.setColspan(5);
				data.setRowspan(2);
				data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Round Off", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("-0.08", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_LEFT);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Total Invoice Amt :", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("36999.00", tableContent));
				footerTable.addCell(data);
				
				
				

				data= new PdfPCell(new Paragraph("CN Adjusted :", tableHeaderStyle));
				data.setColspan(2);
				data.setRowspan(2);
				data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableContent));
				data.setColspan(5);
				data.setRowspan(2);
				data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph(".", tableContent));
				
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Net Payable Amount :", tableHeaderStyle));
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("36999.00", tableContent));
				data.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(data);
				
				
				
				

				data= new PdfPCell(new Paragraph("No of products: 6 ", tableContent));
				data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
				data.setColspan(2);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("No of cases: 14", tableContent));
				data.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
				data.setColspan(2);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("Bill MRP Value: 66460.00", tableContent));
				data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
				data.setColspan(3);
				footerTable.addCell(data);
				
				

				data= new PdfPCell(new Paragraph("For SINKHAI HEALTHCARE LTD BHIWANDI", tableHeaderStyle));
				data.setColspan(2);
				data.setRowspan(10);
				data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.LEFT);
				footerTable.addCell(data);
				
				
				
				data= new PdfPCell(new Paragraph("Name : Sinkhai Healthcare Limited ", tableHeaderStyle));
				data.setBorder(Rectangle.TOP | Rectangle.LEFT );
				data.setColspan(3);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("Bank : Yes Bank,Andheri East , Mumbai .", tableHeaderStyle));
				data.setBorder(Rectangle.TOP | Rectangle.RIGHT );
				data.setColspan(4);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("IFSC :YESB0000078.", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(3);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("A/c No:007881300003921,", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(4);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(7);
				data.setRowspan(3);
				data.setMinimumHeight(40f);
				footerTable.addCell(data);
				
				
				


				
				
				
				data= new PdfPCell(new Paragraph("Principal Company :", tableHeaderStyle));
				data.setBorder(Rectangle.TOP );
				data.setColspan(3);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("SINKHAI HEALTHCARE LTD.,", tableContent));
				data.setBorder(Rectangle.TOP );
				data.setColspan(4);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(3);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("(A Subsidiary Of Medley)", tableContent));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(4);
				footerTable.addCell(data);
				
				
				
				data= new PdfPCell(new Paragraph("Registered Office Address:", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(3);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("ANDHERIMUMBAI", tableContent));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(4);
				footerTable.addCell(data);
				
				
				data= new PdfPCell(new Paragraph("CIN", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				footerTable.addCell(data);
				
				
				
				data= new PdfPCell(new Paragraph("U24230MH2005PLC151938", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(3);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Telephone", tableHeaderStyle));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(4);
				footerTable.addCell(data);
//				
//				
//				
//				
//				
//				
//				
//				
				data= new PdfPCell(new Paragraph("Website", tableContent));
				data.setBorder(Rectangle.NO_BORDER );
				data.setColspan(7);
				footerTable.addCell(data);
				
				data= new PdfPCell(new Paragraph("Authorized Signatory", tableContent));
				data.setBorder(Rectangle.BOTTOM |Rectangle.RIGHT | Rectangle.LEFT);
				data.setColspan(2);
				data.setHorizontalAlignment(Element.ALIGN_CENTER);
				footerTable.addCell(data);
				
				
				
				
				
				
				
				
				
				
				
				containercell.addElement(footerTable);
				containerTable.addCell(containercell);
			mainCell.addElement(containerTable);
				
			
			

			

			mainTable.addCell(mainCell);

			document.add(mainTable);

			document.close();
			writer.close();
			System.out.println("PDF generation complete: " + finalPath);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Final");
	}
}
