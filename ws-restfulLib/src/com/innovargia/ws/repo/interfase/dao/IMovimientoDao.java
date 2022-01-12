package com.innovargia.ws.repo.interfase.dao;

import java.util.List;

import com.innovargia.ws.dto.Movimiento;

public interface IMovimientoDao {

    public abstract int insert(Movimiento obj) throws Exception;

    public abstract int update(Movimiento obj) throws Exception;

    public abstract int delete(Movimiento obj) throws Exception;

    public abstract List<Movimiento> select(Movimiento obj) throws Exception;
    
    public int insertCasamiento(Movimiento obj) throws Exception;

}