package com.administracion.ibo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.ManifiestoDTO;

public interface IManifiestoLogisticaBO {

    	/***
    	 * Configura un consecutivo generico si no existe definido el tipo de documento indicado
    	 * @param manifiesto
    	 * @param usuario
    	 * @param prefijo_manif
    	 * @return
    	 * @throws Exception
    	 */
	public String generaManifiestoMovimiento(ManifiestoDTO manifiesto,UsuarioDTO usuario, String prefijo_manif) throws Exception;
	/**
	 * Obtiene el concentrado de la carga asignada y pendiente
	 * @param manifiesto
	 * @return
	 * @throws Exception
	 */

	public abstract List<ManifiestoDTO> getConcentradoAsignadas(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	/**
	 * Obtiene el detalle de una ruta de carga asignada o pendiente
	 * @param manifiesto
	 * @return
	 * @throws Exception
	 */
	public abstract List<DocumentoConsultaDTO> getDetalleRuta(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	/**
	 * Obtiene los documentos impresos por un usuario en particular y regresa una lista con todos los 
	 * registros encontrados, se utiliza en manifiestos para ETIQUETAS
	 * @param manifiesto
	 * @param usuario
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public abstract List<DocumentoConsultaDTO> getDetalleManifiestoEtiquetas(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	/**
	 * Obtiene la informacion que ya fue asiganda a ruta en un rango de fechas para poder agregarla a un 
	 * manifiesto, este se utiliza en manifiestos para ORDEN SERVICIO y CARTAS PORTE
	 * @param manifiesto
	 * @return
	 * @throws Exception
	 */
	public abstract List<DocumentoConsultaDTO> consultaRegistrosParaManifiesto(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	/**
	 * Obtiene la informacion que ya fue asiganda a ruta de entrega en destino 
	 * @param manifiesto
	 * @return
	 * @throws Exception
	 */
	public abstract List<DocumentoConsultaDTO> consultaRegistrosParaManifiestoEntrega(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	/**
	 * Inserta un registo de manifiesto de entrega
	 * @param manifiesto
	 * @throws Exception
	 */
	public abstract String insertManifiestoEntregaRegistros(
			ManifiestoDTO manifiesto, ArrayList<ManifiestoDTO> arr_manifiesto,
			UsuarioDTO usuario) throws Exception;

	/**
	 * Actualiza los datos de posicion y ruta de reparto
	 * @param manifiesto
	 * @param usuario
	 * @throws Exception
	 */
	public abstract void updatePosicionUnidadRepartoRegistros(
			ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception;

	/**
	 * Asigna un numero de manifiesto a los registros de una ruta y un rango de fechas esto en el 
	 * proceso de distribucion
	 * @param manifiesto
	 * @throws Exception
	 */
	public abstract String updateManifiestoRegistros(ManifiestoDTO manifiesto,
			UsuarioDTO usuario, String tipodocumento) throws Exception;

	/**
	 * Asigna un numero de manifiesto de etiquetas a los registros seleccionados
	 * @param manifiesto
	 * @throws Exception
	 */
	public abstract String updateManifiestoRegistrosEtiquetas(
			ManifiestoDTO manifiesto, UsuarioDTO usuario, String tipodocumento,
			String[] arr_guias) throws Exception;

	/**
	 * Genera un manifiesto para un determinado tipo de documento, lo parametros 
	 * deberan ser generados en action, este metodo solo pasa el tipo de documento y es buscado
	 * en la tabla de catipodocumento donde se indica el nombre del reporte que debera ser generadop
	 * @param manifiesto
	 * @return
	 */
	public abstract byte[] generarManifiestoPDF(ManifiestoDTO manifiesto,
			Map<String, Object> parameters, UsuarioDTO usuario);
	
	
	public String updateManifiestoRegistrosEtiquetas(ManifiestoDTO manifiesto, 
			UsuarioDTO usuario, String[] arr_guias) throws Exception;
		
	
	


}