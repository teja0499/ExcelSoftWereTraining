package org.jsp.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.catalina.core.ApplicationContext;
import org.jsp.dto.PDF_PROCEDURE;
//import org.jsp.dto.PROCEDURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class GenratePdf {
	@Autowired
    private ServletContext servletContext;

	public String genratePdf(List<PDF_PROCEDURE> pdfData) {
		System.out.println("Start");
		Document document = new Document();
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date());

//		String path = "C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\";
		
		
		 String path = servletContext.getRealPath("/pdf_files/");
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
			Font tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
			Font tableContent = new Font(Font.FontFamily.TIMES_ROMAN, 6.5f, Font.NORMAL, BaseColor.BLACK);

			PdfPTable mainTable = new PdfPTable(1);
			mainTable.setWidthPercentage(100f);
			mainTable.setSpacingBefore(0f);

			float fullPageHeight = document.getPageSize().getHeight();
			float marginTop = document.topMargin();
			float marginBottom = document.bottomMargin();
			float availableHeight = fullPageHeight - marginTop - marginBottom;

			PdfPCell mainCell = new PdfPCell();
			PdfPTable containerTable = new PdfPTable(1);
			PdfPCell containerCell = new PdfPCell();

//			for (PDF_PROCEDURE procedure : pdfData) 
			for (int index = 0; index < pdfData.size();) {
				
				float goodsValue =0;  
				float cGST =0;  
				float sGST =0;  
				float roundOff=0;
				
				
				
				PDF_PROCEDURE procedure=pdfData.get(index);
				
				if (index != 0) {
					document.newPage();
				}
				String cnNum=procedure.getCnNumber();
				mainCell = new PdfPCell();
				mainCell.setMinimumHeight(availableHeight);
				mainCell.setPadding(0f);
				mainCell.setBorder(Rectangle.NO_BORDER);

				containerTable = new PdfPTable(1);
				containerTable.setWidthPercentage(100f);
				containerTable.setSpacingBefore(0f);

				containerCell = new PdfPCell();
				containerCell.setPadding(0f);

				PdfPTable headerTable = new PdfPTable(15);
				headerTable.setWidthPercentage(100f);
				headerTable.setSpacingBefore(0f);

				PdfPCell headerCell = new PdfPCell(new Paragraph(procedure.getBillingName(), tableHeaderStyle));
				headerCell.setColspan(15);
				headerCell.setBorder(Rectangle.NO_BORDER); // headerCell.setPadding(5);
				headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				headerTable.addCell(headerCell);

				String[] tableHeaders = { "Product Description", "HSN Code", "Batch", "Expiry", "MRP", "Quantity",
						"Actual rate", "Rate Used", "Rate Differnce", "CGST", "SGST", "Goods Value", "Billed", "Free",
						"%", "Amount", "%", "Amount" };
				float[] tableHeaderWidths = { 7f, 2.4f, 2.4f, 2f, 2f, 2f, 1.6f, 2f, 2f, 2.5f, 1.4f, 2.4f, 1.4f, 2.4f,
						2.2f };
				headerTable.setWidths(tableHeaderWidths);

				tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.BLACK);

				headerCell = new PdfPCell(new Paragraph(procedure.getBillingName(), tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Original/Duplicate/Triplicate", tableHeaderStyle));
				headerCell.setColspan(4);
				headerCell.setRowspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("GSTIN:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLocGstin(), tableContent));
				headerCell.setColspan(3);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				
				
				Image img = Image.getInstance("C:\\Users\\canncopierservicepvt\\Pictures\\Screenshots\\abcd.png");
				img.scaleToFit(60, 60); 
				
				headerCell = new PdfPCell(img);
				headerCell.setColspan(4);
				headerCell.setRowspan(6);
				headerCell.setBorder(Rectangle.BOTTOM);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);
				
				
				
				
				

				headerCell = new PdfPCell(new Paragraph(procedure.getLocAddr1(), tableContent));
				headerCell.setColspan(6);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("D.L. No:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLocDlic1(), tableContent));
				headerCell.setColspan(3);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getAddr2(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Place of supply:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLocDestination(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLocDlic2(), tableContent));
				headerCell.setColspan(3);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getAddr3(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("State:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLocState() + "", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("PAN No.", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getStmPanno(), tableContent));
				headerCell.setColspan(3);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("-", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("State Code:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLocStateCd(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Website", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("NA", tableContent));
				headerCell.setColspan(3);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("IRN NO:", tableHeaderStyle));
				headerCell.setBorder(Rectangle.BOTTOM);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getIrnNumber(), tableContent));
				headerCell.setColspan(10);
				headerCell.setBorder(Rectangle.BOTTOM);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("To,", tableContent));
				headerCell.setColspan(15);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCustName(), tableContent));
				headerCell.setColspan(7);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("C.N. No.", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCnNumber(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Date :", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCnDate(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getAddr1(), tableContent));
				headerCell.setColspan(7);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Customer Ref.", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getRefNo(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Date :", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getRefDate(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getAddr2(), tableContent));
				headerCell.setColspan(7);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("L.R. No.", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLrNum(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Date :", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getLrDate(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getAddr3(), tableContent));
				headerCell.setColspan(7);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Due Date:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getDueDate(), tableContent));
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

				headerCell = new PdfPCell(new Paragraph(procedure.getAddr4(), tableContent));
				headerCell.setColspan(3);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Sales Rep:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("DUMMY MSR", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Transporter:", tableHeaderStyle));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getTransporter(), tableContent));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("GSTIN :", tableHeaderStyle));
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCuGstin(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("HQ", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Dummy HQ", tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Destination", tableHeaderStyle));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCuDestination(), tableContent));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Drug Lic Nos:", tableHeaderStyle));
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getDrugLic1(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Invoicing Group:", tableHeaderStyle));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getDivision(), tableContent));
				headerCell.setColspan(2);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("State", tableHeaderStyle));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCuState(), tableContent));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getDrugLic2(), tableContent));
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

				headerCell = new PdfPCell(new Paragraph("State Code", tableHeaderStyle));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(procedure.getCuStateCd(), tableContent));
				headerCell.setColspan(4);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerCell.setPadding(5);
				headerTable.addCell(headerCell);
				
				for (int i = 0; i < tableHeaders.length; i++) {
					headerCell = new PdfPCell(new Paragraph(tableHeaders[i], tableHeaderStyle));

					headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
					headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

					if (i == 5 || i == 9 || i == 10) {
						headerCell.setColspan(2);
					}

					if (i != 5 && i != 9 && i != 10 && i <= 11) {

						headerCell.setRowspan(2);
//						System.out.println(tableHeaders[i] + " = " + i);
					}
					headerCell.setPadding(5);
					headerTable.addCell(headerCell);
				}
				
				tableHeaderStyle = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.BLACK);

				headerCell = new PdfPCell(new Paragraph("Supply Invoice Number : " + procedure.getSupplyInvNo()
						+ "  Date : " + procedure.getSupplyInvDt(), tableHeaderStyle));
				headerCell.setColspan(15);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph("Division:" + procedure.getDivision(), tableHeaderStyle));
				headerCell.setColspan(15);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerTable.addCell(headerCell);
				int row=0;
				for(;index<pdfData.size() && row<5 && cnNum.equals(pdfData.get(index).getCnNumber()) ;index++)
				{
					procedure=pdfData.get(index);
					if(procedure.getProdName().equals("GOODS VALUE"))
					{
						goodsValue=procedure.getGoodsValue();
					}else if(procedure.getProdName().equals("CGST") )
					{
						cGST=procedure.getGoodsValue();
								
					}
					else if(procedure.getProdName().equals("SGST"))
					{
						sGST=procedure.getGoodsValue();
					}
					else if(procedure.getProdName().equals("Round Off") )
					{
						roundOff=procedure.getGoodsValue();
					}
					else
					{
						row++;
					headerCell = new PdfPCell(new Paragraph(procedure.getProdName(), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(procedure.getHsnCode(), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(procedure.getBatchNo(), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(procedure.getExpiryDt(), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(procedure.getMrp() + "", tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(procedure.getBilledQty() + "", tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(procedure.getFreeQty() + "", tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(
							new Paragraph(String.format("%.2f", procedure.getActualRate()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(setDecimal(procedure.getRate()+""), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(String.format("%.2f", procedure.getRateDiff()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(String.format("%.2f", procedure.getCgstRate()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(new Paragraph(String.format("%.2f", procedure.getCgstAmt()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(
							new Paragraph(String.format("%.2f", procedure.getSgstIgstRate()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(
							new Paragraph(String.format("%.2f", procedure.getSgstIgstAmt()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);

					headerCell = new PdfPCell(
							new Paragraph(String.format("%.2f", procedure.getGoodsValue()), tableContent));
					headerCell.setBorder(Rectangle.NO_BORDER);
					headerCell.setMinimumHeight(15);
					headerTable.addCell(headerCell);
					goodsValue+= procedure.getGoodsValue();
					cGST+=procedure.getCgstAmt();
					sGST+=procedure.getSgstIgstAmt();
					}
				}
				System.out.println(cnNum+"     "+row+"     "+index);
				
				

				headerCell = new PdfPCell(new Paragraph("Division Total", tableHeaderStyle));
				headerCell.setColspan(14);
				headerCell.setBorder(Rectangle.NO_BORDER);
				headerTable.addCell(headerCell);

				headerCell = new PdfPCell(new Paragraph(setDecimal(goodsValue+""), tableHeaderStyle));
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

				footerCell = new PdfPCell(new Paragraph( setDecimal(goodsValue+""), tableHeaderStyle));
				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("CGST", tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(procedure.getCgstRate()+"", tableHeaderStyle));
				footerTable.addCell(footerCell);

				headerCell = new PdfPCell(new Paragraph(setDecimal(""+ goodsValue), tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(""+goodsValue), tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(""+ cGST),tableHeaderStyle));
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

				footerCell = new PdfPCell(new Paragraph("SGST", tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(procedure.getCgstRate()+"", tableHeaderStyle));
				footerTable.addCell(footerCell);

				headerCell = new PdfPCell(new Paragraph(setDecimal(""+ goodsValue), tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(""+goodsValue), tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(""+ sGST),tableHeaderStyle));
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

				footerCell = new PdfPCell(new Paragraph(setDecimal(goodsValue+""), tableHeaderStyle));
				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(footerCell);

				for (int i = 0; i < 7; i++) {
					footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
					footerCell.setMinimumHeight(10f);
					footerTable.addCell(footerCell);
				}

				footerCell = new PdfPCell(new Paragraph("CGST", tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(cGST+""), tableHeaderStyle));
				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(footerCell);

				for (int i = 0; i < 7; i++) {
					footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
					footerCell.setMinimumHeight(10f);
					footerTable.addCell(footerCell);
				}

				footerCell = new PdfPCell(new Paragraph("SGST", tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(sGST+""),tableHeaderStyle));
				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(footerCell);

				for (int i = 0; i < 7; i++) {
					footerCell = new PdfPCell(new Paragraph("", tableHeaderStyle));
					footerCell.setMinimumHeight(10f);
					footerTable.addCell(footerCell);
				}

				footerCell = new PdfPCell(new Paragraph("Round Off", tableHeaderStyle));
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(roundOff+""), tableHeaderStyle));
				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(
						new Paragraph("Rupees in Words :"+Helper.convert(cGST+sGST+roundOff+goodsValue)+" only/-", tableHeaderStyle));
				footerCell.setColspan(7);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("Total CN Amount", tableHeaderStyle));
				footerCell.setRowspan(2);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(setDecimal(""+ (cGST+sGST+roundOff+goodsValue))  , tableHeaderStyle));
				footerCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				footerCell.setRowspan(2);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(
						new Paragraph("Note: Stock Types - S - Saleable Goods, B - Breakage, E - Expiry", tableContent));
				footerCell.setColspan(7);
				footerTable.addCell(footerCell);

				

				footerCell = new PdfPCell(new Paragraph("Principal Company :", tableHeaderStyle));
				footerCell.setColspan(2);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(procedure.getCompanyName(), tableHeaderStyle));
				footerCell.setColspan(5);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);
				
				footerCell = new PdfPCell(new Paragraph(" For "+procedure.getCompanyName(), tableContent));
				footerCell.setRowspan(4);
				footerCell.setColspan(2);
				footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("Registered Office Address:", tableHeaderStyle));
				footerCell.setColspan(2);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(procedure.getCmpAddr(), tableHeaderStyle));
				footerCell.setColspan(5);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("CIN :", tableHeaderStyle));
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph(procedure.getCmpCin(), tableHeaderStyle));
				footerCell.setColspan(3);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("Teleophone :"+procedure.getCmpTel(), tableHeaderStyle));
				footerCell.setColspan(4);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("Website :"+procedure.getCmpWeb(), tableHeaderStyle));
				footerCell.setColspan(7);
				footerCell.setPadding(5);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerTable.addCell(footerCell);

				footerCell = new PdfPCell(new Paragraph("Authorized Signatory", tableHeaderStyle));
				footerCell.setColspan(2);
				footerCell.setBorder(Rectangle.NO_BORDER);
				footerCell.setPadding(5);
				footerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				footerTable.addCell(footerCell);
//				
//				
//				footerCell=  new PdfPCell(new Paragraph(" Principal Company :",tableHeaderStyle));
//				footerCell.setColspan(5);
//				footerCell.setBorder(Rectangle.TOP);
//				footerTable.addCell(footerCell);

				containerCell.addElement(footerTable);

				containerTable.addCell(containerCell);


				

				mainCell.addElement(containerTable);

				mainTable.addCell(mainCell);
				System.out.println(procedure);

			}

			document.add(mainTable);

			document.close();
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}

		System.out.println("pdf created");
		System.out.println(finalPath);
		return timestamp;
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
