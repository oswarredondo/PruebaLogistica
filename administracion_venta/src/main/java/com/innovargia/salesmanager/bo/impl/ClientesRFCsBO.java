/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.ibo.IClientesRFCsBO;
import com.innovargia.salesmanager.idao.IClientesContactosDAO;
import com.innovargia.salesmanager.idao.IClientesRFCsDAO;

/**
 * @author aruaro
 *
 */
@Service
public class ClientesRFCsBO implements IClientesRFCsBO {
	@Autowired
	IClientesRFCsDAO iClientesRFCsDAO;

	/**
	 * 
	 */
	public ClientesRFCsBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(RemDes obj) throws Exception {
		BusquedaDTO busqueda =  new BusquedaDTO();
		busqueda.setTipo(3);
		busqueda.setPatron_busqueda(obj.getNumCliente());
		List<RemDes> lista = iClientesRFCsDAO.getBusquedaRegistros(busqueda);
		
		if (lista.size()>0){
			throw new Exception("Numero de cliente " +obj.getNumCliente() + 
					" ya existe dado de alta, verifique.");
		}
		
		iClientesRFCsDAO.insert(obj);
		
	}

	@Override
	public void update(RemDes obj) throws Exception {
		BusquedaDTO busqueda =  new BusquedaDTO();
		busqueda.setTipo(3);
		busqueda.setPatron_busqueda(obj.getNumCliente());
		List<RemDes> lista = iClientesRFCsDAO.getBusquedaRegistros(busqueda);
		if (lista.size()>0){
			int id = 0;
			for (RemDes remDes : lista) {
				if (remDes.getIdAutonumerico() != obj.getIdAutonumerico()){
					throw new Exception("Numero de cliente " +obj.getNumCliente() + 
							" ya existe dado de alta, verifique.");
				}
			}
		}
		
		iClientesRFCsDAO.update(obj);
		
	}

	@Override
	public void delete(RemDes obj) throws Exception {
		iClientesRFCsDAO.delete(obj);
		
	}


	@Override
	public RemDes get(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iClientesRFCsDAO.get(obj);
	}

	@Override
	public List<RemDes> getBusquedaRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return iClientesRFCsDAO.getBusquedaRegistros(obj);
	}

	@Override
	public void updateEstatus(ClientesDTO obj) throws Exception {
		iClientesRFCsDAO.updateEstatus(obj);
		
	}



}
