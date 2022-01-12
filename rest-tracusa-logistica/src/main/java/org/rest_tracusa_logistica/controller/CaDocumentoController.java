package org.rest_tracusa_logistica.controller;

import java.util.List;

import org.rest_tracusa_logistica.db.CaDocumentoDB;
import org.rest_tracusa_logistica.db.Connect;
import org.rest_tracusa_logistica.db.UserKeyDB;
import org.rest_tracusa_logistica.struct.Guide;
import org.rest_tracusa_logistica.struct.UserKey;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public class CaDocumentoController {

	public String getExistDocumentGuia(String idCliente, String reference, String observations) throws Exception{
		return CaDocumentoDB.getExistDocumentGuia(idCliente, reference.trim(), observations.trim(), new Connect());
	}
	public String getUsuarioFlexi(String idCliente, String reference, String observations) throws Exception{
		return CaDocumentoDB.getUsuarioFlexi(idCliente, reference.trim(), observations.trim(), new Connect());
	}
	public List<EtiquetaRotulacionDTO> getConvenioTarifa(String idCliente, String idServicio) throws Exception{
		return CaDocumentoDB.getConvenioTarifa(idCliente, idServicio.trim(), new Connect());
	}
	public String cotizacion(String cporigen, String cpdestino, UsuarioDTO usuario) throws Exception{
		return CaDocumentoDB.cotizacion(cporigen, cpdestino, usuario, new Connect());
	}
	public String getUsuarioWalmart(String idCliente, String reference, String observations) throws Exception{
		return CaDocumentoDB.getUsuarioWalmart(idCliente, reference.trim(), observations.trim(), new Connect());
	}
	public void setLog(UsuarioDTO usuario, Guide joGuide, int tipo) throws Exception{
		CaDocumentoDB.setLog(usuario,joGuide,tipo, new Connect());
	}
	public void updateLog(Guide joGuide, String iddocumento) throws Exception{
		CaDocumentoDB.updateLog(joGuide,iddocumento, new Connect());
	}
	public String getDirection(EtiquetaRotulacionDTO etiquetaRotulacionDTO) throws Exception{
		return CaDocumentoDB.getDirection(etiquetaRotulacionDTO, new Connect());
	}
}
