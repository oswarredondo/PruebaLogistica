package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.dto.Caexcepcion;
import com.innovargia.ws.dto.CasamientoRespuesta;
import com.innovargia.ws.dto.Movimiento;
import com.innovargia.ws.dto.MovimientoRespuesta;

public interface IMovimientoBO {

    public abstract List<MovimientoRespuesta> insert(Movimiento obj) throws Exception;

    public abstract int update(Movimiento obj) throws Exception;

    public abstract int delete(Movimiento obj) throws Exception;

    public abstract List<Caexcepcion> select(String movType) throws Exception;
    
    public CasamientoRespuesta insertCasamiento(Movimiento obj) throws Exception;
    
    
}