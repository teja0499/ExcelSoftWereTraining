package org.jsp.controller;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelSummery {
	private String fileName;
	private List<PROCEDURE> procedures;
	private ProcedureData procedureData;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<PROCEDURE> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<PROCEDURE> procedures) {
		this.procedures = procedures;
	}

	public ProcedureData getProcedureData() {
		return procedureData;
	}

	public void setProcedureData(ProcedureData procedureData) {
		this.procedureData = procedureData;
	}

	public String genrateExcel(List<PROCEDURE> procedures, ProcedureData procedureData) throws ParseException {

		System.out.println("genrateExcel  " + procedures.size());
		System.out.println("Genrate_ExcelFile start");

		String[] Header = { "Date", "Transfer No.", "Sending Location Details", "Transporter", "LR No.", "LR Date",
				"Receiving Location Details", "GRN Date", "GRN No.", "Max Lead Time", "Delay days", "Form No.", "Date",
				"Amount" };

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		CellStyle header = workbook.createCellStyle();

		Font boldFont = workbook.createFont();
		boldFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		boldFont.setFontName("Arial");
		boldFont.setFontHeight((short) 260);
		header.setFont(boldFont);
		header.setAlignment(CellStyle.ALIGN_CENTER);
		header.setVerticalAlignment((short) 1);
		header.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		header.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

//		dateStyle.setAlignment((short) 1);
//		dateStyle.setVerticalAlignment((short) 1);
//
//		borderStyle.setBorderTop(CellStyle.BORDER_THIN);
//		borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
//		borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
//		borderStyle.setBorderRight(CellStyle.BORDER_THIN);

		Row row1 = sheet.createRow(0);
		Cell cellheader1 = row1.createCell(0);
		cellheader1.setCellValue("EXCEL MEDICARE PVT. LTD.");
		cellheader1.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));

		Row row2 = sheet.createRow(1);
		Cell cellheader2 = row2.createCell(0);
		cellheader2.setCellValue(procedures.get(0).getSendingLocation());
		cellheader2.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 13));

		Row row3 = sheet.createRow(2);
		Cell cellheader3 = row3.createCell(0);
		cellheader3.setCellValue("Stock Transfer Reconciliation Register "
				+ (procedureData.getReportType() == "S" ? "Summary" : "Details"));
		cellheader3.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 13));

		Row row4 = sheet.createRow(3);
		Cell cellheader4 = row4.createCell(0);
		cellheader4
				.setCellValue("From " + formatDate(procedureData.getStartDate() + " to " + procedureData.getEndDate()));
		cellheader4.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 13));

		Row row5 = sheet.createRow(4);
		Cell cellheader5 = row5.createCell(0);
		cellheader5.setCellValue("Report Dated " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		cellheader5.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 13));

		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("Arial");
		headerStyle.setFont(font);
		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
		headerStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle.setBorderRight(CellStyle.BORDER_THIN);

		CellStyle cellStyle = workbook.createCellStyle();
		Font font1 = workbook.createFont();
		font1.setFontName("Arial");
		cellStyle.setFont(font1);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);

		CellStyle cellStyle1 = workbook.createCellStyle();
		cellStyle1.setFont(font1);
		cellStyle1.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle1.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle1.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle1.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle1.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle1.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        CellStyle dateCellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
        dateCellStyle.setFont(font1);
        dateCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        dateCellStyle.setBorderTop(CellStyle.BORDER_THIN);
        dateCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        dateCellStyle.setBorderLeft(CellStyle.BORDER_THIN);

		
		

		Row row = sheet.createRow(5);

		for (int i = 0; i < Header.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(Header[i]);
			cell.setCellStyle(headerStyle);
		}

		int i = 5;
		for (PROCEDURE procedure : procedures) {
			row = sheet.createRow(++i);

			Date parsedDate = dateFormat.parse(procedure.getTrfDate());
			Cell cell0 = row.createCell(0);  
			cell0.setCellValue(parsedDate);  
			cell0.setCellStyle(dateCellStyle); 
			

			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(cellStyle);
			cell1.setCellValue(procedure.getTransferNo());

			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(cellStyle);
			cell2.setCellValue(procedure.getSendingLocation());

			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(cellStyle);
			cell3.setCellValue(procedure.getTransporter());

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(cellStyle);
			cell4.setCellValue(procedure.getLrNo());

//			Cell cell5 = row.createCell(5);
//			cell5.setCellStyle(cellStyle);
//			cell5.setCellValue(procedure.getLrDate());
			
			 parsedDate = dateFormat.parse(procedure.getTrfDate());
			Cell cell5 = row.createCell(5);  
			cell5.setCellValue(parsedDate);  
			cell5.setCellStyle(dateCellStyle); 
			
			
			

			Cell cell6 = row.createCell(6);
			cell6.setCellStyle(cellStyle);
			cell6.setCellValue(procedure.getReceivingLocation());

//			Cell cell7 = row.createCell(7);
//			cell7.setCellStyle(cellStyle);
//			cell7.setCellValue(procedure.getGrnDate());
//			System.out.println(procedure.getGrnDate());
			
			
			Cell cell7 = row.createCell(7);  
			 if(procedure.getGrnDate()!=null)
				 {parsedDate = dateFormat.parse(procedure.getGrnDate());
				cell7.setCellValue(parsedDate); 
				cell7.setCellStyle(dateCellStyle); 
				}
			 else 
			 {
				 cell7.setCellStyle(cellStyle);
					cell7.setCellValue(procedure.getGrnDate());
			 }

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(cellStyle);
			cell8.setCellValue(procedure.getGrnNumber());

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(cellStyle);
			cell9.setCellValue(procedure.getMaxLeadTime());

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(cellStyle);
			cell10.setCellValue(procedure.getDelayDays());

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(cellStyle);
			cell11.setCellValue(procedure.getfFormNo());

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(cellStyle);
			cell12.setCellValue("");

			Cell cell13 = row.createCell(13);
			cell13.setCellValue(Double.parseDouble(procedure.getTransferredValue()));
			cell13.setCellStyle(cellStyle1);
			
			procedure.setTransferredValue(setDecimal(procedure.getTransferredValue()));

			row = sheet.createRow(++i);
			setCellBorder(row, workbook, cellStyle);
			Cell cell14 = row.createCell(2);
			cell14.setCellStyle(cellStyle);
			cell14.setCellValue("CST No.:" + procedure.getSendingCST());

			Cell cell15 = row.createCell(6);
			cell15.setCellStyle(cellStyle);
			cell15.setCellValue("CST No.: " + procedure.getReceivingCst());

			row = sheet.createRow(++i);
			setCellBorder(row, workbook, cellStyle);
			Cell cell16 = row.createCell(2);
			cell16.setCellStyle(cellStyle);
			cell16.setCellValue("TIN No.:" + procedure.getSendingTin());

			Cell cell17 = row.createCell(6);
			cell17.setCellStyle(cellStyle);
			cell17.setCellValue("TIN No.:" + procedure.getReceivingTin());

			row = sheet.createRow(++i);
			setCellBorder(row, workbook, cellStyle);
			Cell cell18 = row.createCell(2);
			cell18.setCellStyle(cellStyle);
			cell18.setCellValue("STATE:" + procedure.getSendingState());

			Cell cell19 = row.createCell(6);
			cell19.setCellStyle(cellStyle);
			cell19.setCellValue("STATE: " + procedure.getReceivingState());

			row = sheet.createRow(++i);
			setCellBorder(row, workbook, cellStyle);
		}

		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date());
		String path = ServletActionContext.getServletContext().getRealPath("/ExcelFiles/");
//			String path="C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\";
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		String finalPath = path + timestamp + ".xlsx";

		try (FileOutputStream fileOut = new FileOutputStream(finalPath)) {
			workbook.write(fileOut);
			System.out.println("Excel file has been created successfully.");
			System.out.println("Genrate_ExcelFile end");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return timestamp;
	}

	public void setCellBorder(Row row, Workbook workbook, CellStyle cellStyle) {
		for (int i = 0; i < 14; i++) {
			if (i != 2 || i != 6) {
				row.createCell(i).setCellStyle(cellStyle);
			}
		}
	}

	public String setDecimal(String str) {
		int len = str.length();
		int posi = str.lastIndexOf('.');
		if (posi == -1) {
			str += ".00";
		} else if (posi == len - 2) {
			str += "0";
		}
		return str;
	}

	public String formatDate(String str) {
		return str.replace('-', '/');
	}

}
