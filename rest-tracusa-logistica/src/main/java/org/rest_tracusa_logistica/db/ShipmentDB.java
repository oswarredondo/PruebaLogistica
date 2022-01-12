package org.rest_tracusa_logistica.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import org.glassfish.jersey.internal.util.Base64;
import org.rest_tracusa_logistica.struct.Delivery;
import org.rest_tracusa_logistica.struct.Guide;
import org.rest_tracusa_logistica.struct.Tracker;
import org.rest_tracusa_logistica.struct.UserKey;

import com.innovargia.utils.UtilsStringFechas;

public class ShipmentDB {
	
	public static ArrayList<Guide> getShipmentByDateDB(String fInicio, String fFin, String idClient, Connect conn) throws Exception{
		ArrayList<Guide> lstGuide = null;
		try{
			lstGuide = new ArrayList<>();
			conn.initDbConnection();
			
			ResultSet rsKey = conn.select("SELECT mo.idGuia, cd.referencia, cd.observacion, mo.tiregistro, mo.fechaevento, ca.fecha, ca.descripcion, ca.base64 " +
											"FROM cadocumentos AS cd " +
											"RIGHT OUTER JOIN " +
												"(SELECT mo1.idGuia, mo1.tiregistro, mo1.fechaevento " +
												"FROM movimientos  AS mo1 " +
												"RIGHT OUTER JOIN " +
													"(SELECT idGuia, max(fechaevento) AS fechaevento FROM movimientos " +
													"GROUP BY idGuia) AS mo2 " +
												"ON mo1.idGuia = mo2.idGuia AND mo1.fechaevento = mo2.fechaevento) AS mo " +
											"ON cd.idDocumento = mo.idGuia " +
											"RIGHT OUTER JOIN " +
												"(SELECT ca1.identificador, ca1.fecha, ca1.descripcion, ca1.base64, ca1.idRegistro " + 
												"FROM caattachdocumento AS ca1 " +
												"RIGHT OUTER JOIN " +
													"(SELECT identificador, max(fecha) AS fecha FROM caattachdocumento " + 
													"WHERE fecha BETWEEN '" + fInicio + "' AND '" + fFin + "' AND descripcion IN ('FIRMA ENTREGA', 'FIRMA DE RECIBIDO') " +
													"GROUP BY identificador) AS ca2 " +
												"ON ca1.identificador = ca2.identificador AND ca1.fecha = ca2.fecha) AS ca " +
											"ON mo.idGuia = ca.idEntificador " +
											"WHERE cd.numCliente = '" + idClient + "' AND mo.tiregistro <> 'CL'" +
											"ORDER BY ca.fecha DESC");
			
			while(rsKey.next()){
				Guide guide = new Guide();
				guide.setIdGuide(rsKey.getString("idGuia"));
				guide.setReference(rsKey.getString("referencia"));
				guide.setObservations(rsKey.getString("observacion"));
				//guide.setReference(rsKey.getString("tiregistro"));
				//guide.setReference(rsKey.getString("fechaevento"));
				guide.setDate(rsKey.getString("fecha"));
				guide.setDescription(rsKey.getString("descripcion"));
				//guide.setSignature(rsKey.getString("base64"));
				lstGuide.add(guide);
			}
			rsKey.close();
			
			return lstGuide;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			conn.cerrarConexion();
		}
	}
	
