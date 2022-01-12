package com.tracusa.logistica.interfase.bo;

import java.util.List;

import com.tracusa.logistica.model.FirmaFoto;

public interface IFirmaFotoBO {

    public abstract int insert(FirmaFoto obj) throws Exception;

    public abstract int update(FirmaFoto obj) throws Exception;

    public abstract int delete(FirmaFoto obj) throws Exception;

    public abstract List<FirmaFoto> select(FirmaFoto obj) throws Exception;

}