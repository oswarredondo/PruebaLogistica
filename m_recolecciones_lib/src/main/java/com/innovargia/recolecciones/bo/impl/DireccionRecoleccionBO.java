/**
 * 
 */
package com.innovargia.recolecciones.bo.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.documentos.dtos.CPs;
import com.innovargia.recolecciones.ibo.IDireccionRecoleccionBO;
import com.innovargia.recolecciones.idao.IDireccionesRecoleccionDAO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.search.idao.IBusquedaCPDao;

/**
 * @author Adrián
 *
 */
@Service
public class DireccionRecoleccionBO implements IDireccionRecoleccionBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DireccionRecoleccionBO.class);
	
	@Autowired
	IDireccionesRecoleccionDAO direccionesRecoleccionDAO;
	@Autowired
	IBusquedaCPDao iCPDao;

	/**
	 * 
	 */
	public DireccionRecoleccionBO() {
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.bo.impl.IDireccionRecoleccionBO#getBuscaDireccion(int, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 */
	 @Override
	public  List<RemDes> getBuscaDireccion(int identidad, int idorganizacion,String numcliente,String inicial, int ordernax,
	    	    String campoBusqueda,String entre, String vertodasdirecciones) throws SQLException {

		 return direccionesRecoleccionDAO.buscaClientesRemDes(identidad, idorganizacion, numcliente, 
				 inicial, ordernax, campoBusqueda, entre, true);
	 }
	 
	 /* (non-Javadoc)
	 * @see com.innovargia.recolecciones.bo.impl.IDireccionRecoleccionBO#insert(int, int, com.innovargia.salesmanager.dtos.RemDes)
	 */
	  @Override
    public void insert(int identidad, int idorganizacion, RemDes remdes)
	    throws SQLException {

	if ((remdes.getCiudad() == null)
		|| (remdes.getCiudad().trim().length() <= 0)) {
	    CPs cp = new CPs();
	    cp.setCp(remdes.getCp());
	    cp.setCiudad(remdes.getEstado());
	    cp = iCPDao.getCiudad(cp);
	    if (cp != null) {
		remdes.setCiudad(cp.getCiudad());
	    }else{
		  remdes.setCiudad("");
	    }
	}
	
	direccionesRecoleccionDAO.insert(identidad, idorganizacion, remdes);

    }
	  /* (non-Javadoc)
	 * @see com.innovargia.recolecciones.bo.impl.IDireccionRecoleccionBO#update(com.innovargia.salesmanager.dtos.RemDes)
	 */
	  @Override
	public void update(RemDes remdes)   throws SQLException {
	      if (remdes.getCiudad()==null){
		  remdes.setCiudad("");
	      }
		  direccionesRecoleccionDAO.update(remdes);
	  }
	  
	  /* (non-Javadoc)
	 * @see com.innovargia.recolecciones.bo.impl.IDireccionRecoleccionBO#delete(com.innovargia.salesmanager.dtos.RemDes, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	  @Override
	public void delete(RemDes remdes,UsuarioDTO usuario)   throws SQLException {
		  direccionesRecoleccionDAO.update(remdes);
	  }

}
