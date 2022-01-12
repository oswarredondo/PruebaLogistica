package com.tracusa.logistica.interfase.dao;

import java.util.List;

import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.RutaRequest;
import com.tracusa.logistica.model.RutaResponse;
import com.servicio.dtos.Guia;

public interface IEntregaDao {

    public abstract int insert(Entrega obj) throws Exception;

    public abstract int update(Entrega obj) throws Exception;

    public abstract int delete(Entrega obj) throws Exception;

    public abstract List<Entrega> select(Entrega obj) throws Exception;
    
    public List<Guia> select(String manifiesto) throws Exception ;
    
    //PARA OBTENER GUIAS Y DIRECCIONES
    public List<RutaResponse> getRutas(RutaRequest ruta) throws Exception;

}