package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.dto.FirmaFoto;

public interface IFirmaFotoBO {

    public abstract int insert(FirmaFoto obj) throws Exception;

    public abstract int update(FirmaFoto obj) throws Exception;

    public abstract int delete(FirmaFoto obj) throws Exception;

    public abstract List<FirmaFoto> select(FirmaFoto obj) throws Exception;

}