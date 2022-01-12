/**
 * 
 */
package com.servicio.search.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.TipoEmpaqueFormato;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.servicio.search.ibo.IBusquedaCatalogoBO;
import com.servicio.search.idao.IBusquedaCatalogoDAO;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaCatalogoBO implements IBusquedaCatalogoBO {
	@Autowired
	IBusquedaCatalogoDAO iBusquedaCatalogoDAO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCatalogoBO.class);
	

	public BusquedaCatalogoBO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<CatalogoDTO> getBancos() throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getBancos();
	}


	@Override
	public List<CatalogoDTO> getTipoIdentificacion() throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getTipoIdentificacion();
	}


	@Override
	public List<CatalogoDTO> getTipoPagoVenta(CatalogoDTO catalogo)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getTipoPagoVenta(null);
	}


	@Override
	public List<CatalogoDTO> getTiposPagosCaja() throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getTiposPagosCaja();
	}


	@Override
	public List<CatalogoDTO> getExcepciones() throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getExcepciones();
	}


	@Override
	public List<CatalogoDTO> getExcepcionespdv() throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getExcepcionespdv();
	}


	@Override
	public List<CatalogoDTO> getServicioInternacional() throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getServicioInternacional();
	}
	@Override
	public CatalogoDTO getServicioInternacional(String id) throws Exception {
	    // TODO Auto-generated method stub
	    return iBusquedaCatalogoDAO.getServicioInternacional(id);
	}


	@Override
	public List<TipoEmpaqueFormato> getTiposFormatoEmpaque(boolean onlyPDV) throws Exception {
		// TODO Auto-generated method stub
		return iBusquedaCatalogoDAO.getTiposFormatoEmpaque(onlyPDV);
	}

	
	
}
