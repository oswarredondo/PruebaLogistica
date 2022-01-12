package com.innovargia.recolecciones.ibo;

import java.sql.SQLException;
import java.util.List;

import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Movimiento;
import com.servicio.dtos.Ruta;

public interface ISolicitudRecoleccionBO {

	/**
	 * @param idSolicitud
	 * @return
	 * @throws SQLException 
	 */
	public abstract List<SolicitudRecoleccion> getSolicitudesRecoleccion(
			SolicitudRecoleccion solicitud) throws SQLException;

	/**
	 * @param idSolicitud
	 * @return
	 * @throws SQLException 
	 */
	public abstract List<SolicitudRecoleccion> getRecoleccion(
			SolicitudRecoleccion solicitud) throws SQLException;

	/**
	 * @param idSolicitud
	 * @return
	 * @throws SQLException 
	 */
	public abstract void agregaRecoleccionAManifesto(
			SolicitudRecoleccion solicitud) throws SQLException;

	/**
	 *  Actualiza el manifiesto a todos los registros donde sea la ruta igual a la indicada
	 * 
	 * @param idmanifiesto, 
	 * @param  ruta
	 * @return
	 * @throws SQLException 
	 */
	public abstract List<String> agregaRecoleccionAManifesto(
			List<String> arr_rutas, UsuarioDTO usuario, String plaza, String fecha)
			throws SQLException;

	/**
	 * Devuelve un arreglo con todas las rutas que tienen recoleccion en un dia determinado
	 * @param usuario
	 * @return
	 * @throws SQLException 
	 */
	public abstract List<String> getRutasOrdenesRecoleccion(UsuarioDTO usuario)
			throws SQLException;

	/**
	 * Obtiene todas las rutas que tienen una recoleccion en el dia actual
	 * @param usuario
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Ruta> getRutasConOrdenesRecoleccion(
			UsuarioDTO usuario, boolean isShowAll) throws SQLException;

	/**
	 * @param solicitud
	 * @param dias
	 */
	public abstract void agregarSolicitudRecoleccion(
			SolicitudRecoleccion solicitud,List<DiasSemanaMes> dias) throws SQLException;

	/**
	 * Actualiza los datos de una orden de recoleccion
	 * @param solicitud
	 */
	public abstract void updateRecoleccion(SolicitudRecoleccion solicitud,
			List<DiasSemanaMes> dias) throws SQLException;

	/**
	 * Actualiza los datos de una solicitud de recoleccion
	 * @param solicitud
	 */
	public abstract void updateSolicitudRecoleccion(
			SolicitudRecoleccion solicitud, List<DiasSemanaMes> dias) throws SQLException;

	/**
	 * Agrega uns Solicitud de Recoleccion
	 * 
	 * @param solicitud
	 * @param dias
	 */
	public abstract void agregarSolicitudRecoleccion(
			SolicitudRecoleccion solicitud) throws SQLException;

	/**
	 * Agrega una recoleccion que se va a realizar en un fecha determinada
	 * 
	 * @param solicitud
	 * @param dias
	 */
	public abstract void agregarRecoleccion(SolicitudRecoleccion solicitud) throws SQLException;

	/**
	 * Actualiza el estatus de la recoleccion que se esta realizando
	 * 
	 * @param solicitud
	 * @param dias
	 */
	public abstract void cambiarEstatusRecoleccion(
			SolicitudRecoleccion solicitud, UsuarioDTO usuario);

	/**
	 * Actualiza el estatus de la recoleccion que se esta realizando
	 * 
	 * @param solicitud
	 * @param dias
	 */
	public abstract void cambiarFechaRecoleccion(
			SolicitudRecoleccion solicitud, UsuarioDTO usuario);

	/**
	 * @param idSolicitud
	 * @param dias
	 */
	public abstract void agregarDiasSemanaSolicitudRecoleccion(
			String idSolicitud, List<DiasSemanaMes> dias);

	/**
	 * @param idSolicitud
	 * @param dias
	 */
	public abstract void agregarDiasMesSolicitudRecoleccion(String idSolicitud,
			List<DiasSemanaMes> dias);

