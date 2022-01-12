package com.tracusa.logistica.interfase.bo;

import java.util.List;

import com.tracusa.logistica.model.Caexcepcion;
import com.tracusa.logistica.model.CasamientoRespuesta;
import com.tracusa.logistica.model.Movimiento;
import com.tracusa.logistica.model.MovimientoRespuesta;

public interface IMovimientoBO {

    public abstract List<MovimientoRespuesta> insert(Movimiento obj) throws Exception;

    public abstract int update(Movimiento obj) throws Exception;

    public abstract int delete(Movimiento obj) throws Exception;

    public abstract List<Caexcepcion> select(String movType) throws Exception;
    
    public CasamientoRespuesta insertCasamiento(Movimiento obj) throws Exception;
    
    
}