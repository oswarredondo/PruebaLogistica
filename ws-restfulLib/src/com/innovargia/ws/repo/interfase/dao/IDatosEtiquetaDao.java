package com.innovargia.ws.repo.interfase.dao;

import com.innovargia.ws.dto.DatosEtiqueta;

public interface IDatosEtiquetaDao {

    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    public abstract int insert(DatosEtiqueta obj) throws Exception;

}