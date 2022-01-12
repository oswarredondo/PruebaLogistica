package com.administracion.export.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.innovargia.documentos.dtos.Envio;
import com.servicio.dtos.DocumentoConsultaDTO;

public class ExportExcelConsultaEtiquetasView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HSSFSheet excelSheet = workbook.createSheet("Reporte");

		// get data model which is passed by the Spring container
        List<DocumentoConsultaDTO> listBooks = (List<DocumentoConsultaDTO>) model.get("lista");
        setExcelHeader(excelSheet); 
       setExcelRows(excelSheet, listBooks);
	}
	
	/***
	 * Agrega los encabezados
	 * @param excelSheet
	 */
	public void setExcelHeader(HSSFSheet excelSheet) {
		int index=0;
	    HSSFRow excelHeader = excelSheet.createRow(0);
	    excelHeader.createCell(index++).setCellValue("Estatus");
	    
	    excelHeader.createCell(index++).setCellValue("Guia Madre");
	    
	    excelHeader.createCell(index++).setCellValue("Etiqueta");
	    excelHeader.createCell(index++).setCellValue("F.Creacion");
	    excelHeader.createCell(index++).setCellValue("Referencia");
	    excelHeader.createCell(index++).setCellValue("Guia Casamiento");
	    excelHeader.createCell(index++).setCellValue("Guia Devolucion");
	    excelHeader.createCell(index++).setCellValue("Peso");
	    excelHeader.createCell(index++).setCellValue("Val. Decl.");
	   // excelHeader.createCell(index++).setCellValue("Cant.Asegurada");
	    excelHeader.createCell(index++).setCellValue("Contenido");
	    excelHeader.createCell(index++).setCellValue("Observacion");
	    excelHeader.createCell(index++).setCellValue("Remitente");
	    excelHeader.createCell(index++).setCellValue("Destino");
	    excelHeader.createCell(index++).setCellValue("Quien Recibe");
	    excelHeader.createCell(index++).setCellValue("Fecha Entrega");
	    
	 

				
	  }
	   
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param lista
	 */
	  public void setExcelRows(HSSFSheet excelSheet, List<DocumentoConsultaDTO> lista){
	    int record = 1;
		int index=0;
	    for (DocumentoConsultaDTO envio : lista) {
	    	 index=0;
	      HSSFRow excelRow = excelSheet.createRow(record++);
	      excelRow.createCell(index++).setCellValue(envio.getEstatus());
	      
	      excelRow.createCell(index++).setCellValue(envio.getIdDocumentoMadre());
	      
	      excelRow.createCell(index++).setCellValue(envio.getIdDocumento());
	      excelRow.createCell(index++).setCellValue(envio.getFechaCreacion());
	      excelRow.createCell(index++).setCellValue(envio.getReferencia());
	      excelRow.createCell(index++).setCellValue(envio.getIdGuiaDevolucion());
	      excelRow.createCell(index++).setCellValue(envio.getIdGuiaCasamiento());
	      excelRow.createCell(index++).setCellValue(envio.getPesoBruto());
	      excelRow.createCell(index++).setCellValue(envio.getValorDeclarado());
	      
	      excelRow.createCell(index++).setCellValue(envio.getContenidoDeclarado());
	      excelRow.createCell(index++).setCellValue(envio.getObservaciones());
	      excelRow.createCell(index++).setCellValue(envio.remitente.getRazonSocial());
	      excelRow.createCell(index++).setCellValue(envio.destinatario.getRazonSocial());
	      excelRow.createCell(index++).setCellValue(envio.getQuienRecibe());
	      excelRow.createCell(index++).setCellValue(envio.getFechaConfirmacion());
	    }
	  }

	  
	  
	
	}
