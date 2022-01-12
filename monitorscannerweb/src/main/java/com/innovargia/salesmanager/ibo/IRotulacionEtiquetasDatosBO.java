package com.innovargia.salesmanager.ibo;

import com.innovargia.documentos.dtos.Envio;

public interface IRotulacionEtiquetasDatosBO {

		public void UpdateDocumentoUnigis(String iddocumento, int unigis_status);
		
		public String getDeposito(String codigo);
		
		public String getFehaCreacion(String iddocumento);
		
		public String getDirection(Envio etiquetaRotulacionDTO);
		
}