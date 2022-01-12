/**
 * 
 */
package com.servicio.search.bo;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.servicio.dtos.OficinasDTO;
import com.servicio.search.ibo.IBusquedaOficinasBO;
import com.servicio.search.idao.IBusquedaOficinasReceptorasDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaOficinasBO implements IBusquedaOficinasBO {
	@Autowired
	IBusquedaOficinasReceptorasDao iOficinasReceptorasDao; 
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaOficinasBO.class);
	
  
	public BusquedaOficinasBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OficinasDTO> getOficinasReceptoras(BusquedaDTO busqueda)
			throws SQLException {
		// TODO Auto-generated method stub
		return iOficinasReceptorasDao.getOficinasReceptoras(busqueda);
	}
	@Override
	public List<OficinasDTO> getOficinasReceptorasPDVCaja(BusquedaDTO busqueda)throws SQLException {
	   return  iOficinasReceptorasDao.getOficinasReceptorasPDVCaja(busqueda);
	}
	
	@Override
	public List<OficinasDTO> getOficinasReceptorasConOcurre(BusquedaDTO busqueda)throws SQLException {
	   
	   return  iOficinasReceptorasDao.getOficinasReceptorasConOcurre(busqueda);
	}
	@Override
	 public List<OficinasDTO> getPDVAsignadosAlUsuario(BusquedaDTO busqueda) throws SQLException{
	     return iOficinasReceptorasDao.getPDVAsignadosAlUsuario(busqueda);
	 } 

	
	  @Override
	    public List<OficinasDTO> getOficinasReceptorasPDVs(BusquedaDTO busqueda)
		    throws SQLException {
		// TODO Auto-generated method stub
		return null;
	    }
	  
	@Override
	public void insert(OficinasDTO objeto) throws Exception {
		
	}

	@Override
	public OficinasDTO getOficinaReceptora(BusquedaDTO busqueda)
		throws SQLException {
	    // TODO Auto-generated method stub
	    return iOficinasReceptorasDao.getOficinaReceptora(busqueda);
	}

	
}
