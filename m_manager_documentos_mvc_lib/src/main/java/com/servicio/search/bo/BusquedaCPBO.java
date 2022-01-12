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

import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.servicio.search.ibo.IBusquedaCPBO;
import com.servicio.search.idao.IBusquedaCPDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaCPBO implements IBusquedaCPBO {
	@Autowired
	IBusquedaCPDao iIBusquedaCPDao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCPBO.class);
	

	public BusquedaCPBO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public CPs getInfoCP(String cp) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getInfoCP(cp);
	}


	@Override
	public List<CPs> getCPs(String cp) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getCPs(cp);
	}


	@Override
	public boolean isExistCP(String cp) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.isExistCP(cp);
	}


	@Override
	public CPs getMunicpioEstadoDelCP(String cp) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getMunicpioEstadoDelCP(cp);
	}


	@Override
	public String getInfoCP(String cp, int etiqueta) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getInfoCP(cp, etiqueta);
	}


	@Override
	public List<CPs> getColonias(String colonia) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getColonias(colonia);
	}


	@Override
	public List<CPs> getMuniciposEstado(String estado) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getMuniciposEstado(estado);
	}


	@Override
	public List<CPs> getColoniasMunicipo(String municipio)
		throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getColoniasMunicipo(municipio);
	}


	@Override
	public List<CPs> getEstado() throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getEstado();
	}


	@Override
	public CPs getCiudad(CPs cp) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getCiudad(cp);
	}


	@Override
	public CPs getCP(String id, String colonia) throws SQLException {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getCP(id, colonia);
	}


	@Override
	public List<DireccionDTO> getDatosDireccionCP(BusquedaDTO busqueda)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iIBusquedaCPDao.getDatosDireccionCP(busqueda);
	}



	
	
}
