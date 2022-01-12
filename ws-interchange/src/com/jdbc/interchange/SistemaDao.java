/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: UsuarioDao.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion:  Acceso de a los datos de la tabla de usuarios
 *
 * $Log:$
 */
package com.jdbc.interchange;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mensajeria.forms.Sistema;

import com.debug.utils.DebugLog;

public class SistemaDao {
	private String db = null;

	public SistemaDao(String db) {
		this.db = db;
	}
		/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	/**
	 * Obtiene los datos de la propiedad solicitada, Entre las pripiedades
	 * existentes estan: <b>PathLogosEtiqueta</b>= Contiene el path físico donde
	 * se encuentran almacenadas las imagenes que son configuradas en la
	 * rotulación o importación de una etiqueta <b>Debug</b>= indica si se deben
	 * desplegar los datos de debug en pantalla <b>DirPDFTXTFile</b>= indica
	 * donde se van a almacenar todos los archivos de texto o pdf que genere el
	 * sistema <b>DirPDFTXTFile</b>
	 * 
	 * En caso de no encontrar el valor devuelve null.
	 * @param idSistema
	 * @param propiedad
	 * @return
	 */
	public String getValorPropiedad(String idSistema, String propiedad) {

		if (idSistema == null)
			return null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnx = null;
		String sql = "SELECT IdPropertie, IdSistema,Valor FROM catPropertieSystem "
				+ " WHERE IdSistema=? AND IdPropertie=?";
		Conexion conexion = new Conexion(this.db);
		try {
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql);
			ps.setString(1, idSistema);
			ps.setString(2, propiedad);

			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString("Valor");
			}
		} catch (SQLException sq) {
			debug("Error getValorPropiedad:" + sq.getMessage());
		} finally {
			// Cierra recursos
			conexion.closeRecursos(rs, ps, cnx);
		}
		return null;

	}// getValorPropiedad


}// fin 
