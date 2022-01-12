package com.administracion.idao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;

public interface IAdminConsecutivosDAO {

	/**
	 * Obtiene todos los documentos existentes para una entidad, si la variable 
	 * onlyVisible=true entonces solo devuelve los documentos cuyo valor del campo visible=T si no
	 * onlyVisible=false devuelve todos
	 * @param id
	 * @param identidad
	 * @param organizacion
	 * @return
	 * @throws SQLException
	 */
	public abstract ArrayList<MetaDatoCatalogoDTO> getDatosTipoDoc(
			int identidad, int organizacion, boolean onlyVisible)
			throws SQLException;

	/**
	 * Obtiene los datos del tipo de documento que se esta trabajando de una entidad
	 * @param id
	 * @param identidad
	 * @param organizacion
	 * @return
	 * @throws SQLException
	 */
	public abstract MetaDatoCatalogoDTO getDatosTipoDoc(String id,
			int identidad, int organizacion) throws SQLException;

	/**
	 * Obtiene el consecutrivo de la tabla indicada, ver diagramas 
	 * de ER para mas informacion
	 * @param tabla indica el nombre de la tabla que contiene o donde se
	 * va a crear l consecutivo
	 *  @param indica si se necesita largo si el largo es -1 entonces 
	 *  se devuelve sin complemneto de ceros
	 * @return
	 */
	public abstract String getConsecutivo(MetaDatoCatalogoDTO meta)
			throws SQLException;
	
	
	public MetaDatoCatalogoDTO getDatosTipoDocCuenta(String id, int identidad,
			int organizacion, String cuenta) throws SQLException ;

	/***
	 * Valida si una tabla de consecutivos existe
	 * @param meta
	 * @return
	 * @throws Exception
	 */
	public boolean existeTablaConsecutivos(MetaDatoCatalogoDTO meta) throws Exception;
}