	/**
	 * Agrega los dias de recoleccion de la semana
	 * @param idSolicitud
	 * @param dias
	 */
	public abstract void modificarDiasSemanaSolicitudRecoleccion(
			String idSolicitud, List<DiasSemanaMes> dias);

	/**
	 * Agrega los dias de recoleccion del mes
	 * @param idSolicitud
	 * @param dias
	 */
	public abstract void modificarDiasMesSolicitudRecoleccion(
			String idSolicitud, List<DiasSemanaMes> dias);

	/**
	 * Actualiza la ruta de la recoleccion
	 * 
	 * @param idSolicitud
	 * @param ruta
	 */
	public abstract void modificarRutaRecoleccion(String idrecoleccion,
			String ruta, UsuarioDTO usuario);

	/**
	 * Actualiza la ruta de una solicitud de recoleccion
	 * 
	 * @param idSolicitud
	 * @param ruta
	 */
	public abstract void modificarRutaSolicitudRecoleccion(String idSolicitud,
			String ruta);

	/**
	 * Obtienes las ordenes de recoleccion del dia actual y de una ruta en paricular
	 * solo devuelve las recolecciones de las plazas y rutas asignadas a la organizacion
	 * de un usuario
	 * @param ruta
	 * @param usuario
	 * @throws SQLException
	 */
	public abstract List<SolicitudRecoleccion> getOrdenesRecoleccionRuta(
			String ruta, UsuarioDTO usuario) throws SQLException;

	/**
	 * Cambia el estatus de una solicitud de una recoleccion
	 * @param idSolicitud
	 *
	 */
	public abstract void cambiarEstatusSolicitudRecoleccion(String idSolicitud,
			String status);

	public abstract void insertaMovimiento(Movimiento movimiento)
			throws SQLException;

	/**
	 * Agrega la cancelacion de una de una solicitud de recoleccion
	 * @param idSolicitud
	 * 
	 */
	public abstract void agregarCancelacionSolicitudRecoleccion(
			SolicitudRecoleccion solicitud);

	/**
	 * Genera un manifiesto en PDF para las ordenes de recoleccion ya sea 
	 * impresion o reimpresion
	 * @param manifiesto
	 * @return
	 */
	public abstract byte[] generarManifiestoPDF(
			List<String> arr_manifiestos, UsuarioDTO usuario, String error);

	/**
	 * Genera las ordenes de recoleccion que aún no se han generado ,
	 * obtiene los datos generales, dia y posible cancelación.
	 * 
	 * Genera las ordenes de recoleccion del dia actual, utiliza las 
	 * ordenes de recolecciones generadas por programacion mensual o 
	 * semanal donde el idsolicitud no exista con id y fecha en rerecoleccion
	 * @throws SQLException 
	 * 
	 */
	public abstract void generarOrdenesRecoleccion() throws SQLException;

	/**
	 * @param idrecoleccion
	 * @return
	 */
	public abstract List<Movimiento> getHistoriaRecoelccion(String idrecoleccion);

	/**
	 * Obtiene la programacion de acuerdo a al tipo de solicitud de recoleccion
	 * @param solicitud
	 * @return
	 */
	public abstract List<DiasSemanaMes> getProgramacion(
			SolicitudRecoleccion solicitud);
	
	public SolicitudRecoleccion getDocumentoOrdenRecoleccion(
			SolicitudRecoleccion solicitud) throws SQLException;
	
			public SolicitudRecoleccion getDocumentoSolicitudRecoleccion(
					SolicitudRecoleccion solicitud) throws SQLException;
			
    public void insertDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);
    public void insertDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);
    public void updateDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);
    public void updateDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);
    public void deleteDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);
    public void deleteDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);	
    
    public List<Ruta> obtienePlazaTotal(String plaza, String fecha)
	    throws SQLException;

    public List<Ruta> obtienePlazaRutasTotal(String plaza, String fecha)
	    throws SQLException;
    
    public SolicitudRecoleccion  getSolicitudRecoleccionById(int idregistro,
		boolean isSolicitudRecoleccion) throws SQLException;
    
    
    public void insertHistoriaRecoleccion(int idregistro, 
	    String tipoRegistro, String login, String quienrechaza,
	    String motivo, boolean isSolicitudRecoleccion);

}