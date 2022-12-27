package com.valtech.spring.security.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.valtech.spring.security.entity.CartLine;

public class BillDownload {

	private static final Logger logger = LoggerFactory.getLogger(BillDownload.class);

	public static ByteArrayInputStream cartBill(List<CartLine> cartLines) {

		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);

			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.RED);

			Font font3 = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.RED);

			Font font2 = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.RED);

			Paragraph para = new Paragraph("SpiceLand Invoice Bill", font);
			Paragraph para2 = new Paragraph("Thanks for Visiting", font2);
			Paragraph para3 = new Paragraph("                                ", font3);

			para.setAlignment(Element.ALIGN_CENTER);
			para2.setAlignment(Element.ALIGN_CENTER);

			PdfPTable table = new PdfPTable(4);

			table.setWidthPercentage(60);
			table.setWidths(new int[] { 4, 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Product Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Price", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Quantity", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Total", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			for (CartLine cart : cartLines) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(cart.getProductName().toString()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(cart.getPrice())));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(cart.getQuantity())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(cart.getQuantity() * cart.getPrice())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);

			}

			hcell = new PdfPCell(new Phrase("TotalSum", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("----", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("----", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			float totalSum = 0;
			for (CartLine cart : cartLines) {
				totalSum += cart.getQuantity() * cart.getPrice();

			}

			hcell = new PdfPCell(new Phrase("Rs. " + totalSum + "/-", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			document.open();

			document.add(new Paragraph(new Date().toString()));

			document.add(para);
			document.add(para3);

			document.add(table);
			document.add(para2);
			// document.open();

			document.close();

		} catch (DocumentException ex) {

			logger.error("Error occurred: {0}", ex);
		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}