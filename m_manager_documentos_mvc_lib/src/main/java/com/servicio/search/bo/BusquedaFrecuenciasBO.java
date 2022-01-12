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

import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.documentos.dtos.Regional;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.search.ibo.IBusquedaFrecuenciasBO;
import com.servicio.search.idao.IBusquedaFrecuenciasDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaFrecuenciasBO implements IBusquedaFrecuenciasBO {
	@Autowired
	IBusquedaFrecuenciasDao iFrecuenciasDao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaFrecuenciasBO.class);
	

	public BusquedaFrecuenciasBO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Frecuencias getFrecuenciaCP(String cp, String idgarantia,
			UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		List<Frecuencias> lista;
		try {
			lista = iFrecuenciasDao.getFrecuenciasCP(cp, idgarantia, usuario);
			
			if (lista.size()>0){
				return lista.get(0);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public List<Frecuencias> getFrecuenciasCPFoliosUsuario(String cp,
			UsuarioDTO usuario) throws SQLException {
		// TODO Auto-generated method stub
		return iFrecuenciasDao.getFrecuenciasCPFoliosUsuario(cp, usuario);
	}


	@Override
	public List<Frecuencias> getFrecuenciasCP(String cp, String idgarantia,
			UsuarioDTO usuario) throws SQLException {
		// TODO Auto-generated method stub
		return iFrecuenciasDao.getFrecuenciasCP(cp, idgarantia, usuario);
	}


	@Override
	public Regional getGarantiaRegional(int regionalOri, int regionalDes) {
		// TODO Auto-generated method stub
		return iFrecuenciasDao.getGarantiaRegional(regionalOri, regionalDes);
	}


	@Override
	public Frecuencias getFrecuenciasEntregaCP(String cp) throws SQLException {
		// TODO Auto-generated method stub
		return iFrecuenciasDao.getFrecuenciasEntregaCP(cp);
	}


	@Override
	public Frecuencias getRutaAsignada(String cp) throws SQLException {
	    // TODO Auto-generated method stub
	    return iFrecuenciasDao.getRutaAsignada(cp);
	}

	
}
