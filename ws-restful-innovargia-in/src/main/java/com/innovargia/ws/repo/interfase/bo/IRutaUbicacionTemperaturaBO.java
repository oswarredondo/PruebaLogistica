package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.RutaUbicacion;

public interface IRutaUbicacionTemperaturaBO {

    public abstract int insert(RutaUbicacion obj) throws Exception;

    public abstract int update(RutaUbicacion obj) throws Exception;

    public abstract int delete(RutaUbicacion obj) throws Exception;

    public abstract List<RutaUbicacion> select(RutaUbicacion obj) throws Exception;

}