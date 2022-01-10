package com.tracusa.logistica.interfaces.dao;

import java.util.List;

import com.tracusa.logistica.model.CartaPorteResumen;
import com.tracusa.logistica.model.DetalleFactura;
import com.tracusa.logistica.model.FacturaCCP;

public interface ICartaPorteDAO {
	
	public int createMarcaFactura(CartaPorteResumen cartaPorteResumen) throws Exception;
	
	public void marcarGuias(int idControl, String factura, String lstDocumentos);
	
	public String getClientNumber(String rfc) throws Exception;

	public String getIdViaje(String NoDocumento) throws Exception;

	void updateMarcaFactura(int idControl, String factura, String mensaje);

	public List<FacturaCCP> getClientesViaje(String idviaje) throws Exception;
	
	public String getReferenciaViaje(String NoDocumento) throws Exception;
	
	void timbrarMarcaFactura(DetalleFactura detalleFactura);
}
