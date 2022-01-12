/**
 * Replica la informacion al WS solicitado 
 */
package com.ws.interchange.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.debug.utils.DebugLog;
import com.jdbc.interchange.SistemaDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
public class ReplicaInformacionAWS {

	private String db = "TRANSPORTE";

	/**
	 * 
	 */
	public ReplicaInformacionAWS(String db) {
		this.db = db;
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	/***
	 * Replica la informacion al WS configrado en el parametro WS.Replica.Info
	 * 
	 * @param list_Registros_Replica
	 * @param list_Configuracion_Replica
	 */
	public void ReplicaInformacionWS(
			java.util.ArrayList<java.lang.String> list_Registros_Replica,
			java.util.ArrayList<java.lang.String> list_Configuracion_Replica) {
		SistemaDao daoSistema = new SistemaDao(db);

		String endpoint = daoSistema.getValorPropiedad("INFOINTERCHANGE",
				"WS.Replica.Info");
		
		// Obtiene el URL
		// URL wsdlURL = InterchangeInfoService.WSDL_LOCATION;

	}

}
