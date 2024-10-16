package org.jsp.controller;

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
import org.apache.struts2.ServletActionContext;
import org.jsp.dto.PROCEDURE;
import org.jsp.dto.ProcedureData;

public class GenrateExcel {

	public String getExcel(List<PROCEDURE> procedures, ProcedureData procedureData) throws ParseException {

//		System.out.println("genrateExcel  " + procedures.size());
		System.out.println("Genrate_ExcelFile start");
		System.out.println(procedureData);
		String[] Header = { "Customer Code", "Customer", "HQ", "State", "Invoice No.", "Invoice Amt.",
				"Tran Date", "Due Date", "Receivable but not due",
				(procedureData.getSlab11() + "-" + procedureData.getSlab12()),
				(procedureData.getSlab21() + "-" + procedureData.getSlab22()),
				(procedureData.getSlab31() + "-" + procedureData.getSlab32()),
				(procedureData.getSlab41() + "-" + procedureData.getSlab42()),
				(procedureData.getSlab51() + "-" + procedureData.getSlab52()), ">366	", "Unadjusted Credit Note	", "Advance	", "Net Outstanding	", "Remark	", "Receivable Remark	", "LR Date	",
				"LR Number" };

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
		cellheader1.setCellValue("HEALTHCARE PVT. LTD.");
		cellheader1.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 21));

		Row row2 = sheet.createRow(1);
		Cell cellheader2 = row2.createCell(0);
		String loc = procedureData.getBranch() == procedures.get(0).getLocId() ? procedures.get(0).getLocName() : "All";
		cellheader2.setCellValue(loc);
		cellheader2.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 21));

		Row row3 = sheet.createRow(2);
		Cell cellheader3 = row3.createCell(0);
		cellheader3.setCellValue("Customer Wise  OutStanding"
				+ (procedureData.getEndDate().length() != 0 ? "(Specific Date)" : "") + " Detail's Report");
		cellheader3.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 21));
		
		Row row4 = sheet.createRow(3);
		Cell cellheader4 = row4.createCell(0);
		cellheader4.setCellValue("Report Dated " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		cellheader4.setCellStyle(header);
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 21));
		
		
		

		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
//		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("Arial");
		headerStyle.setFont(font);
		headerStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		headerStyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle.setBorderRight(CellStyle.BORDER_THIN);
		
		
		CellStyle headerStyle2= workbook.createCellStyle();
		headerStyle2.setFont(font);
		headerStyle2.setAlignment(CellStyle.ALIGN_LEFT);
		headerStyle2.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		headerStyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		headerStyle2.setBorderTop(CellStyle.BORDER_THIN);
		headerStyle2.setBorderBottom(CellStyle.BORDER_THIN);
		headerStyle2.setBorderLeft(CellStyle.BORDER_THIN);
		headerStyle2.setBorderRight(CellStyle.BORDER_THIN);

		CellStyle cellStyle = workbook.createCellStyle();
//		Font font1 = workbook.createFont();
//		font1.setFontName("Arial");
		cellStyle.setFont(font);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);


		CellStyle cellStyle1 = workbook.createCellStyle();
		cellStyle1.setFont(font);
		cellStyle1.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle1.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle1.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle1.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle1.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle1.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		
		
		CellStyle cellStyle2 = workbook.createCellStyle();
	
		cellStyle2.setFont(font);
		cellStyle2.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle2.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle2.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle2.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle2.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle2.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		cellStyle2.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		cellStyle2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		
		CellStyle cellStyle3 = workbook.createCellStyle();
		
		cellStyle3.setFont(font);
		cellStyle3.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle3.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle3.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle3.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle3.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle3.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		cellStyle3.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		cellStyle3.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
CellStyle cellStyle4 = workbook.createCellStyle();
		
		cellStyle4.setFont(font);
		cellStyle4.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle4.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle4.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle4.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle4.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		cellStyle4.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		cellStyle4.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		
		
CellStyle cellStyle5 = workbook.createCellStyle();
		
		cellStyle5.setFont(font);
		cellStyle5.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle5.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle5.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle5.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle5.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		cellStyle5.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		cellStyle5.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CellStyle dateCellStyle = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
		dateCellStyle.setFont(font);
		dateCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		dateCellStyle.setBorderTop(CellStyle.BORDER_THIN);
		dateCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		dateCellStyle.setBorderLeft(CellStyle.BORDER_THIN);

