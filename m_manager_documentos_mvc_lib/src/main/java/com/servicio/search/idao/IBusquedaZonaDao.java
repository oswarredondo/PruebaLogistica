package com.servicio.search.idao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Zona;

public interface IBusquedaZonaDao {

	/**
	 * Obtiene los valores de la zona de acuerdo al cruce
	 *
	 * @throws SQLException
	 *  @return datos de la zona o null en caso de no encontrar info
	 * @see Zona
	 */
	public abstract ArrayList<Zona> getListaZonas(String idzona,
			UsuarioDTO usuario) throws SQLException;//fin de getListaZonas

	/**
	 * Obtiene los valores de la zona de acuerdo a su municipio y estado
	 *
	 * @throws SQLException
	 *  @return datos de la zona o null en caso de no encontrar info
	 * @see Zona
	 */
	public abstract Zona getZona(String idestado, String idmunicipio,
			UsuarioDTO usuario) throws SQLException;//fin de getZona

	/**
	 * Obtiene los datos de la tarifa
	 * @param zona
	 * @param usuario
	 * @throws SQLException
	 */
	public abstract void getTarifaZonaCobertura(Zona zona, UsuarioDTO usuario)
			throws SQLException;//fin de getTarifaZonaCobertura
	
	
   	public List<CruceCoberturaDTO> getEnrutamientos(String siglasorigen, String siglasdestino,  String garantiamax) throws Exception;

	int getSeguro(CruceCoberturaDTO catalogo) throws SQLException;

	public List<CruceCoberturaDTO> validarConvenioSeguro(String numCliente) throws SQLException;

}