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
import java.util.ArrayList;

import mensajeria.forms.Sistema;

import com.debug.utils.DebugLog;
import com.innovargia.utils.CheckSumUtility;

public class UsuariosDao {
	private String db = null;

	public UsuariosDao(String db) {
		this.db = db;
	}
		/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		DebugLog.debug(this.getClass(), mensaje);
	}// fin de debug

	
	public String[] getUsuariosOperativos(String plaza) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnx = null;
		ArrayList<String> usuarios = new ArrayList<String>();
		String[] arr_usuarios = null;
		String sql = "SELECT * FROM caUsuarios where nivelpuesto='80' "
			+ "and estatus='A' and siglasplaza='" + plaza +"'";
		Conexion conexion = new Conexion(this.db);
		try {
			cnx = conexion.getConexion();
			ps = cnx.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
			    usuarios.add(
				    CheckSumUtility.encryptaPassWordSHA1(rs.getString("login")) +
				    rs.getString("password") );
			}
			if (usuarios.size()>0){
			    arr_usuarios = new String[usuarios.size()];
			    int indice = 0;
			    for (String linea : usuarios) {
				arr_usuarios[indice++] = linea;
			    }
			}else{
			    arr_usuarios = new String[1];
			    arr_usuarios[0] = "";
			}
			
			
			
		} catch (SQLException sq) {
			debug("Error getValorPropiedad:" + sq.getMessage());
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} finally {
			// Cierra recursos
			conexion.closeRecursos(rs, ps, cnx);
		}
		return arr_usuarios;

	}// getValorPropiedad


}// fin 
