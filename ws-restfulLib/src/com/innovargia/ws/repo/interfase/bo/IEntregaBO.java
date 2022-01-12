package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.dto.Entrega;

public interface IEntregaBO {

    public abstract int insert(Entrega obj) throws Exception;

    public abstract int update(Entrega obj) throws Exception;

    public abstract int delete(Entrega obj) throws Exception;

    public abstract List<Entrega> select(Entrega obj) throws Exception;

}