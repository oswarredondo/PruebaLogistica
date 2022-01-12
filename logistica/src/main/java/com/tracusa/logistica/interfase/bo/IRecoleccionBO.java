package com.tracusa.logistica.interfase.bo;

import java.util.List;

import com.tracusa.logistica.model.OrdenRecoleccion;

public interface IRecoleccionBO {

    public abstract int insert(OrdenRecoleccion obj) throws Exception;

    public abstract int update(OrdenRecoleccion obj) throws Exception;

    public abstract int delete(OrdenRecoleccion obj) throws Exception;

    public abstract List<OrdenRecoleccion> select(OrdenRecoleccion obj)
	    throws Exception;

}