package com.innovargia.ws.repo.interfase.dao;

import java.util.List;

import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.RutaUbicacion;

public interface IRutaUbicacionTemperaturaDao {

    public abstract int insert(RutaUbicacion obj) throws Exception;

    public abstract int update(RutaUbicacion obj) throws Exception;

    public abstract int delete(RutaUbicacion obj) throws Exception;

    public abstract List<RutaUbicacion> select(RutaUbicacion obj) throws Exception;

}