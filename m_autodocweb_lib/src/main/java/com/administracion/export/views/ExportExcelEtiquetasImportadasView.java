package com.administracion.export.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;

public class ExportExcelEtiquetasImportadasView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HSSFSheet excelSheet = workbook.createSheet("Reporte");

		// get data model which is passed by the Spring container
        List<EtiquetaRotulacionDTO> listBooks = (List<EtiquetaRotulacionDTO>) model.get("lista");
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
	    excelHeader.createCell(index++).setCellValue("ESTATUS");
	    excelHeader.createCell(index++).setCellValue("ERROR");
	    excelHeader.createCell(index++).setCellValue("razonsocial_rem");
	    excelHeader.createCell(index++).setCellValue("contacto_rem");
	    excelHeader.createCell(index++).setCellValue("calle_rem");
	    excelHeader.createCell(index++).setCellValue("numinterior_rem");
	    excelHeader.createCell(index++).setCellValue("numexterior_rem");
	    excelHeader.createCell(index++).setCellValue("colonia_rem");
	    excelHeader.createCell(index++).setCellValue("municipio_rem");
	    excelHeader.createCell(index++).setCellValue("estado_rem");
	    excelHeader.createCell(index++).setCellValue("ciudad_rem");
	    excelHeader.createCell(index++).setCellValue("cp_rem");
	    excelHeader.createCell(index++).setCellValue("telefono_rem");
	    excelHeader.createCell(index++).setCellValue("celular_rem");
	    excelHeader.createCell(index++).setCellValue("rfc_rem");
	    excelHeader.createCell(index++).setCellValue("email_rem");
	    excelHeader.createCell(index++).setCellValue("razonsocial_des");
	    excelHeader.createCell(index++).setCellValue("contacto_des");
	    excelHeader.createCell(index++).setCellValue("calle_des");
	    excelHeader.createCell(index++).setCellValue("numinterior_des");
	    excelHeader.createCell(index++).setCellValue("numexterior_des");
	    excelHeader.createCell(index++).setCellValue("colonia_des");
	    excelHeader.createCell(index++).setCellValue("municipio_des");
	    excelHeader.createCell(index++).setCellValue("estado_des");
	    excelHeader.createCell(index++).setCellValue("ciudad_des");
	    excelHeader.createCell(index++).setCellValue("cp_des");
	    excelHeader.createCell(index++).setCellValue("telefono_des");
	    excelHeader.createCell(index++).setCellValue("celular_des");
	    excelHeader.createCell(index++).setCellValue("email_des");
	    excelHeader.createCell(index++).setCellValue("es_ocurre");
	    excelHeader.createCell(index++).setCellValue("tiene_seguro");
	    excelHeader.createCell(index++).setCellValue("nacional");
	    excelHeader.createCell(index++).setCellValue("es_multiple");
	    excelHeader.createCell(index++).setCellValue("numpiezas");
	    excelHeader.createCell(index++).setCellValue("pesofisico");
	    excelHeader.createCell(index++).setCellValue("largo");
	    excelHeader.createCell(index++).setCellValue("ancho");
	    excelHeader.createCell(index++).setCellValue("alto");
	    excelHeader.createCell(index++).setCellValue("contenido");
	    excelHeader.createCell(index++).setCellValue("observacion");
	    excelHeader.createCell(index++).setCellValue("referencia");
	    excelHeader.createCell(index++).setCellValue("valor_asegurado");
	    excelHeader.createCell(index++).setCellValue("valordeclarado");

	    
	 

				
	  }
	   
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param lista
	 */
	  public void setExcelRows(HSSFSheet excelSheet, List<EtiquetaRotulacionDTO> lista){
	    int record = 1;
		int index=0;
	    for (EtiquetaRotulacionDTO envio : lista) {
	    	 index=0;
	      HSSFRow excelRow = excelSheet.createRow(record++);
	      excelRow.createCell(index++).setCellValue(envio.getEsvalido()==0?"CORRECTO":"INCORRECTO");
	      excelRow.createCell(index++).setCellValue(envio.getMensajeError());
	      excelRow.createCell(index++).setCellValue(envio.getRazonsocial_rem());
	      excelRow.createCell(index++).setCellValue(envio.getContacto_rem());
	      excelRow.createCell(index++).setCellValue(envio.getCalle_rem());
	      excelRow.createCell(index++).setCellValue(envio.getNuminterior_rem());
	      excelRow.createCell(index++).setCellValue(envio.getNumexterior_rem());
	      excelRow.createCell(index++).setCellValue(envio.getColonia_rem());
	      excelRow.createCell(index++).setCellValue(envio.getMunicipio_rem());
	      excelRow.createCell(index++).setCellValue(envio.getEstado_rem());
	      excelRow.createCell(index++).setCellValue(envio.getCiudad_rem());
	      excelRow.createCell(index++).setCellValue(envio.getCp_rem());
	      excelRow.createCell(index++).setCellValue(envio.getTelefono_rem());
	      excelRow.createCell(index++).setCellValue(envio.getCelular_rem());
	      excelRow.createCell(index++).setCellValue(envio.getRfc_rem());
	      excelRow.createCell(index++).setCellValue(envio.getEmail_rem());
	      
	      excelRow.createCell(index++).setCellValue(envio.getRazonsocial_des());
	      excelRow.createCell(index++).setCellValue(envio.getContacto_des());
	      excelRow.createCell(index++).setCellValue(envio.getCalle_des());
	      excelRow.createCell(index++).setCellValue(envio.getNuminterior_des());
	      excelRow.createCell(index++).setCellValue(envio.getNumexterior_des());
	      excelRow.createCell(index++).setCellValue(envio.getColonia_des());
	      excelRow.createCell(index++).setCellValue(envio.getMunicipio_des());
	      excelRow.createCell(index++).setCellValue(envio.getEstado_des());
	      excelRow.createCell(index++).setCellValue(envio.getCiudad_des());
	      excelRow.createCell(index++).setCellValue(envio.getCp_des());
	      excelRow.createCell(index++).setCellValue(envio.getTelefono_des());
	      excelRow.createCell(index++).setCellValue(envio.getCelular_des());
	      excelRow.createCell(index++).setCellValue(envio.getRfc_des());
	      excelRow.createCell(index++).setCellValue(envio.getEmail_des());
	      
	      
	      excelRow.createCell(index++).setCellValue(envio.getEs_ocurre());
	      excelRow.createCell(index++).setCellValue(envio.getTiene_seguro());
	      excelRow.createCell(index++).setCellValue(envio.getNacional());
	      excelRow.createCell(index++).setCellValue(envio.getEs_multiple());
	      excelRow.createCell(index++).setCellValue(envio.getNumpiezas());
	      excelRow.createCell(index++).setCellValue(envio.getPesofisico());
	      excelRow.createCell(index++).setCellValue(envio.getLargo());
	      excelRow.createCell(index++).setCellValue(envio.getAncho());
	      excelRow.createCell(index++).setCellValue(envio.getAlto());
	      excelRow.createCell(index++).setCellValue(envio.getContenido());
	      excelRow.createCell(index++).setCellValue(envio.getObservacion());
	      excelRow.createCell(index++).setCellValue(envio.getReferencia());
	      excelRow.createCell(index++).setCellValue(envio.getValor_asegurado());
	      excelRow.createCell(index++).setCellValue(envio.getValordeclarado());
	    }
	  }

	  
	  
	
	}
