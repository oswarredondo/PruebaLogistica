package com.innovargia.salesmanager.ibo;

import java.util.List;
import java.util.Map;

import com.administracion.dto.Factura;
import com.administracion.dto.FacturaGuia;
import com.google.gson.JsonObject;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

import mc_style.functions.soap.sap.document.sap_com.Tvkot;
import mc_style.functions.soap.sap.document.sap_com.Tvstt;
import mc_style.functions.soap.sap.document.sap_com.ZsdAuart;
import mc_style.functions.soap.sap.document.sap_com.ZsdBaseCto;
import mc_style.functions.soap.sap.document.sap_com.ZsdWerks;

public interface IFacturaResumenBO {

	int insert(Factura obj) throws Exception;

	void updateCancela(Factura obj) throws Exception;

	void updateFactura(Factura obj) throws Exception;

	List<Factura> getRegistros(Factura obj) throws Exception;
	
	List<FacturaGuia> getRegistrosGuias(Factura obj) throws Exception;
	
	public String updateDesmarcaFacturaEnDocumento(Factura obj) throws Exception;
	public void updateMarcaFacturaEnDocumento(Factura obj) throws Exception;
	
	public JsonObject generaExcel(Factura obj) throws Exception;
	
	public byte[] generarPDF(Factura factura,
			Map<String, Object> parameters, UsuarioDTO usuario);
	
	public void notaCredito(Factura obj) throws Exception ;
	public int insertConsumo(Factura obj) throws Exception ;
	public void updateMarcaFacturaEnDocumentoConsumo(Factura obj) throws Exception;
	
	List<ZsdAuart> getAuart() throws Exception;
	
	List<Tvkot> getTvkot() throws Exception;
	
	List<ZsdBaseCto> getVtweg() throws Exception;
	
	List<ZsdWerks> getWerks() throws Exception;
	
	List<Tvstt> getTvstt() throws Exception;

}