package com.innovargia.servicios.etiquetas.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.CartaFacturaDetalle;
import com.administracion.ibo.ICartaPorteBO;
import com.administracion.idao.ICartaPorteDAO;

@Service
public class CartaPorteBO implements  ICartaPorteBO{
	
	private static final Logger logger = LoggerFactory
			.getLogger(CartaPorteBO.class);
	
	@Autowired
	ICartaPorteDAO ICartaPorteDAO;
	@Override
	public void insertCartaFacturaDocumento(CartaFacturaDetalle obj) throws Exception {
		
		ICartaPorteDAO.insertCartaFacturaDocumento(obj);
	}

	@Override
	public void insertCartaFacturaDetalleDocumento(CartaFacturaDetalle obj) throws Exception {
		ICartaPorteDAO.insertCartaFacturaDetalleDocumento(obj);
		
	}

}
