package com.innovargia.ws.repo.interfase.dao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.ws.tracking.rest.dto.Movimiento;

public interface IHistoriaDao {

	/**Obtiene los datos de historia y agrega un link cuando la guia no esta confirmada
	 * @param idGuia
	 * @throws SQLException
	 * @return
	 */
	List<Movimiento> getHistoria(String idGuia) throws SQLException;//fin de getHistoria

	List<Movimiento> getUltimoRegistroHistoria(String idGuia) throws SQLException;//fin de getHistoria

}