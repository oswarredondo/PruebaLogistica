package com.servicio.search.ibo;

import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;

public interface IBusquedaConvenioBO {

    public abstract ConvenioContratoDTO get(ConvenioContratoDTO obj)
	    throws Exception;

}