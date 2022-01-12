package com.innovargia.salesmanager.bo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.salesmanager.idao.IRotulacionEtiquetasDatosDAO;

@Service
public class RotulacionEtiquetaBO implements IRotulacionEtiquetasDatosBO {

	private static final Logger logger = LoggerFactory.getLogger(RotulacionEtiquetaBO.class);

	@Autowired
	IRotulacionEtiquetasDatosDAO iRotulacionEtiquetasDatosDAO;

	public RotulacionEtiquetaBO() {

	}

	@Override
	public void UpdateDocumentoUnigis(String iddocumento, int unigis_status) {
		
		iRotulacionEtiquetasDatosDAO.UpdateDocumentoUnigis(iddocumento, unigis_status);
		
	}

	@Override
	public String getDeposito(String codigo) {
		
		return iRotulacionEtiquetasDatosDAO.getDeposito(codigo);
	}

	@Override
	public String getFehaCreacion(String iddocumento) {
		
		return iRotulacionEtiquetasDatosDAO.getFehaCreacion(iddocumento);
	}

	@Override
	public String getDirection(Envio etiquetaRotulacionDTO) {
		
		return iRotulacionEtiquetasDatosDAO.getDirection(etiquetaRotulacionDTO);
	}
}
