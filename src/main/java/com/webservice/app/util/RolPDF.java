package com.webservice.app.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.webservice.app.entities.UsuarioRol;

public class RolPDF {
	
	private List<UsuarioRol> lstRoles;
    
    public RolPDF(List<UsuarioRol> lstRoles) {
        this.lstRoles = lstRoles;
    }
 
    public void export(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		
		/* Fuentes, tamaños y colores para cada seccion */
		Font fuenteTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.BLUE);
		Font fuenteTituloColumnas = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.BLUE);
		Font fuenteDataCeldas = FontFactory.getFont(FontFactory.COURIER, 10, Color.BLACK);

		//document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-20, -20, 30, 20);
		document.open();
		PdfPCell celda = null;

		/* Tabla Para El Titulo del PDF */
		PdfPTable tablaTitulo = new PdfPTable(1);

		celda = new PdfPCell(new Phrase("LISTADO GENERAL DE ROLES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(40, 190, 138));
		celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
		celda.setPadding(30);

		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(15);

		/*Tabla Para Mostrar Listado de Roles*/
		PdfPTable tablaRol = new PdfPTable(1);
		tablaRol.setWidths(new float[] { 10f});

		celda = new PdfPCell(new Phrase("ROL", fuenteTituloColumnas));
		celda.setBackgroundColor(Color.lightGray);
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaRol.addCell(celda);

		/* Bucle For, mostrar datos de rol */

		 for (UsuarioRol user : lstRoles) {
			celda = new PdfPCell(new Phrase(user.getRol().toString(), fuenteDataCeldas));
			celda.setPadding(5);
			tablaRol.addCell(celda);
		
		 }

		/*Anexamos las Tablas al Documento*/

		document.add(tablaTitulo);
		document.add(tablaRol);
		document.close();

	}

}