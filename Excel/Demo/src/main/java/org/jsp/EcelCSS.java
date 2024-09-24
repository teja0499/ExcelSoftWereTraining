package org.jsp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class EcelCSS {
	public static void main(String[] args) {

		List<Student> stu;
		Workbook workbook = new HSSFWorkbook();

		// to give style to cell we have to use cell style
		CellStyle headerStyle = workbook.createCellStyle();
		
		// to give style to font
		Font font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setFont(font);

		
		// to give background color
		headerStyle.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		
		// to set border 
		headerStyle.setBorderTop(CellStyle.BORDER_THICK);
		headerStyle.setBorderBottom(CellStyle.BORDER_THICK);
		headerStyle.setBorderLeft(CellStyle.BORDER_THICK);
		headerStyle.setBorderRight(CellStyle.BORDER_THICK);

		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);

		Cell id = row.createCell(0);
		id.setCellValue("ID");
		id.setCellStyle(headerStyle);

		Cell name = row.createCell(1);
		name.setCellValue("Name");
		name.setCellStyle(headerStyle);

		Cell mobile = row.createCell(2);
		mobile.setCellValue("Mobile");
		mobile.setCellStyle(headerStyle);

		
		// to frezz the first line where first 0 for number of column to frezz nd  sec 1 for numner of row to freez
		sheet.createFreezePane(0, 1);

		int i = 1;
		for (char c = 'A'; i <= 26; i++, c++) {
			Student s = new Student(i , c + "" + c, i + 100);
			row = sheet.createRow(i);
			id = row.createCell(0);
			id.setCellValue(s.id);

			name = row.createCell(1);
			name.setCellValue(s.name);

			mobile = row.createCell(2);
			mobile.setCellValue(s.mobile);
			System.out.println(s);
		}

		try (FileOutputStream fileOut = new FileOutputStream(
				"C:\\Users\\canncopierservicepvt\\Desktop\\Excel files\\StudentExcelCss.xls")) {
			workbook.write(fileOut);
			System.out.println("Excel file has been created successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------");
	}

}