	public static ArrayList<Guide> getShipmentByIDDB(String idGuide, String idClient, Connect conn) throws Exception{
		ArrayList<Guide> lstGuide = null;
		try{
			lstGuide = new ArrayList<>();
			conn.initDbConnection();
			
			ResultSet rsKey = conn.select("SELECT mo.idGuia, cd.referencia, cd.observacion, mo.tiregistro, mo.fechaevento, ca.fecha, ca.descripcion, ca.base64 " +
											"FROM cadocumentos AS cd " +
											"RIGHT OUTER JOIN " +
												"(SELECT mo1.idGuia, mo1.tiregistro, mo1.fechaevento " +
												"FROM movimientos  AS mo1 " +
												"RIGHT OUTER JOIN " +
													"(SELECT idGuia, max(fechaevento) AS fechaevento FROM movimientos " +
													"WHERE idGuia = '" + idGuide + "' " +
													"GROUP BY idGuia) AS mo2 " +
												"ON mo1.idGuia = mo2.idGuia AND mo1.fechaevento = mo2.fechaevento) AS mo " +
											"ON cd.idDocumento = mo.idGuia " +
											"LEFT OUTER JOIN " +
												"(SELECT ca1.identificador, ca1.fecha, ca1.descripcion, ca1.base64, ca1.idRegistro " + 
												"FROM caattachdocumento AS ca1 " +
												"RIGHT OUTER JOIN " +
													"(SELECT identificador, max(fecha) AS fecha FROM caattachdocumento " + 
													"WHERE identificador = '" + idGuide + "' " +
													"GROUP BY identificador) AS ca2 " +
												"ON ca1.identificador = ca2.identificador AND ca1.fecha = ca2.fecha) AS ca " +
											"ON mo.idGuia = ca.idEntificador " +
											"WHERE cd.numCliente = '" + idClient + "' " +
											"ORDER BY ca.fecha DESC");
			
			while(rsKey.next()){
				Guide guide = new Guide();
				guide.setIdGuide(rsKey.getString("idGuia"));
				guide.setReference(rsKey.getString("referencia"));
				guide.setObservations(rsKey.getString("observacion"));
				guide.setTypeMovement(typeMovement(rsKey.getString("descripcion") != null ? "5" : rsKey.getString("tiregistro")));
				//guide.setReference(rsKey.getString("fechaevento"));
				guide.setDate(rsKey.getString("fecha") != null ? rsKey.getString("fecha") : rsKey.getString("fechaevento"));
				guide.setDescription(rsKey.getString("descripcion"));
				//guide.setSignature(rsKey.getString("base64"));
				lstGuide.add(guide);
			}
			rsKey.close();
			
			return lstGuide;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			conn.cerrarConexion();
		}
	}
	
	public static ArrayList<Guide> getShipmentTrackingByIDDB(String idGuide, UserKey userKey, Connect conn) throws Exception{
		ArrayList<Guide> lstGuide = null;
		String sql = "";
		String idPerfil = "";
		try{
			lstGuide = new ArrayList<>();
			conn.initDbConnection();
			
			sql = "SELECT numcliente, idperfil, nombre, login, estatus FROM causuarios WHERE login = '" + userKey.getLogin() +"'";
			ResultSet rsIsAdmin = conn.select(sql);
			while(rsIsAdmin.next()){
				idPerfil = rsIsAdmin.getString("idperfil");
			}
			rsIsAdmin.close();
			
			//Obtiene entrega y entrega
			sql = "SELECT cd.iddocumento, cd.referencia, cd.observacion, mo.idguia, mo.ruta, mo.cofecha, mo.conombre, mo.latitud, mo.longitud, " + 
						"mo.identificador, mo.fecha, mo.descripcion, mo.base64, mo.idRegistro " +
						"FROM cadocumentos AS cd " +
						"LEFT OUTER JOIN " +
						"	(SELECT co.idguia, co.ruta, co.cofecha, co.conombre, co.latitud, co.longitud, ca1.identificador, ca1.fecha, ca1.descripcion, ca1.base64, ca1.idRegistro " + 
						"		FROM caattachdocumento AS ca1 " +
						"		RIGHT OUTER JOIN " +
						"			(SELECT identificador, max(fecha) AS fecha FROM caattachdocumento " +
						"			WHERE identificador IN ('"+ idGuide +"') AND descripcion IN ('FIRMA ENTREGA', 'FIRMA DE RECIBIDO') " + 
						"			GROUP BY identificador) AS ca2 " +
						"		ON ca1.identificador = ca2.identificador AND ca1.fecha = ca2.fecha " +
						"		RIGHT OUTER JOIN confirma AS co " +
						"		ON ca1.identificador = co.idguia " +
						"		WHERE idguia IN ('"+ idGuide +"')" +
						"		ORDER BY fecha DESC) AS mo " +
						"ON cd.iddocumento = mo.idguia " +
						"WHERE " + (idPerfil.equals("ADMIN") ? "" : "cd.numCliente = '" + userKey.getIdClient() + "' AND ") + 
						"iddocumento IN ('" + idGuide + "') AND estatus = 'A' " +
						"ORDER BY mo.fecha DESC";
			ResultSet rsShipment = conn.select(sql);
			
			while(rsShipment.next()){
				Guide guide = new Guide();
				String iddocumento = rsShipment.getString("iddocumento");
				//Cabecera
				guide.setIdGuide(rsShipment.getString("iddocumento"));
				guide.setReference(rsShipment.getString("referencia"));
				guide.setObservations(rsShipment.getString("observacion"));
				//Entrega
				Delivery delivery = getDelivery(rsShipment);
				guide.setDelivery(delivery);
				//Rastreo
				ArrayList<Tracker> lsTrackers = getTrackers(iddocumento, userKey.getIdClient(), idPerfil, conn);
				guide.setTracker(lsTrackers);
				lstGuide.add(guide);
				break;
			}
			rsShipment.close();
			
			return lstGuide;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			conn.cerrarConexion();
		}
	}
	
