package com.tracusa.logistica.interfase.bo;

import com.tracusa.logistica.model.DatosEtiqueta;

public interface IDatosEtiquetaBO {

    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    public abstract int insert(DatosEtiqueta obj) throws Exception;

}