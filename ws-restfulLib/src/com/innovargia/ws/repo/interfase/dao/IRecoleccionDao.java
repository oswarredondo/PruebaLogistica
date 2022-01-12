package com.innovargia.ws.repo.interfase.dao;

import java.util.List;

import com.innovargia.ws.dto.OrdenRecoleccion;

public interface IRecoleccionDao {

    public abstract int insert(OrdenRecoleccion obj) throws Exception;

    public abstract int update(OrdenRecoleccion obj) throws Exception;

    public abstract int delete(OrdenRecoleccion obj) throws Exception;

    public abstract List<OrdenRecoleccion> select(OrdenRecoleccion obj)
	    throws Exception;

}