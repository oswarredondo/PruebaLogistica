package com.administracion.ibo;

import com.administracion.dto.CartaFacturaDetalle;

public interface ICartaPorteBO {

	void insertCartaFacturaDocumento(CartaFacturaDetalle obj) throws Exception;

	void insertCartaFacturaDetalleDocumento(CartaFacturaDetalle obj) throws Exception;

}