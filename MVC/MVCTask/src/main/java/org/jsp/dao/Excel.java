package org.jsp.dao;

import java.util.List;

import javax.servlet.ServletContext;

import org.jsp.dto.PROCEDURE;


import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Excel {
	@Autowired
    private ServletContext servletContext;

	public String getExcel(List<PROCEDURE> procedurelist, ProcedureData data) throws ParseException {

		System.out.println("Generate Excel");
		String[] headers = { "TRANSACTION NO	",
				"DISPATCH DATE	","PARTY	","DESTINATION	","TRANSPORTER	","GOODS VALUE	","INVOICE NO	","LR NO	","DRIVER NAME	","LORRY NUMBER	","LR DATE	","DISPATCH DELAY	","NO OF CASES	","Form No	","C Form Date	","C Form Value	","POD Date	","POD Number","Reason" };
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		
		Font boldFont = workbook.createFont();
		boldFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		boldFont.setFontName("Arial");
		boldFont.setFontHeight((short) 260);
		
		CellStyle header = workbook.createCellStyle();
		header.setFont(boldFont);
		header.setAlignment(CellStyle.ALIGN_CENTER);
		header.setVerticalAlignment((short) 1);
		header.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		header.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

		

		Row row1 = sheet.createRow(0);
		Cell cellheader1 = row1.createCell(0);
		cellheader1.setCellValue("HEALTHCARE PVT. LTD.");
		cellheader1.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,headers.length-1));
		
		Row row2 = sheet.createRow(1);
		Cell cellheader2 = row2.createCell(0);
		String loc=data.getLocName();
		cellheader2.setCellValue(loc);
		cellheader2.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, headers.length-1));
		
		
		Row row3 = sheet.createRow(2);
		Cell cellheader3 = row3.createCell(0);
		cellheader3.setCellValue("Dispatch Register Summary Report From : "+ data.getStdt() +"To"+ data.getEndt());
		cellheader3.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, headers.length-1));
		
		
		Row row4 = sheet.createRow(3);
		Cell cellheader4 = row4.createCell(0);
		cellheader4.setCellValue("Report Dated " + new SimpleDateFormat("dd/mm/yyyy").format(new Date()));
		cellheader4.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, headers.length-1));
		
		
		CellStyle headerStyle2= workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		headerStyle2.setFont(font);
		headerStyle2.setAlignment(CellStyle.ALIGN_CENTER);
		headerStyle2.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		headerStyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerStyle2.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle2.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle2.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle2.setBorderRight(CellStyle.BORDER_THIN);

		
		CellStyle headerStyle3= workbook.createCellStyle();

		headerStyle3.setFont(font);
		headerStyle3.setAlignment(CellStyle.ALIGN_LEFT);
		headerStyle3.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		headerStyle3.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerStyle3.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle3.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle3.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle3.setBorderRight(CellStyle.BORDER_THIN);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CellStyle dateCellStyle = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
		dateCellStyle.setFont(font);
		dateCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		dateCellStyle.setBorderTop(CellStyle.BORDER_THIN);
		dateCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		dateCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		
		
		
		
		Row row5= sheet.createRow(4);
		
		for(int j=0;j<headers.length;j++)
		{
			Cell cell=row5.createCell(j);
			cell.setCellStyle(headerStyle2);
			cell.setCellValue(headers[j]);
			
		}
		
		sheet.createFreezePane(0, 5);
		
		
		
		
		
		
		CellStyle cellStyle = workbook.createCellStyle();
		
		cellStyle.setFont(font);
