package com.administracion.ibo;

import java.util.ArrayList;

import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;

public interface IAdminConsecutivosBO {

	/**
	 * Genera un consecutivo de acuerdo al tipo de documento
	 * @param idTipoDocumento
	 * @return
	 */
	public abstract String getConsecutivoDocumento(String idTipoDocumento,
			int identidad, int idorganizacion) throws Exception;

	/**
	 * Obtiene los meta datos de un tipo de documento
	 * @param idTipoDocumento
	 * @return
	 */
	public abstract MetaDatoCatalogoDTO getMetaDatoCatalogoDTO(
			String idTipoDocumento, int identidad, int idorganizacion)
			throws Exception;

	/**
	 * Obtiene los meta datos de un tipo de documento
	 * @param idTipoDocumento
	 * @return
	 */
	public abstract ArrayList<MetaDatoCatalogoDTO> getDatosTipoDoc(
			int identidad, int idorganizacion, boolean onlyVisible)
			throws Exception;
	
	

	/***
	 * Valida si una tabla de consecutivos existe
	 * @param meta
	 * @return
	 * @throws Exception
	 */
	public boolean existeTablaConsecutivos(MetaDatoCatalogoDTO meta) throws Exception;

}