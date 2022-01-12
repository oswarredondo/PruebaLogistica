package com.innovargia.ws.repo.interfase.bo;

import com.innovargia.ws.dto.DatosEtiqueta;

public interface IDatosEtiquetaBO {

    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    public abstract int insert(DatosEtiqueta obj) throws Exception;

}