//		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		int i=4;
		Row row= sheet.createRow(5);
		Date parsedDate ;
		
		String div="";
		
		for(PROCEDURE procedures:procedurelist)
		{
			if(!div.equals(procedures.getDivision()))
			{
				row = sheet.createRow(++i);
				sheet.addMergedRegion(new CellRangeAddress(i, i, 0, headers.length-1));
				div=procedures.getDivision();
				Cell cell = row.createCell(0);
				cell.setCellValue("Division : "+procedures.getDivision());
				cell.setCellStyle(headerStyle3);
				
				
			}
			row = sheet.createRow(++i);
			Cell cell0 = row.createCell(0);
		  cell0.setCellStyle(cellStyle);
		cell0.setCellValue(procedures.getDspTrnNo());

		
		parsedDate=dateFormat.parse(procedures.getDspDt());
		Cell cell1 = row.createCell(1);
		  cell1.setCellStyle(dateCellStyle);
		cell1.setCellValue(parsedDate);

		Cell cell2 = row.createCell(2);
		  cell2.setCellStyle(cellStyle);
		cell2.setCellValue(procedures.getCustName());

		Cell cell3 = row.createCell(3);
		  cell3.setCellStyle(cellStyle);
		cell3.setCellValue(procedures.getDestination());

		Cell cell4 = row.createCell(4);
		  cell4.setCellStyle(cellStyle);
		cell4.setCellValue(procedures.getTransporter());

		Cell cell5 = row.createCell(5);
		  cell5.setCellStyle(cellStyle);
		cell5.setCellValue(procedures.getGoodsValue());

		Cell cell6 = row.createCell(6);
		  cell6.setCellStyle(cellStyle);
		cell6.setCellValue(procedures.getInvNo());

		Cell cell7 = row.createCell(7);
		  cell7.setCellStyle(cellStyle);
		cell7.setCellValue(procedures.getLrNum());

		Cell cell8 = row.createCell(8);
		  cell8.setCellStyle(cellStyle);
		cell8.setCellValue(procedures.getDriverName());

		Cell cell9 = row.createCell(9);
		  cell9.setCellStyle(cellStyle);
		cell9.setCellValue(procedures.getLorryNo());

		
		parsedDate=dateFormat.parse(procedures.getLrDate());
		Cell cell10 = row.createCell(10);
		  cell10.setCellStyle(dateCellStyle);
		cell10.setCellValue(parsedDate);


		Cell cell11 = row.createCell(11);
		  cell11.setCellStyle(cellStyle);
		cell11.setCellValue(procedures.getDelayDays());

		Cell cell12 = row.createCell(12);
		  cell12.setCellStyle(cellStyle);
		cell12.setCellValue(procedures.getNoOfCases());

		Cell cell13 = row.createCell(13);
		  cell13.setCellStyle(cellStyle);
		cell13.setCellValue(procedures.getFormNum());

		
		
		parsedDate=dateFormat.parse(procedures.getLrDate());
		Cell cell14 = row.createCell(14);
		  cell14.setCellStyle(dateCellStyle);
		cell14.setCellValue(parsedDate);

		Cell cell15 = row.createCell(15);
		  cell15.setCellStyle(cellStyle);
		cell15.setCellValue(procedures.getCformValue());

		Cell cell16 = row.createCell(16);
		  cell16.setCellStyle(cellStyle);
		cell16.setCellValue(procedures.getPodDate());

		Cell cell17 = row.createCell(17);
		  cell17.setCellStyle(cellStyle);
		cell17.setCellValue(procedures.getPodNum());

		Cell cell18 = row.createCell(18);
		  cell18.setCellStyle(cellStyle);
		cell18.setCellValue(procedures.getPodReason());
		}

		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date());
//		String path = ServletActionContext.getServletContext().getRealPath("/ExcelFiles/");
//		String path = "C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\";
		 String path = servletContext.getRealPath("/ExcelFiles/");
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		String finalPath = path + timestamp + ".xlsx";

		try (FileOutputStream fileOut = new FileOutputStream(finalPath)) {
			workbook.write(fileOut);
			System.out.println(finalPath);
			System.out.println("Excel file has been created successfully.");
			System.out.println("Genrate_ExcelFile end");

		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		return timestamp;
	}
}
