package com.innovargia.ws.repo.interfase.dao;

import java.sql.SQLException;

import com.innovargia.ws.tracking.rest.dto.FirmaFoto;

public interface IFirmaEvidenciaDao {

	/**Obtiene los datos de historia y agrega un link cuando la guia no esta confirmada
	 * @param idGuia
	 * @throws SQLException
	 * @return
	 */
	FirmaFoto getFirmaEntrega(String idGuia) throws SQLException;

	/**Obtiene los datos de historia y agrega un link cuando la guia no esta confirmada
	 * @param idGuia
	 * @throws SQLException
	 * @return
	 */
	FirmaFoto getEvienciaEntrega(String idGuia) throws SQLException;

}