	private static Delivery getDelivery(ResultSet rsShipment) throws Exception{
		Delivery delivery = new Delivery();
		try{
			delivery.setId(rsShipment.getString("idguia"));
			delivery.setSuccess((rsShipment.getString("idguia") != null) ? true : false);
			delivery.setDeliveryDate(rsShipment.getString("cofecha"));
			delivery.setRoute(rsShipment.getString("ruta"));
			delivery.setSignedBy(rsShipment.getString("conombre"));
			String latitud = rsShipment.getString("latitud");
			delivery.setLatitude(latitud == null ? 0 : latitud.isEmpty() ? 0 : Double.parseDouble(latitud));
			String longitud = rsShipment.getString("longitud");
			delivery.setLongitude(longitud == null ? 0 : longitud.isEmpty() ? 0 : Double.parseDouble(longitud));
			delivery.setSignatureDate(rsShipment.getString("fecha"));
			delivery.setSignature((rsShipment.getString("identificador") != null) ? true : false);
			delivery.setImageSignature(rsShipment.getString("base64"));
			
//			String sql = "SELECT FechaEstimada('"+ rsShipment.getString("iddocumento") +"')";
			String sql = "SELECT CASE WHEN formatoetiperso = 'WALMART' THEN "
					   + "(SELECT maxedd AS fechaestimada FROM cadocumentos WHERE iddocumento = '"+ rsShipment.getString("iddocumento") +"' ) ELSE "
					   + "(SELECT FechaEstimada('"+ rsShipment.getString("iddocumento") +"')) END "
					   + "FROM causuarios WHERE login= (SELECT login FROM cadocumentos WHERE iddocumento = '"+ rsShipment.getString("iddocumento") +"' )";
			
			Connect conn = new Connect();
			
			ResultSet rsShipmentFE = conn.select(sql);
			
			while(rsShipmentFE.next()){
				
				String fechaEstimada = rsShipmentFE.getString("fechaestimada");
				
				if(fechaEstimada == null){
					
					delivery.setEstimatedDate("SIN FECHA ESTIMADA POR EL MOMENTO");
					
				}else{
					
					delivery.setEstimatedDate(rsShipmentFE.getString("fechaestimada"));
					
				}
				
				
			}
			rsShipmentFE.close();
			
			return delivery;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	private static ArrayList<Tracker> getTrackers(String idDocumento, String idCliente, String idPerfil, Connect conn) throws Exception{
		ArrayList<Tracker> lsTrackers = new ArrayList<>();
		String sql = "";
		
		try{
			
			sql = "SELECT mo.idguia, mo.fechaevento, mo.tiregistro, mo.exclave, mo.plsiglasplaza, ca.zonades, cae.descripcion, dc.colonia, dc.estado, dc.ciudad, dc.pais, dc.cp, " +
					"CONCAT(ca.zonaori , '|' ,(SELECT CONCAT( " + 
				    "cadireccionesdocumento.colonia , '|' , " + 
					"cadireccionesdocumento.estado , '|' , " + 
					"cadireccionesdocumento.ciudad, '|' , " + 
					"cadireccionesdocumento.pais  , '|' , " + 
					"cadireccionesdocumento.cp) AS Remitente FROM cadireccionesdocumento " + 
					"WHERE cadireccionesdocumento.iddocumento = '" + idDocumento + "' AND cadireccionesdocumento.idtipodireccion = 'O')) AS remitente " +
					"FROM movimientos AS mo " +
					"LEFT OUTER JOIN cadocumentos AS ca ON mo.idguia = ca.iddocumento " +
					"LEFT OUTER JOIN cadireccionesdocumento AS dc ON ca.iddocumento = dc.iddocumento " +
					"LEFT OUTER JOIN (select distinct F.idexcepcion, f.descripcion FROM (select distinct F.idexcepcion, F.DESCRIPCION FROM " +
					"(SELECT DISTINCT CA.idexcepcion, CA.DESCRIPCION FROM caexcepcion AS CA WHERE CA.idexcepcion IS NOT NULL and CA.idexcepcion !='' " +
					"UNION ALL " +
					"SELECT DISTINCT ME.idexcepcion, ED.DESCRIPCION FROM movimiento_estatus AS ME LEFT OUTER JOIN " +
					"estatus_documento AS ED ON ME.idestatus = ED.idestatus " +
					"WHERE ME.idexcepcion IS NOT NULL and ME.idexcepcion !='' ) as F ORDER BY F.idexcepcion ASC) as F ORDER BY F.idexcepcion ASC) AS cae ON mo.exclave = cae.idexcepcion " +
//			sql = "SELECT mo.idguia, mo.fechaevento, mo.tiregistro, mo.exclave, mo.plsiglasplaza, ca.zonades, cae.descripcion FROM movimientos AS mo " +
//					"LEFT OUTER JOIN cadocumentos AS ca " +
//					"ON mo.idguia = ca.iddocumento " +
//					"LEFT OUTER JOIN caexcepcion AS cae " +
//					"ON mo.exclave = cae.idexcepcion " +
					"WHERE " + (idPerfil.equals("ADMIN") ? "" : "ca.numCliente = '" + idCliente + "' AND ") +
					"mo.idguia = '" + idDocumento + "' " + 
					"AND dc.idtipodireccion = 'D' " + 
					"ORDER BY mo.fechaevento DESC ";
		
			ResultSet rsTracker= conn.select(sql);
			
			while(rsTracker.next()){
				Tracker tracker = new Tracker();
				tracker.setId(rsTracker.getString("idguia"));
				tracker.setDate(rsTracker.getString("fechaevento"));
				tracker.setTypeMovement(typeMovement(rsTracker.getString("tiregistro")));
				//tracker.setTypeMovement(rsTracker.getString("tiregistro"));
				tracker.setDescription(rsTracker.getString("descripcion"));
				tracker.setCode(rsTracker.getString("exclave"));
				tracker.setPlace(rsTracker.getString("plsiglasplaza"));
				tracker.setDestination(UtilsStringFechas.convierteCadenaNULL(rsTracker.getString("zonades")) + "|" + UtilsStringFechas.convierteCadenaNULL(rsTracker.getString("colonia")) + "|" + UtilsStringFechas.convierteCadenaNULL(rsTracker.getString("estado")) + "|" + UtilsStringFechas.convierteCadenaNULL(rsTracker.getString("ciudad")) + "|" + UtilsStringFechas.convierteCadenaNULL(rsTracker.getString("pais")) + "|" + UtilsStringFechas.convierteCadenaNULL(rsTracker.getString("cp")));
				tracker.setRemitter(rsTracker.getString("remitente").replaceAll("null", ""));
				lsTrackers.add(tracker);
			}
			rsTracker.close();
			
			return lsTrackers;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	private static String typeMovement(String type){
		switch(type)
		{
			case "1":
				return "ENTRADA A CENTRO OPERATIVO";
			case "2":
				return "SALIDA DEL CENTRO OPERATIVO";
			case "03":
			case "3":
				return "MOVIMIENTO INTERNO";
			case "4":
				return "SIN ENTREGA";
			case "5":
				return "CONFIRMACIÓN DE ENTREGA";			
			case "8":
				return "PESO";
			case "9":
				return "CASAMIENTO";
			case "15":
				return "FLETE POR COBRAR";				
			case "21":
				return "ENVÍO RECOLECTADO";				
			case "22":
				return "EOFI";
			case "23":
				return "SALIDA DE PDV";		
			case "24":
				return "SALIDA A REPARTO";
			case "31":
				return "ECON";	
			case "32":
				return "SCON";			
			case "95":
				return "CONFIRMACIÓN DE LOCALIZACIÓN";	
			case "CA":
				return "PEDIDO CAPTURADO";
			case "CL":
				return "CANCELACIÓN";		
			case "CP":
				return "PEDIDO CON PESO Y VOL";				
			case "DE":
				return "PEDIDO DESPACHADO";		
			case "IE":
				return "PEDIDO CON IMPRESIÓN ETIQUETAS";				
			case "IM":
				return "PEDIDO IMPORTADO";
			case "LI":
				return "PEDIDO LIBERADO";				
			case "MA":
				return "RECOLECCIÓN ACTIVADA";
			case "MB":
				return "RECOLECCIÓN DESBLOQUEADA";
			case "MC":
				return "RECOLECCIÓN CANCELADA";
			case "MF":
				return "REASIGNACIÓN DE FECHA RECOL";
			case "MM":
				return "ORDEN DE RECOL. MANIFESTADA";	
			case "MR":
				return "REASIGNACIÓN DE RUTA RECOL.";			
			case "MU":
				return "ACTUALIZACIÓN DE DATOS";			
			case "SP":
				return "PEDIDO SIN PESO Y VOL.";				
			default:
				return "NO EXISTE";
		}
	}//Señor envio
	
	public static boolean isNoShipmentClientDB(String idGuide, UserKey userKey, Connect conn) throws Exception{
		ArrayList<Guide> lstGuide = null;
		String sql = "";
		String idPerfil = "";
		ResultSet rsShipment = null;
		try{
			lstGuide = new ArrayList<>();
			conn.initDbConnection();
			
			sql = "SELECT numcliente, idperfil, nombre, login, estatus FROM causuarios WHERE login = '" + userKey.getLogin() +"'";
			ResultSet rsIsAdmin = conn.select(sql);
			while(rsIsAdmin.next()){
				idPerfil = rsIsAdmin.getString("idperfil");
			}
			rsIsAdmin.close();
			
			//Obtiene entrega y entrega
			sql = "SELECT COUNT(iddocumento) AS rowcount FROM cadocumentos WHERE " + (idPerfil.equals("ADMIN") ? "" : "numcliente = '" + userKey.getIdClient() + "' AND ") + " iddocumento = '" + idGuide + "'";
			rsShipment = conn.select(sql);
			rsShipment.next();
			int count = rsShipment.getInt("rowcount");
			if(count >= 1){
				return true; //Entregada (La guia ya tiene entrega)
			}else{
				return false; //No exitoso | Entrega
			}
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			rsShipment.close();
			conn.cerrarConexion();
		}
	}
	
	public static Guide getShipmentPODDB(String idGuide, UserKey userKey, Connect conn) throws Exception{
		Guide guide = null;
		String sql = "";
		String idPerfil = "";
		ResultSet rsIsAdmin = null;
		ResultSet rsShipment = null;
		try{
			
			conn.initDbConnection();
			
			sql = "SELECT numcliente, idperfil, nombre, login, estatus FROM causuarios WHERE login = '" + userKey.getLogin() +"'";
			rsIsAdmin = conn.select(sql);
			while(rsIsAdmin.next()){
				idPerfil = rsIsAdmin.getString("idperfil");
			}
			rsIsAdmin.close();
			
			//Obtiene entrega
			sql = "SELECT cd.iddocumento, cd.referencia, cd.observacion, cd.fechacreacion, mo.idguia, mo.ruta, mo.cofecha, mo.conombre, mo.latitud, mo.longitud, " + 
						"mo.identificador, mo.fecha, mo.descripcion, mo.base64, mo.idRegistro " +
						"FROM cadocumentos AS cd " +
						"LEFT OUTER JOIN " +
						"	(SELECT co.idguia, co.ruta, co.cofecha, co.conombre, co.latitud, co.longitud, ca1.identificador, ca1.fecha, ca1.descripcion, ca1.base64, ca1.idRegistro " + 
						"		FROM caattachdocumento AS ca1 " +
						"		RIGHT OUTER JOIN " +
						"			(SELECT identificador, max(fecha) AS fecha FROM caattachdocumento " +
						"			WHERE identificador IN ('"+ idGuide +"') AND descripcion IN ('FIRMA ENTREGA', 'FIRMA DE RECIBIDO') " + 
						"			GROUP BY identificador) AS ca2 " +
						"		ON ca1.identificador = ca2.identificador AND ca1.fecha = ca2.fecha " +
						"		RIGHT OUTER JOIN confirma AS co " +
						"		ON ca1.identificador = co.idguia " +
						"		WHERE idguia IN ('"+ idGuide +"')" +
						"		ORDER BY fecha DESC) AS mo " +
						"ON cd.iddocumento = mo.idguia " +
						"WHERE " + (idPerfil.equals("ADMIN") ? "" : "cd.numCliente = '" + userKey.getIdClient() + "' AND ") + 
						"iddocumento IN ('" + idGuide + "') AND estatus = 'A' " +
						"ORDER BY mo.fecha DESC";
			rsShipment = conn.select(sql);
			
			while(rsShipment.next()){
				/*
				 * idGuia
				 * Fecha salida
				 * Fecha entrega
				 * Recibió
				 * Lugar de entrega
				 * Referencia
				 * Firma
				 * */
				//Cabecera
				guide = new Guide();
				guide.setIdGuide(rsShipment.getString("iddocumento"));
				guide.setReference(rsShipment.getString("referencia"));
				guide.setObservations(rsShipment.getString("observacion"));
				guide.setDate(rsShipment.getString("fechacreacion"));
				//Entrega
				Delivery delivery = getDelivery(rsShipment);
				guide.setDelivery(delivery);
				break;
			}
			rsShipment.close();
			
			return guide;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			guide = null;
			sql = "";
			idPerfil = "";
			rsIsAdmin = null;
			rsShipment = null;
			conn.cerrarConexion();
		}
	}

}
