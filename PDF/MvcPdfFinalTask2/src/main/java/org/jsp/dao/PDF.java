package org.jsp.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.catalina.core.ApplicationContext;
//import org.jsp.dto.PROCEDURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDF {

	public void genratePdf() {
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
			Font tableHeaderStyle = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
			Font tableContent = new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK);

			PdfPTable mainTable = new PdfPTable(1);
			mainTable.setWidthPercentage(100f);
			mainTable.setSpacingBefore(0f);

			float fullPageHeight = document.getPageSize().getHeight();
			float marginTop = document.topMargin();
			float marginBottom = document.bottomMargin();
			float availableHeight = fullPageHeight - marginTop - marginBottom;

			PdfPCell mainCell = new PdfPCell();
			mainCell.setMinimumHeight(availableHeight);
			mainCell.setPadding(0f);
			mainCell.setBorder(Rectangle.NO_BORDER);

			PdfPTable containerTable = new PdfPTable(1);
			containerTable.setWidthPercentage(100f);
			containerTable.setSpacingBefore(0f);

			PdfPCell containerCell = new PdfPCell();
			containerCell.setPadding(0f);

			PdfPTable headerTable = new PdfPTable(15);
			headerTable.setWidthPercentage(100f);
			headerTable.setSpacingBefore(0f);

			PdfPCell headerCell = new PdfPCell(new Paragraph("SINKHAI HEALTHCARE LTD.", tableHeaderStyle));
			headerCell.setColspan(15);
			headerCell.setBorder(Rectangle.NO_BORDER); // headerCell.setPadding(5);
			headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			headerTable.addCell(headerCell);

			String[] tableHeaders = { "Product Description", "HSN Code", "Batch", "Expiry", "MRP", "Quantity",
					"Actual rate", "Rate Used", "Rate Differnce", "CGST", "SGST", "Goods Value", "Billed", "Free ", "%",
					"Amount ", "%", "Amount " };
			float[] tableHeaderWidths = { 7f, 2.4f, 2.4f, 2f, 2f, 2f, 1.6f, 2f, 2f, 2.5f, 1.4f, 2.4f, 1.4f, 2.4f,
					2.2f };
			headerTable.setWidths(tableHeaderWidths);

			tableHeaderStyle = new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.BLACK);

			headerCell = new PdfPCell(new Paragraph("SINKHAI HEALTHCARE LTD.", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Original/Duplicate/Triplicate", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setRowspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" GSTIN:", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("09AAACZ2364F1ZA", tableContent));
			headerCell.setColspan(3);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("------", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setRowspan(6);
			headerCell.setBorder(Rectangle.BOTTOM);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("A-5,SECTOR -59, NOIDA", tableContent));
			headerCell.setColspan(6);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" D.L. No:", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" UP1620B00009", tableContent));
			headerCell.setColspan(3);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("DIST : GAUTAM BUDH NAGAR", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("Place of supply:", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("NOIDA", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" UP1620B00009", tableContent));
			headerCell.setColspan(3);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" UTTAR PRADESH", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" State:", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" UTTAR PRADESH" + " ", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("PAN No.", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("AAACZ2364F", tableContent));
			headerCell.setColspan(3);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("-", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" State Code:", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("09", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("Website", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("NA", tableContent));
			headerCell.setColspan(3);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("IRN NO:", tableContent));
			headerCell.setBorder(Rectangle.BOTTOM);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(
					new Paragraph(" c62fd7e8f795cdd6190f6ea80912db81a06ecda8c046c6a49ea6ddbfeeaf750e", tableContent));
			headerCell.setColspan(10);
			headerCell.setBorder(Rectangle.BOTTOM);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("To,", tableContent));
			headerCell.setColspan(15);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("ALPHA BIOCEUTICALS,", tableContent));
			headerCell.setColspan(7);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("C.N. No.", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("SZFGC2100044", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Date : ", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("07/12/2021", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" NOIDA,GAUTAM BUDH NAGAR", tableContent));
			headerCell.setColspan(7);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Customer Ref.", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("SZFGI2100620", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Date : ", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("07/12/2021", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("NOIDA,GAUTAM BUDH NAGAR", tableContent));
			headerCell.setColspan(7);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" L.R. No. ", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Date : ", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" NOIDA UTTAR PRADESH", tableContent));
			headerCell.setColspan(7);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Due Date: ", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("07/12/2021", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" PIN CODE -201307", tableContent));
			headerCell.setColspan(3);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("Sales Rep: ", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" DUMMY MSR", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Transporter:", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("GSTIN :", tableHeaderStyle));
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" 09ADJPA2675F2ZM", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("HQ", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("Dummy HQ", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Destination", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("NOIDA", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("Drug Lic Nos:", tableHeaderStyle));
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("UP1620B000005", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" Invoicing Group:", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("ZENKARE", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" State", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" UTTAR PRADESH", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("UP1620B000005", tableHeaderStyle));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("", tableContent));
			headerCell.setColspan(2);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph(" State Code", tableHeaderStyle));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("09", tableContent));
			headerCell.setColspan(4);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerCell.setPadding(5);
			headerTable.addCell(headerCell);

			tableHeaderStyle = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK);

			for (int i = 0; i < tableHeaders.length; i++) {
				headerCell = new PdfPCell(new Paragraph(tableHeaders[i], tableHeaderStyle));

				headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

				if (i == 5 || i == 9 || i == 10) {
					headerCell.setColspan(2);
				}

				if (i != 5 && i != 9 && i != 10 && i <= 11) {

					headerCell.setRowspan(2);
					System.out.println(tableHeaders[i] + "  =  " + i);
				}
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);
			}

			headerCell = new PdfPCell(
					new Paragraph(" Supply Invoice Number : SZFGI2100620  Date : 24/11/2021", tableHeaderStyle));
			headerCell.setColspan(15);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("Division: ZENKAR", tableHeaderStyle));
			headerCell.setColspan(15);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerTable.addCell(headerCell);

			String data[] = { "MONTEL LC 30 ML SYRUP ", "30049039 ", "ML-4086 ", "10-2023 ", "67.00 ", "28000 ", "0 ",
					"6.04", " 6.36 ", "0.32", " 6.00", " 537.60", " 6.00 ", "537.60 ", "8960.00" };

			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < data.length; i++) {
					headerCell = new PdfPCell(new Paragraph(data[i], tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);
				}
			}

			headerCell = new PdfPCell(new Paragraph("Division Total", tableHeaderStyle));
			headerCell.setColspan(14);
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerTable.addCell(headerCell);

			headerCell = new PdfPCell(new Paragraph("92829.00", tableHeaderStyle));
			headerCell.setBorder(Rectangle.NO_BORDER);
			headerTable.addCell(headerCell);

			containerCell.addElement(headerTable);
			containerCell.setMinimumHeight(500);

			containerTable.addCell(containerCell);

			containerCell = new PdfPCell();
			containerCell.setPadding(0f);

			PdfPTable footerTable = new PdfPTable(9);
			footerTable.setWidthPercentage(100f);
			footerTable.setSpacingBefore(0f);
			PdfPCell footerCell;
			float[] tableFooterWidths = { 4f, 2.5f, 3f, 3f, 2.5f, 2f, 3f, 5f, 5f };
			footerTable.setWidths(tableFooterWidths);

			String[] footerHeader = { "Tax Type ", "  %  ", " Goods Value ", " Taxable Amt ", "  Tax Amt ", " Cess % ",
					" Cess Amt ", "GOODS VALUE" };
			for (int i = 0; i < footerHeader.length; i++) {
				footerCell = new PdfPCell(new Paragraph(footerHeader[i], tableHeaderStyle));
				footerTable.addCell(footerCell);
			}

			footerCell = new PdfPCell(new Paragraph("27892.00", tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("CGST", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("6%", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("8960.00", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("8960.00", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("537.60", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("0%", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("00", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
			footerCell.setMinimumHeight(10f);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
			footerCell.setMinimumHeight(10f);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("CGST", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("6%", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("8960.00", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("8960.00", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("537.60", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("0%", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("00", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
			footerCell.setMinimumHeight(10f);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
			footerCell.setMinimumHeight(10f);
			footerTable.addCell(footerCell);

			for (int i = 0; i < 7; i++) {
				footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerCell.setMinimumHeight(10f);
				footerTable.addCell(footerCell);
			}

			footerCell = new PdfPCell(new Paragraph(" Taxable Amount", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" 8960.00", tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(footerCell);

			for (int i = 0; i < 7; i++) {
				footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerCell.setMinimumHeight(10f);
				footerTable.addCell(footerCell);
			}

			footerCell = new PdfPCell(new Paragraph("CGST", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" 8960.00", tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(footerCell);

			for (int i = 0; i < 7; i++) {
				footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerCell.setMinimumHeight(10f);
				footerTable.addCell(footerCell);
			}

			footerCell = new PdfPCell(new Paragraph("SGST", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" 8960.00", tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(footerCell);

			for (int i = 0; i < 7; i++) {
				footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
				footerCell.setMinimumHeight(10f);
				footerTable.addCell(footerCell);
			}

			footerCell = new PdfPCell(new Paragraph("Round Off", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("-0.20", tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(
					new Paragraph(" Rupees in Words : Ten Thousand Thirty Five Only", tableHeaderStyle));
			footerCell.setColspan(7);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("Total CN Amount", tableHeaderStyle));
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("10035.00", tableHeaderStyle));
			footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(
					new Paragraph("Note: Stock Types - S - Saleable Goods, B - Breakage, E - Expiry", tableContent));
			footerCell.setColspan(7);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" For SINKHAI HEALTHCARE LTD", tableContent));
			footerCell.setRowspan(5);
			footerCell.setColspan(2);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" Principal Company :", tableHeaderStyle));
			footerCell.setColspan(2);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" SINKHAI HEALTHCARE LTD", tableHeaderStyle));
			footerCell.setColspan(5);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("Registered Office Address:", tableHeaderStyle));
			footerCell.setColspan(2);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("ANDHERI,MUMBAI", tableHeaderStyle));
			footerCell.setColspan(5);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("CIN :", tableHeaderStyle));
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("U24230MH2005PLC151938", tableHeaderStyle));
			footerCell.setColspan(2);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph("Teleophone", tableHeaderStyle));
			footerCell.setColspan(5);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

			footerCell = new PdfPCell(new Paragraph(" Website :", tableHeaderStyle));
			footerCell.setColspan(7);
			footerCell.setPadding(5);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(footerCell);

//			
//			
//			
			footerCell = new PdfPCell(new Paragraph(" Authorized Signatory", tableHeaderStyle));
			footerCell.setColspan(2);
			footerCell.setBorder(Rectangle.NO_BORDER);
			footerCell.setPadding(5);
			footerTable.addCell(footerCell);
//			
//			
//			footerCell=  new PdfPCell(new Paragraph(" Principal Company :",tableHeaderStyle));
//			footerCell.setColspan(5);
//			footerCell.setBorder(Rectangle.TOP);
//			footerTable.addCell(footerCell);

			containerCell.addElement(footerTable);

			containerTable.addCell(containerCell);

			mainCell.addElement(containerTable);

			mainTable.addCell(mainCell);

			document.add(mainTable);

			document.close();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("pdf created");
		System.out.println(finalPath);
	}
}
