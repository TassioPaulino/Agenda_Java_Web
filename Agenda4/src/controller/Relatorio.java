package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Relatorio.
 */
public class Relatorio {
	
	/**
	 * Gerar relatorio.
	 *
	 * @param response the response
	 */
	public static void gerarRelatorio(HttpServletResponse response) {
		DAO dao = new DAO();
		ArrayList<JavaBeans> lista = dao.listarContatos();
		
		try {
			Document documento = new Document();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline;filename=relatorio.pdf");
			
			PdfWriter.getInstance(documento, response.getOutputStream());
			
			documento.open();
			documento.add(new Paragraph("Lista de Contatos " + LocalDateTime.now()));
			documento.add(new Paragraph(" "));
			
			PdfPTable table = new PdfPTable(4);
			PdfPCell hd_idcon = new PdfPCell(new Paragraph("ID"));
			PdfPCell hd_nome = new PdfPCell(new Paragraph("NOME"));
			PdfPCell hd_fone = new PdfPCell(new Paragraph("FONE"));
			PdfPCell hd_email = new PdfPCell(new Paragraph("E-MAIL"));
			
			hd_idcon.setHorizontalAlignment(1);
			hd_nome.setHorizontalAlignment(1);
			hd_fone.setHorizontalAlignment(1);
			hd_email.setHorizontalAlignment(1);
			
			BaseColor green = new BaseColor(38, 115, 73);
			BaseColor light_green = new BaseColor(179, 230, 201);
			
			hd_idcon.setBackgroundColor(green);
			hd_nome.setBackgroundColor(green);
			hd_fone.setBackgroundColor(green);
			hd_email.setBackgroundColor(green);
			
			table.addCell(hd_idcon);
			table.addCell(hd_nome);
			table.addCell(hd_fone);
			table.addCell(hd_email);
			
			for(int i = 0; i < lista.size(); i++) {
				
				table.addCell(lista.get(i).getIdcon());
				table.addCell(lista.get(i).getNome());
				table.addCell(lista.get(i).getFone());
				table.addCell(lista.get(i).getEmail());
			}
			documento.add(table);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
