package org.jsp.dto;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Footer {
	public PdfPTable getFooter(Font tableHeaderStyle, Font tableContent) throws DocumentException
	{
		PdfPTable footerTable = new PdfPTable(9);
		footerTable.setWidthPercentage(100f);
		footerTable.setSpacingBefore(0f);
		float[] tableWidths = { 3f, 2f, 4f, 4f, 2f, 2f, 3f, 5f, 5f };
		footerTable.setWidths(tableWidths);

		PdfPCell data = new PdfPCell(new Paragraph("Manufacturing\r\n" + " Locations :", tableHeaderStyle));
		data.setColspan(2);
		data.setRowspan(2);
		;
		data.setBorder(Rectangle.NO_BORDER);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph(
				"170-MEDLEY PHARMACEUTICALS LIMITED - DAMAN, - ,170-MEDLEY\r\n"
						+ "PHARMACEUTICALS LIMITED - DAMAN, - ,170-MEDLEY PHARMACEUTICALS\r\n" + "LIMITED - DAMAN,",
				tableContent));
		data.setColspan(5);
		data.setRowspan(2);

		data.setBorder(Rectangle.NO_BORDER);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Total goods Value:", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("42724.00", tableContent));
		data.setHorizontalAlignment(Element.ALIGN_RIGHT);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Product Discount", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("-7278.40", tableContent));
		data.setHorizontalAlignment(Element.ALIGN_RIGHT);
		footerTable.addCell(data);

		// new row
		// ----------------------------------------------------------------------------------------------------------------------------

		data = new PdfPCell(new Paragraph("Tax Type", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("%", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Goods Value", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Taxable Amt", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Tax Amt", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Cess %", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Cess Amt", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableHeaderStyle));
		footerTable.addCell(data);

		// new row
		// ----------------------------------------------------------------------------------------------------------------------------

		for (int i = 0; i < 2; i++) {
			data = new PdfPCell(new Paragraph("SGST", tableContent));
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("6.00%", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("42724.00 ", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("35445.60", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("2126.74", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("0.00", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("0.00", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("Total Taxable Amt :", tableHeaderStyle));
			footerTable.addCell(data);

			data = new PdfPCell(new Paragraph("35445.60", tableContent));
			data.setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(data);
		}
		for (int i = 0; i < 7; i++) {
			data = new PdfPCell(new Paragraph("", tableContent));
			footerTable.addCell(data);
		}

		data = new PdfPCell(new Paragraph("CGST :", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("35445.60", tableContent));
		data.setHorizontalAlignment(Element.ALIGN_RIGHT);
		footerTable.addCell(data);

		tableContent = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.WHITE);
		for (int i = 0; i < 27; i++) {
			data = new PdfPCell(new Paragraph("T", tableContent));
			footerTable.addCell(data);
		}

		tableContent = new Font(Font.FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);

		data = new PdfPCell(new Paragraph("Rupees in Words :", tableContent));
		data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		data.setColspan(2);

		footerTable.addCell(data);

		data = new PdfPCell(
				new Paragraph(" Thirty Nine Thousand Six Hundred and Ninety Nine Only .", tableContent));
		data.setColspan(5);
		data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableContent));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableContent));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Note :", tableHeaderStyle));
		data.setColspan(2);
		data.setRowspan(2);
		data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableContent));
		data.setColspan(5);
		data.setRowspan(2);
		data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Round Off", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("-0.08", tableContent));
		data.setHorizontalAlignment(Element.ALIGN_LEFT);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Total Invoice Amt :", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("36999.00", tableContent));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("CN Adjusted :", tableHeaderStyle));
		data.setColspan(2);
		data.setRowspan(2);
		data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableContent));
		data.setColspan(5);
		data.setRowspan(2);
		data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph(".", tableContent));

		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Net Payable Amount :", tableHeaderStyle));
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("36999.00", tableContent));
		data.setHorizontalAlignment(Element.ALIGN_RIGHT);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("No of products: 6 ", tableContent));
		data.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.BOTTOM);
		data.setColspan(2);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("No of cases: 14", tableContent));
		data.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
		data.setColspan(2);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Bill MRP Value: 66460.00", tableContent));
		data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.BOTTOM);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("For SINKHAI HEALTHCARE LTD BHIWANDI", tableHeaderStyle));
		data.setColspan(2);
		data.setRowspan(10);
		data.setBorder(Rectangle.TOP | Rectangle.RIGHT | Rectangle.LEFT);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Name : Sinkhai Healthcare Limited ", tableHeaderStyle));
		data.setBorder(Rectangle.TOP | Rectangle.LEFT);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Bank : Yes Bank,Andheri East , Mumbai .", tableHeaderStyle));
		data.setBorder(Rectangle.TOP | Rectangle.RIGHT);
		data.setColspan(4);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("IFSC :YESB0000078.", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("A/c No:007881300003921,", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(4);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(7);
		data.setRowspan(3);
		data.setMinimumHeight(40f);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Principal Company :", tableHeaderStyle));
		data.setBorder(Rectangle.TOP);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("SINKHAI HEALTHCARE LTD.,", tableContent));
		data.setBorder(Rectangle.TOP);
		data.setColspan(4);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("(A Subsidiary Of Medley)", tableContent));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(4);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Registered Office Address:", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("ANDHERIMUMBAI", tableContent));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(4);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("CIN", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("U24230MH2005PLC151938", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(3);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Telephone", tableHeaderStyle));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(4);
		footerTable.addCell(data);
		
		data = new PdfPCell(new Paragraph("Website", tableContent));
		data.setBorder(Rectangle.NO_BORDER);
		data.setColspan(7);
		footerTable.addCell(data);

		data = new PdfPCell(new Paragraph("Authorized Signatory", tableContent));
		data.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
		data.setColspan(2);
		data.setHorizontalAlignment(Element.ALIGN_CENTER);
		footerTable.addCell(data);
		
		return footerTable;

	}
}
