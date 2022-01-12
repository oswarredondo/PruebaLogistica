package com.innovargia.ws.repo.interfase.dao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.ws.dto.Caexcepcion;
import com.innovargia.ws.dto.Movimiento;
import com.servicio.dtos.Guia;

public interface IMovimientoDao {

    public abstract String insert(Movimiento obj) throws Exception;

    public abstract int update(Movimiento obj) throws Exception;

    public abstract int delete(Movimiento obj) throws Exception;

    public abstract List<Caexcepcion> select(String movType) throws Exception;
    
    public int insertCasamiento(Movimiento obj) throws Exception;
    
    public int insertEstadisticasCarga(com.administracion.dto.RegistroInfo o)throws Exception;
    
    public abstract String movimientoActual(Movimiento obj) throws Exception;

}