/**
 * 
 */
package com.ws.replica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import com.debug.utils.DebugLog;


/**
 * @author Adrian Morales Ruaro
 *
 */
public class ReplicaInfoDAO {

	private String db = "TRANSPORTE";
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private static void debug(String mensaje){
        //logger.info("Conexion-->" + mensaje);
    	DebugLog.debug("ReplicaInfoDAO ", mensaje);
    }//fin de debug
	/**
	 * 
	 */
	public ReplicaInfoDAO(String db) {
		this.db = db;
	}

	/***
	 * Obtiene todas las guias que estan pendientes de transmitir
	 * @return
	 */
	public ArrayList<String> getRegistrosPendientes(String uuid){

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnx = null;
		String sql = "SELECT plazaenvia, servidor, cliente, archivo, transmitido, registro, "+
	           " fechaproceso, guia, msgstatus, tipoerror FROM caregistrosprocesados "
				+ " WHERE llavetransmision=? AND msgstatus='SUCCESS'";
		
		debug("getRegistrosPendientes-->" + sql );
		
		Conexion conexion = new Conexion(this.db);
		ArrayList<String> arr_guias = new ArrayList<String>();
		try {
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql);
			ps.setString(1, uuid);

			rs = ps.executeQuery();
			while (rs.next()) {
				
				//if (arr_guias.size()<100){
					arr_guias.add(rs.getString("registro"));
				//}
			}
		} catch (SQLException sq) {
			debug("Error getRegistrosPendientes:" + sq.getMessage());
		} finally {
			// Cierra recursos
			conexion.closeRecursos(rs, ps, cnx);
		}
		return arr_guias;
		
	}
	
	/***
	 * Actualiza el registro transmitido
	 * @param registro
	 */
	public void updateTransmitida(String uuid,boolean tranmitido){
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql_insert = " UPDATE  caregistrosprocesados SET transmitido=? WHERE " +
				" llavetransmision=?  ";
		
		Conexion conexion = new Conexion(this.db);
		Connection cnx = null;
		try {
			
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql_insert);
			// envio.setIdEnvio(getConsecutivo());
			int index = 1;
			ps.setBoolean(index++, tranmitido);
			ps.setString(index++, uuid);
			ps.executeUpdate(); 

		} catch (SQLException sq) {
			debug("Error al  updateTransmitida-->" + sq.getMessage());
			// throw sq;
		}finally {
			// Cierra recursos
			conexion.closeRecursos(null, ps, cnx);
		}

	}
	
	/***
	 * marca los registros que seran enviados en la replica, con la llave a procesar
	 * y la bandera de enviados
	 * @param registro
	 * @return la cantidad de registros afectado
	 */
	public int marcaRegistrosReplica(String uuid){
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cantidad_afectados =0;

		String sql_insert = " UPDATE  caregistrosprocesados SET llavetransmision=? , transmitido=true WHERE " +
				" transmitido=false AND  msgstatus='SUCCESS'";
		
		debug("marcaRegistrosReplica-->" + sql_insert);
		
		Conexion conexion = new Conexion(this.db);
		Connection cnx = null;
		try {
			
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql_insert);
			// envio.setIdEnvio(getConsecutivo());
			int index = 1;
			
			ps.setString(index++, uuid);
			cantidad_afectados=  ps.executeUpdate(); 

		} catch (SQLException sq) {
			debug("Error al  marcaRegistrosReplica-->" + sq.getMessage());
			// throw sq;
		}finally {
			// Cierra recursos
			conexion.closeRecursos(null, ps, cnx);
		}
		
		return cantidad_afectados;

	}
}
