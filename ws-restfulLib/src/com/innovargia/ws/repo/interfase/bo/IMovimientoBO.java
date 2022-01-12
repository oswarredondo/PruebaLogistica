package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.dto.Movimiento;

public interface IMovimientoBO {

    public abstract int insert(Movimiento obj) throws Exception;

    public abstract int update(Movimiento obj) throws Exception;

    public abstract int delete(Movimiento obj) throws Exception;

    public abstract List<Movimiento> select(Movimiento obj) throws Exception;
    public int insertCasamiento(Movimiento obj) throws Exception;
    
    
}