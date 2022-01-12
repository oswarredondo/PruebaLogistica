/**
 * 
 */
package com.servicio.search.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.servicio.search.ibo.IBusquedaCuentasClientesBO;
import com.servicio.search.idao.IBusquedaCuentasClientesDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class BusquedaCuentasClientesBO  implements IBusquedaCuentasClientesBO {

	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCuentasClientesBO.class);

	
	@Autowired
	IBusquedaCuentasClientesDAO clientesDAO;
	
	public BusquedaCuentasClientesBO(){
		
	}
	

	@Override
	public List<CuentasDTO> getBusquedaRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.getBusquedaRegistros(obj);
	}


	@Override
	public CuentasDTO getDatosCliente(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.getDatosCliente(obj);
	}


	@Override
	public CuentasConexionMensajeriaDTO getDatosConexionCliente(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.getDatosConexionCliente(obj);
	}


	@Override
	public List<CuentasConexionMensajeriaDTO> getDatosConexionClientes(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return  clientesDAO.getDatosConexionClientes(obj);
	}



	
}
