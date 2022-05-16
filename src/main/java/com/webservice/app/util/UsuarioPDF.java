package com.webservice.app.util;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.webservice.app.entities.Usuario;

public class UsuarioPDF {

	private List<Usuario> lstusuarios;

	public UsuarioPDF(List<Usuario> lstusuarios) {
		this.lstusuarios = lstusuarios;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();

		cell.setPhrase(new Phrase("Usuario"));

		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (Usuario user : lstusuarios) {
			table.addCell(user.getNombre());
			table.addCell(user.getApellido());
			table.addCell(user.getTipoDocumento().toString());
			table.addCell(user.getDni().toString());
			table.addCell(user.getEmail());
			table.addCell(user.getRol().getRol());

		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Lista de Usuarios", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}

}
