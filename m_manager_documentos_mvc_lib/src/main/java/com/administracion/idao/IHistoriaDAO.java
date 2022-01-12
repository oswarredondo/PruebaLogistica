package com.administracion.idao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.servicio.dtos.Movimiento;

public interface IHistoriaDAO {

	/**
	 * Inserta un registro de historia
	 * @param movimiento
	 * @throws SQLException
	 */
	public abstract void insertHistoriaDocumento(Movimiento movimiento)
			throws SQLException;

	/**Obtiene los datos de historia y agrega un link cuando la guia no esta confirmada
	 * @param idGuia
	 * @throws SQLException
	 * @return
	 */
	public abstract List<Movimiento> getHistoria(String idGuia) throws SQLException;//fin de getHistoria

	/** Obtiene los datos de historia y agrega un link cuando la guia no esta confirmada
	 * @param idGuia
	 * @throws SQLException
	 * @return
	 */
	public abstract List<Movimiento> getHistoria(String idGuia, boolean confirmacion)
			throws SQLException;//fin de getHistoria

	/**
	 * Busca una guia de casamiento cuandoi el registro es de tipo 9 o 09, en
	 * caso de no encontrar caasamiento devuelve null
	 * @param idGuia estafeta que se esta consultado
	 * @param fechaevento la fecha en la que se esta realizando el casamiento, esto con 
	 * el fin de que se pueda realizar la consulta del registro correcto
	 * @throws SQLException
	 * @return
	 */
	public abstract String getCasamiento(String idGuia, String fechaevento)
			throws SQLException;//fin de getCasamiento

	/**
	 * INserta Registro de Casamiento Nacional o Internacional
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	 public int insertCasamiento(Movimiento obj) throws Exception ;
	
}