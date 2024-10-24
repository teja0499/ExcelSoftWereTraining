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

import oracle.net.aso.h;

public class test {
	public void pdf(int n) throws MalformedURLException, IOException {
		System.out.println("Start");
		Document document = new Document();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date())+"test";

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
			float fullPageHeight = document.getPageSize().getHeight();
			float marginTop = document.topMargin();
			float marginBottom = document.bottomMargin();
			float availableHeight = fullPageHeight - marginTop - marginBottom;
			mainCell.setPadding(0f);
			mainCell.setMinimumHeight(availableHeight);
			mainTable.setWidthPercentage(100f);
			mainTable.setSpacingBefore(0f);
			PdfPTable containerTable = new PdfPTable(1);
			PdfPCell containercell = new PdfPCell();
			Font tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.BLACK);
			Font tableContent = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);
			containerTable.setWidthPercentage(100f);
			containerTable.setSpacingBefore(0f);
			containercell.setPadding(0f);
			containercell.setMinimumHeight(532);
			Header header = new Header();

			for (int i = 0; n>=0; i++) {
				if (i != 0) {
					document.newPage();
					mainCell = new PdfPCell();
					mainCell.setPadding(0f);
					mainCell.setMinimumHeight(availableHeight);
					containerTable = new PdfPTable(1);
					containercell = new PdfPCell();
					containerTable.setWidthPercentage(100f);
					containerTable.setSpacingBefore(0f);
					containercell.setPadding(0f);
					containercell.setMinimumHeight(532);
				}
				PdfPTable table = header.getHeader();
				PdfPCell tabledata = new PdfPCell(new Paragraph("Division :MAIN", tableHeaderStyle));
				tabledata.setColspan(13);
				tabledata.setBorder(Rectangle.NO_BORDER);
				table.addCell(tabledata);
				
				

				for (int j = 0; j < 12 && j < n; j++) {

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

				// -------------------------------new
				// row---------------------------------------------------

				tabledata = new PdfPCell(new Paragraph("Division Total", tableHeaderStyle));
				tabledata.setColspan(12);
				tabledata.setBorder(Rectangle.NO_BORDER);
				table.addCell(tabledata);

				tabledata = new PdfPCell(new Paragraph("42724.00", tableHeaderStyle));

				tabledata.setHorizontalAlignment(Element.ALIGN_RIGHT);
				tabledata.setBorder(Rectangle.NO_BORDER);
				table.addCell(tabledata);

				containercell.addElement(table);
				containerTable.addCell(containercell);

				containercell = new PdfPCell();
				containercell.setPadding(0f);

				// footer table
				// ---------------------------------------------------------------------------------------------------------
				Footer footer = new Footer();

				PdfPTable footerTable = footer.getFooter(tableHeaderStyle, tableContent);
				containercell.addElement(footerTable);
				containerTable.addCell(containercell);
				mainCell.addElement(containerTable);

				mainTable.addCell(mainCell);
				n=n-12;

			}

			// -------------------------------new
			// row---------------------------------------------------

//-------------------------------new
//row---------------------------------------------------

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
