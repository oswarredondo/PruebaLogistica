/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.ibo.IClientesBO;
import com.innovargia.salesmanager.idao.IClientesDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class ClientesBO  implements IClientesBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ClientesBO.class);

	
	@Autowired
	IClientesDAO clientesDAO;
	
	public ClientesBO(){
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#insert(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void insert(ClientesDTO obj) throws Exception{
		BusquedaDTO busquedaDTO= new BusquedaDTO();
		busquedaDTO.setTipo(1);
		busquedaDTO.setPatron_busqueda(obj.getRfc());
		busquedaDTO.setUsuario(obj.getUsuario());
		//Vereifica si existe un cliente con el mismo RFC  
		 List<ClientesDTO> lista = clientesDAO.getBusquedaRegistros(busquedaDTO);
		 if (lista.size()>0){
			 throw new Exception("RFC " + obj.getRfc() + " ya fué dado de alta");
		 }
		clientesDAO.insert(obj);
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#update(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void update(ClientesDTO obj) throws Exception{
		BusquedaDTO busquedaDTO= new BusquedaDTO();
		busquedaDTO.setTipo(1);
		busquedaDTO.setPatron_busqueda(obj.getRfc());
		busquedaDTO.setUsuario(obj.getUsuario());
		//Vereifica si existe un cliente con el mismo RFC
		 List<ClientesDTO> lista = clientesDAO.getBusquedaRegistros(busquedaDTO);
		 if (lista.size()>0){
			 for (ClientesDTO clientesDTO : lista) {
				if (clientesDTO.getIdcliente()!=obj.getIdcliente()){
					 throw new Exception("RFC " + obj.getRfc() + " ya fué dado de alta");
				}
			}
			
		 }
		clientesDAO.update(obj);
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#delete(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void delete(ClientesDTO obj) throws Exception{
		clientesDAO.delete(obj);
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#getRegistros(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public List<ClientesDTO> getRegistros(BusquedaDTO obj) throws Exception{
		return  clientesDAO.getRegistros(obj);
	}


	@Override
	public void updateEstatus(ClientesDTO obj) throws Exception {
		clientesDAO.updateEstatus(obj);
		
	}


	@Override
	public ClientesDTO get(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.get(obj);
	}

	@Override
	public List<ClientesDTO> getBusquedaRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.getBusquedaRegistros(obj);
	}
	@Override
	public void  setTipoCliente(ClientesDTO obj) throws Exception{
		clientesDAO.setTipoCliente(obj);
	}

	@Override
	public void updateUsuarioCreador(ClientesDTO obj) throws Exception {
		clientesDAO.updateUsuarioCreador(obj);
		
	}
	



}
