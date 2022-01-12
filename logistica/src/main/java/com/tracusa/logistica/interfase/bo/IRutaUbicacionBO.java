package com.tracusa.logistica.interfase.bo;

import java.util.List;

import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.RutaUbicacion;

public interface IRutaUbicacionBO {

    public abstract int insert(RutaUbicacion obj) throws Exception;

    public abstract int update(RutaUbicacion obj) throws Exception;

    public abstract int delete(RutaUbicacion obj) throws Exception;

    public abstract List<RutaUbicacion> select(RutaUbicacion obj) throws Exception;

}