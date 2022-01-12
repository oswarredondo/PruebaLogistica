package com.administracion.idao;

import com.administracion.dto.CartaFacturaDetalle;

public interface ICartaPorteDAO {

	void insertCartaFacturaDocumento(CartaFacturaDetalle obj) throws Exception;

	void insertCartaFacturaDetalleDocumento(CartaFacturaDetalle obj) throws Exception;

}