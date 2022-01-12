package com.administracion.export.views;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import com.administracion.dto.FacturaGuia;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.innovargia.salesmanager.ibo.IFacturaResumenBO;
import com.servicio.dtos.DocumentoConsultaDTO;

public class ExportExcelFacturaGuiasView extends AbstractExcelView {
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		
		// get data model which is passed by the Spring container
		JsonParser parser = new JsonParser();
		//Obtain JsonObject
		JsonObject joResult =  parser.parse(model.get("lista").toString()).getAsJsonObject();
        // Obtain Array
        //JsonArray gsonArr = parser.parse(model.get("lista").toString()).getAsJsonArray();
        //List<FacturaGuia> listBooks = (List<FacturaGuia>) model.get("lista");
        setExcel(workbook, joResult); 
        //setExcelRowsGuides(excelSheet, jsonObject);
	}
	
	/***
	 * Agrega los encabezados
	 * @param excelSheet
	 * @throws Exception 
	 */
	public void setExcel(HSSFWorkbook workbook, JsonObject joResult) throws Exception {
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
	    
	    JsonArray jaGuias = joResult.get("guias").getAsJsonArray();
	    JsonArray jaGuiasAseguradas = joResult.get("aseguradas").getAsJsonArray();
	    JsonArray jaAdicionales= joResult.get("adicionales").getAsJsonArray();
	    JsonArray jaServicios = joResult.get("servicios").getAsJsonArray();
	    JsonArray jaSobrepesos = joResult.get("sobrepesos").getAsJsonArray();
	    JsonArray jaReexpedicion = joResult.get("reexpedicion").getAsJsonArray();
	    JsonArray jaGuiasMadre = joResult.get("madre").getAsJsonArray();

	    //Guias
	    int row = 0;
	    HSSFSheet excelSheet = workbook.createSheet("Guias");
	    excelSheet.setDefaultColumnWidth(17);
	    setExcelHeaderGuias(excelSheet, style, 0);
	    setExcelRowsGuias(excelSheet, jaGuias, 1);	 
	    
	    //Aseguradas
	    excelSheet = workbook.createSheet("Aseguradas");
	    excelSheet.setDefaultColumnWidth(17);
	    row = setExcelHeaderAseguradas(excelSheet, style, 0);
	    row = setExcelRowsAseguradas(excelSheet, jaGuiasAseguradas, 1);
	    
	    //Adicionales
	    excelSheet = workbook.createSheet("Adicionales");
	    excelSheet.setDefaultColumnWidth(17);
	    row = setExcelHeaderAdicionales(excelSheet, style, 0);
	    row = setExcelRowsAdicionales(excelSheet, jaAdicionales, 1);
	    
	    //Servicios
	    excelSheet = workbook.createSheet("Servicios");
	    excelSheet.setDefaultColumnWidth(17);
	    row = setExcelHeaderServicios(excelSheet, style, 0);
	    row = setExcelRowsServicios(excelSheet, jaServicios, 1);
	    
	    //Sobrepesos
	    excelSheet = workbook.createSheet("Sobrepesos");
	    excelSheet.setDefaultColumnWidth(17);
	    row = setExcelHeaderSobrepesos(excelSheet, style, 0);
	    row = setExcelRowsSobrepesos(excelSheet, jaSobrepesos, 1);
	    
	    //ReExpedicion
	    excelSheet = workbook.createSheet("ReExpedicion");
	    excelSheet.setDefaultColumnWidth(17);
	    row = setExcelHeaderReexpedicion(excelSheet, style, 0);
	    row = setExcelRowsReexpedicion(excelSheet, jaReexpedicion, 1);
	    
	    /*CREAMOS HOJA, HEADER Y RENGLONESENEXCEL */
	    //Guias Madre
	    excelSheet = workbook.createSheet("Guias Madre");
	    excelSheet.setDefaultColumnWidth(17);
	    row = setExcelHeaderGuiasMadre(excelSheet, style, 0);
	    /*COMO ES UNFORMATO ESPECIAL OCUPAREMOS EL ESTYLO DEL HEADER *
	     *Y LA LISTA DEOBJETOSYUA QUE ESTA CUENTA CON LOS DATOS DE LAS
	     *GUIAS A LAS QUE AMPARA*/
	    row = setExcelRowsGuiasMadre(excelSheet, jaGuiasMadre, style, joResult, 1);
    }
	
	private int setExcelHeaderGuias(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row);
		
		excelHeader.createCell(index++).setCellValue("Guia");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Servicio");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Referencia");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Fecha Entrega");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Origen");
	    excelHeader.getCell(4).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Destino");
	    excelHeader.getCell(5).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Zona");
	    excelHeader.getCell(6).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Largo");
	    excelHeader.getCell(7).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Ancho");
	    excelHeader.getCell(8).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Alto");
	    excelHeader.getCell(9).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Peso");
	    excelHeader.getCell(10).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Total");
	    excelHeader.getCell(11).setCellStyle(style);
		
		return row;
	}
	
	private int setExcelHeaderAseguradas(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Folio Interno");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("No De Facturacion");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Fecha Enbarque");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Medio de Transporte");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Origen");
	    excelHeader.getCell(4).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Destino");
	    excelHeader.getCell(5).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Descripcion de Bienes");
	    excelHeader.getCell(6).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Valor Asegurado");
	    excelHeader.getCell(7).setCellStyle(style);
	    
	    return row;
	}
	
	private int setExcelHeaderAdicionales(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Guia");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Adicional");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Total");
	    excelHeader.getCell(2).setCellStyle(style);
		
		return row;
	}

	private int setExcelHeaderServicios(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Servicio");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Descripción");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Cantidad");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Precio");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Total");
	    excelHeader.getCell(4).setCellStyle(style);
		
		return row;
	}
	
	private int setExcelHeaderSobrepesos(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Guia");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Peso ampara envio");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Peso cliente");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Peso real");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("KGs de sobrepeso");
	    excelHeader.getCell(4).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Precio del KG de sp");
	    excelHeader.getCell(5).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Total");
	    excelHeader.getCell(6).setCellStyle(style);
		
		return row;
	}
	   
	private int setExcelHeaderReexpedicion(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Guia");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Origen");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Destino");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("CP Destino");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Precio");
	    excelHeader.getCell(4).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Total");
	    excelHeader.getCell(5).setCellStyle(style);
	    
		return row;
	}
	
	/* HEADER GUIA MADRE */
	private int setExcelHeaderGuiasMadre(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Guia Madre");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Servicio");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Referencia");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Fecha Entrega");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Origen");
	    excelHeader.getCell(4).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Destino");
	    excelHeader.getCell(5).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Zona");
	    excelHeader.getCell(6).setCellStyle(style);
	
	    excelHeader.createCell(index++).setCellValue("Cant");
	    excelHeader.getCell(7).setCellStyle(style);
		
		return row;
	}
	
	/* HEADER GUIAS QUE AMPARA LA GUIA MADRE */
	private int setExcelHeaderGuiasMadreBody(HSSFSheet excelSheet, CellStyle style, int row){
		
		int index=0;
		HSSFRow excelHeader = excelSheet.createRow(row++);
		
		excelHeader.createCell(index++).setCellValue("Guias que ampara");
	    excelHeader.getCell(0).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Servicio");
	    excelHeader.getCell(1).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Referencia");
	    excelHeader.getCell(2).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Fecha Entrega");
	    excelHeader.getCell(3).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Origen");
	    excelHeader.getCell(4).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Destino");
	    excelHeader.getCell(5).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Zona");
	    excelHeader.getCell(6).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Largo");
	    excelHeader.getCell(7).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Ancho");
	    excelHeader.getCell(8).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Alto");
	    excelHeader.getCell(9).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Peso");
	    excelHeader.getCell(10).setCellStyle(style);
	    
	    excelHeader.createCell(index++).setCellValue("Total");
	    excelHeader.getCell(11).setCellStyle(style);
		
		return row;
	}

	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr guias
	 */
	public int setExcelRowsGuias(HSSFSheet excelSheet, JsonArray gsonArr, int row){
		int index=0;
		for (int i = 0; i<gsonArr.size(); i++){
			index=0;
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("iddocumento") ? "" : gsonObj.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("tiposervicio") ? "" : gsonObj.get("tiposervicio").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("referencia") ? "" : gsonObj.get("referencia").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("fechaentrega") ? "" : gsonObj.get("fechaentrega").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonaori") ? "" : gsonObj.get("zonaori").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonades") ? "" : gsonObj.get("zonades").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonaventa") ? "" : gsonObj.get("zonaventa").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("largo") ? 0.0 : gsonObj.get("largo").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("ancho") ? 0.0 : gsonObj.get("ancho").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("alto") ? 0.0 : gsonObj.get("alto").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("pesofisico") ? 0.0 : gsonObj.get("pesofisico").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio") ? 0.0 : gsonObj.get("precio").getAsDouble());
		}
		return row;
	}
	
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr Aseguradas
	 */
	public int setExcelRowsAseguradas(HSSFSheet excelSheet, JsonArray gsonArr, int row){
		int index=0;
		for (int i = 0; i<gsonArr.size(); i++){
			index=0;
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("iddocumento") ? "" : gsonObj.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("referencia") ? "" : gsonObj.get("referencia").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("fecha") ? "" : gsonObj.get("fecha").getAsString());
	    	excelRow.createCell(index++).setCellValue("TERRESTRE");
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonaori") ? "" : gsonObj.get("zonaori").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonades") ? "" : gsonObj.get("zonades").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("contenido") ? "" : gsonObj.get("contenido").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("valorasegurado") ? 0.0 : gsonObj.get("valorasegurado").getAsDouble());
		}
		return row;
	}
	
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr Adicionales
	 */
	public int setExcelRowsAdicionales(HSSFSheet excelSheet, JsonArray gsonArr, int row){
		int index=0;
		for (int i = 0; i<gsonArr.size(); i++){
			index=0;
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("iddocumento") ? "" : gsonObj.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("descripcion") ? "" : gsonObj.get("descripcion").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio") ? 0.0 : gsonObj.get("precio").getAsDouble());
		}
		return row;
	}
	
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr Servicios
	 */
	public int setExcelRowsServicios(HSSFSheet excelSheet, JsonArray gsonArr, int row){
		int index=0;
		for (int i = 0; i<gsonArr.size(); i++){
			index=0;
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("nombre") ? "" : gsonObj.get("nombre").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("descripcion") ? "" : gsonObj.get("descripcion").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("cantidad") ? 0 : gsonObj.get("cantidad").getAsInt());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio") ? 0.0 : gsonObj.get("precio").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("subtotal") ? 0.0 : gsonObj.get("subtotal").getAsDouble());
		}
		return row;
	}
	
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr Sobrepesos
	 */
	public int setExcelRowsSobrepesos(HSSFSheet excelSheet, JsonArray gsonArr, int row){
		int index=0;
		for (int i = 0; i<gsonArr.size(); i++){
			index=0;
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("iddocumento") ? "" : gsonObj.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("peso_amparado") ? 0.0 : gsonObj.get("peso_amparado").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("peso_max_cliente") ? .0 : gsonObj.get("peso_max_cliente").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("peso_max_medido") ? 0.0 : gsonObj.get("peso_max_medido").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("kg_sobrepeso") ? 0.0 : gsonObj.get("kg_sobrepeso").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio_kg_sp") ? 0.0 : gsonObj.get("precio_kg_sp").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("monto_sobrepeso") ? 0.0 : gsonObj.get("monto_sobrepeso").getAsDouble());
	    	//excelRow.createCell(index++).setCellValue(!gsonObj.has("peso_max_calculado") ? "" : gsonObj.get("peso_max_calculado").getAsString());
		}
		return row ;
	}
	
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr Sobrepesos
	 */
	public int setExcelRowsReexpedicion(HSSFSheet excelSheet, JsonArray gsonArr, int row){
		int index=0;
		for (int i = 0; i<gsonArr.size(); i++){
			index=0;
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("iddocumento") ? "" : gsonObj.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonaori") ? "" : gsonObj.get("zonaori").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonades") ? "" : gsonObj.get("zonades").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("cp") ? "" : gsonObj.get("cp").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio") ? 0.0 : gsonObj.get("precio").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio") ? 0.0 : gsonObj.get("precio").getAsDouble());
//	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio_reexpedcion") ? 0.0 : gsonObj.get("precio_reexpedcion").getAsDouble());
//	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio_reexpedcion") ? 0.0 : gsonObj.get("precio_reexpedcion").getAsDouble());
		}
		return row;
	}
	
	/***
	 * Agrega el contenido
	 * @param excelSheet
	 * @param gsonArr guias madre
	 * @throws Exception 
	 */
	public int setExcelRowsGuiasMadre(HSSFSheet excelSheet, JsonArray gsonArr, CellStyle style, JsonObject joResult, int row) throws Exception{
		
		int index=0;
		int aux = 0;
		
		for (int i = 0; i<gsonArr.size(); i++){
			 
			if(i != 0){
				
				row = setExcelHeaderGuiasMadre(excelSheet, style, row++);
				
			 }
			
			index=0;
			
			JsonObject gsonObj = gsonArr.get(i).getAsJsonObject();
			HSSFRow excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("iddocumento") ? "" : gsonObj.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("tiposervicio") ? "" : gsonObj.get("tiposervicio").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("referencia") ? "" : gsonObj.get("referencia").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("fechaentrega") ? "" : gsonObj.get("fechaentrega").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonaori") ? "" : gsonObj.get("zonaori").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonades") ? "" : gsonObj.get("zonades").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("zonaventa") ? "" : gsonObj.get("zonaventa").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObj.has("precio") ? 0.0 : gsonObj.get("precio").getAsDouble());
			
	    	JsonArray jaGuiasMadreBody = joResult.get("body"+(i+1)).getAsJsonArray();
		    
		    row = setExcelHeaderGuiasMadreBody(excelSheet, style, row++);
	    	
		    for(int j = 0; j<jaGuiasMadreBody.size(); j++){
	    	
	    	index=0;

	    	
			JsonObject gsonObjB = jaGuiasMadreBody.get(j).getAsJsonObject();
			excelRow = excelSheet.createRow(row++);
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("iddocumento") ? "" : gsonObjB.get("iddocumento").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("tiposervicio") ? "" : gsonObjB.get("tiposervicio").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("referencia") ? "" : gsonObjB.get("referencia").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("fechaentrega") ? "" : gsonObjB.get("fechaentrega").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("zonaori") ? "" : gsonObjB.get("zonaori").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("zonades") ? "" : gsonObjB.get("zonades").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("zonaventa") ? "" : gsonObjB.get("zonaventa").getAsString());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("largo") ? 0.0 : gsonObjB.get("largo").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("ancho") ? 0.0 : gsonObjB.get("ancho").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("alto") ? 0.0 : gsonObjB.get("alto").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("pesofisico") ? 0.0 : gsonObjB.get("pesofisico").getAsDouble());
	    	excelRow.createCell(index++).setCellValue(!gsonObjB.has("precio") ? 0.0 : gsonObjB.get("precio").getAsDouble());

	    }
		    row++;
		    row++;

		}
		return row;
	}
	  /*public void setExcelRows(HSSFSheet excelSheet, List<FacturaGuia> lista){
	    int record = 1;
		int index=0;
	    for (FacturaGuia envio : lista) {
	    	index=0;
	    	HSSFRow excelRow = excelSheet.createRow(record++);
	    	excelRow.createCell(index++).setCellValue(envio.getIddocumento());
	    	excelRow.createCell(index++).setCellValue(envio.getTiposervicio());
	    	excelRow.createCell(index++).setCellValue(envio.getReferencia());
	    	excelRow.createCell(index++).setCellValue(envio.getFechaentrega());
	    	excelRow.createCell(index++).setCellValue(envio.getZonaori());
	    	excelRow.createCell(index++).setCellValue(envio.getZonades());
	    	excelRow.createCell(index++).setCellValue(envio.getZonaventa());
	    	excelRow.createCell(index++).setCellValue(Double.parseDouble(envio.getLargo()));
	    	excelRow.createCell(index++).setCellValue(Double.parseDouble(envio.getAncho()));
	    	excelRow.createCell(index++).setCellValue(Double.parseDouble(envio.getAlto()));
	    	excelRow.createCell(index++).setCellValue(Double.parseDouble(envio.getPesofisico()));
	    	excelRow.createCell(index++).setCellValue((envio.getPrecio() == null ? "" : "$ " + envio.getPrecio()));
	    }
	  }*/
}
