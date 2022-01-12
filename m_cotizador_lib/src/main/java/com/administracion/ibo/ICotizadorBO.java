package com.administracion.ibo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.administracion.dto.CotizacionLineaDireccion;
import com.administracion.dto.CotizacionLineaVolumen;
import com.administracion.dto.CotizacionTarifa;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.RemDes;

public interface ICotizadorBO {

    public List<CotizacionTarifa> getCotizacionesTarifa(CotizacionTarifa tarifa) throws Exception;
	public List<CotizacionTarifa> getTarifasPrepagado(CotizacionTarifa tarifa) throws DataAccessException ;
	public List<CotizacionTarifa> getTarifasContado(CotizacionTarifa tarifa) throws DataAccessException;
	public List<CotizacionTarifa> getLineaCotizacionesTarifa(CotizacionLineaVolumen linea,
		CotizacionLineaDireccion cotiza ) throws Exception;
	
	public CotizacionTarifa getTarifa(CotizacionTarifa tarifa) throws DataAccessException; 

	public List<CotizacionTarifa> getTarifasFXC(CotizacionTarifa tarifa)
			throws DataAccessException;
	
	public List<CotizacionTarifa> getRangosKMTarifa(CotizacionTarifa tarifa)
			throws SQLException ;
	
	public List<CotizacionTarifa> getRangosEnviosTarifa(CotizacionTarifa tarifa)
			throws SQLException;
	
	public List<CotizacionTarifa> getRangosEnviosConvenio(CotizacionTarifa tarifa)
			throws SQLException;
	
	public List<CotizacionTarifa> getFiltraTarifas(CotizacionTarifa tarifa) throws Exception ;
	
	public List<CotizacionTarifa> getFiltraConveniosContado(CotizacionTarifa tarifa) throws Exception;;
	public List<RemDes> getClientesConvenios(BusquedaDTO busqueda)
			throws SQLException;
}