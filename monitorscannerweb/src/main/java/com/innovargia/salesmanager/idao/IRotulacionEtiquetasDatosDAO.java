package com.innovargia.salesmanager.idao;

import com.innovargia.documentos.dtos.Envio;

public interface IRotulacionEtiquetasDatosDAO {

		public void UpdateDocumentoUnigis(String iddocumento, int unigis_status);
		
		public String getDeposito(String codigo);
		
		public String getFehaCreacion(String iddocumento);
		
		public String getDirection(Envio etiquetaRotulacionDTO);
		
}