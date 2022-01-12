/**
 * 
 */
package com.ws.replica.info;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

import javax.xml.namespace.QName;

import com.debug.utils.DebugLog;
import com.ws.interchange.InterchangeInfoService;
import com.ws.interchange.InterchangeSEI;
import com.ws.replica.dao.ReplicaInfoDAO;
import com.ws.replica.dao.SistemaDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
public class ReplicaInfo {
	ReplicaInfoDAO replicaInfo = null;

	private QName SERVICE_NAME = new QName("http://interchange.ws.com/",
			"InterchangeInfoService");

	private String db = "TRANSPORTE";

	/**
	 * 
	 */
	public ReplicaInfo() {
		// TODO Auto-generated constructor stub
	}

	public ReplicaInfo(String db) {
		this.db = db;
		this.replicaInfo = new ReplicaInfoDAO(db);
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	/***
	 * Envia la informcion que se encuantra de replica al servidor indicado
	 */
	public void enviaInformacion(String proceso) {
		String llavetransmision="";

		try{
			SistemaDao daoSistema = new SistemaDao(this.db);
			String endpoint = daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
					"WS.replica.info");
			if ((endpoint == null) || (endpoint.trim().length() <= 0)) {
				return;
			}

			String urlws = endpoint;
			URL wsdlURL = null;
			try {
				wsdlURL = new URL(urlws);
			} catch (MalformedURLException e) {
				debug(proceso + ":No se puede inicializar wsdl de " + urlws);
				return;
			}

			InterchangeInfoService ss = new InterchangeInfoService(wsdlURL,
					SERVICE_NAME);
			InterchangeSEI port = ss.getInterchangeInfoPort();

			// Genera un UUID para marcar los registros
			UUID uuid = UUID.randomUUID();
			llavetransmision = String.valueOf(uuid);

			debug(proceso + ":Marcando registros para replicacion con llave "+llavetransmision);
			int cantidad_afectados = replicaInfo
					.marcaRegistrosReplica(llavetransmision);
			if (cantidad_afectados <= 0) {
				debug(proceso + ":No existen registros que transmitir ");
				return;
			}

			java.util.List<java.lang.String> configuracion = new java.util.ArrayList<java.lang.String>();
			configuracion.add(daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
					"WS.replica.siglas.plaza"));
			configuracion.add(daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
					"WS.replica.servidor"));
			configuracion.add(daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
					"WS.replica.cliente"));
			configuracion.add(llavetransmision); // Archivo
			configuracion.add(daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
					"WS.replica.db"));
			configuracion.add("REPLICA");

			// Obtiene todos los registros que tengan la llave indicada
			java.util.List<java.lang.String> registros = replicaInfo
					.getRegistrosPendientes(llavetransmision);
			//Transmite lotes de 100 en 100 para no saturar el ws
			java.util.List<java.lang.String> registros_100 = new ArrayList<String>();
			
			java.util.List<java.lang.String> _procesa__return=null;
			int bloques=1;
			for (String string_ri : registros) {
				registros_100.add(string_ri);
				if (registros_100.size()>=100){
					debug(proceso + ":Enviando " + registros_100.size() + ", restan:" + ((bloques++*100) - registros.size()) + " de " + registros.size());
					// Envia la solicitud
					_procesa__return = port.procesa(
							registros_100, configuracion);
					
					//Limpia la lista
					registros_100.clear();
				}
				
			}
			//Verifica si el arreglo es menor de 100 significa que no se enviaron
			if ((registros_100.size()>=1) && (registros_100.size()<100)){
				debug(proceso + ":Enviando " + registros_100.size() + ", registros de replicacion.");
				// Envia la solicitud
				_procesa__return = port.procesa(
						registros_100, configuracion);
				
			}
			registros_100.clear();

			//Indica la respuesta del WS
			debug("Transmision terminada  " );
			
		}catch(Exception e){
			//Desmarca los registros procesados
			//Actualiza los registros con la bandera de transmision
			replicaInfo.updateTransmitida(llavetransmision,false);
			debug("Error en la replica de la informacion " + e.getMessage());
			debug("Se activaton nuevamente los registros para transmision con llave " + llavetransmision);
		}

	}

}
