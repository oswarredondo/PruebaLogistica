package com.servicio.search.idao;

import java.util.List;

import com.administracion.dto.TipoEmpaqueFormato;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;

public interface IBusquedaCatalogoDAO {

    public abstract List<CatalogoDTO> getBancos() throws Exception;

    public abstract List<CatalogoDTO> getTipoIdentificacion() throws Exception;

    public abstract List<CatalogoDTO> getTipoPagoVenta(CatalogoDTO catalogo)
	    throws Exception;
    
    public  List<CatalogoDTO> getTiposPagosCaja() throws Exception;
    
	public List<CatalogoDTO> getExcepciones()
		throws Exception;
	
	public List<CatalogoDTO> getExcepcionespdv()
		throws Exception;
	
	public List<CatalogoDTO> getServicioInternacional() throws Exception;
	
	public CatalogoDTO getServicioInternacional(String id) throws Exception;
	public  List<TipoEmpaqueFormato> getTiposFormatoEmpaque(boolean onlyPDV) throws Exception;

}