//    	sheet.createFreezePane(0, 0, 0, 0)
		sheet.createFreezePane(0, 5);

		Row row = sheet.createRow(4);

		for (int i = 0; i < Header.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(Header[i]);
			cell.setCellStyle(headerStyle);
		}
		
		headerStyle.setAlignment(CellStyle.ALIGN_LEFT);

		int i = 4; int id=1,slab1=0,slab2=0,slab3=0,slab4=0,slab5=0,slab6=0,receivable=0,ucn=0,adv=0,totalnetOut=0;
		int slabt1=0,slabt2=0,slabt3=0,slabt4=0,slabt5=0,slabt6=0,receivablet=0,ucnt=0,advt=0,totalnetOutt=0;
		String customerCode="";
		int locationId=-1;
		for (PROCEDURE procedure : procedures) {
			int netOut=0;
			Date parsedDate ;
			if(locationId!=procedure.getLocId())
			{
				row = sheet.createRow(++i);
				sheet.addMergedRegion(new CellRangeAddress(i, i, 0,21));
				
				Cell cell0 = row.createCell(0);
				cell0.setCellStyle(headerStyle2);
				cell0.setCellValue("Location : "+procedure.getLocName());
				for(int j=1;j<=21;j++)
				{
				row.createCell(j).setCellStyle(headerStyle2);
				}
				locationId=procedure.getLocId();
			}
			
			
			
			if(!customerCode.equals(procedure.getCustCd()))
			{
				row = sheet.createRow(++i);
				customerCode=procedure.getCustCd();
				Cell cell0 = row.createCell(0);
				cell0.setCellValue(procedure.getCustCd());
				cell0.setCellStyle(cellStyle5);


				Cell cell1 = row.createCell(1);
				cell1.setCellStyle(cellStyle5);
				cell1.setCellValue(procedure.getCustName());
				
				Cell cell2 = row.createCell(2);
				cell2.setCellStyle(cellStyle5);
				cell2.setCellValue(procedure.getHq());
				
				Cell cell3 = row.createCell(3);
				cell3.setCellStyle(cellStyle5);
				cell3.setCellValue(procedure.getState());
				
				Cell cell4 = row.createCell(4);
				cell4.setCellStyle(cellStyle5);
				cell4.setCellValue(procedure.getDestination());
				
				sheet.addMergedRegion(new CellRangeAddress(i, i, 5,6));
				Cell cell5 = row.createCell(5);
				cell5.setCellStyle(cellStyle5);
				cell5.setCellValue("CREDIT LIMIT : "+procedure.getTotCreditLmt());
				
				row.createCell(6).setCellStyle(cellStyle5);
				
				sheet.addMergedRegion(new CellRangeAddress(i, i, 7,21));
				Cell cell6 = row.createCell(7);
				cell6.setCellStyle(cellStyle5);
				
				for(int j=7;j<22;j++)
				{
				row.createCell(j).setCellStyle(cellStyle5);
				}
				
				
			}
			
			

			row = sheet.createRow(++i);
		
			customerCode=procedure.getCustCd();
			Cell cell0 = row.createCell(0);
			cell0.setCellStyle(cellStyle);


			Cell cell1 = row.createCell(1);
			cell1.setCellStyle(cellStyle);
		
			Cell cell2 = row.createCell(2);
			cell2.setCellStyle(cellStyle);
	
			Cell cell3 = row.createCell(3);
			cell3.setCellStyle(cellStyle);

			Cell cell4 = row.createCell(4);
			cell4.setCellStyle(cellStyle);
			cell4.setCellValue(procedure.getInvoiceNo());

			Cell cell5 = row.createCell(5);
			cell5.setCellStyle(cellStyle1);
			cell5.setCellValue(procedure.getAdjAmount());

			
			
			
//			Cell cell6 = row.createCell(6);
//			cell6.setCellStyle(dateCellStyle);
//			cell6.setCellValue(dateFormat(procedure.getTranDate()));
			
			
			Cell cell6 = row.createCell(6);  
			 if(procedure.getTranDate()!=null)
				 {parsedDate = dateFormat.parse(dateFormat(procedure.getTranDate()));
				cell6.setCellValue(parsedDate); 
				cell6.setCellStyle(dateCellStyle); 
				}
			 else 
			 {
				 cell6.setCellStyle(cellStyle);
					cell6.setCellValue(procedure.getTranDate());
			 }
			
			

//			Cell cell7 = row.createCell(7);
//			cell7.setCellStyle(dateCellStyle);
//			cell7.setCellValue(dateFormat(procedure.getDueDate()));
			 
			 Cell cell7 = row.createCell(7);  
			 if(procedure.getTranDate()!=null)
				 {parsedDate = dateFormat.parse(dateFormat(procedure.getTranDate()));
				cell7.setCellValue(parsedDate); 
				cell7.setCellStyle(dateCellStyle); 
				}
			 else 
			 {
				 cell7.setCellStyle(cellStyle);
					cell7.setCellValue(procedure.getTranDate());
			 }

			Cell cell8 = row.createCell(8);
			cell8.setCellStyle(cellStyle1);
			cell8.setCellValue(procedure.getReceivable());
			receivable+=procedure.getReceivable();
			netOut+=procedure.getReceivable();

			Cell cell9 = row.createCell(9);
			cell9.setCellStyle(cellStyle1);
			cell9.setCellValue(procedure.getSlab1());
			slab1+=procedure.getSlab1();
			netOut+=procedure.getSlab1();

			Cell cell10 = row.createCell(10);
			cell10.setCellStyle(cellStyle1);
			cell10.setCellValue(procedure.getSlab2());
			slab2+=procedure.getSlab2();
			netOut+=procedure.getSlab2();

			Cell cell11 = row.createCell(11);
			cell11.setCellStyle(cellStyle1);
			cell11.setCellValue(procedure.getSlab3());
			slab3+=procedure.getSlab3();
			netOut+=procedure.getSlab3();

			Cell cell12 = row.createCell(12);
			cell12.setCellStyle(cellStyle1);
			cell12.setCellValue(procedure.getSlab4());
			slab4+=procedure.getSlab4();
			netOut+=procedure.getSlab4();

			Cell cell13 = row.createCell(13);
			cell13.setCellStyle(cellStyle1);
			cell13.setCellValue(procedure.getSlab5());
			slab5+=procedure.getSlab5();
			netOut+=procedure.getSlab5();

			Cell cell14 = row.createCell(14);
			cell14.setCellStyle(cellStyle1);
			cell14.setCellValue(procedure.getSlab6());
			slab6+=procedure.getSlab6();
			netOut+=procedure.getSlab6();

			Cell cell15 = row.createCell(15);
			cell15.setCellStyle(cellStyle1);
			cell15.setCellValue(procedure.getUnadjCr());
			ucn+=procedure.getUnadjCr();

			Cell cell16 = row.createCell(16);
			cell16.setCellStyle(cellStyle1);
			cell16.setCellValue(procedure.getAdvance());
			adv+=procedure.getAdvance();
			netOut+=procedure.getAdvance();

			Cell cell17 = row.createCell(17);
			cell17.setCellStyle(cellStyle1);
			cell17.setCellValue(netOut);   
			totalnetOut+=netOut;
			
			Cell cell18 = row.createCell(18);
			cell18.setCellStyle(cellStyle);
			cell18.setCellValue(procedure.getRemark());

			Cell cell19 = row.createCell(19);
			cell19.setCellStyle(cellStyle);
			cell19.setCellValue(procedure.getReceivableRemark());

//			Cell cell20 = row.createCell(20);
//			cell20.setCellStyle(dateCellStyle);
//			cell20.setCellValue(dateFormat(procedure.getLrDate()));
			Cell cell20 = row.createCell(20);  
			 if(procedure.getTranDate()!=null)
				 {parsedDate = dateFormat.parse(dateFormat(procedure.getTranDate()));
				cell20.setCellValue(parsedDate); 
				cell20.setCellStyle(dateCellStyle); 
				}
			 else 
			 {
				 cell20.setCellStyle(cellStyle);
					cell20.setCellValue(procedure.getTranDate());
			 }

			Cell cell21 = row.createCell(21);
			cell21.setCellStyle(cellStyle1);
			cell21.setCellValue(procedure.getLrNumber());
		
			if(procedures.size()==id || !customerCode.equals(procedures.get(id).getCustCd()))
			{
				row = sheet.createRow(++i);
				sheet.addMergedRegion(new CellRangeAddress(i, i, 0,7));
				sheet.addMergedRegion(new CellRangeAddress(i, i, 18,21));
				
				for(int j=0;j<8;j++)
				{
					
					Cell celllast = row.createCell(j);
					celllast.setCellStyle(cellStyle3);
					if(j==0)
						{
						celllast.setCellValue("Customer Total : ");
						}
					
				}
				
				Cell cell8a = row.createCell(8);
				cell8a.setCellStyle(cellStyle2);
				cell8a.setCellValue(receivable);


				Cell cell9a = row.createCell(9);
				cell9a.setCellStyle(cellStyle2);
				cell9a.setCellValue(slab1);


				Cell cell10a = row.createCell(10);
				cell10a.setCellStyle(cellStyle2);
				cell10a.setCellValue(slab2);
			

				Cell cell11a = row.createCell(11);
				cell11a.setCellStyle(cellStyle2);
				cell11a.setCellValue(slab3);
		

				Cell cell12a = row.createCell(12);
				cell12a.setCellStyle(cellStyle2);
				cell12a.setCellValue(slab4);

				Cell cell13a = row.createCell(13);
				cell13a.setCellStyle(cellStyle2);
				cell13a.setCellValue(slab5);
		

				Cell cell14a = row.createCell(14);
				cell14a.setCellStyle(cellStyle2);
				cell14a.setCellValue(slab6);
				slab6+=procedure.getSlab6();

				Cell cell15a = row.createCell(15);
				cell15a.setCellStyle(cellStyle2);
				cell15a.setCellValue(ucn);
				

				Cell cell16a = row.createCell(16);
				cell16a.setCellStyle(cellStyle2);
				cell16a.setCellValue(adv);

				Cell cell17a = row.createCell(17);
				cell17a.setCellStyle(cellStyle2);
				cell17a.setCellValue(totalnetOut);    //outstanding

				for(int j=18;j<22;j++)
				{
				row.createCell(j).setCellStyle(cellStyle2);
				}
				slabt1+=slab1;
				slabt2+=slab2;
				slabt3+=slab3;
				slabt4+=slab4;
				slabt5+=slab5;
				slabt6+=slab6;
				receivablet+=receivable;
				ucnt+=ucn;
				adv+=advt;
				totalnetOutt+=totalnetOut;
				slab1=0;slab2=0;slab3=0;slab4=0;slab5=0;slab6=0;receivable=0;ucn=0;adv=0;totalnetOut=0;
				
			}
			
			
			
			if(procedures.size()==id || locationId!=procedure.getLocId())
			{
			row = sheet.createRow(++i);
			sheet.addMergedRegion(new CellRangeAddress(i, i, 0,7));
			sheet.addMergedRegion(new CellRangeAddress(i, i, 18,21));
			for(int j=0;j<8;j++)
			{
				
				Cell celllast = row.createCell(j);
				celllast.setCellStyle(cellStyle4);
				if(j==0)
					{
					celllast.setCellValue("Location Total : ");
					celllast.setCellStyle(headerStyle);
					}
			}
		
			
			Cell cell8a = row.createCell(8);
			cell8a.setCellStyle(cellStyle4);
			cell8a.setCellValue(receivablet);


			Cell cell9a = row.createCell(9);
			cell9a.setCellStyle(cellStyle4);
			cell9a.setCellValue(slabt1);


			Cell cell10a = row.createCell(10);
			cell10a.setCellStyle(cellStyle4);
			cell10a.setCellValue(slabt2);
		

			Cell cell11a = row.createCell(11);
			cell11a.setCellStyle(cellStyle4);
			cell11a.setCellValue(slabt3);
	

			Cell cell12a = row.createCell(12);
			cell12a.setCellStyle(cellStyle4);
			cell12a.setCellValue(slabt4);

			Cell cell13a = row.createCell(13);
			cell13a.setCellStyle(cellStyle4);
			cell13a.setCellValue(slabt5);
	

			Cell cell14a = row.createCell(14);
			cell14a.setCellStyle(cellStyle4);
			cell14a.setCellValue(slabt6);
			slab6+=procedure.getSlab6();

			Cell cell15a = row.createCell(15);
			cell15a.setCellStyle(cellStyle4);
			cell15a.setCellValue(ucn);
			

			Cell cell16a = row.createCell(16);
			cell16a.setCellStyle(cellStyle4);
			cell16a.setCellValue(advt);

			Cell cell17a = row.createCell(17);
			cell17a.setCellStyle(cellStyle4);
			cell17a.setCellValue(totalnetOutt);   

			for(int j=18;j<22;j++)
			{
			row.createCell(j).setCellStyle(cellStyle4);
			}
			 slabt1=0;slabt2=0;slabt3=0;slabt4=0;slabt5=0;slabt6=0;receivablet=0;ucnt=0;advt=0;totalnetOutt=0;
			}
			id++;
			

		}
		

		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateTimeFormat.format(new Date());
		String path = ServletActionContext.getServletContext().getRealPath("/ExcelFiles/");
//		String path = "C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\";
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
	
	public String dateFormat(String str)
	{
		
//		if(str==null || str.length()==0)return null;
//		String [] arr=str.substring(0,10).split("-");
//		return arr[2]+"/"+arr[1]+"/"+arr[0];
		return str;
	}
}
