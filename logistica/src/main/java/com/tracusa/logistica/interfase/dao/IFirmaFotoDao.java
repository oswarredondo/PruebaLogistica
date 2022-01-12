package com.tracusa.logistica.interfase.dao;

import java.util.List;

import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.tracusa.logistica.model.FirmaFoto;

public interface IFirmaFotoDao {

    public abstract int insert(AttachmentDTO obj) throws Exception;

    public abstract int update(FirmaFoto obj) throws Exception;

    public abstract int delete(FirmaFoto obj) throws Exception;

    public abstract List<FirmaFoto> select(FirmaFoto obj) throws Exception;

}