package com.tracusa.logistica.interfase.bo;

import java.util.List;

import com.tracusa.logistica.model.CasamientoRespuesta;
import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.RutaRequest;
import com.tracusa.logistica.model.RutaResponse;
import com.servicio.dtos.Guia;

public interface IEntregaBO {

    public abstract CasamientoRespuesta insert(Entrega obj) throws Exception;

    public abstract int update(Entrega obj) throws Exception;

    public abstract int delete(Entrega obj) throws Exception;

    public abstract List<Entrega> select(Entrega obj) throws Exception;
    
    public CasamientoRespuesta insertConfirmacionGuiasManif(Entrega obj) throws Exception ;
    
    //PARA OBTENER LAS GUIAS Y DIRECCIONES
    public List<RutaResponse> getRutas(RutaRequest ruta) throws Exception;

}