package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.dto.CasamientoRespuesta;
import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.RutaRequest;
import com.innovargia.ws.dto.RutaResponse;
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