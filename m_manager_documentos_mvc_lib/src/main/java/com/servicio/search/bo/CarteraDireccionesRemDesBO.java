/**
 * 
 */
package com.servicio.search.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.idao.ICPZonaDao;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.Utils;
import com.innovargia.utils.UtilsStrings;
import com.servicio.dtos.Zona;
import com.servicio.search.ibo.ICarteraDireccionesRemDesBO;
import com.servicio.search.ibo.IBusquedaZonasBO;
import com.servicio.search.idao.ICarteraDireccionesRemDesDao;
import com.servicio.search.idao.IBusquedaFrecuenciasDao;
import com.servicio.search.idao.IBusquedaZonaDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class CarteraDireccionesRemDesBO implements ICarteraDireccionesRemDesBO {
	@Autowired
	ICarteraDireccionesRemDesDao iCarteraDireccionesRemDesDao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(CarteraDireccionesRemDesBO.class);
	

	public CarteraDireccionesRemDesBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RemDes> getDirecconesRemDes(BusquedaDTO busqueda,UsuarioDTO usuario)
			throws SQLException {
		// TODO Auto-generated method stub
		return iCarteraDireccionesRemDesDao.getDirecconesRemDes(busqueda, usuario);
	}

	@Override
	public void insert(RemDes objeto, UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		if (objeto.getIdRmDes()==null){
			objeto.setIdRmDes(UUIDUniqueCreator.generateUUID());
		}
		
		/*
		objeto.setCalle(objeto.getCalle().replaceAll("\\W", " "));
		objeto.setCiudad(objeto.getCiudad().replaceAll("\\W", " "));
		objeto.setColonia(objeto.getColonia().replaceAll("\\W", " "));
		objeto.setDireccion(objeto.getDireccion().replaceAll("\\W", " "));
		objeto.setEstado(objeto.getEstado().replaceAll("\\W", " "));
		objeto.setMunicipio(objeto.getMunicipio().replaceAll("\\W", " "));
		objeto.setLocalidad(objeto.getLocalidad().replaceAll("\\W", " "));
		*/
		iCarteraDireccionesRemDesDao.insert(objeto,usuario);
	}
	
	@Override
	public void update(RemDes objeto) throws Exception {
		iCarteraDireccionesRemDesDao.update(objeto);
	}
	@Override
	public void delete(RemDes objeto) throws Exception {
		iCarteraDireccionesRemDesDao.delete(objeto);
	}
}