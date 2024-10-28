package org.jsp.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.catalina.core.ApplicationContext;
import org.jsp.dto.PROCEDURE;
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
public class GennratePdf {
	
//	 private ServletContext servletContext;
//
//	    public GennratePdf(ServletContext servletContext) {
//	        this.servletContext = servletContext;
//	    }


	
	public GennratePdf() {
			// TODO Auto-generated constructor stub
		}



	public String PDF(List<PROCEDURE> procedures) {
		System.out.println("Start");
		Document document = new Document();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date());

//		String path = servletContext.getRealPath("/pdf-files/");
//		 String path = Paths.get("pdf-files").toAbsolutePath().toString();
//        System.out.println("PDF files path: " + path);
//		ServletContext servletContext =new ApplicationContext();
//		 String baseDir = System.getProperty("user.dir");
//	        String path = baseDir + "/pdf-files/";
//	        System.out.println("PDF files path: " + path);
		String path="C:\\Users\\canncopierservicepvt\\Desktop\\Final Task\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\PDF_FINAL_TASK\\pdf_files\\";
		
//		 String path = servletContext.getRealPath("/pdf-files/");
			File directory = new File(path);
			if (!directory.exists()) {
				directory.mkdirs();
			}
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
			mainCell.setPadding(0f);
			mainCell.setBorder(Rectangle.NO_BORDER);

			PdfPTable containerTable = new PdfPTable(1);
			containerTable.setWidthPercentage(100f);
			containerTable.setSpacingBefore(0f);
//			PROCEDURE procedure = null;

			int row = procedures.size();

			String invnum=procedures.get(0).getInvNumber();
			for (int i = 0; i < procedures.size(); i++) {

				if (i != 0) {
					document.newPage();

					mainCell = new PdfPCell();
					mainCell.setPadding(0f);
					mainCell.setBorder(Rectangle.NO_BORDER);
					mainCell.setMinimumHeight(availableHeight);

					containerTable = new PdfPTable(1);
					containerTable.setWidthPercentage(100f);
					containerTable.setSpacingBefore(0f);
				}

				PdfPCell containercell = new PdfPCell();
				containercell.setPadding(5f);
				Paragraph paragraph = new Paragraph(procedures.get(0).getBillingName(), tableHeaderStyle);
				paragraph.setAlignment(Element.ALIGN_CENTER);
				containercell.addElement(paragraph);
				containercell.setHorizontalAlignment(Element.ALIGN_CENTER);
				containerTable.addCell(containercell);

				containercell = new PdfPCell();
				containercell.setPadding(0f);
				containercell.setMinimumHeight(140);

				tableHeaderStyle = new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK);

				Header head = new Header();

				PdfPTable headerTable = head.header1(procedures.get(i), tableHeaderStyle);

				containercell.addElement(headerTable);
				containerTable.addCell(containercell);

				containercell = new PdfPCell();
				containercell.setPadding(0f);
				containercell.setMinimumHeight(140);

				PdfPTable headerTable2 = head.header2(procedures.get(i), tableHeaderStyle);

				containercell.addElement(headerTable2);
				containerTable.addCell(containercell);

				containercell = new PdfPCell();
				containercell.setPadding(0f);
				containercell.setMinimumHeight(250);

				int n = head.tableBody(procedures, tableHeaderStyle, tableContent, containercell, containerTable, row,i);

//				
				i += n;
				row = row - n;

				containercell = new PdfPCell();
				containercell.setPadding(0f);
				containercell.setMinimumHeight(220);
				containercell.setBorder(Rectangle.NO_BORDER);
				containercell.setVerticalAlignment(Element.ALIGN_BOTTOM);

				PdfPTable tableFooter = head.tableFooter(procedures, tableHeaderStyle, tableContent, i,
						procedures.size(),invnum);

				containercell.addElement(tableFooter);

				containerTable.addCell(containercell);

				mainCell.addElement(containerTable);

				mainTable.addCell(mainCell);
//				i++;

			}

			document.add(mainTable);
			document.close();
			writer.close();
			System.out.println("PDF generation complete: " + finalPath);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		
		return timestamp;
	}
}
