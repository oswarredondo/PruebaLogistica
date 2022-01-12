package com.administracion.idao;

import java.sql.SQLException;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Zona;

public interface ICPZonaDao {

	/**
	 * Obtiene los valores de la zona de acuerdo al cruce
	 *
	 * @param zonaOri
	 * @param zonaDes
	 * @param usuario
	 * @param idgarantia
	 * @return
	 * @throws SQLException
	 */
	public abstract Zona getCruceZona(String zonaOri, String zonaDes,
			UsuarioDTO usuario, String idgarantia) throws SQLException;//fin de getCPs

	/**
	 * Obtiene los valores de la zona de acuerdo al cruce
	 *
	 * @throws SQLException
	 *  @return datos de la zona o null en caso de no encontrar info
	 * @see Zona
	 */
	public abstract Zona getZonaVenta(String zonaVentaOri, String zonaVentaDes,
			UsuarioDTO usuario, String idgarantia) throws SQLException;//fin de getCPs

}