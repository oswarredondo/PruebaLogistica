package com.servicio.search.idao;

import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;

public interface IConvenioContratoDAO {

    public abstract ConvenioContratoDTO get(ConvenioContratoDTO obj)
	    throws Exception;

}