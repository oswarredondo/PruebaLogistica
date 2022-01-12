package com.servicio.search.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;

public interface IBusquedaCuentasClientesDAO {

	public List<CuentasDTO> getBusquedaRegistros(BusquedaDTO obj) throws Exception;
	
	public CuentasDTO getDatosCliente(BusquedaDTO obj) throws Exception;
	public CuentasConexionMensajeriaDTO getDatosConexionCliente(BusquedaDTO obj) throws Exception;
	public List<CuentasConexionMensajeriaDTO> getDatosConexionClientes(BusquedaDTO obj) throws Exception;

}