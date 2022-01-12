package com.innovargia.salesmanager.idao;

import com.administracion.dto.CotizacionTarifa;

public interface IPDVDAO {

    public abstract void insertaOficinaUsuario(String login, String idoficina)
	    throws Exception;

    public abstract void deleteOficinaDeUsuario(String login) throws Exception;

    public abstract void deleteUsuarioDeOficina(String login, String idoficina)
	    throws Exception;
    
    public abstract void insertLineaCotizacion(CotizacionTarifa obj)
	    throws Exception;

}