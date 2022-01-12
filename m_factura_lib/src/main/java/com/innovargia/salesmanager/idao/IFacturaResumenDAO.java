package com.innovargia.salesmanager.idao;

import java.util.List;

import com.administracion.dto.Factura;
import com.administracion.dto.FacturaDetalle;
import com.administracion.dto.FacturaGuia;
import com.google.gson.JsonObject;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;

public interface IFacturaResumenDAO {

	int insert(Factura obj) throws Exception;

	void updateCancela(Factura obj) throws Exception;

	void updateFactura(Factura obj) throws Exception;

	List<Factura> getRegistros(Factura obj) throws Exception;
	List<FacturaGuia> getRegistrosGuias(Factura obj) throws Exception;
	JsonObject generaExcel(Factura obj) throws Exception;
	
	public void updateDesmarcaFacturaEnDocumento(Factura obj) throws Exception;
	public void updateMarcaFacturaEnDocumento(Factura obj) throws Exception;
	
	public List<LineaFacturaSAP> getLineas(String marcafactura)throws Exception;
	public LineaFacturaSAP getParametroGeneraFactura(String p_proceso, String p_tipo )throws Exception;
	public Factura getRegistroById(Factura obj) throws Exception;
	
	public int cantidadRegistrosAMarcar(Factura obj)throws Exception;
	public int cantidadRegistrosMarcados(Factura obj)throws Exception;
	
	public CuentasDTO getDatosCliente(String numcliente) throws Exception;
	public void updateNotaCredito(Factura obj) throws Exception;
	
	public List<LineaFacturaSAP> getLineasFacturadas(String marcafactura)throws Exception;
	public void insert(FacturaDetalle obj) throws Exception ;
	public List<FacturaDetalle> cantidadRegistrosAMarcarConsumo(Factura obj)throws Exception;
	public void updateMarcaFacturaEnDocumentoConsumo(Factura obj) throws Exception;
		
}