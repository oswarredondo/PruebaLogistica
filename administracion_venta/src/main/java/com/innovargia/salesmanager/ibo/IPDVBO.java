package com.innovargia.salesmanager.ibo;

public interface IPDVBO {

    public abstract void insertaOficinaUsuario(String login, String idoficina)
	    throws Exception;

    public abstract void deleteOficinaDeUsuario(String login) throws Exception;

    public abstract void deleteUsuarioDeOficina(String login, String idoficina)
	    throws Exception;

}