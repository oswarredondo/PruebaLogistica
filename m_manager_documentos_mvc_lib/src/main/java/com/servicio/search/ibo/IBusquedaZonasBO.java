package com.servicio.search.ibo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Zona;

public interface IBusquedaZonasBO {

	public abstract ArrayList<Zona> getListaZonas(String idzona,
			UsuarioDTO usuario) throws SQLException;

	/**
	 * Obtiene el cruce de zonas de acuerdo a las zonas indicadas
	 * 
	 * @param zonaori
	 * @param zonades
	 * @return
	 * @throws SQLException
	 */
	public abstract Zona getCruceZonas(String zonaori, String zonades,
			UsuarioDTO usuario, String idgarantia) throws SQLException;

	/**
	 * Obtiene el cruce de zonas por medio de los CPs origen y destino
	 * 
	 * @param cpori
	 * @param cpdes
	 * @return
	 * @throws SQLException
	 */
	public abstract Zona getCruceZonasPorCPs(String cpori, String cpdes,
			UsuarioDTO usuario, String idgarantia) throws Exception;

}